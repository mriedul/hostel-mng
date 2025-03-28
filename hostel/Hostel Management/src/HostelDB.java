// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class HostelDB {
//     // MySQL Server Connection (Without a specific database)
//     private static final String URL = "jdbc:mysql://localhost:3306/";
//     private static final String USER = "root"; // Change this
//     private static final String PASSWORD = "Priyanshu@06"; // Change this

//     public static void main(String[] args) {
//         Connection connection = null;
//         Statement statement = null;

//         try {
//             // Load MySQL JDBC Driver
//             Class.forName("com.mysql.cj.jdbc.Driver");

//             // Connect to MySQL Server
//             connection = DriverManager.getConnection(URL, USER, PASSWORD);
//             System.out.println("Connected to MySQL Server successfully!");

//             // Create Statement
//             statement = connection.createStatement();

//             // SQL to create a database
//             String sql = "CREATE DATABASE IF NOT EXISTS HostelDB";
//             statement.executeUpdate(sql);
//             System.out.println("Hostel Database created successfully!");

//         } catch (ClassNotFoundException e) {
//             System.err.println("MySQL JDBC Driver not found!");
//             e.printStackTrace();
//         } catch (SQLException e) {
//             System.err.println("Database creation error!");
//             e.printStackTrace();
//         } finally {
//             // Close resources
//             try {
//                 if (statement != null) statement.close();
//                 if (connection != null) connection.close();
//             } catch (SQLException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }
