import javax.swing.*;
import java.sql.*;
import java.awt.FlowLayout;


public class RoomManagement extends JFrame {
    public RoomManagement() {
        setTitle("Room Management");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton viewRooms = new JButton("View Available Rooms");
        add(viewRooms);

        viewRooms.addActionListener(e -> viewRooms());
    }

    private void viewRooms() {
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM rooms WHERE occupied < capacity");
            StringBuilder data = new StringBuilder("Available Rooms:\n");
            while (rs.next()) {
                data.append("Room ").append(rs.getInt("room_number")).append(" (")
                    .append(rs.getString("room_type")).append(")\n");
            }
            JOptionPane.showMessageDialog(this, data.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

