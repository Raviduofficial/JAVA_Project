package Undergraduate.components;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.dbconnection;

public class GradePanel extends JPanel {

    private JPanel titlePanel;
    private JLabel titleLabel;
    private Font titleFont;
    private Color titleColor;
    private JTable gradesTable;
    private DefaultTableModel gradesTableModel;
    private JScrollPane scrollPane;
    private JTableHeader gradesTableHeader;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;


    public GradePanel(String userId) {
        initUI(userId);
    }
    private void initUI(String userId){
        setLayout(null);

        titleFont = new Font("Segoe UI", Font.BOLD, 22);
        titleColor = new Color(54, 57, 63);

        titlePanel = new JPanel();
        titlePanel.setBounds(0,0,800,60);
        titlePanel.setBackground(new Color(153,187,187));
        titlePanel.setOpaque(true);

        titleLabel = new JLabel("Grades & GPA");
        titleLabel.setBounds(20,5,800,50);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleFont);


        add(titleLabel);
        add(titlePanel);

        createGradeTable(userId);
        loadGrades(userId);

    }
    private void createGradeTable(String userId){

        String[] columnNames = {"Course Code","Course Name","Grades","SGPA","CGPA"};

        gradesTableModel = new DefaultTableModel(columnNames,0);
        gradesTable = new JTable(gradesTableModel);

        gradesTable.setDefaultEditor(Object.class, null);
        gradesTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gradesTable.setRowHeight(28);
        gradesTable.setGridColor(Color.LIGHT_GRAY);
        gradesTable.setShowVerticalLines(false);
        gradesTable.setShowHorizontalLines(true);
        gradesTable.setDefaultEditor(Object.class, null);

        gradesTableHeader = gradesTable.getTableHeader();
        gradesTableHeader.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gradesTableHeader.setBackground(new Color(102, 153, 255));
        gradesTableHeader.setForeground(Color.WHITE);
        gradesTableHeader.setReorderingAllowed(false);

        scrollPane = new JScrollPane(gradesTable);
        scrollPane.setBounds(20,100,760,300);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        scrollPane.getViewport().setBackground(Color.WHITE);

        DefaultTableCellRenderer rightAlign = new DefaultTableCellRenderer();
        rightAlign.setHorizontalAlignment(SwingConstants.RIGHT);

        gradesTable.getColumnModel().getColumn(3).setCellRenderer(rightAlign);
        gradesTable.getColumnModel().getColumn(4).setCellRenderer(rightAlign);

        gradesTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        gradesTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        gradesTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        gradesTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        gradesTable.getColumnModel().getColumn(4).setPreferredWidth(80);

        for(int i = 0; i < gradesTable.getColumnCount(); i++){
            gradesTable.getColumnModel().getColumn(i).setResizable(false);
        }


        add(scrollPane);

    }
    private void loadGrades(String userId){
        String sql = "select * from gradesOfUgs where ug_id = ?";
        con = dbconnection.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                String courseCode = rs.getString("course_id");
                String courseName = rs.getString("course_name");
                String grade = rs.getString("grade");
                String sgpa = rs.getString("SGPA");
                String cgpa = rs.getString("CGPA");

                gradesTableModel.addRow(new Object[]{courseCode, courseName, grade, sgpa, cgpa});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error loading Grades data: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
