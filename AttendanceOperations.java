import java.sql.*;
import java.io.FileWriter;

public class AttendanceOperations {

    // Method to mark attendance
    public static void markAttendance(String name, String date, String status) {
        try (Connection conn = DatabaseConnection.connect()) {
            String query = "INSERT INTO attendance (name, date, status) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, date);
            stmt.setString(3, status);

            stmt.executeUpdate();
            System.out.println("Attendance marked successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to view all attendance records
    public static void viewAttendance() {
        try (Connection conn = DatabaseConnection.connect()) {
            String query = "SELECT * FROM attendance";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("ID | Name       | Date       | Status");
            System.out.println("---------------------------------------");
            while (rs.next()) {
                System.out.printf("%d | %-10s | %-10s | %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("date"),
                        rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to export attendance records to a CSV file
    public static void exportAttendance() {
        try (Connection conn = DatabaseConnection.connect();
             FileWriter writer = new FileWriter("attendance_records.csv")) {

            String query = "SELECT * FROM attendance";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Write header to CSV file
            writer.write("ID,Name,Date,Status\n");

            // Write records to CSV file
            while (rs.next()) {
                writer.write(rs.getInt("id") + "," +
                        rs.getString("name") + "," +
                        rs.getDate("date") + "," +
                        rs.getString("status") + "\n");
            }

            System.out.println("Attendance records exported to 'attendance_records.csv'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}