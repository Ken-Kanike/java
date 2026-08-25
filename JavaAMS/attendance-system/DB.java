import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private static final String DB_URL = "jdbc:sqlite:attendance.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initialize() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL)");

            stmt.execute("CREATE TABLE IF NOT EXISTS classes (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL)");

            stmt.execute("CREATE TABLE IF NOT EXISTS attendance (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "student_id INTEGER NOT NULL, " +
                    "class_id INTEGER NOT NULL, " +
                    "date TEXT NOT NULL, " +
                    "FOREIGN KEY(student_id) REFERENCES students(id), " +
                    "FOREIGN KEY(class_id) REFERENCES classes(id))");

            stmt.execute("CREATE TABLE IF NOT EXISTS tokens (" +
                    "token TEXT PRIMARY KEY, " +
                    "class_id INTEGER NOT NULL, " +
                    "expiry_epoch_ms INTEGER NOT NULL, " +
                    "FOREIGN KEY(class_id) REFERENCES classes(id))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int addStudent(String name) {
        String sql = "INSERT INTO students(name) VALUES(?)";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public static int addClass(String name) {
        String sql = "INSERT INTO classes(name) VALUES(?)";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public static void insertToken(String token, int classId, long expiryEpochMs) {
        String sql = "INSERT OR REPLACE INTO tokens(token, class_id, expiry_epoch_ms) VALUES(?,?,?)";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, token);
            ps.setInt(2, classId);
            ps.setLong(3, expiryEpochMs);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer getTokenClassIfValid(String token) {
        String sql = "SELECT class_id, expiry_epoch_ms FROM tokens WHERE token=?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, token);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    long expiry = rs.getLong("expiry_epoch_ms");
                    long now = Instant.now().toEpochMilli();
                    if (now <= expiry) {
                        return rs.getInt("class_id");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void insertAttendance(int studentId, int classId, LocalDate date) {
        String sql = "INSERT INTO attendance(student_id, class_id, date) VALUES(?,?,?)";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, classId);
            ps.setString(3, date.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getAttendance(int classId, String date) {
        String sql = "SELECT a.id, s.id AS student_id, s.name FROM attendance a " +
                "JOIN students s ON s.id = a.student_id WHERE a.class_id = ? AND a.date = ? ORDER BY a.id";
        List<String> rows = new ArrayList<>();
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, classId);
            ps.setString(2, date);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int sid = rs.getInt("student_id");
                    String name = rs.getString("name");
                    rows.add(sid + ": " + name);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    public static List<String> listStudents() {
        List<String> rows = new ArrayList<>();
        try (Connection conn = connect(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT id, name FROM students ORDER BY id")) {
            while (rs.next()) {
                rows.add(rs.getInt("id") + ": " + rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    public static List<String> listClasses() {
        List<String> rows = new ArrayList<>();
        try (Connection conn = connect(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT id, name FROM classes ORDER BY id")) {
            while (rs.next()) {
                rows.add(rs.getInt("id") + ": " + rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }
}




