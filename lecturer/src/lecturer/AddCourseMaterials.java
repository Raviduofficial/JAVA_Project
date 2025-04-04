package lecturer;

//import student.Login;

import javax.swing.table.DefaultTableModel;


//import javax.swing.table.DefaultTableModel;


public class AddCourseMaterials extends javax.swing.JFrame {
    
//    Course course = new Course();
    private int rowIndex;
    int xx, xy;
//    private DefaultTableModel model;
    String bookName,author;
    int bookId,quantity;
    DefaultTableModel model;

    public AddCourseMaterials() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_back = new javax.swing.JLabel();
        txt_courseCode = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_CourseName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Credit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_week = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_theory = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_Practical = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_LecID = new javax.swing.JTextField();
        Add_Button = new rojerusan.RSMaterialButtonCircle();
        Update_Button = new rojerusan.RSMaterialButtonCircle();
        Delete_Button = new rojerusan.RSMaterialButtonCircle();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_back.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_back.setForeground(new java.awt.Color(255, 255, 255));
        lbl_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/back.png"))); // NOI18N
        jPanel1.add(lbl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        txt_courseCode.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_courseCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseCodeActionPerformed(evt);
            }
        });
        jPanel1.add(txt_courseCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 320, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Course Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, 30));

        txt_CourseName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 320, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Credit");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, 20));

        txt_Credit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_Credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 320, 20));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Week");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 100, 20));

        txt_week.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_week, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 320, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Theory");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 100, 20));

        txt_theory.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_theory, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 320, 20));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Practical");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 100, 20));

        txt_Practical.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_Practical, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 320, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Lecture ID");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 100, 20));

        txt_LecID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(txt_LecID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 320, 20));

        Add_Button.setText("ADD");
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 150, 60));

        Update_Button.setText("UPDATE");
        Update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Update_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 150, 60));

        Delete_Button.setText("DELETE");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Delete_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 150, 60));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course Code");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Courses");

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Name", "Credit", "Week", "Theory", "Practical", "Lecture ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(rSTableMetro1);

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

    private void txt_courseCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseCodeActionPerformed

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        // TODO add your handling code here:
//        if(deleteBook() == true){
//            JOptionPane.showMessageDialog(this, "Book Deleted Successfully!!");
//            clearTable();
//            setBookDetailsToTable();
//            txt_bookId.setText("");
//            txt_bookName.setText("");
//            txt_author.setText("");
//            txt_quantity.setText("");
//        }else{
//            JOptionPane.showMessageDialog(this, "Book Deleted Failed!!");
//        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ButtonActionPerformed
        // TODO add your handling code here: for add button
//        if(addBook() == true){
//            JOptionPane.showMessageDialog(this, "Book Added Successfully!!");
//            clearTable();
//            setBookDetailsToTable();
//            txt_bookId.setText("");
//            txt_bookName.setText("");
//            txt_author.setText("");
//            txt_quantity.setText("");
//        }else{
//            JOptionPane.showMessageDialog(this, "Book Added Failed!!");
//        }
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
    private rojerusan.RSMaterialButtonCircle Delete_Button;
    private rojerusan.RSMaterialButtonCircle Update_Button;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_back;
    private rojeru_san.complementos.RSTableMetro rSTableMetro1;
    private javax.swing.JTextField txt_CourseName;
    private javax.swing.JTextField txt_Credit;
    private javax.swing.JTextField txt_LecID;
    private javax.swing.JTextField txt_Practical;
    private javax.swing.JTextField txt_courseCode;
    private javax.swing.JTextField txt_theory;
    private javax.swing.JTextField txt_week;
    // End of variables declaration//GEN-END:variables
}
