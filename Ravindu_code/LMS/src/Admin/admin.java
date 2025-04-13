
package Admin;
import java.sql.*;
import Database.dbconnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.time.LocalDate;
import java.sql.Date;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.imageio.ImageIO;
import java.io.File;

public class admin extends javax.swing.JFrame {

    public admin() {
        initComponents();
        tbload();
        notice_tbload();
    }
    
    public void tbload(){
        try {
                DefaultTableModel dt = (DefaultTableModel) Table1.getModel();
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
                        v.add(rs.getString(5));
          

                        dt.addRow(v);
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void notice_tbload(){
        try {
                DefaultTableModel dt = (DefaultTableModel) noticeTable.getModel();
                dt.setRowCount(0);

                try(Connection conn = dbconnection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM notice");){

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        u_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addUser = new javax.swing.JButton();
        updateUser = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        u_email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        u_phone = new javax.swing.JTextField();
        u_pass = new javax.swing.JPasswordField();
        u_role = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noticeTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        n_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        n_title = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        n_content = new javax.swing.JTextArea();
        addNotice = new javax.swing.JButton();
        n_update = new javax.swing.JButton();
        n_DELETE = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        time_table = new javax.swing.JTable();
        t_day_select = new javax.swing.JComboBox<>();
        t_sub = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        t_add = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        t_time = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        t_sess_select = new javax.swing.JComboBox<>();
        t_t_level = new javax.swing.JComboBox<>();
        t_t_find = new javax.swing.JButton();
        t_level_find = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        t_update = new javax.swing.JButton();
        t_find = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        profilePic = new javax.swing.JLabel();
        updateProfile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel1.setText("USER NAME");

        jLabel2.setText("PASSWORD");

        jLabel3.setText("ROLE");

        addUser.setText("ADD USER");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        updateUser.setText("UPDATE");
        updateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserActionPerformed(evt);
            }
        });

        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "USER NAME", "PASSWORD", "ROLE", "Email", "Phone Number"
            }
        ));
        Table1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(Table1);
        Table1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jButton1.setText("SERCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("EMAIL");

        jLabel10.setText("PHONE");

        u_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Undergraduate", "To", "Lecturer" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(u_pass))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(u_name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(40, 40, 40)
                                        .addComponent(u_phone, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                                .addGap(58, 58, 58))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(u_email)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(u_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateUser)
                        .addGap(31, 31, 31)
                        .addComponent(DELETE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(u_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(u_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(u_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(u_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUser)
                    .addComponent(updateUser)
                    .addComponent(DELETE)
                    .addComponent(jButton1))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("User", jPanel1);

        noticeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Notice ID", "Notice Title", "Notice Content", "Notice Date"
            }
        ));
        jScrollPane2.setViewportView(noticeTable);

        jLabel5.setText("Notice ID");

        n_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_idActionPerformed(evt);
            }
        });

        jLabel6.setText("Notice Title");

        jLabel7.setText("Notice Content");

        n_content.setColumns(20);
        n_content.setRows(5);
        jScrollPane3.setViewportView(n_content);

        addNotice.setText("ADD_NOTICE");
        addNotice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNoticeActionPerformed(evt);
            }
        });

        n_update.setText("UPDATE");
        n_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_updateActionPerformed(evt);
            }
        });

        n_DELETE.setText("DELETE");
        n_DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_DELETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(addNotice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(n_id)
                            .addComponent(n_title)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(n_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(n_DELETE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(n_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(n_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addNotice)
                            .addComponent(n_update)
                            .addComponent(n_DELETE))))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Notice", jPanel2);

        time_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Day", "Subject", "Time", "Session_type"
            }
        ));
        jScrollPane5.setViewportView(time_table);

        t_day_select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Thuesdat", "Wenesday", "Thuresday", "Friday" }));
        t_day_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_day_selectActionPerformed(evt);
            }
        });

        jLabel14.setText("Subject ");

        t_add.setText("Add");
        t_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_addActionPerformed(evt);
            }
        });

        jLabel15.setText("Day");

        jLabel16.setText("Time");

        t_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_timeActionPerformed(evt);
            }
        });

        jLabel17.setText("Session Type");

        t_sess_select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theory", "Patrical" }));

        t_t_level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "Level2", "Level3", "Level4" }));

        t_t_find.setText("FIND");
        t_t_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_t_findActionPerformed(evt);
            }
        });

        t_level_find.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level1", "Level2", "Level3", "Level4" }));

        jLabel18.setText("Level");

        t_update.setText("Update");
        t_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_updateActionPerformed(evt);
            }
        });

        t_find.setText("Find");
        t_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_findActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(t_t_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(t_t_find)))
                .addGap(109, 109, 109)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(t_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(t_find))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_time, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_day_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_level_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_sess_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_t_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_t_find)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_day_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(t_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(t_sess_select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_level_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_add)
                            .addComponent(t_update)
                            .addComponent(t_find))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Time Table", jPanel4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1155, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Courses", jPanel3);

        profilePic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fOT.jpeg"))); // NOI18N
        profilePic.setText("jLabel8");
        profilePic.setPreferredSize(new java.awt.Dimension(150, 150));

        updateProfile.setText("Update_Profile_Pic");
        updateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(updateProfile)))
                .addContainerGap(851, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(updateProfile)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profile", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void n_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_DELETEActionPerformed
        // TODO add your handling code here:
        int notice_id = Integer.parseInt(n_id.getText());

        String sql = "DELETE FROM notice WHERE notice_id = ?";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setInt(1, notice_id);
            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Notice DELETE successfully!");
                notice_tbload();
            }else{
                JOptionPane.showMessageDialog(this, "Notice could not be DELETE.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_n_DELETEActionPerformed

    private void n_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_updateActionPerformed
        // TODO add your handling code here:
        LocalDate localdate = LocalDate.now();

        int notice_id = Integer.parseInt(n_id.getText());
        String Notice_title = n_title.getText();
        String Notice_content = n_content.getText();
        Date sqlDate = Date.valueOf(localdate);

        String sql = "UPDATE notice SET notice_title = ?, notice_content = ?, notice_date = ? WHERE notice_id = ?";

        try (Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, Notice_title);
            pst.setString(2, Notice_content);
            pst.setDate(3, sqlDate);
            pst.setInt(4, notice_id);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Notice updated successfully!");
                notice_tbload();
            }else{
                JOptionPane.showMessageDialog(this, "Notice could not be updated.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_n_updateActionPerformed

    private void addNoticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNoticeActionPerformed
        // TODO add your handling code here:
        LocalDate localdate = LocalDate.now();

        String Notice_title = n_title.getText();
        String Notice_content = n_content.getText();
        Date sqlDate = Date.valueOf(localdate);

        String sql = "INSERT INTO notice (notice_title, notice_content,notice_date) VALUES (?, ?, ?)";

        try (Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            // Set parameter values
            pst.setString(1, Notice_title);
            pst.setString(2, Notice_content);
            pst.setDate(3, sqlDate);

            // Execute update
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Notice saved successfully!");
                n_title.setText("");
                n_content.setText("");
                n_id.setText("");
                notice_tbload();
            } else {
                JOptionPane.showMessageDialog(this, "Notice could not be saved.");
            }

        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_addNoticeActionPerformed

    private void n_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              String username = u_name.getText();

        String sql = "SELECT * FROM users WHERE username = ?";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, username);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    
                    u_name.setText(rs.getString("username"));
                    u_pass.setText(rs.getString("password"));
                    
                    u_email.setText(rs.getString("email"));
                    u_phone.setText(rs.getString("phone"));
                     String roleFromDB = rs.getString("role");
                    u_role.setSelectedItem(roleFromDB);
                    tbload();
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        String userID = u_name.getText();

        String sql = "DELETE FROM users WHERE username = ?";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setString(1, userID);
            int rowsInserted = pst.executeUpdate();
            tbload();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_DELETEActionPerformed

    private void updateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserActionPerformed
        String username = u_name.getText().trim();
        char[] password = u_pass.getPassword(); 
        String role = u_role.getSelectedItem().toString().toLowerCase();
        String email = u_email.getText();
        String phone = u_phone.getText();
        
     
        String hashedPassword = Admin.encryption.hashpassword(new String(password));

        String sql = "UPDATE users SET password = ?, role = ?, email = ?, phone = ? WHERE username = ?";

        try (Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, hashedPassword);
            pst.setString(2, role);
            pst.setString(3, email);
            pst.setString(4, phone);
             pst.setString(5, username);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "User updated successfully!");
                tbload();
            }else{
                JOptionPane.showMessageDialog(this, "User could not be updated.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_updateUserActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        // Retrieve user inputs
        String username = u_name.getText().trim().toLowerCase();
        char[] password = u_pass.getPassword(); 
        String role = u_role.getSelectedItem().toString().toLowerCase();;
        String email = u_email.getText();
        String phone = u_phone.getText();
        
        if (username.isEmpty() || password.length == 0 || role.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required!");
        return;
        }
        
         if (!email.isEmpty() && !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
        JOptionPane.showMessageDialog(this, "Please enter a valid email address!");
        return;
        }
        
        if (!phone.isEmpty() && !phone.matches("^[0-9]{10,13}$")) {
        JOptionPane.showMessageDialog(this, "Please enter a valid phone number (10-13 digits)!");
        return;
        }
        
        if (password.length < 8 || !new String(password).matches("^(?=.*[A-Za-z])(?=.*\\d).+$")) {
        JOptionPane.showMessageDialog(this, "Password must be at least 8 characters and contain both letters and numbers!");
        return;
        }
        
        try {
            // Check if username exists
            String checkSql = "SELECT username FROM users WHERE username = ?";
            try (Connection conn = dbconnection.getConnection();
                PreparedStatement checkPst = conn.prepareStatement(checkSql)){
                checkPst.setString(1, username);
                ResultSet rs = checkPst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Username already exists!");
                    return;
                }
            }catch(Exception e){
                         System.out.println(e);
                }
                        
            }catch(Exception e){
               System.out.println(e);
            }
            
                        
                
            
         
        
        String hashedPassword = Admin.encryption.hashpassword(new String(password));

        // Database connection and secure query execution
        String sql = "INSERT INTO users VALUES (?, ?, ?, ? , ?)";

        try (Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            // Set parameter values
            pst.setString(1, username);
            pst.setString(2, hashedPassword);
            pst.setString(3, role);
            pst.setString(4, email);
            pst.setString(5, phone);
            // Execute update
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "User saved successfully!");
                u_name.setText("");
                u_pass.setText("");
                //u_role.setItem(admin);
                u_phone.setText("");
                u_email.setText("");
                tbload();
            } else {
                JOptionPane.showMessageDialog(this, "User could not be saved.");
            }

        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_addUserActionPerformed

    private void t_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_addActionPerformed

    private void t_day_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_day_selectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_day_selectActionPerformed

    private void t_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_updateActionPerformed

    private void t_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_findActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_findActionPerformed

    private void t_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_timeActionPerformed

    private void t_t_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_t_findActionPerformed
         DefaultTableModel tt = (DefaultTableModel) time_table.getModel();
         tt.setRowCount(0); 
    
    if (t_t_level.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Please select a level first");
        return;
    }
    
    String level = t_t_level.getSelectedItem().toString();
    
    
    String sql = "SELECT id, day, subject, time, session_type FROM time_table WHERE level = ?";
    
    try (Connection conn = dbconnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, level);
        ResultSet rs = pstmt.executeQuery();
               
            while (rs.next()) {
                
                Vector v = new Vector();
                v.add(rs.getInt("id"));
                v.add(rs.getString("day"));
                v.add(rs.getString("subject"));
                v.add(rs.getString("time"));
                v.add(rs.getString("session_type"));
                
                tt.addRow(v);
            }
            
                
    } catch (Exception e) {
        
      System.out.println(e);
    }
    
    //UI refresh
    tt.fireTableDataChanged();
    time_table.repaint();
    }//GEN-LAST:event_t_t_findActionPerformed

    private void updateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProfileActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fileChooser.getSelectedFile();
    ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
    Image image = icon.getImage().getScaledInstance(
        profilePic.getWidth(), 
        profilePic.getHeight(), 
        Image.SCALE_SMOOTH
    );
    profilePic.setIcon(new ImageIcon(image));
}
    }//GEN-LAST:event_updateProfileActionPerformed
    
    

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE;
    private javax.swing.JTable Table1;
    private javax.swing.JButton addNotice;
    private javax.swing.JButton addUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton n_DELETE;
    private javax.swing.JTextArea n_content;
    private javax.swing.JTextField n_id;
    private javax.swing.JTextField n_title;
    private javax.swing.JButton n_update;
    private javax.swing.JTable noticeTable;
    private javax.swing.JLabel profilePic;
    private javax.swing.JButton t_add;
    private javax.swing.JComboBox<String> t_day_select;
    private javax.swing.JButton t_find;
    private javax.swing.JComboBox<String> t_level_find;
    private javax.swing.JComboBox<String> t_sess_select;
    private javax.swing.JTextField t_sub;
    private javax.swing.JButton t_t_find;
    private javax.swing.JComboBox<String> t_t_level;
    private javax.swing.JTextField t_time;
    private javax.swing.JButton t_update;
    private javax.swing.JTable time_table;
    private javax.swing.JTextField u_email;
    private javax.swing.JTextField u_name;
    private javax.swing.JPasswordField u_pass;
    private javax.swing.JTextField u_phone;
    private javax.swing.JComboBox<String> u_role;
    private javax.swing.JButton updateProfile;
    private javax.swing.JButton updateUser;
    // End of variables declaration//GEN-END:variables
}
