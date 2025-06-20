import java.util.Scanner;

public class EduMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Educational Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> StudentOperations.addStudent(sc);
                case 2 -> StudentOperations.viewStudents();
                case 3 -> CourseOperations.addCourse(sc);
                case 4 -> CourseOperations.viewCourses();
                case 5 -> System.out.println("👋 Exiting... Thank you!");
                default -> System.out.println("❌ Invalid Choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
