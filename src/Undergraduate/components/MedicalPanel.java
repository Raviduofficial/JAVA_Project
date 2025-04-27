package Undergraduate.components;

import Database.dbconnection;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class MedicalPanel extends JPanel {

    private String userId;
    private dbconnection dbConnector;
    private JTable table;
    private DefaultTableModel tableModel;

    public MedicalPanel(String userId, dbconnection dbConnector) {
        this.userId = userId;
        this.dbConnector = dbConnector;
        setLayout(new BorderLayout());

        initUI();
    }

    private void initUI() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(153,187,187));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("Approved Medicals");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);

        titlePanel.add(titleLabel, BorderLayout.WEST);
        add(titlePanel, BorderLayout.NORTH);

        // Table model
        tableModel = new DefaultTableModel(new String[] {
                "Course ID","Session Type", "Reason", "Date"
        }, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 15));
        header.setBackground(new Color(102, 153, 255));
        header.setForeground(Color.WHITE);

        table.setRowHeight(28);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.setDefaultEditor(Object.class, null);

        table.setFillsViewportHeight(true);

        // Custom renderer to color status column
        table.getColumnModel().getColumn(3).setCellRenderer(new StatusCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        add(scrollPane, BorderLayout.CENTER);

        loadMedicalData();
    }

    private void loadMedicalData() {
        String query = "SELECT course_id, session_type, reason, medical_date " +
                "FROM medical WHERE ug_id = ? ORDER BY medical_date DESC";

        try (Connection conn = dbconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String courseId = rs.getString("course_id");
                String sessionType = rs.getString("session_type");
                Date date = rs.getDate("medical_date");
                String reason = rs.getString("reason");

                tableModel.addRow(new Object[] {
                        courseId,sessionType, reason, date.toString(),
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading medical data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Renderer for status column with color
    private static class StatusCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int col) {
            JLabel cell = (JLabel) super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, col
            );
            String status = value.toString();
            cell.setFont(cell.getFont().deriveFont(Font.BOLD));

            switch (status.toLowerCase()) {
                case "approved":
                    cell.setForeground(new Color(0, 128, 0)); // green
                    break;
                case "pending":
                    cell.setForeground(new Color(255, 165, 0)); // orange
                    break;
                case "rejected":
                    cell.setForeground(Color.RED);
                    break;
                default:
                    cell.setForeground(Color.BLACK);
            }

            cell.setHorizontalAlignment(SwingConstants.CENTER);
            return cell;
        }
    }
}
