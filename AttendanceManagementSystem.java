import java.util.Scanner;

public class AttendanceManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Attendance Management System ===");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Export Attendance Records");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.next();
                    System.out.print("Enter Status (Present/Absent): ");
                    String status = scanner.next();

                    AttendanceOperations.markAttendance(name, date, status);
                    break;

                case 2:
                    AttendanceOperations.viewAttendance();
                    break;

                case 3:
                    AttendanceOperations.exportAttendance();
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}