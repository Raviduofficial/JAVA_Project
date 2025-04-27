package lecturer;

import Database.dbconnection;
import Login.Login;

import java.awt.Color;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class UploadMarksExams extends javax.swing.JFrame {

    marks marks = new marks();
    private DefaultTableModel model;
    private int rowIndex;
    private String currentUserId;

    public UploadMarksExams(String userId) {
        this.currentUserId = userId;

        initComponents();

        setResizable(false);
        Lecture_ID.setText(currentUserId);
        Lecture_ID.setEditable(false);
        tableViewMarks();
        SwingUtilities.invokeLater(() -> {
            setComboBox(userId);
        });

    }

    private void tableViewMarks() {
        marks.getMarksValues(Marks_table, currentUserId);
        model = (DefaultTableModel) Marks_table.getModel();
        Marks_table.setRowHeight(30);
        Marks_table.setShowGrid(true);
    }

    private void clearMarks() {
        Lecture_ID.setText(currentUserId);
        Student_ID.setText(null);
        Quiz_1.setText(null);
        Quiz_2.setText(null);
        Quiz_3.setText(null);
        Quiz_4.setText(null);
        assesmnent_1.setText(null);
        assesmnent_2.setText(null);
        Mid_term.setText(null);
        final_T.setText(null);
        final_P.setText("Only enter Update & Delete");
        Marks_table.clearSelection();
        resetAllMarkFields();
    }

    public boolean isEmptyMarks() {
        if (Mark_ID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mark ID is Empty");
            return false;
        }
        if (Lecture_ID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "lecture ID is Empty");
            return false;
        }
        if (Student_ID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID is Empty");
            return false;
        }
        return true;
    }

    private void setComboBox(String userId) {
        if (Course_ID == null) {
            System.out.println("Course_ID is null!");
            return;
        }
        String sql = "select course_id from course where lec_id = ?";
        try (Connection con = dbconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                Course_ID.addItem(id);
            }
        } catch (Exception ex) { 
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Mark_ID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Lecture_ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Student_ID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Quiz_1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Update_Button = new rojerusan.RSMaterialButtonCircle();
        Clear_Button = new rojerusan.RSMaterialButtonCircle();
        jLabel3 = new javax.swing.JLabel();
        Add_Button = new rojerusan.RSMaterialButtonCircle();
        Delete_Button = new rojerusan.RSMaterialButtonCircle();
        jLabel15 = new javax.swing.JLabel();
        Quiz_2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Quiz_3 = new javax.swing.JTextField();
        Quiz_4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        assesmnent_1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Mid_term = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        final_T = new javax.swing.JTextField();
        final_P = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Course_ID = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        assesmnent_2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Marks_table = new rojeru_san.complementos.RSTableMetro();
        jPanel13 = new javax.swing.JPanel();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_marks = new javax.swing.JLabel();
        lbl_student = new javax.swing.JLabel();
        lbl_eligibility = new javax.swing.JLabel();
        lbl_gpa = new javax.swing.JLabel();
        lbl_grades = new javax.swing.JLabel();
        lbl_attendance = new javax.swing.JLabel();
        lbl_medical = new javax.swing.JLabel();
        lbl_notices = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        lbl_course1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Mark_ID.setText("Only enter update & Delete");
        Mark_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Mark_ID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Mark_IDMouseClicked(evt);
            }
        });
        Mark_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mark_IDActionPerformed(evt);
            }
        });
        jPanel1.add(Mark_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 190, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Lecture ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        Lecture_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Lecture_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 190, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 20));

        Student_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Student_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 190, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Course ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, 20));

        Quiz_1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Quiz_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 190, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Quiz 1 ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, 20));

        Update_Button.setText("UPDATE");
        Update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Update_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 150, 40));

        Clear_Button.setText("Clear");
        Clear_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Clear_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 150, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mark Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 20));

        Add_Button.setText("ADD");
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 150, 40));

        Delete_Button.setText("Delete");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Delete_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 150, 40));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Quiz 2");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 20));

        Quiz_2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Quiz_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 190, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quiz 3");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 100, 20));

        Quiz_3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Quiz_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 190, 30));

        Quiz_4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Quiz_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 190, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Quiz 4");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 100, 20));

        assesmnent_1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(assesmnent_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 190, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Assessment 1");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 100, 20));

        Mid_term.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Mid_term, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 190, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Mid Term");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 100, 20));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Final Theory");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 100, 20));

        final_T.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(final_T, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 190, 30));

        final_P.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(final_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 190, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Final Practical");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 110, 20));

        Course_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Course_IDActionPerformed(evt);
            }
        });
        jPanel1.add(Course_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, 30));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Assessment 2");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 100, 20));

        assesmnent_2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(assesmnent_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 190, 30));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        Marks_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mark ID", "LectureID", "Student ID", "Course ID", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Ass 1", "Ass 2", "Mid Term", "Final T", "Final P"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Marks_table.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Marks_table.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Marks_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Marks_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Marks_table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(153, 187, 187));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dashboard.setBackground(new java.awt.Color(0, 0, 0));
        lbl_dashboard.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dashboard.setText("Profile");
        lbl_dashboard.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_dashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashboardMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 30));

        lbl_marks.setBackground(new java.awt.Color(0, 0, 0));
        lbl_marks.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_marks.setForeground(new java.awt.Color(255, 255, 255));
        lbl_marks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_marks.setText("Marks");
        lbl_marks.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_marks.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_marks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_marks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_marksMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_marks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 30));

        lbl_student.setBackground(new java.awt.Color(0, 0, 0));
        lbl_student.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_student.setText("Student");
        lbl_student.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_student.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_student.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_studentMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, 30));

        lbl_eligibility.setBackground(new java.awt.Color(0, 0, 0));
        lbl_eligibility.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_eligibility.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_eligibility.setText("Eligibility");
        lbl_eligibility.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_eligibility.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_eligibility.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_eligibility.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_eligibilityMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_eligibility, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, 30));

        lbl_gpa.setBackground(new java.awt.Color(0, 0, 0));
        lbl_gpa.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_gpa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_gpa.setText("GPA");
        lbl_gpa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_gpa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_gpa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_gpa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_gpaMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_gpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 200, 30));

        lbl_grades.setBackground(new java.awt.Color(0, 0, 0));
        lbl_grades.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_grades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_grades.setText("Grades & Final Marks");
        lbl_grades.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_grades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_grades.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_grades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_gradesMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_grades, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 200, 30));

        lbl_attendance.setBackground(new java.awt.Color(0, 0, 0));
        lbl_attendance.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_attendance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_attendance.setText("Attedance");
        lbl_attendance.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_attendance.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_attendance.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_attendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_attendanceMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 200, 30));

        lbl_medical.setBackground(new java.awt.Color(0, 0, 0));
        lbl_medical.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_medical.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_medical.setText("Medical");
        lbl_medical.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_medical.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_medical.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_medical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_medicalMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_medical, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 200, 30));

        lbl_notices.setBackground(new java.awt.Color(0, 0, 0));
        lbl_notices.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_notices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_notices.setText("Notices");
        lbl_notices.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_notices.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_notices.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_notices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_noticesMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_notices, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 200, 30));

        lbl_logout.setBackground(new java.awt.Color(0, 0, 0));
        lbl_logout.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(153, 0, 0));
        lbl_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logout.setText("LOGOUT");
        lbl_logout.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 200, 30));

        lbl_course1.setBackground(new java.awt.Color(0, 0, 0));
        lbl_course1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_course1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_course1.setText("Course");
        lbl_course1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        lbl_course1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_course1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_course1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_course1MouseClicked(evt);
            }
        });
        jPanel13.add(lbl_course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/resize_logo.png"))); // NOI18N
        jLabel5.setText("jLabel1");
        jPanel13.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 110));

        jPanel2.setBackground(new java.awt.Color(153, 187, 187));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Add Marks");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_ButtonActionPerformed
        if (isEmptyMarks()) {
            float q1 = Quiz_1.getText().equals("N/A") ? 0 : Float.parseFloat(Quiz_1.getText());
            float q2 = Quiz_2.getText().equals("N/A") ? 0 : Float.parseFloat(Quiz_2.getText());
            float q3 = Quiz_3.getText().equals("N/A") ? 0 : Float.parseFloat(Quiz_3.getText());
            float q4 = Quiz_4.getText().equals("N/A") ? 0 : Float.parseFloat(Quiz_4.getText());
            float ass_1 = assesmnent_1.getText().equals("N/A") ? 0 : Float.parseFloat(assesmnent_1.getText());
            float ass_2 = assesmnent_2.getText().equals("N/A") ? 0 : Float.parseFloat(assesmnent_2.getText());
            float mid = Mid_term.getText().equals("N/A") ? 0 : Float.parseFloat(Mid_term.getText());
            float f_t = final_T.getText().equals("N/A") ? 0 : Float.parseFloat(final_T.getText());
            float f_p = final_P.getText().equals("N/A") ? 0 : Float.parseFloat(final_P.getText());
            String m_id = Mark_ID.getText();
            String lid = Lecture_ID.getText();
            String sid = Student_ID.getText();
            String cid = (String) Course_ID.getSelectedItem();

            marks.update(m_id, lid, sid, cid, q1, q2, q3, q4, ass_1, ass_2, mid, f_t, f_p);
            clearMarks();
            marks.getMarksValues(Marks_table, currentUserId);
        }
    }//GEN-LAST:event_Update_ButtonActionPerformed

    private void Clear_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_ButtonActionPerformed
        clearMarks();
    }//GEN-LAST:event_Clear_ButtonActionPerformed

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ButtonActionPerformed
        // TODO add your handling code here:
        if (isEmptyMarks()) {
            float q1 = Quiz_1.getText().equals("N/A") ? 0 : Float.parseFloat(Quiz_1.getText());
            float q2 = Quiz_2.getText().equals("N/A") ? 0 : Float.parseFloat(Quiz_2.getText());
            float q3 = Quiz_3.getText().equals("N/A") ? 0 : Float.parseFloat(Quiz_3.getText());
            float q4 = Quiz_4.getText().equals("N/A") ? 0 : Float.parseFloat(Quiz_4.getText());
            float ass_1 = assesmnent_1.getText().equals("N/A") ? 0 : Float.parseFloat(assesmnent_1.getText());
            float ass_2 = assesmnent_2.getText().equals("N/A") ? 0 : Float.parseFloat(assesmnent_2.getText());
            float mid = Mid_term.getText().equals("N/A") ? 0 : Float.parseFloat(Mid_term.getText());
            float f_t = final_T.getText().equals("N/A") ? 0 : Float.parseFloat(final_T.getText());
            float f_p = final_P.getText().equals("N/A") ? 0 : Float.parseFloat(final_P.getText());
            String m_id = Mark_ID.getText();
            String lid = Lecture_ID.getText();
            String sid = Student_ID.getText();
            String cid = (String) Course_ID.getSelectedItem();

            marks.insert(lid, sid, cid, q1, q2, q3, q4, ass_1, ass_2, mid, f_t, f_p);
            marks.getMarksValues(Marks_table, currentUserId);
            clearMarks();
        }
    }//GEN-LAST:event_Add_ButtonActionPerformed

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        if (marks.delete(Mark_ID.getText()) == true) {
            clearMarks();
            marks.getMarksValues(Marks_table, currentUserId);
        } else {
            JOptionPane.showMessageDialog(this, " Enter All Fields!!");
        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void Marks_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Marks_tableMouseClicked
        // TODO add your handling code here:
        model = (DefaultTableModel) Marks_table.getModel();
        rowIndex = Marks_table.getSelectedRow();
        if (rowIndex >= 0) {
            Mark_ID.setText(model.getValueAt(rowIndex, 0).toString());
            Lecture_ID.setText(model.getValueAt(rowIndex, 1).toString());
            Student_ID.setText(model.getValueAt(rowIndex, 2).toString());
            Course_ID.setSelectedItem(model.getValueAt(rowIndex, 3).toString());
            Quiz_1.setText(model.getValueAt(rowIndex, 4).toString());
            Quiz_2.setText(model.getValueAt(rowIndex, 5).toString());
            Quiz_3.setText(model.getValueAt(rowIndex, 6).toString());
            Quiz_4.setText(model.getValueAt(rowIndex, 7).toString());
            assesmnent_1.setText(model.getValueAt(rowIndex, 8).toString());
            assesmnent_2.setText(model.getValueAt(rowIndex, 8).toString());
            Mid_term.setText(model.getValueAt(rowIndex, 9).toString());
            final_T.setText(model.getValueAt(rowIndex, 10).toString());
            final_P.setText(model.getValueAt(rowIndex, 11).toString());
        }
    }//GEN-LAST:event_Marks_tableMouseClicked

    private void Mark_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mark_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mark_IDActionPerformed

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
        // TODO add your handling code here:
        Lecture_profile lectureDashboard = new Lecture_profile(this.currentUserId);
        lectureDashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lbl_course1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_course1MouseClicked
        // TODO add your handling code here:
        AddCourseMaterials addCourseMaterials = new AddCourseMaterials(this.currentUserId);
        addCourseMaterials.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_course1MouseClicked

    private void lbl_marksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_marksMouseClicked
        // TODO add your handling code here:
        UploadMarksExams uploadMarksExams = new UploadMarksExams(this.currentUserId);
        uploadMarksExams.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_marksMouseClicked

    private void lbl_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_studentMouseClicked
        // TODO add your handling code here:
        StudentDetails studentDetails = new StudentDetails(this.currentUserId);
        studentDetails.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_studentMouseClicked

    private void lbl_eligibilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_eligibilityMouseClicked
        // TODO add your handling code here:
        CAEligibility cAEligibility = new CAEligibility(this.currentUserId);
        cAEligibility.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_eligibilityMouseClicked

    private void lbl_gpaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gpaMouseClicked
        // TODO add your handling code here:
        GPAcalculation gPAcalculation = new GPAcalculation(this.currentUserId);
        gPAcalculation.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_gpaMouseClicked

    private void lbl_gradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gradesMouseClicked
        // TODO add your handling code here:
        GradePoint gradePoint = new GradePoint(this.currentUserId);
        gradePoint.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_gradesMouseClicked

    private void lbl_attendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_attendanceMouseClicked
        // TODO add your handling code here:
        Attendance attendance = new Attendance(this.currentUserId);
        attendance.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_attendanceMouseClicked

    private void lbl_medicalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_medicalMouseClicked
        // TODO add your handling code here:
        MedicalLEC medicalLEC = new MedicalLEC(this.currentUserId);
        medicalLEC.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_medicalMouseClicked

    private void lbl_noticesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_noticesMouseClicked
        // TODO add your handling code here:
        Notice notice = new Notice(this.currentUserId);
        notice.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_noticesMouseClicked

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void Mark_IDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Mark_IDMouseClicked
        // TODO add your handling code here:
        Mark_ID.setText("");
    }//GEN-LAST:event_Mark_IDMouseClicked

    private void Course_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Course_IDActionPerformed
        // TODO add your handling code here:
        String selectedCourse = (String) Course_ID.getSelectedItem();

        // Reset all fields to default state
        resetAllMarkFields();

        // Apply course-specific rules
        if (selectedCourse != null) {
            switch (selectedCourse) {
                case "ict2113":
                    setFieldsInactive(Quiz_4, assesmnent_1, assesmnent_2);
                    break;

                case "ict2122":
                    setFieldsInactive(final_P, assesmnent_2);
                    break;

                case "ict2133":
                    setFieldsInactive(Quiz_4, Mid_term);
                    break;

                case "ict2142":
                    setFieldsInactive(Quiz_1, Quiz_2, Quiz_3, Quiz_4, final_T, assesmnent_2);
                    break;

                case "ict2152":
                    setFieldsInactive(Quiz_4, Mid_term, final_P);
                    break;
            }
        }
    }//GEN-LAST:event_Course_IDActionPerformed

    // Helper method to reset all fields to active state
    private void resetAllMarkFields() {
        JTextField[] allFields = {
            Quiz_1, Quiz_2, Quiz_3, Quiz_4, assesmnent_1, assesmnent_2, Mid_term, final_T, final_P
        };

        for (JTextField field : allFields) {
            setFieldActive(field);
        }
    }

    // Method to deactivate multiple fields at once
    private void setFieldsInactive(JTextField... fields) {
        for (JTextField field : fields) {
            setFieldInactive(field);
        }
    }

    // Styles an inactive field
    private void setFieldInactive(JTextField field) {
        field.setEditable(false);
        field.setBackground(new Color(204, 204, 255)); // Light gray
        field.setText("N/A"); // Indicator instead of 0
    }

    // Styles an active field
    private void setFieldActive(JTextField field) {
        field.setEditable(true);
        field.setBackground(Color.WHITE);
        field.setForeground(Color.BLACK);
        field.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Add_Button;
    private rojerusan.RSMaterialButtonCircle Clear_Button;
    private javax.swing.JComboBox<String> Course_ID;
    private rojerusan.RSMaterialButtonCircle Delete_Button;
    private javax.swing.JTextField Lecture_ID;
    private javax.swing.JTextField Mark_ID;
    private rojeru_san.complementos.RSTableMetro Marks_table;
    private javax.swing.JTextField Mid_term;
    private javax.swing.JTextField Quiz_1;
    private javax.swing.JTextField Quiz_2;
    private javax.swing.JTextField Quiz_3;
    private javax.swing.JTextField Quiz_4;
    private javax.swing.JTextField Student_ID;
    private rojerusan.RSMaterialButtonCircle Update_Button;
    private javax.swing.JTextField assesmnent_1;
    private javax.swing.JTextField assesmnent_2;
    private javax.swing.JTextField final_P;
    private javax.swing.JTextField final_T;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_attendance;
    private javax.swing.JLabel lbl_course1;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_eligibility;
    private javax.swing.JLabel lbl_gpa;
    private javax.swing.JLabel lbl_grades;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_marks;
    private javax.swing.JLabel lbl_medical;
    private javax.swing.JLabel lbl_notices;
    private javax.swing.JLabel lbl_student;
    // End of variables declaration//GEN-END:variables
}
