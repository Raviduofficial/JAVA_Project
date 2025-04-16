package lecturer;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UploadMarksExams extends javax.swing.JFrame {
    marks marks = new marks();
    private DefaultTableModel model;
    private int rowIndex;
    
    public UploadMarksExams() {
        initComponents();
        tableViewMarks();
    }
 
    
    private void tableViewMarks(){
        marks.getMarksValues(Marks_table, "");
        model = (DefaultTableModel) Marks_table.getModel();
        Marks_table.setRowHeight(30);
        Marks_table.setShowGrid(true);
    }
    
    private void clearMarks(){
        Mark_ID.setText(null);        
        Lecture_ID.setText(null); 
        Student_ID.setText(null); 
        Course_ID.setText(null); 
        Quiz_1.setText(null); 
        Quiz_2.setText(null); 
        Quiz_3.setText(null); 
        Quiz_4.setText(null); 
        Assesmnent.setText(null); 
        Mid_term.setText(null); 
        final_T.setText(null); 
        final_P.setText(null); 
        Marks_table.clearSelection();
    }
    
    public boolean isEmptyMarks(){
        if(Quiz_1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Quiz 1 is Empty");
            return false;
        }
        if(Quiz_2.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Quiz 2 is Empty");
            return false;
        }
        if(Quiz_3.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Quiz 3 is Empty");
            return false;
        }
        if(Quiz_4.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Quiz 4 is Empty");
            return false;
        }
        if(Assesmnent.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Assesment is Empty");
            return false;
        }
        if(Mid_term.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Mid Term is Empty");
            return false;
        }
        if(final_T.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Final Theory is Empty");
            return false;
        }
        if(final_P.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Final Practical is Empty");
            return false;
        }
        if(Mark_ID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Mark ID is Empty");
            return false;
        }
        if(Lecture_ID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "lecture ID is Empty");
            return false;
        }
        if(Student_ID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Student ID is Empty");
            return false;
        }
        if(Course_ID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Course ID is Empty");
            return false;
        }
        return true;
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
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
        Course_ID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Quiz_2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Quiz_3 = new javax.swing.JTextField();
        Quiz_4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Assesmnent = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Mid_term = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        final_T = new javax.swing.JTextField();
        final_P = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Marks_table = new rojeru_san.complementos.RSTableMetro();

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

        Mark_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Mark_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mark_IDActionPerformed(evt);
            }
        });
        jPanel1.add(Mark_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 190, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Lecture ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        Lecture_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Lecture_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 190, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 20));

        Student_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Student_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 190, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Course ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, 20));

        Quiz_1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Quiz_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 190, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Quiz 1 ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 100, 20));

        Update_Button.setText("UPDATE");
        Update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Update_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 150, 50));

        Clear_Button.setText("Clear");
        Clear_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Clear_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 150, 50));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mark Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 20));

        Add_Button.setText("ADD");
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Add_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 150, 50));

        Delete_Button.setText("Delete");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Delete_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 150, 50));

        Course_ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Course_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 190, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Quiz 2");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, 20));

        Quiz_2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Quiz_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 190, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quiz 3");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 100, 20));

        Quiz_3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Quiz_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 190, 30));

        Quiz_4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Quiz_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 190, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Quiz 4");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 100, 20));

        Assesmnent.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Assesmnent, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 190, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Assessment");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 20));

        Mid_term.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Mid_term, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 190, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Mid Term");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 100, 20));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Final Theory");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 100, 20));

        final_T.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(final_T, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 190, 30));

        final_P.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(final_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 190, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Final Practical");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 110, 20));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Marks");

        Marks_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mark ID", "LectureID", "Student ID", "Course ID", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Assessment", "Mid Term", "Final Theroy", "Final Practical"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(417, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        LectureDashboard dash = new LectureDashboard();
        dash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void Update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_ButtonActionPerformed
        if(isEmptyMarks()){
            float q1 = Float.parseFloat(Quiz_1.getText());
            float q2 = Float.parseFloat(Quiz_2.getText());
            float q3 = Float.parseFloat(Quiz_3.getText());
            float q4 = Float.parseFloat(Quiz_4.getText());
            float ass = Float.parseFloat(Assesmnent.getText());
            float mid = Float.parseFloat(Mid_term.getText());
            float f_t = Float.parseFloat(final_T.getText());
            float f_p = Float.parseFloat(final_P.getText());
            String m_id = Mark_ID.getText();
            String lid = Lecture_ID.getText();
            String sid = Student_ID.getText();
            String cid = Course_ID.getText();
            
            marks.update(m_id, lid, sid, cid, q1, q2, q3, q4, ass, mid, f_t, f_p);
            clearMarks();
            marks.getMarksValues(Marks_table, "");
        }
    }//GEN-LAST:event_Update_ButtonActionPerformed

    private void Clear_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_ButtonActionPerformed
        clearMarks();
    }//GEN-LAST:event_Clear_ButtonActionPerformed

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ButtonActionPerformed
        // TODO add your handling code here:
        if(isEmptyMarks()){
            float q1 = Float.parseFloat(Quiz_1.getText());
            float q2 = Float.parseFloat(Quiz_2.getText());
            float q3 = Float.parseFloat(Quiz_3.getText());
            float q4 = Float.parseFloat(Quiz_4.getText());
            float ass = Float.parseFloat(Assesmnent.getText());
            float mid = Float.parseFloat(Mid_term.getText());
            float f_t = Float.parseFloat(final_T.getText());
            float f_p = Float.parseFloat(final_P.getText());
            String m_id = Mark_ID.getText();
            String lid = Lecture_ID.getText();
            String sid = Student_ID.getText();
            String cid = Course_ID.getText();
            
            marks.insert(m_id, lid, sid, cid, q1, q2, q3, q4, ass, mid, f_t, f_p);
//            Marks_table.setModel(new DefaultTableModel(null,new Object[]{"m_id", "lid", "sid", "cid", "q1", "q2", "q3", "q4", "ass", "mid", "f_t", "f_p"}));
            marks.getMarksValues(Marks_table, "");
            clearMarks();
            
        }
    }//GEN-LAST:event_Add_ButtonActionPerformed

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        if(marks.delete(Mark_ID.getText()) == true ){
            JOptionPane.showMessageDialog(this, "Course Deleted Successfully..");
            clearMarks();
            marks.getMarksValues(Marks_table, "");
        }else{
            JOptionPane.showMessageDialog(this, "Course Deleted Failed!!");
        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void Marks_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Marks_tableMouseClicked
        // TODO add your handling code here:
        model = (DefaultTableModel) Marks_table.getModel();
        rowIndex = Marks_table.getSelectedRow();
        if(rowIndex >= 0){
            Mark_ID.setText(model.getValueAt(rowIndex, 0).toString());
            Lecture_ID.setText(model.getValueAt(rowIndex, 1).toString());
            Student_ID.setText(model.getValueAt(rowIndex, 2).toString());
            Course_ID.setText(model.getValueAt(rowIndex, 3).toString());
            Quiz_1.setText(model.getValueAt(rowIndex, 4).toString());
            Quiz_2.setText(model.getValueAt(rowIndex, 5).toString());
            Quiz_3.setText(model.getValueAt(rowIndex, 6).toString());
            Quiz_4.setText(model.getValueAt(rowIndex, 7).toString());
            Assesmnent.setText(model.getValueAt(rowIndex, 8).toString());
            Mid_term.setText(model.getValueAt(rowIndex, 9).toString());
            final_T.setText(model.getValueAt(rowIndex, 10).toString());
            final_P.setText(model.getValueAt(rowIndex, 11).toString());
        }
    }//GEN-LAST:event_Marks_tableMouseClicked

    private void Mark_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mark_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mark_IDActionPerformed

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
            java.util.logging.Logger.getLogger(UploadMarksExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UploadMarksExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UploadMarksExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UploadMarksExams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UploadMarksExams().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Add_Button;
    private javax.swing.JTextField Assesmnent;
    private rojerusan.RSMaterialButtonCircle Clear_Button;
    private javax.swing.JTextField Course_ID;
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
    private javax.swing.JLabel back;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
