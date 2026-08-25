# Attendance Management System (Pure Java + SQLite + ZXing)

Minimal single-folder HTTP app for managing students, classes, and attendance with QR-based check-in.

- Pure Java (no Maven/Gradle)
- Embedded SQLite (Xerial JDBC)
- QR codes via ZXing (core + javase)
- Simple HTTP server using `com.sun.net.httpserver.HttpServer`

## Project Layout
```
attendance-system/
  ├── attendance.db               # auto-created on first run
  ├── lib/                        # third-party jars
  │   ├── sqlite-jdbc-3.39.3.0.jar
  │   ├── core-3.4.1.jar
  │   └── javase-3.4.1.jar
  ├── DB.java                     # SQLite helper
  ├── QRUtil.java                 # QR generation
  ├── Main.java                   # HTTP server + endpoints
  └── index.html                  # minimal web UI
```

## Prerequisites
- Java 11+ JDK installed (`java -version` / `javac -version`)
- Internet access to download JARs (first-time setup only)

## 1) Download Dependencies
Download the three JARs and place them into `attendance-system/lib`.

- SQLite JDBC (Xerial): `https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.39.3.0/sqlite-jdbc-3.39.3.0.jar`
- ZXing core: `https://repo1.maven.org/maven2/com/google/zxing/core/3.4.1/core-3.4.1.jar`
- ZXing javase: `https://repo1.maven.org/maven2/com/google/zxing/javase/3.4.1/javase-3.4.1.jar`

If you are on Windows PowerShell, you can run (from folder `attendance-system`):
```powershell
mkdir lib -ErrorAction SilentlyContinue
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.39.3.0/sqlite-jdbc-3.39.3.0.jar" -OutFile "lib/sqlite-jdbc-3.39.3.0.jar"
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/com/google/zxing/core/3.4.1/core-3.4.1.jar" -OutFile "lib/core-3.4.1.jar"
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/com/google/zxing/javase/3.4.1/javase-3.4.1.jar" -OutFile "lib/javase-3.4.1.jar"
```

## 2) Compile
From inside `attendance-system/`:

Windows (PowerShell/CMD):
```bat
javac -cp "lib/*" *.java
```

macOS/Linux (Bash):
```bash
javac -cp "lib/*" *.java
```

## 3) Run
Windows:
```bat
java -cp ".;lib/*" Main
```
macOS/Linux:
```bash
java -cp ".:lib/*" Main
```
The server starts on `http://localhost:7000`.

## 4) Use the Web UI
Open `http://localhost:7000/` in a browser.
- Add students and classes. Note the numeric IDs shown (e.g., `1: Alice` → Student ID = 1; `1: Math` → Class ID = 1).
- Generate QR by entering the numeric Class ID (token valid for 2 minutes). A PNG is saved as `qr-<token>.png` and can be viewed in the UI.
- Students scan the QR (opens `/mark?token=...`) and enter their Student ID to mark attendance.
- Fetch attendance by Class ID and Date (`YYYY-MM-DD`).

## REST Endpoints
- `GET  /students` → list students
- `POST /students` (form) → `name=<text>`
- `GET  /classes` → list classes
- `POST /classes` (form) → `name=<text>`
- `GET  /generate?classId=<ID>` → create token + save QR PNG
- `GET  /mark?token=<TOKEN>` → HTML form to submit student ID
- `POST /mark?token=<TOKEN>` (form) → `studentId=<ID>`
- `GET  /attendance?classId=<ID>&date=YYYY-MM-DD` → list attendance

### cURL Examples
```bash
# Add a student
curl -X POST -d "name=Alice" http://localhost:7000/students

# Add a class
curl -X POST -d "name=Math" http://localhost:7000/classes

# Generate QR for class 1
curl "http://localhost:7000/generate?classId=1"

# Mark attendance with token and student 1
curl -X POST -d "studentId=1" "http://localhost:7000/mark?token=REPLACE_TOKEN"

# Get attendance for class 1 today
# macOS/Linux
curl "http://localhost:7000/attendance?classId=1&date=$(date +%F)"
# Windows PowerShell (example date)
curl "http://localhost:7000/attendance?classId=1&date=2025-01-01"
```

## Data Storage
- SQLite DB file: `attendance.db` (auto-created on first run)
- Tables: `students`, `classes`, `attendance`, `tokens`
- Token expiry is enforced server-side; expired tokens are rejected

## Notes / Troubleshooting
- If you get `ClassNotFoundException` or cannot load SQLite: ensure classpath includes `lib/*` and that the JARs exist in `lib/`.
- On macOS/Linux, classpath separator is `:` not `;`.
- QR images are written to the project folder as `qr-<token>.png`. The UI loads them via `/qr?f=...`.
- To reset data, stop the app and delete `attendance.db`.

## License
MIT — see `LICENSE` for full text.

## Author
Junaid Shaikh
