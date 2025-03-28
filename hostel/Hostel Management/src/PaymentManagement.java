import javax.swing.*;
import java.sql.*;
import java.awt.FlowLayout;


public class PaymentManagement extends JFrame {
    public PaymentManagement() {
        setTitle("Payment Management");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton viewPayments = new JButton("View Pending Payments");
        add(viewPayments);

        viewPayments.addActionListener(e -> viewPayments());
    }

    private void viewPayments() {
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM payments WHERE payment_status = 'Pending'");
            StringBuilder data = new StringBuilder("Pending Payments:\n");
            while (rs.next()) {
                data.append("Student ID: ").append(rs.getInt("student_id")).append(", Amount: ")
                    .append(rs.getDouble("amount")).append("\n");
            }
            JOptionPane.showMessageDialog(this, data.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
