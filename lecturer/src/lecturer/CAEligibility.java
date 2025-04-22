package lecturer;

import connection.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojeru_san.complementos.RSTableMetro;

public class CAEligibility extends javax.swing.JFrame {
    private Connection getConnection() throws SQLException {
        Connection conn = dbConnection.connect();
        if (conn == null) {
            throw new SQLException("Failed to establish database connection");
        }
        return conn;
    }
    
    private DefaultTableModel model;
    
    public CAEligibility() {
        initComponents();
        getCAeligibility(tbl_eligibility, "");
    }
    
    
    
public void getCAeligibility(RSTableMetro table, String searchValue) {
    String sql = "SELECT m.ug_id, m.course_id, m.quiz_1, m.quiz_2, m.quiz_3, m.quiz_4, " +
                 "m.assesment, m.mid_term, cm.ca_mark, ce.ca_eligibility_status " +
                 "FROM marks m " +
                 "LEFT JOIN ca_marks cm ON m.ug_id = cm.ug_id AND m.course_id = cm.course_id " +
                 "LEFT JOIN ca_eligibility ce ON m.ug_id = ce.ug_id AND m.course_id = ce.course_id " +
                 "WHERE CONCAT(m.ug_id, m.course_id, m.quiz_1, m.quiz_2, m.quiz_3, m.quiz_4, " +
                 "m.assesment, m.mid_term, cm.ca_mark, ce.ca_eligibility_status) LIKE ? " +
                 "ORDER BY m.ug_id ASC";
    
    try (Connection con = getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, "%" + searchValue + "%");
        
        try (ResultSet result = ps.executeQuery()) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            
            while (result.next()) {
                model.addRow(new Object[]{
                    result.getString("ug_id"),
                    result.getString("course_id"),
                    result.getFloat("quiz_1"),
                    result.getFloat("quiz_2"),
                    result.getFloat("quiz_3"),
                    result.getFloat("quiz_4"),
                    result.getFloat("assesment"),
                    result.getFloat("mid_term"),
                    result.getDouble("ca_mark"),
                    result.getString("ca_eligibility_status")
                });
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, 
            "Error loading CA eligibility data: " + ex.getMessage(),
            "Database Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void tableviewStuedntCAeLIGIBILITY(){
        getCAeligibility(tbl_eligibility, "");
        model = (DefaultTableModel) tbl_eligibility.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_eligibility = new rojeru_san.complementos.RSTableMetro();
        txt_search = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_refresh = new rojerusan.RSMaterialButtonCircle();
        btn_search = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        tbl_eligibility.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Course Code", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Assessment", "Mid Marks", "CA Marks", "Eligibility"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_eligibility.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbl_eligibility.setRowHeight(30);
        jScrollPane1.setViewportView(tbl_eligibility);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Search Student ID :");

        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 187, 187));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CA ELIGIBILITY ");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(153, 187, 187));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dashboard.setBackground(new java.awt.Color(0, 0, 0));
        lbl_dashboard.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_dashboard.setForeground(new java.awt.Color(0, 0, 0));
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
        lbl_marks.setForeground(new java.awt.Color(0, 0, 0));
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
        lbl_student.setForeground(new java.awt.Color(0, 0, 0));
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
        lbl_eligibility.setForeground(new java.awt.Color(255, 255, 255));
        lbl_eligibility.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_eligibility.setText("Eligibility");
        lbl_eligibility.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
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
        lbl_gpa.setForeground(new java.awt.Color(0, 0, 0));
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
        lbl_grades.setForeground(new java.awt.Color(0, 0, 0));
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
        lbl_attendance.setForeground(new java.awt.Color(0, 0, 0));
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
        lbl_medical.setForeground(new java.awt.Color(0, 0, 0));
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
        lbl_notices.setForeground(new java.awt.Color(0, 0, 0));
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
        lbl_course1.setForeground(new java.awt.Color(0, 0, 0));
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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/resize_logo.png"))); // NOI18N
        jLabel6.setText("jLabel1");
        jPanel13.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        if(txt_search.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter course code or student ID");
        }else{
            getCAeligibility(tbl_eligibility, "");
            txt_search.setText("");
        }
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:

        if(txt_search.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter course code or student ID");
        }else{
            getCAeligibility(tbl_eligibility, txt_search.getText());
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
        // TODO add your handling code here:
        Lecture_profile lectureDashboard = new Lecture_profile();
        lectureDashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lbl_marksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_marksMouseClicked
        // TODO add your handling code here:
        UploadMarksExams uploadMarksExams = new UploadMarksExams();
        uploadMarksExams.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_marksMouseClicked

    private void lbl_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_studentMouseClicked
        // TODO add your handling code here:
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_studentMouseClicked

    private void lbl_eligibilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_eligibilityMouseClicked
        // TODO add your handling code here:
        CAEligibility cAEligibility = new CAEligibility();
        cAEligibility.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_eligibilityMouseClicked

    private void lbl_gpaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gpaMouseClicked
        // TODO add your handling code here:
        GPAcalculation gPAcalculation = new GPAcalculation();
        gPAcalculation.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_gpaMouseClicked

    private void lbl_gradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gradesMouseClicked
        // TODO add your handling code here:
        GradePoint gradePoint = new GradePoint();
        gradePoint.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_gradesMouseClicked

    private void lbl_attendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_attendanceMouseClicked
        // TODO add your handling code here:
        Attendance attendance = new Attendance();
        attendance.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_attendanceMouseClicked

    private void lbl_medicalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_medicalMouseClicked
        // TODO add your handling code here:
        MedicalLEC medicalLEC = new MedicalLEC();
        medicalLEC.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_medicalMouseClicked

    private void lbl_noticesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_noticesMouseClicked
        // TODO add your handling code here:
                Notice notice =  new Notice();
                notice.setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_lbl_noticesMouseClicked

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?","Logout",JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            //            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void lbl_course1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_course1MouseClicked
        // TODO add your handling code here:
        AddCourseMaterials addCourseMaterials = new AddCourseMaterials();
        addCourseMaterials.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_course1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CAEligibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CAEligibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CAEligibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CAEligibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CAEligibility().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_refresh;
    private rojerusan.RSMaterialButtonCircle btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
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
    private rojeru_san.complementos.RSTableMetro tbl_eligibility;
    private app.bolivia.swing.JCTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
