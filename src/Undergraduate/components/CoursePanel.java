package Undergraduate.components;

import Database.dbconnection;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.File;
import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CoursePanel extends JPanel {
    private JTable courseTable;
    private DefaultTableModel courseTableModel;
    private JComboBox<String> courseComboBox;
    private JButton loadMaterialsButton;
    private JTable lectureMaterialTable;
    private DefaultTableModel lectureMaterialTableModel;

    public CoursePanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255)); // Light bluish background

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(153,187,187));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("Course Overview");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);

        titlePanel.add(titleLabel, BorderLayout.WEST);
        add(titlePanel, BorderLayout.NORTH);

        // Panel for course selection and button
        JPanel courseSelectionPanel = new JPanel();
        courseSelectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel courseLabel = new JLabel("Select Course:");
        courseSelectionPanel.add(courseLabel);

        courseComboBox = new JComboBox<>();
        courseSelectionPanel.add(courseComboBox);

        loadMaterialsButton = new JButton("Load Lecture Materials");
        loadMaterialsButton.addActionListener(e -> loadLectureMaterials());
        courseSelectionPanel.add(loadMaterialsButton);

        add(courseSelectionPanel, BorderLayout.CENTER);

        // Table for showing lecture materials
        String[] lectureColumns = {"Material ID", "Material Name", "Material Type", "Material Path"};
        lectureMaterialTableModel = new DefaultTableModel(lectureColumns, 0);
        lectureMaterialTable = new JTable(lectureMaterialTableModel) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        lectureMaterialTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lectureMaterialTable.setRowHeight(30);
        lectureMaterialTable.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(lectureMaterialTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        add(scrollPane, BorderLayout.SOUTH);

        // Load courses into JComboBox
        loadCourseData();
    }

    private void loadCourseData() {
        dbconnection mdc = new dbconnection();
        try (Connection con = mdc.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM course")) {

            while (rs.next()) {
                String courseName = rs.getString("course_name");
                courseComboBox.addItem(courseName);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading course data: " + e.getMessage());
        }
    }

    private void loadLectureMaterials() {
        String selectedCourse = (String) courseComboBox.getSelectedItem();
        if (selectedCourse == null) {
            JOptionPane.showMessageDialog(this, "Please select a course first.");
            return;
        }

        // Clear previous lecture material data
        lectureMaterialTableModel.setRowCount(0);

        dbconnection mdc = new dbconnection();
        try (Connection con = mdc.getConnection();
             PreparedStatement stmt = con.prepareStatement(
                     "SELECT lm.material_id, lm.material_name, lm.material_type, lm.material_path " +
                             "FROM lecture_materials lm " +
                             "JOIN course c ON lm.course_id = c.course_id " +
                             "WHERE c.course_name = ?")) {

            stmt.setString(1, selectedCourse);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int materialId = rs.getInt("material_id");
                String materialName = rs.getString("material_name");
                String materialType = rs.getString("material_type");
                String materialPath = rs.getString("material_path");

                // Add the fetched material directly into the table
                lectureMaterialTableModel.addRow(new Object[] {
                        materialId, materialName, materialType, materialPath
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading lecture materials: " + e.getMessage());
        }

        // Add mouse listener to handle click on "Download/Open"
        lectureMaterialTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = lectureMaterialTable.rowAtPoint(e.getPoint());
                int column = lectureMaterialTable.columnAtPoint(e.getPoint());

                if (column == 3) { // Action column (Download/Open)
                    String filePath = (String) lectureMaterialTable.getValueAt(row, 3);
                    String action = JOptionPane.showInputDialog(null,
                            "Would you like to open or download this file?\nEnter 'open' to view or 'download' to download.",
                            "Choose Action", JOptionPane.QUESTION_MESSAGE);

                    if ("open".equalsIgnoreCase(action)) {
                        openFile(filePath);
                    } else if ("download".equalsIgnoreCase(action)) {
                        downloadFile(filePath);
                    } else {
                        JOptionPane.showMessageDialog(CoursePanel.this, "Invalid option.");
                    }
                }
            }
        });
    }

    private void openFile(String filePath) {
        File file = new File(filePath);
        System.out.println("Attempting to open file at: " + filePath);  // Debugging line

        if (file.exists()) {
            try {
                // If the file type is supported, open the file directly
                if (Desktop.isDesktopSupported()) {
                    if (filePath.endsWith(".pdf") || filePath.endsWith(".docx") || filePath.endsWith(".txt")) {
                        Desktop.getDesktop().open(file); // Open the file in the default viewer
                    } else {
                        JOptionPane.showMessageDialog(this, "Unsupported file type for automatic opening.");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Failed to open the file: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "File does not exist at the path: " + filePath);
        }
    }

    private void downloadFile(String filePath) {
        File sourceFile = new File(filePath);
        if (sourceFile.exists()) {
            try {
                // Define the target path (user's Downloads folder)
                String userHome = System.getProperty("user.home");
                String downloadFolder = userHome + File.separator + "Downloads" + File.separator + sourceFile.getName();
                File targetFile = new File(downloadFolder);

                // Copy the file from source to the target (Downloads folder)
                Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(this, "File downloaded successfully to: " + downloadFolder);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Failed to download the file: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "File does not exist.");
        }
    }
}