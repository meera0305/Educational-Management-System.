import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;  

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/edudb";
    private static final String USER = "root";  
    private static final String PASS = "your_password";  

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("DBConnection Error: " + e);  
            return null;
        }
    }
}
