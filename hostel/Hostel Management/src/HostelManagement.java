import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HostelManagement extends JFrame {
    public HostelManagement() {
        setTitle("Hostel Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JButton studentButton = new JButton("Manage Students");
        JButton roomButton = new JButton("Manage Rooms");
        JButton paymentButton = new JButton("Manage Payments");
        JButton exitButton = new JButton("Exit");

        add(studentButton);
        add(roomButton);
        add(paymentButton);
        add(exitButton);

        studentButton.addActionListener(e -> new StudentManagement().setVisible(true));
        roomButton.addActionListener(e -> new RoomManagement().setVisible(true));
        paymentButton.addActionListener(e -> new PaymentManagement().setVisible(true));
        exitButton.addActionListener(e -> System.exit(0));
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
    
}