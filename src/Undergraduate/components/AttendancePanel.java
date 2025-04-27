package Undergraduate.components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import Undergraduate.Attendance.Attendance;
import Database.dbconnection;

public class AttendancePanel extends JPanel {

    private String userId;
    private dbconnection dbConnector;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel tableTitleLabel;
    private JCheckBox medicalCheckBox;
    private JButton viewAttendanceButton;
    private JPanel titlePanel;
    private JLabel mainTitle;

    public AttendancePanel(String userId, dbconnection dbConnector) {
        this.userId = userId;
        this.dbConnector = dbConnector;
        setLayout(null);
    
        initUI();
    }

    private void initUI() {
        // Title Panel (like GradePanel)
        titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 800, 60);
        titlePanel.setBackground(new Color(153,187,187));
        titlePanel.setLayout(null);

        mainTitle = new JLabel("Attendance Overview");
        mainTitle.setBounds(20, 5, 800, 50);
        mainTitle.setForeground(Color.WHITE);
        mainTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titlePanel.add(mainTitle);

        add(titlePanel);

        // Medical Checkbox
        medicalCheckBox = new JCheckBox("Medical");
        medicalCheckBox.setFocusable(false);
        medicalCheckBox.setFocusPainted(false);
        medicalCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        medicalCheckBox.setBounds(20, 70, 100, 25);
        
        add(medicalCheckBox);

        // View Attendance Button
        viewAttendanceButton = new JButton("View Attendance");
        viewAttendanceButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        viewAttendanceButton.setBounds(130, 70, 160, 25);
        viewAttendanceButton.setBackground(new Color(102, 153, 255));
        viewAttendanceButton.setForeground(Color.WHITE);
        viewAttendanceButton.setBorderPainted(false);
        viewAttendanceButton.setFocusable(false);
        viewAttendanceButton.setFocusPainted(false);
        add(viewAttendanceButton);

        // Table Title Label
        tableTitleLabel = new JLabel("");
        tableTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        tableTitleLabel.setBounds(20, 105, 400, 25);
        add(tableTitleLabel);


        // Table Setup
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel) {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    c.setBackground(row % 2 == 0 ? new Color(245, 245, 245) : Color.WHITE);
                }
                return c;
            }
        };

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(102, 153, 255));
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);

        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(28);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);
        table.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 140, 740, 280);
        scrollPane.getViewport().setBackground(Color.WHITE);


        // Button Action
        viewAttendanceButton.addActionListener(e -> {
            boolean includeMedical = medicalCheckBox.isSelected();
            loadAttendanceData(includeMedical);
        });
        loadAttendanceData(false);
        add(scrollPane);
    }

    private void loadAttendanceData(boolean includeMedical) {
        Attendance attendance = new Attendance();
        DefaultTableModel model = includeMedical
                ? attendance.attendanceWithUgIdWithMedical(userId)
                : attendance.attendanceWithUgIdWithoutMedical(userId);

        table.setModel(model);
        styleTable();

        tableTitleLabel.setText(includeMedical
                ? "Attendance (With Medical)"
                : "Attendance (Without Medical)");
    }

    private void styleTable() {
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(102, 153, 255));
        header.setForeground(Color.WHITE);
    }
}
