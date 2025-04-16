package lecturer;

//import student.Login;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddCourseMaterials extends javax.swing.JFrame {
    
    Course course = new Course();
    private int rowIndex;
    private DefaultTableModel model;

    public AddCourseMaterials() {
        initComponents();
        init();
    }
    
    public  void init(){
        tableviewLecturer();
    }
    
    private void tableviewLecturer(){
        course.getCourseValue(course_table, "");
        model = (DefaultTableModel) course_table.getModel();
    }
    
    private void clearCourseMaterials(){
        txt_course_Id.setText(null);
        txt_CourseName.setText(null);
        txt_LecId.setText(null);
        txt_credit.setText(null);
        ComboBox_course_type.setSelectedIndex(0);
        txt_driverlink.setText(null);
        course_table.clearSelection();
    }
    
    public boolean isEmptyCourse(){
        if(txt_course_Id.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Course Code is missing");
            return false;
        }
        if(txt_CourseName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Course Name is missing");
            return false;
        }
        if(txt_LecId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Course Lecture ID is missing");
            return false;
        }
        if(txt_credit.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Course Credit is missing");
            return false;
        }
        if(txt_driverlink.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Course Material is missing");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        txt_course_Id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_CourseName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_LecId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_credit = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Update_Button = new rojerusan.RSMaterialButtonCircle();
        Clear_Button = new rojerusan.RSMaterialButtonCircle();
        jLabel3 = new javax.swing.JLabel();
        Add_Button = new rojerusan.RSMaterialButtonCircle();
        ComboBox_course_type = new javax.swing.JComboBox<>();
        Delete_Button = new rojerusan.RSMaterialButtonCircle();
        jLabel11 = new javax.swing.JLabel();
        txt_driverlink = new app.bolivia.swing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        course_table = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/back.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        txt_course_Id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_course_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_IdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_course_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 320, 35));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Course Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 130, 30));

        txt_CourseName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 320, 35));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lecture ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 130, 30));

        txt_LecId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_LecId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 320, 35));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Credit");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 90, 30));

        txt_credit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 320, 35));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Course Type");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 120, 40));

        Update_Button.setText("UPDATE");
        Update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Update_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 150, 60));

        Clear_Button.setText("Clear");
        Clear_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Clear_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 150, 60));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 30));

        Add_Button.setText("ADD");
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 150, 60));

        ComboBox_course_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theory", "Practical", "Theory/Practical", " " }));
        jPanel1.add(ComboBox_course_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 320, 35));

        Delete_Button.setText("Delete");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Delete_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, 150, 60));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Add Materials");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 130, 40));

        txt_driverlink.setText("Enter your Driver Link");
        txt_driverlink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_driverlinkMouseClicked(evt);
            }
        });
        txt_driverlink.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_driverlinkKeyPressed(evt);
            }
        });
        jPanel1.add(txt_driverlink, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 320, 35));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Courses");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        course_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Course Id", "Course Name", "Lecture ID", "Credit", "Course Type", "Lecture Materials"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        course_table.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        course_table.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        course_table.setRowHeight(25);
        course_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                course_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(course_table);
        if (course_table.getColumnModel().getColumnCount() > 0) {
            course_table.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Clear_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_ButtonActionPerformed
        clearCourseMaterials();
    }//GEN-LAST:event_Clear_ButtonActionPerformed

    private void Update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_ButtonActionPerformed
        if(isEmptyCourse()){
                String courseId = txt_course_Id.getText();
                String courseName = txt_CourseName.getText();
                String lecId = txt_LecId.getText();
                int credit = Integer.parseInt(txt_credit.getText());
                String course_type = ComboBox_course_type.getSelectedItem().toString();
                String lecture_materials = txt_driverlink.getText();
                
                course.update(courseId, courseName, lecId, credit, course_type, lecture_materials);
                clearCourseMaterials();
                course.getCourseValue(course_table, "");
                
        }
    }//GEN-LAST:event_Update_ButtonActionPerformed

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked

    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ButtonActionPerformed
        // TODO add your handling code here:
        if(isEmptyCourse()){
            if(!course.isCourseCodeExist(txt_course_Id.getText())){
                String courseId = txt_course_Id.getText();
                String courseName = txt_CourseName.getText();
                String lecId = txt_LecId.getText();
                int credit = Integer.parseInt(txt_credit.getText());
                String course_type = ComboBox_course_type.getSelectedItem().toString();
                String lecture_materials = txt_driverlink.getText();
                
                course.insert(courseId, courseName, lecId, credit, course_type, lecture_materials);
                course.getCourseValue(course_table, "");
                clearCourseMaterials();
            }else{
                JOptionPane.showMessageDialog(this, "Course code Already Exist !!!");
            }
        }
    }//GEN-LAST:event_Add_ButtonActionPerformed

    private void txt_course_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_IdActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        LectureDashboard dash = new LectureDashboard();
        dash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void course_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course_tableMouseClicked
        // TODO add your handling code here:
        model = (DefaultTableModel) course_table.getModel();
        rowIndex = course_table.getSelectedRow();
        txt_course_Id.setText(model.getValueAt(rowIndex, 0).toString());
        txt_CourseName.setText(model.getValueAt(rowIndex, 1).toString());
        txt_LecId.setText(model.getValueAt(rowIndex, 2).toString());
        txt_credit.setText(model.getValueAt(rowIndex, 3).toString());
        String ct = model.getValueAt(rowIndex, 4).toString();
        switch (ct) {
            case "Theory":
                ComboBox_course_type.setSelectedIndex(0);
                break;
            case "Practical":
                ComboBox_course_type.setSelectedIndex(1);
                break;
            default:
                ComboBox_course_type.setSelectedIndex(2);
                break;
        }
        txt_driverlink.setText(model.getValueAt(rowIndex, 5).toString());
    }//GEN-LAST:event_course_tableMouseClicked

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        if(course.delete(txt_course_Id.getText()) == true ){
            JOptionPane.showMessageDialog(this, "Course Deleted Successfully..");
            clearCourseMaterials();
            course.getCourseValue(course_table, "");
        }else{
            JOptionPane.showMessageDialog(this, "Course Deleted Failed!!");
        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void txt_driverlinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_driverlinkMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_driverlinkMouseClicked

    private void txt_driverlinkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_driverlinkKeyPressed
        // TODO add your handling code here:
        txt_driverlink.setText("");
    }//GEN-LAST:event_txt_driverlinkKeyPressed

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
            java.util.logging.Logger.getLogger(AddCourseMaterials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCourseMaterials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCourseMaterials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCourseMaterials.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCourseMaterials().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Add_Button;
    private rojerusan.RSMaterialButtonCircle Clear_Button;
    private javax.swing.JComboBox<String> ComboBox_course_type;
    private rojerusan.RSMaterialButtonCircle Delete_Button;
    private rojerusan.RSMaterialButtonCircle Update_Button;
    private javax.swing.JLabel back;
    private rojeru_san.complementos.RSTableMetro course_table;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_CourseName;
    private javax.swing.JTextField txt_LecId;
    private javax.swing.JTextField txt_course_Id;
    private javax.swing.JTextField txt_credit;
    private app.bolivia.swing.JCTextField txt_driverlink;
    // End of variables declaration//GEN-END:variables
}
