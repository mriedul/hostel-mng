import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentManagement extends JFrame {
    private JTextField nameField, ageField, contactField, emailField;
    private JButton addButton, viewButton;

    public StudentManagement() {
        setTitle("Student Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Contact:"));
        contactField = new JTextField();
        add(contactField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        addButton = new JButton("Add Student");
        add(addButton);
        viewButton = new JButton("View Students");
        add(viewButton);

        addButton.addActionListener(e -> addStudent());
        viewButton.addActionListener(e -> viewStudents());
    }

    private void addStudent() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO students (name, age, contact, email, check_in_date) VALUES (?, ?, ?, ?, NOW())";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nameField.getText());
            pstmt.setInt(2, Integer.parseInt(ageField.getText()));
            pstmt.setString(3, contactField.getText());
            pstmt.setString(4, emailField.getText());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student Added Successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Adding Student!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void viewStudents() {
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            StringBuilder data = new StringBuilder("Student List:\n");
            while (rs.next()) {
                data.append(rs.getInt("id")).append(", ")
                    .append(rs.getString("name")).append(", ")
                    .append(rs.getInt("age")).append(", ")
                    .append(rs.getString("contact")).append(", ")
                    .append(rs.getString("email")).append("\n");
            }
            JOptionPane.showMessageDialog(this, data.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Retrieving Students!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
