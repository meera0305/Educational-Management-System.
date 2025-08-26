import java.sql.*;
import java.util.Scanner;

public class CourseOperations {
    public static void addCourse(Scanner sc) {
        System.out.print("Course ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Course Title: ");  
        String title = sc.nextLine();

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO courses(id,title) VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, title);
            pst.executeUpdate();
            System.out.println("✔️ Course added!");
        } catch (SQLException e) {
            System.err.println("Add Error: " + e);
        }
    }

    public static void viewCourses() {
        System.out.println("Course ID | Title");
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM courses");
            while (rs.next()) {
                System.out.printf("%d | %s\n",
                    rs.getInt("id"), rs.getString("title"));
            }
        } catch (SQLException e) {
            System.err.println("View Error: " + e);
        }
    }
}
