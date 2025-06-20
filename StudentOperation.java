import java.sql.*;
import java.util.Scanner;

public class StudentOperations {
    public static void addStudent(Scanner sc) {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO students(id,name,email) VALUES(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.executeUpdate();
            System.out.println("✔️ Student added!");
        } catch (SQLException e) {
            System.err.println("Add Error: " + e);
        }
    }

    public static void viewStudents() {
        System.out.println("ID | Name | Email");
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.printf("%d | %s | %s\n",
                    rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            System.err.println("View Error: " + e);
        }
    }
}
