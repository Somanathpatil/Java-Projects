import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/attendance_db";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "password"; // Replace with your MySQL password

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}