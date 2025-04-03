package lecturer;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import student.Login;

public class AddCourseMaterials extends javax.swing.JFrame {
    
    Course course = new Course();
    private int rowIndex;
    int xx, xy;
    private DefaultTableModel model;
    

    public AddCourseMaterials() {
        initComponents();
        init();
    }
    
    public  void init(){
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
        tableviewLecturer();
    }
    
    private void tableviewLecturer(){
        course.getCourseValue(course_table, "");
        model = (DefaultTableModel) course_table.getModel();
        course_table.setRowHeight(30);
        course_table.setShowGrid(true);
        course_table.setGridColor(Color.gray);
        course_table.setBackground(Color.white);
    }
    
    private void clearCourseMaterials(){
        txt_course_Id.setText(null);
        txt_Credit.setText(null);
        jComboBox_course_type.setSelectedIndex(0);
        txt_LecID.setText(null);
        txt_CourseName.setText(null);
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
        if(txt_LecID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Course Lecture ID is missing");
            return false;
        }
        if(txt_Credit.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Course Credit is missing");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_back = new javax.swing.JLabel();
        txt_course_Id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_CourseName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Credit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_LecID = new javax.swing.JTextField();
        Add_Button = new rojerusan.RSMaterialButtonCircle();
        Update_Button = new rojerusan.RSMaterialButtonCircle();
        clear_button = new rojerusan.RSMaterialButtonCircle();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_course_type = new javax.swing.JComboBox<>();
        Delete_Button1 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        course_table = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_back.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_back.setForeground(new java.awt.Color(255, 255, 255));
        lbl_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/back.png"))); // NOI18N
        lbl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_backMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        txt_course_Id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_course_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_IdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_course_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 320, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Course Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, 30));

        txt_CourseName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 320, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Credit");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, 20));

        txt_Credit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_Credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 320, 20));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Course Type");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 100, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Lecture ID");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 100, 20));

        txt_LecID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_LecID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 320, 20));

        Add_Button.setText("ADD");
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, 60));

        Update_Button.setText("UPDATE");
        Update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Update_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 150, 60));

        clear_button.setText("Clear");
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(clear_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 150, 60));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 20));

        jComboBox_course_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theroy", "Practical", "Theory/Practical" }));
        jPanel1.add(jComboBox_course_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 320, -1));

        Delete_Button1.setText("DELETE");
        Delete_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_Button1ActionPerformed(evt);
            }
        });
        jPanel1.add(Delete_Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 150, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Courses");

        course_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Lecture ID", "Credit", "Course Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        course_table.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        course_table.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        course_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                course_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(course_table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(290, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_course_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_IdActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        clearCourseMaterials();
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ButtonActionPerformed
        if(isEmptyCourse()){
            if(!course.isCourseCodeExist(txt_course_Id.getText())){
                String courseId = txt_course_Id.getText();
                String courseName = txt_CourseName.getText();
                String lecId = txt_LecID.getText();
                int credit = Integer.parseInt(txt_Credit.getText());
                String course_type = jComboBox_course_type.getSelectedItem().toString();
                
                course.insert(courseId, courseName, lecId, credit, course_type);
                course_table.setModel(new DefaultTableModel(null,new Object[]{"courseId", "courseName", "lecId", "credit", "course_type"}));
                course.getCourseValue(course_table, "");
            }else{
                JOptionPane.showMessageDialog(this, "Course code Already Exist !!!");
            }
        }
    }//GEN-LAST:event_Add_ButtonActionPerformed

    private void Update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_ButtonActionPerformed
        // TODO add your handling code here:
//        if(updateBook() == true){
//            JOptionPane.showMessageDialog(this, "Book Updated Successfully!!");
//            clearTable();
//            setBookDetailsToTable();
//            txt_bookId.setText("");
//            txt_bookName.setText("");
//            txt_author.setText("");
//            txt_quantity.setText("");
//        }else{
//            JOptionPane.showMessageDialog(this, "Book Updated Failed!!");
//        }
    }//GEN-LAST:event_Update_ButtonActionPerformed

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        // TODO add your handling code here:
//        int rowNo = tbl_bookDetails.getSelectedRow();
//        TableModel model = tbl_bookDetails.getModel();
//
//        txt_bookId.setText(model.getValueAt(rowNo, 0).toString());
//        txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
//        txt_author.setText(model.getValueAt(rowNo, 2).toString());
//        txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void Delete_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_Button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Delete_Button1ActionPerformed

    private void lbl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseClicked
        LectureDashboard dash = new LectureDashboard();
        dash.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_backMouseClicked

    private void course_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_course_tableMouseClicked

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
    private rojerusan.RSMaterialButtonCircle Delete_Button1;
    private rojerusan.RSMaterialButtonCircle Update_Button;
    private rojerusan.RSMaterialButtonCircle clear_button;
    private rojeru_san.complementos.RSTableMetro course_table;
    private javax.swing.JComboBox<String> jComboBox_course_type;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JTextField txt_CourseName;
    private javax.swing.JTextField txt_Credit;
    private javax.swing.JTextField txt_LecID;
    private javax.swing.JTextField txt_course_Id;
    // End of variables declaration//GEN-END:variables
}
