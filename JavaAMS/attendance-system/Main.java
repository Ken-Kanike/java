import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        DB.initialize();

        HttpServer server = HttpServer.create(new InetSocketAddress(7000), 0);
        server.createContext("/students", new StudentsHandler());
        server.createContext("/classes", new ClassesHandler());
        server.createContext("/generate", new GenerateHandler());
        server.createContext("/mark", new MarkHandler());
        server.createContext("/attendance", new AttendanceHandler());
        server.createContext("/", new RootHandler());
        server.createContext("/qr", new QRHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on http://localhost:7000");
    }

    static class StudentsHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String method = ex.getRequestMethod();
            if (method.equalsIgnoreCase("GET")) {
                respondText(ex, String.join("\n", DB.listStudents()));
            } else if (method.equalsIgnoreCase("POST")) {
                Map<String, String> params = readParams(ex);
                String name = params.getOrDefault("name", "").trim();
                if (name.isEmpty()) { respondCode(ex, 400, "name required"); return; }
                int id = DB.addStudent(name);
                respondText(ex, "OK " + id);
            } else {
                respondCode(ex, 405, "Method Not Allowed");
            }
        }
    }

    static class RootHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            if (!ex.getRequestMethod().equalsIgnoreCase("GET")) { respondCode(ex, 405, "Method Not Allowed"); return; }
            java.nio.file.Path path = java.nio.file.Paths.get("index.html");
            if (!java.nio.file.Files.exists(path)) { respondCode(ex, 404, "index.html not found"); return; }
            byte[] bytes = java.nio.file.Files.readAllBytes(path);
            Headers h = ex.getResponseHeaders();
            h.set("Content-Type", "text/html; charset=utf-8");
            ex.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = ex.getResponseBody()) { os.write(bytes); }
        }
    }

    static class QRHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            if (!ex.getRequestMethod().equalsIgnoreCase("GET")) { respondCode(ex, 405, "Method Not Allowed"); return; }
            Map<String, String> q = queryParams(ex.getRequestURI().getRawQuery());
            String f = q.get("f");
            if (f == null || !f.toLowerCase().endsWith(".png")) { respondCode(ex, 400, "invalid file"); return; }
            java.nio.file.Path path = java.nio.file.Paths.get(f);
            if (!java.nio.file.Files.exists(path)) { respondCode(ex, 404, "not found"); return; }
            byte[] bytes = java.nio.file.Files.readAllBytes(path);
            Headers h = ex.getResponseHeaders();
            h.set("Content-Type", "image/png");
            ex.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = ex.getResponseBody()) { os.write(bytes); }
        }
    }

    static class ClassesHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            String method = ex.getRequestMethod();
            if (method.equalsIgnoreCase("GET")) {
                respondText(ex, String.join("\n", DB.listClasses()));
            } else if (method.equalsIgnoreCase("POST")) {
                Map<String, String> params = readParams(ex);
                String name = params.getOrDefault("name", "").trim();
                if (name.isEmpty()) { respondCode(ex, 400, "name required"); return; }
                int id = DB.addClass(name);
                respondText(ex, "OK " + id);
            } else {
                respondCode(ex, 405, "Method Not Allowed");
            }
        }
    }

    static class GenerateHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            if (!ex.getRequestMethod().equalsIgnoreCase("GET")) { respondCode(ex, 405, "Method Not Allowed"); return; }
            Map<String, String> q = queryParams(ex.getRequestURI().getRawQuery());
            String classIdStr = q.get("classId");
            String hostOverride = q.get("host");
            if (classIdStr == null) { respondCode(ex, 400, "classId required"); return; }
            int classId;
            try { classId = Integer.parseInt(classIdStr); } catch (NumberFormatException e) { respondCode(ex, 400, "invalid classId"); return; }

            String token = UUID.randomUUID().toString().replace("-", "");
            long expiry = Instant.now().toEpochMilli() + 2 * 60 * 1000; // 2 minutes
            DB.insertToken(token, classId, expiry);

            String host = (hostOverride != null && !hostOverride.isBlank()) ? hostOverride : resolveLocalIPv4(ex);
            String markUrl = "http://" + host + ":" + ex.getLocalAddress().getPort() + "/mark?token=" + token;
            String file = "qr-" + token + ".png";                 // URL QR
            String fileToken = "qr-token-" + token + ".png";       // token-only QR (for offline/manual use)
            QRUtil.generateQRCode(markUrl, file);
            QRUtil.generateQRCode(token, fileToken);

            String body = "Token generated. Expires in 2 min.\n" +
                    "Token: " + token + "\n" +
                    "Mark URL: " + markUrl + "\n" +
                    "QR saved: " + file + "\n" +
                    "Token-Only QR: " + fileToken + "\n" +
                    "Hint: You can override host via /generate?classId=" + classId + "&host=YOUR_IP\n";
            respondText(ex, body);
        }
    }

    static class MarkHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            Map<String, String> q = queryParams(ex.getRequestURI().getRawQuery());
            String token = q.get("token");
            if (token == null) { respondCode(ex, 400, "token required"); return; }

            Integer classId = DB.getTokenClassIfValid(token);
            if (classId == null) { respondCode(ex, 400, "invalid or expired token"); return; }

            if (ex.getRequestMethod().equalsIgnoreCase("GET")) {
                String html = "<html><body>" +
                        "<h3>Mark Attendance (Class " + classId + ")</h3>" +
                        "<form method='POST'>" +
                        "Student ID: <input name='studentId'/>" +
                        "<button type='submit'>Mark</button>" +
                        "</form>" +
                        "</body></html>";
                respondHtml(ex, html);
            } else if (ex.getRequestMethod().equalsIgnoreCase("POST")) {
                Map<String, String> form = readParams(ex);
                String sidStr = form.get("studentId");
                int studentId;
                try { studentId = Integer.parseInt(sidStr); } catch (Exception e) { respondCode(ex, 400, "invalid studentId"); return; }
                DB.insertAttendance(studentId, classId, LocalDate.now());
                respondHtml(ex, "<html><body>Marked for student " + studentId + " in class " + classId + "</body></html>");
            } else {
                respondCode(ex, 405, "Method Not Allowed");
            }
        }
    }

    static class AttendanceHandler implements HttpHandler {
        public void handle(HttpExchange ex) throws IOException {
            if (!ex.getRequestMethod().equalsIgnoreCase("GET")) { respondCode(ex, 405, "Method Not Allowed"); return; }
            Map<String, String> q = queryParams(ex.getRequestURI().getRawQuery());
            String classIdStr = q.get("classId");
            String date = q.get("date");
            if (classIdStr == null || date == null) { respondCode(ex, 400, "classId and date required"); return; }
            int classId;
            try { classId = Integer.parseInt(classIdStr); } catch (NumberFormatException e) { respondCode(ex, 400, "invalid classId"); return; }
            List<String> rows = DB.getAttendance(classId, date);
            respondText(ex, String.join("\n", rows));
        }
    }

    private static void respondText(HttpExchange ex, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        Headers h = ex.getResponseHeaders();
        h.set("Content-Type", "text/plain; charset=utf-8");
        ex.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = ex.getResponseBody()) { os.write(bytes); }
    }

    private static void respondHtml(HttpExchange ex, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        Headers h = ex.getResponseHeaders();
        h.set("Content-Type", "text/html; charset=utf-8");
        ex.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = ex.getResponseBody()) { os.write(bytes); }
    }

    private static void respondCode(HttpExchange ex, int code, String message) throws IOException {
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        ex.sendResponseHeaders(code, bytes.length);
        try (OutputStream os = ex.getResponseBody()) { os.write(bytes); }
    }

    private static Map<String, String> queryParams(String rawQuery) {
        Map<String, String> map = new HashMap<>();
        if (rawQuery == null || rawQuery.isEmpty()) return map;
        for (String p : rawQuery.split("&")) {
            String[] kv = p.split("=", 2);
            String k = urlDecode(kv[0]);
            String v = kv.length > 1 ? urlDecode(kv[1]) : "";
            map.put(k, v);
        }
        return map;
    }

    private static Map<String, String> readParams(HttpExchange ex) throws IOException {
        String ct = Optional.ofNullable(ex.getRequestHeaders().getFirst("Content-Type")).orElse("");
        String body;
        try (InputStream is = ex.getRequestBody()) { body = new String(is.readAllBytes(), StandardCharsets.UTF_8); }
        if (ct.contains("application/x-www-form-urlencoded") || ex.getRequestMethod().equalsIgnoreCase("POST")) {
            return queryParams(body);
        }
        return Collections.emptyMap();
    }

    private static String urlDecode(String s) {
        return URLDecoder.decode(s, StandardCharsets.UTF_8);
    }

    private static String resolveLocalIPv4(HttpExchange ex) {
        try {
            // Prefer site-local, non-loopback IPv4
            Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
            List<String> candidates = new ArrayList<>();
            while (ifaces.hasMoreElements()) {
                NetworkInterface ni = ifaces.nextElement();
                if (!ni.isUp() || ni.isLoopback() || ni.isVirtual()) continue;
                Enumeration<InetAddress> addrs = ni.getInetAddresses();
                while (addrs.hasMoreElements()) {
                    InetAddress addr = addrs.nextElement();
                    if (addr.isLoopbackAddress() || addr.isAnyLocalAddress()) continue;
                    if (addr instanceof java.net.Inet4Address) {
                        String ip = addr.getHostAddress();
                        // Prefer private ranges first
                        if (ip.startsWith("10.") || ip.startsWith("192.168.") || ip.startsWith("172.16.") || ip.startsWith("172.17.") || ip.startsWith("172.18.") || ip.startsWith("172.19.") || ip.startsWith("172.2") || ip.startsWith("172.3")) {
                            return ip;
                        }
                        candidates.add(ip);
                    }
                }
            }
            if (!candidates.isEmpty()) return candidates.get(0);
        } catch (Exception ignored) { }
        // Fallback to the server's local address host string (may be 127.0.0.1)
        return ex.getLocalAddress().getHostString();
    }
}


