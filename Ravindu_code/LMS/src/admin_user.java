import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class admin_user extends javax.swing.JFrame {

    public admin_user() {
        initComponents();
        tbload();
    }
    
    public void tbload(){
        try {
                DefaultTableModel dt = (DefaultTableModel) loader.getModel();
                dt.setRowCount(0);

                try(Connection conn = dbconnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");){

                    while(rs.next()){
                        Vector v = new Vector();
                        v.add(rs.getString(1));
                        v.add(rs.getString(2));
                        v.add(rs.getString(3));
                        v.add(rs.getString(4));

                        dt.addRow(v);
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        u_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        u_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        u_password = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        u_role = new javax.swing.JTextField();
        u_save = new javax.swing.JButton();
        u_update = new javax.swing.JButton();
        u_delete = new javax.swing.JButton();
        u_serch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        loader = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        u_serach = new javax.swing.JTextField();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        u_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_nameActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");

        u_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_idActionPerformed(evt);
            }
        });

        jLabel3.setText("Password");

        u_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_passwordActionPerformed(evt);
            }
        });

        jLabel4.setText("Role");

        u_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_roleActionPerformed(evt);
            }
        });

        u_save.setText("SAVE");
        u_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_saveActionPerformed(evt);
            }
        });

        u_update.setText("UPDATE");
        u_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_updateActionPerformed(evt);
            }
        });

        u_delete.setText("DELETE");
        u_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_deleteActionPerformed(evt);
            }
        });

        u_serch.setText("SERCH");
        u_serch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_serchActionPerformed(evt);
            }
        });

        loader.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(loader);

        jLabel5.setText("ID");

        u_serach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_serachActionPerformed(evt);
            }
        });

        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(u_id, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(u_name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(u_role, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addComponent(u_password, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(u_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(u_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(u_delete)
                        .addGap(12, 12, 12)
                        .addComponent(u_serch)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(u_serach, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(back)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(u_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(u_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(u_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(u_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(u_save)
                            .addComponent(u_update)
                            .addComponent(u_delete)
                            .addComponent(u_serch)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(u_serach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(back)))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void u_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_nameActionPerformed

    private void u_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_idActionPerformed

    private void u_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_passwordActionPerformed

    private void u_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_roleActionPerformed

    private void u_serchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String userID = u_id.getText();

        String sql = "SELECT * FROM users WHERE id = ?";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, userID);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    u_name.setText(rs.getString("username"));
                    u_password.setText(rs.getString("password"));
                    u_role.setText(rs.getString("role"));
                }else{
                    JOptionPane.showMessageDialog(null, "User not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }                                       

    private void u_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_saveActionPerformed
        // Retrieve user inputs
        String username = u_name.getText();
        String password = u_password.getText(); // Use getPassword() for security
        String role = u_role.getText();

        // Database connection and secure query execution
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try (Connection conn = dbconnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            // Set parameter values
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, role);

            // Execute update
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "User saved successfully!");
                u_name.setText("");
                u_password.setText("");
                u_role.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "User could not be saved.");
            }

        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
//GEN-LAST:event_u_saveActionPerformed

    private void u_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_updateActionPerformed
        // TODO add your handling code here:
        String userID = u_id.getText();
        String username = u_name.getText();
        String password = u_password.getText();
        String role = u_role.getText();

        String sql = "UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?";

        try (Connection conn = dbconnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, role);
            pst.setString(4, userID);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "User updated successfully!");
            }else{
                JOptionPane.showMessageDialog(this, "User could not be updated.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }//GEN-LAST:event_u_updateActionPerformed

    private void u_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_deleteActionPerformed
        // TODO add your handling code here:
        String userID = u_id.getText();

        String sql = "DELETE FROM users WHERE id = ?";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setString(1, userID);
            int rowsInserted = pst.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_u_deleteActionPerformed

    private void u_serachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_serachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_serachActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        admin add = new admin();
        add.setVisible(true);
    }//GEN-LAST:event_backActionPerformed



    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable loader;
    private javax.swing.JButton u_delete;
    private javax.swing.JTextField u_id;
    private javax.swing.JTextField u_name;
    private javax.swing.JTextField u_password;
    private javax.swing.JTextField u_role;
    private javax.swing.JButton u_save;
    private javax.swing.JTextField u_serach;
    private javax.swing.JButton u_serch;
    private javax.swing.JButton u_update;
    // End of variables declaration//GEN-END:variables
}
