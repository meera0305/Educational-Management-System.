import java.sql.*;
import java.util.Scanner;

public class Student {
    public void addStudent() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO student(name, course, age) VALUES (?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, course);
        ps.setInt(3, age);
        ps.executeUpdate();
        System.out.println("Student added successfully!");
    }

    public void viewStudents() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + 
                               ", Name: " + rs.getString("name") + 
                               ", Course: " + rs.getString("course") + 
                               ", Age: " + rs.getInt("age"));
        }
    }
}
