import java.sql.*;
import java.util.Scanner;

public class Teacher {
    Scanner sc = new Scanner(System.in);

    public void addTeacher() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO teachers(name, subject, email) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            System.out.print("Enter name: ");
            pst.setString(1, sc.nextLine());
            System.out.print("Enter subject: ");
            pst.setString(2, sc.nextLine());
            System.out.print("Enter email: ");
            pst.setString(3, sc.nextLine());
            pst.executeUpdate();
            System.out.println("Teacher added successfully.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewTeachers() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM teachers";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Subject: " + rs.getString("subject")
                        + ", Email: " + rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
