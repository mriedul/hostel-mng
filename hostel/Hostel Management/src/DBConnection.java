import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/HostelDB";
    private static final String USER = "root"; // Change this
    private static final String PASSWORD = "Priyanshu@06"; // Change this

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
