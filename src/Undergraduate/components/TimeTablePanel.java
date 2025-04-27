package Undergraduate.components;

import Database.dbconnection;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class TimeTablePanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private dbconnection dbConnector;

    public TimeTablePanel(dbconnection dbConnector) {
        this.dbConnector = dbConnector;
        setLayout(new BorderLayout());
        
        initUI();
    }

    private void initUI() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(153,187,187));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("Weekly Time Table");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);

        titlePanel.add(titleLabel, BorderLayout.WEST);
        add(titlePanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{
                "Day", "Start Time", "End Time", "Course ID", "Session Type", "Lecturer ID", "Department"
        });

        table = new JTable(tableModel);
        styleTable();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        add(scrollPane, BorderLayout.CENTER);

        loadTimeTableData();
    }

    private void styleTable() {
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(28);
        table.setGridColor(new Color(220, 230, 240));
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);
        table.setDefaultEditor(Object.class, null);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(102, 153, 255));
        header.setForeground(Color.WHITE);

        table.setSelectionBackground(new Color(184, 207, 251));
        table.setSelectionForeground(Color.BLACK);
    }

    private void loadTimeTableData() {
        String query = "SELECT day, start_time,end_time, course_id, session_type, lec_id, department FROM time_table ORDER BY FIELD(day, 'Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday'), start_time";

        try (Connection conn = dbconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String day = rs.getString("day");
                String startTime = rs.getString("start_time");
                String endTime = rs.getString("end_time");
                String courseId = rs.getString("course_id");
                String sessionType = rs.getString("session_type");
                String lecId = rs.getString("lec_id");
                String dept = rs.getString("department");

                tableModel.addRow(new Object[]{day, startTime,endTime, courseId, sessionType, lecId, dept});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load timetable: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
