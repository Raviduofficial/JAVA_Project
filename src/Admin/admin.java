
package Admin;
import java.sql.*;
import Database.dbconnection;
import Admin.editprofiledailog;
import javax.swing.*;
import Login.Login;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.time.LocalDate;
import java.sql.Date;
import java.awt.*;
import java.io.File;


public class admin extends javax.swing.JFrame {

    private String u_username;

    public admin(String username) {
      u_username = username;
        initComponents();
      tbload();
      notice_tbload();
      time_table();
      display_profile(username);
      course_table();
      setDefaultProfilePic();
      loadProfilePic();
    }
    
    private void loadProfilePic() {
    try (Connection con = dbconnection.getConnection()) {
        String sql = "SELECT user_pro_pic FROM user WHERE user_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, u_username);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String path = rs.getString("user_pro_pic");
            if (path != null && !path.isEmpty()) {
                Profile_Pic.setIcon(resizeImage(path, Profile_Pic));
            } else {
                setDefaultProfilePic();
            }
        } else {
            setDefaultProfilePic();
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    
    private void setDefaultProfilePic() {
        String defaultPath = "src/Images/Default_pfp.svg.png";
        Profile_Pic.setIcon(resizeImage(defaultPath, Profile_Pic));
    }
    
    private ImageIcon resizeImage(String imagePath, JLabel label) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(
            label.getWidth(), 
            label.getHeight(), 
            Image.SCALE_SMOOTH
        );
        return new ImageIcon(newImg);
    }
    
    private void display_profile(String username){
        //jLabel7.setText(username);
        String sql ="select * from user where user_id = ?";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,username);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                       out_username.setText(rs.getString("user_name"));
                       out_email.setText(rs.getString("user_email"));
                       out_role.setText(rs.getString("user_role"));
                       out_pnumber.setText(rs.getString("user_phone"));
                    }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void tbload(){
        try {
                DefaultTableModel dt = (DefaultTableModel) Table1.getModel();
                dt.setRowCount(0);

                try(Connection conn = dbconnection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM user");){

                    while(rs.next()){
                        Vector v = new Vector();
                        v.add(rs.getString(1));
                        v.add(rs.getString(2));
                        v.add(rs.getString(3));
                        v.add(rs.getString(4));
                        v.add(rs.getString(5));
                        v.add(rs.getString(6));
                        v.add(rs.getString(7));

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
                        v.add(rs.getDate(4));
                        
                        dt.addRow(v);
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void time_table(){
           try{
               DefaultTableModel tt = (DefaultTableModel) time_table.getModel();
               tt.setRowCount(0);
               
               try(Connection conn = dbconnection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM time_table");){

                    while(rs.next()){
                        Vector v = new Vector();
                        v.add(rs.getString(1));
                        v.add(rs.getString(2));
                        v.add(rs.getString(3));
                        v.add(rs.getString(4));
                        v.add(rs.getString(5));
                        v.add(rs.getString(6));
                        v.add(rs.getTime(7));
                        v.add(rs.getTime(8));
                        v.add(rs.getString(9));
                        
                        tt.addRow(v);
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
               
           }catch(Exception e){
               System.out.println(e);
           }
    }
    
    public void course_table(){
           try{
               DefaultTableModel ct = (DefaultTableModel) Course_table.getModel();
               ct.setRowCount(0);
               
               try(Connection conn = dbconnection.getConnection();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM course");){

                    while(rs.next()){
                        Vector v = new Vector();
                        v.add(rs.getString(1));
                        v.add(rs.getString(2));
                        v.add(rs.getString(3));
                        v.add(rs.getInt(4));
                        v.add(rs.getString(5));
                        
                        ct.addRow(v);
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
               
           }catch(Exception e){
               System.out.println(e);
           }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jDialog3 = new javax.swing.JDialog();
        jDialog4 = new javax.swing.JDialog();
        jDialog5 = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noticeTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        n_id = new javax.swing.JTextField();
        n_DELETE = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        n_id_update = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        n_title_update = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        n_content_update = new javax.swing.JTextArea();
        n_update = new javax.swing.JButton();
        n_find = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        n_title_add = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        addNotice = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        n_content_adduser = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Course_table = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Course_id = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        Course_name = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        Lec_Id = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        Credit = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        add_course = new javax.swing.JButton();
        Course_type = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        Course_id_update = new javax.swing.JTextField();
        Course_name_update = new javax.swing.JTextField();
        Lec_Id_update = new javax.swing.JTextField();
        Credit_update = new javax.swing.JTextField();
        Course_type_update = new javax.swing.JComboBox<>();
        c_update = new javax.swing.JButton();
        u_find = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        Course_delete = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        course_delete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        out_username = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        out_email = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        out_role = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        out_pnumber = new javax.swing.JLabel();
        Edit_User_profile = new javax.swing.JButton();
        Profile_Pic = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        time_table = new javax.swing.JTable();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        t_day_add = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        t_time_add_st = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        t_sess_add = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        t_add = new javax.swing.JButton();
        t_time_add_end = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        t_lec_id_add = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        t_course_id_add = new javax.swing.JTextField();
        t_id_add = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        t_dep_add = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        t_update = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        t_id_update = new javax.swing.JTextField();
        t_day_update = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        t_course_up = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        t_time_update_st = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        t_time_update_end = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        t_sess_update = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        t_lec_id_up = new javax.swing.JTextField();
        t_find = new javax.swing.JButton();
        t_dep_up = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        t_id_delete = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        t_delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        u_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        u_name_new = new javax.swing.JTextField();
        u_pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        u_role = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        u_email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        u_phone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        addUser = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        u_name_u = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        u_name_new_u = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        u_pass_u = new javax.swing.JPasswordField();
        jLabel43 = new javax.swing.JLabel();
        u_role_u = new javax.swing.JComboBox<>();
        u_email_u = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        u_phone_u = new javax.swing.JTextField();
        updateUser = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        u_name_d = new javax.swing.JTextField();
        DELETE = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog5Layout = new javax.swing.GroupLayout(jDialog5.getContentPane());
        jDialog5.getContentPane().setLayout(jDialog5Layout);
        jDialog5Layout.setHorizontalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(153, 187, 187));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1000, 700));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(900, 700));

        jPanel2.setBackground(new java.awt.Color(140, 140, 140));

        noticeTable.setBackground(new java.awt.Color(140, 140, 140));
        noticeTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBackground(new java.awt.Color(140, 140, 140));

        jLabel8.setText("Notice ID");

        n_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_idActionPerformed(evt);
            }
        });

        n_DELETE.setBackground(new java.awt.Color(0, 112, 192));
        n_DELETE.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        n_DELETE.setText("DELETE");
        n_DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_DELETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(n_id, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addGap(51, 51, 51))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(n_DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(n_DELETE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("DELETE", jPanel6);

        jLabel11.setText("Notice ID");

        n_id_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_id_updateActionPerformed(evt);
            }
        });

        jLabel12.setText("Notice Title");

        jLabel13.setText("Notice Content");

        n_content_update.setColumns(20);
        n_content_update.setRows(5);
        jScrollPane4.setViewportView(n_content_update);

        n_update.setText("UPDATE");
        n_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_updateActionPerformed(evt);
            }
        });

        n_find.setText("FIND");
        n_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_findActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(26, 26, 26)
                                .addComponent(n_id_update, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(n_title_update, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(n_update)
                            .addComponent(n_find))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(n_id_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(n_title_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(n_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(n_find))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("UPDATE", jPanel7);

        jLabel19.setText("Notice Title");

        jLabel20.setText("Notice Content");

        addNotice.setText("ADD_NOTICE");
        addNotice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNoticeActionPerformed(evt);
            }
        });

        n_content_adduser.setColumns(20);
        n_content_adduser.setRows(5);
        jScrollPane6.setViewportView(n_content_adduser);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(n_title_add, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                        .addContainerGap(13, Short.MAX_VALUE))))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(addNotice)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(n_title_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addNotice)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ADD_Notice", jPanel8);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );

        jTabbedPane1.addTab("Notice", jPanel2);

        jPanel3.setBackground(new java.awt.Color(140, 140, 140));

        Course_table.setBackground(new java.awt.Color(140, 140, 140));
        Course_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Course_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course Id", "Course Name", "Lec Id", "Credit", "Course Type"
            }
        ));
        jScrollPane3.setViewportView(Course_table);

        jTabbedPane4.setBackground(new java.awt.Color(140, 140, 140));
        jTabbedPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel13.setBackground(new java.awt.Color(140, 140, 140));

        jLabel6.setText("Course Id");

        jLabel30.setText("Course name");

        jLabel32.setText("Lec Id");

        jLabel34.setText("Credit");

        Credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditActionPerformed(evt);
            }
        });

        jLabel35.setText("Course type");

        add_course.setBackground(new java.awt.Color(0, 112, 192));
        add_course.setText("Add_Course");
        add_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_courseActionPerformed(evt);
            }
        });

        Course_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theory", "Practical", "Both" }));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel35))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Course_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Course_name, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(Course_id)
                                        .addComponent(Lec_Id)
                                        .addComponent(Credit))))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(add_course, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Course_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(Course_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(Lec_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Credit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Course_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(add_course, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("ADD", jPanel13);

        jPanel14.setBackground(new java.awt.Color(140, 140, 140));

        jLabel37.setText("Course_Id");

        jLabel38.setText("Course_name");

        jLabel39.setText("Lec_Id");

        jLabel40.setText("Credit");

        jLabel41.setText("Course_type");

        Course_type_update.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theory", "Practical", "Both" }));

        c_update.setText("Update");
        c_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_updateActionPerformed(evt);
            }
        });

        u_find.setText("Find");
        u_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_findActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(58, 58, 58)
                        .addComponent(Course_id_update, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(38, 38, 38)
                        .addComponent(Course_name_update, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(77, 77, 77)
                        .addComponent(Lec_Id_update))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(Course_type_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Credit_update))))
                .addGap(55, 55, 55))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(c_update)
                .addGap(31, 31, 31)
                .addComponent(u_find)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(Course_id_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(Course_name_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(Lec_Id_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Credit_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Course_type_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_update)
                    .addComponent(u_find))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("UPDATE", jPanel14);

        jPanel18.setBackground(new java.awt.Color(140, 140, 140));

        jLabel53.setText("Course_Id");

        course_delete.setText("Remove");
        course_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Course_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(87, 87, 87))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(course_delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Course_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addGap(18, 18, 18)
                .addComponent(course_delete)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("REMOVE", jPanel18);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Courses", jPanel3);

        jPanel5.setBackground(new java.awt.Color(140, 140, 140));

        out_username.setText("out_username");

        jLabel23.setText("EMAIL ADDRESS");

        out_email.setText("out_email");

        jLabel31.setText("ROLE");

        out_role.setText("out_role");

        jLabel33.setText("PHONE NUMBER");

        out_pnumber.setText("out_pnumber");

        Edit_User_profile.setBackground(new java.awt.Color(0, 112, 192));
        Edit_User_profile.setText("Edit User profile");
        Edit_User_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_User_profileActionPerformed(evt);
            }
        });

        Profile_Pic.setText("Profile pic");
        Profile_Pic.setMaximumSize(new java.awt.Dimension(150, 150));
        Profile_Pic.setMinimumSize(new java.awt.Dimension(150, 150));
        Profile_Pic.setPreferredSize(new java.awt.Dimension(150, 150));

        jButton2.setBackground(new java.awt.Color(0, 112, 192));
        jButton2.setText("Add Profile Pic");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel54.setText("NAME");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(out_pnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel54)
                            .addComponent(jLabel31))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(out_role)
                            .addComponent(out_email, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out_username, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Edit_User_profile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Profile_Pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGap(168, 168, 168))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(out_username)
                            .addComponent(jLabel54))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(out_email))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(out_role))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(out_pnumber))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Profile_Pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edit_User_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(344, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profile", jPanel5);

        jPanel4.setBackground(new java.awt.Color(140, 140, 140));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        time_table.setBackground(new java.awt.Color(140, 140, 140));
        time_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        time_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Department", "Lec_Id", "Course_Id", "Admin_Id", "Day", "Start Time", "End Time", "Session Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(time_table);

        jTabbedPane3.setBackground(new java.awt.Color(140, 140, 140));
        jTabbedPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel10.setBackground(new java.awt.Color(140, 140, 140));

        t_day_add.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Thuesdat", "Wenesday", "Thuresday", "Friday" }));
        t_day_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_day_addActionPerformed(evt);
            }
        });

        jLabel15.setText("Day");

        t_time_add_st.setText("00:00");
        t_time_add_st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_time_add_stActionPerformed(evt);
            }
        });

        jLabel16.setText("Start Time");

        t_sess_add.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theory", "Practical" }));
        t_sess_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_sess_addActionPerformed(evt);
            }
        });

        jLabel17.setText("Session Type");

        t_add.setBackground(new java.awt.Color(0, 112, 192));
        t_add.setText("Add");
        t_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_addActionPerformed(evt);
            }
        });

        t_time_add_end.setText("00:00");
        t_time_add_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_time_add_endActionPerformed(evt);
            }
        });

        jLabel22.setText("End Time");

        jLabel47.setText("Department");

        jLabel48.setText("Lec_Id");

        jLabel50.setText("Course_Id");

        t_id_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_id_addActionPerformed(evt);
            }
        });

        jLabel14.setText("ID");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(t_add, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel22)
                    .addComponent(jLabel48)
                    .addComponent(jLabel14)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(t_dep_add))
                    .addComponent(t_time_add_end)
                    .addComponent(t_time_add_st)
                    .addComponent(t_lec_id_add)
                    .addComponent(t_id_add)
                    .addComponent(t_day_add, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_course_id_add)
                    .addComponent(t_sess_add, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(t_id_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_day_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_time_add_st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_time_add_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_lec_id_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_course_id_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_sess_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(t_dep_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(t_add)
                .addGap(19, 19, 19))
        );

        jTabbedPane3.addTab("ADD", jPanel10);

        jPanel11.setBackground(new java.awt.Color(140, 140, 140));

        t_update.setBackground(new java.awt.Color(0, 112, 192));
        t_update.setText("Update");
        t_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_updateActionPerformed(evt);
            }
        });

        jLabel5.setText("ID");

        t_id_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_id_updateActionPerformed(evt);
            }
        });

        t_day_update.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Thuesdat", "Wenesday", "Thuresday", "Friday" }));
        t_day_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_day_updateActionPerformed(evt);
            }
        });

        jLabel24.setText("Day");

        jLabel25.setText("Course_id");

        jLabel26.setText("Start Time");

        t_time_update_st.setText("00:00");
        t_time_update_st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_time_update_stActionPerformed(evt);
            }
        });

        jLabel27.setText("End Time");

        t_time_update_end.setText("00:00");
        t_time_update_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_time_update_endActionPerformed(evt);
            }
        });

        jLabel28.setText("Session Type");

        t_sess_update.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theory", "Practical" }));
        t_sess_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_sess_updateActionPerformed(evt);
            }
        });

        jLabel49.setText("Department");

        jLabel51.setText("Lec_Id");

        t_find.setBackground(new java.awt.Color(0, 112, 192));
        t_find.setText("Find");
        t_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_findActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel5))
                                    .addGap(62, 62, 62)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(t_id_update)
                                        .addComponent(t_day_update, 0, 132, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(t_course_up, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel28)
                                        .addComponent(jLabel49)
                                        .addComponent(jLabel51))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(t_lec_id_up, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(t_dep_up, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(t_sess_update, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(4, 4, 4)))))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(t_update)
                        .addGap(18, 18, 18)
                        .addComponent(t_find)))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(t_time_update_end, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t_time_update_st, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(t_id_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(t_day_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(t_course_up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(t_sess_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(t_dep_up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(t_lec_id_up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_update)
                    .addComponent(t_find))
                .addGap(27, 27, 27))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(t_time_update_st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(t_time_update_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(159, Short.MAX_VALUE)))
        );

        jTabbedPane3.addTab("UPDATE", jPanel11);

        jPanel12.setBackground(new java.awt.Color(140, 140, 140));

        t_id_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_id_deleteActionPerformed(evt);
            }
        });

        jLabel52.setText("ID");

        t_delete.setBackground(new java.awt.Color(0, 112, 192));
        t_delete.setText("Delete");
        t_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel52)
                        .addGap(50, 50, 50)
                        .addComponent(t_id_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(t_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_id_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addComponent(t_delete)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("DELETE", jPanel12);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(773, 773, 773))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Time Table", jPanel4);

        jPanel1.setBackground(new java.awt.Color(140, 140, 140));
        jPanel1.setMaximumSize(new java.awt.Dimension(25000, 25000));

        Table1.setBackground(new java.awt.Color(140, 140, 140));
        Table1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "UserPassword", "User Name", "User Email", "User Phone", "User Pro Pic", "User Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(Table1);
        Table1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jTabbedPane5.setBackground(new java.awt.Color(140, 140, 140));
        jTabbedPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel15.setBackground(new java.awt.Color(140, 140, 140));

        jLabel1.setText("USER ID");

        jLabel7.setText("USER NAME");

        u_name_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_name_newActionPerformed(evt);
            }
        });

        jLabel2.setText("PASSWORD");

        u_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Undergraduate", "tech_officer", "Lecturer" }));

        jLabel3.setText("ROLE");

        jLabel9.setText("EMAIL");

        jLabel10.setText("PHONE");

        addUser.setBackground(new java.awt.Color(0, 112, 192));
        addUser.setText("ADD USER");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(addUser)
                        .addGap(0, 103, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(u_phone)
                            .addComponent(u_email, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(u_pass, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(u_name_new, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(u_name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(u_role, 0, 147, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(u_name_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addUser)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("ADD USER", jPanel15);

        jPanel16.setBackground(new java.awt.Color(140, 140, 140));

        jLabel18.setText("USER ID");

        jLabel21.setText("USER NAME");

        u_name_new_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_name_new_uActionPerformed(evt);
            }
        });

        jLabel29.setText("PASSWORD");

        jLabel43.setText("ROLE");

        u_role_u.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Undergraduate", "Tech_officer", "Lecturer" }));

        jLabel44.setText("EMAIL");

        jLabel45.setText("PHONE");

        updateUser.setText("UPDATE");
        updateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserActionPerformed(evt);
            }
        });

        jButton1.setText("SERCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(u_email_u)
                    .addComponent(u_role_u, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(u_phone_u)
                    .addComponent(u_pass_u))
                .addContainerGap())
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(u_name_u, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(u_name_new_u, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(updateUser)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(u_name_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(u_name_new_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(u_pass_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(u_role_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(u_email_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(u_phone_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateUser)
                    .addComponent(jButton1))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("UPDATE", jPanel16);

        jPanel17.setBackground(new java.awt.Color(140, 140, 140));

        jLabel46.setText("USER ID");

        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(u_name_d, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(DELETE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(u_name_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DELETE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("DELETE", jPanel17);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("User", jPanel1);

        logout.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(153, 0, 51));
        logout.setText("LOGOUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    private void n_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_DELETEActionPerformed
       String noticeIdText = n_id.getText().trim();
        try{
            if(!Admin.deleteNotice.validation(noticeIdText)){
                return;
            }
            int noticeid = Integer.parseInt(noticeIdText);
            if(!Admin.deleteNotice.noticeExists(noticeid)){
               JOptionPane.showMessageDialog(this, "Notice id find error" ); 
               return;
            }
            
            if(Admin.deleteNotice.deleteNotice(noticeid)){
                JOptionPane.showMessageDialog(this, "Notice delete success" );
                notice_tbload();
                n_id.setText("");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Notice delete error" + e.getMessage());
        }
    }//GEN-LAST:event_n_DELETEActionPerformed

    private void n_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_updateActionPerformed
        // TODO add your handling code here:
        LocalDate localdate = LocalDate.now();
        
        String noticeText = n_id_update.getText().trim();

        String notice_id = n_id_update.getText();
        String Notice_title = n_title_update.getText();
        String Notice_content = n_content_update.getText();
        Date sqlDate = Date.valueOf(localdate);
        try{
        if(!Admin.updateNotice.validation(notice_id,Notice_title,Notice_content)){
            return ;
        }
        
        int notice = Integer.parseInt(notice_id);
        
        if(Admin.updateNotice.updateNotice(notice, Notice_title, Notice_content, sqlDate)){
            JOptionPane.showMessageDialog(this, "Notice updated successful");
            notice_tbload();
            n_id_update.setText("");
            n_title_update.setText("");
            n_content_update.setText("");
            notice_tbload();
        }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Notice updated error" + e.getMessage());
        }
    }//GEN-LAST:event_n_updateActionPerformed

    private void addNoticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNoticeActionPerformed
        
        LocalDate localdate = LocalDate.now();

        String Notice_title = n_title_add.getText();
        String Notice_content = n_content_adduser.getText();
        Date sqlDate = Date.valueOf(localdate);
        
        try{
            if(!Admin.addNotice.validation(Notice_title,Notice_content)){
                return ;
            }
            if(Admin.addNotice.addNotice(Notice_title, Notice_content, sqlDate)){
                JOptionPane.showMessageDialog(this, "Notice saved success");
                n_title_add.setText("");
                n_content_adduser.setText("");
                notice_tbload();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
             
    }//GEN-LAST:event_addNoticeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = u_name_u.getText();

        String sql = "SELECT * FROM user WHERE user_id = ?";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, username);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    
                    u_name_u.setText(rs.getString("user_id"));
                    u_name_new_u.setText(rs.getString("user_name"));
                    //u_pass_u.setText(rs.getString("user_password"));
                    
                    u_email_u.setText(rs.getString("user_email"));
                    u_phone_u.setText(rs.getString("user_phone"));
                     String roleFromDB = rs.getString("user_role");
                    u_role_u.setSelectedItem(roleFromDB);
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
         String userID = u_name_d.getText();

        try{
        if(!Admin.deleteUser.validation(userID)){
            return;
        }
        if(!Admin.deleteUser.usernameExists(userID)){
            JOptionPane.showMessageDialog(this, "User  not  found");
            return;
        }
       
        if(Admin.deleteUser.deleteUser(userID)){
            JOptionPane.showMessageDialog(this, "User  remove  success");
            tbload();
            u_name_d.setText(" ");
        }

    }
            catch(Exception e){
        JOptionPane.showMessageDialog(this, "User delete not  successfully!"+ e.getMessage());
        }
    }//GEN-LAST:event_DELETEActionPerformed

    private void updateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserActionPerformed
        String username = u_name_u.getText().trim();
        String name = u_name_new_u.getText().trim();
        char[] password = u_pass_u.getPassword(); 
        String role = u_role_u.getSelectedItem().toString().toLowerCase();
        String email = u_email_u.getText();
        String phone = u_phone_u.getText();
        
        try{
        if(!Admin.updateUser.validation(username, role, name, email, phone)){
            //return ;
        }
        boolean updateState;
        if(password.length > 0){
            updateState = Admin.updateUser.updateUserWithPassword(username, password, role, name, email, phone);
        }else{
            updateState = Admin.updateUser.updateUserWithoutPassword(username, role, name, email, phone);
        }
        if(updateState){
            JOptionPane.showMessageDialog(this, "User updated successfully!");
            tbload();
        }else{
            JOptionPane.showMessageDialog(this, "User could not be updated.");
        }


    }catch(Exception e){
        JOptionPane.showMessageDialog(this, "User updated not  successfully!"+ e.getMessage());
    }
    }//GEN-LAST:event_updateUserActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        String username = u_name.getText().trim();
        String name = u_name_new.getText().trim();
        char[] password = u_pass.getPassword();
        String role = u_role.getSelectedItem().toString().toLowerCase();;
        String email = u_email.getText();
        String phone = u_phone.getText();


        try {
        if(!Admin.addUser.validation(username, password, role, name, email, phone)){
            return;
        }
        if(Admin.addUser.usernameExists(username)){
            JOptionPane.showMessageDialog(this, "User name Exits");
            return;
        }
        if(Admin.addUser.addUser(username, name, password, role, email, phone)){
            JOptionPane.showMessageDialog(this, "User add successfully");
            u_name.setText(" ");
            u_name_new.setText(" ");
            u_pass.setText(" ");
            u_phone.setText(" ");
            u_email.setText(" ");
            tbload();
        }else{
            JOptionPane.showMessageDialog(this, "User add not successfully");
        }
    }
        catch(Exception e){
        System.out.println(e);
    }
    }//GEN-LAST:event_addUserActionPerformed

    private void n_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_idActionPerformed

    private void n_id_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_id_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_id_updateActionPerformed

    private void Edit_User_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_User_profileActionPerformed
       editprofiledailog dialog = new editprofiledailog(this, true, u_username); // true = modal
       dialog.setVisible(true);
  
    }//GEN-LAST:event_Edit_User_profileActionPerformed

    private void add_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_courseActionPerformed
    String c_id = Course_id.getText();
    String c_name = Course_name.getText();
    String lec_id = Lec_Id.getText();
    String creditText = Credit.getText().trim();
    String c_type = Course_type.getSelectedItem().toString().toLowerCase();
    
    
    try{
        if(!Admin.addCourse.validation(c_id, c_name, lec_id, creditText, c_type)){
            return ;
        }
        int credit = Integer.parseInt(creditText);
        if(Admin.addCourse.addCourses(c_id, c_name, lec_id, credit, c_type)){
            JOptionPane.showMessageDialog(this, "Course add successfull");
            Course_id.setText("");
            Course_name.setText("");
            Lec_Id.setText("");
            Credit.setText("");
            
            course_table();
        }
    
    }catch(Exception e){
        JOptionPane.showMessageDialog(this, "Course add error"+ e.getMessage());
    }
    
    }//GEN-LAST:event_add_courseActionPerformed

    private void c_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_updateActionPerformed
    String c_id = Course_id_update.getText().trim();
    String c_name = Course_name_update.getText().trim();
    String lec_id = Lec_Id_update.getText().trim();
    String creditText = Credit_update.getText().trim();
    String c_type = Course_type_update.getSelectedItem().toString().toLowerCase().trim();
    
    
    try{
        if(!Admin.updateCourse.validation(c_id, c_name, lec_id, creditText, c_type)){
            return ;
        }
        int credit = Integer.parseInt(creditText);
        if(Admin.updateCourse.updateCourses(c_id, c_name, lec_id, credit, c_type)){
            JOptionPane.showMessageDialog( this,"Course updated successful" );
            course_table();
            
            Course_id.setText("");
            Course_name.setText("");
            Lec_Id.setText("");
            Credit.setText("");
            
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog( this, "Error " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }

    
    }//GEN-LAST:event_c_updateActionPerformed

    private void u_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_findActionPerformed
        String c_id = Course_id_update.getText().trim();
    
    if (c_id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a Course ID to find.");
        return;
    }
    
    String sql = "SELECT * FROM course WHERE course_id = ?";
    
    try (Connection conn = dbconnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setString(1, c_id);
        
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            
            Course_name_update.setText(rs.getString("course_name"));
            Lec_Id_update.setText(rs.getString("lec_id"));
            Credit_update.setText(String.valueOf(rs.getInt("credit")));
            Course_type_update.setSelectedItem(rs.getString("course_type")); 
            //Course_content_update.setText(rs.getString("course_content"));
        } else {
            JOptionPane.showMessageDialog(this, "Course not found!");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error " + e.getMessage());
        System.out.println(e);
    }
    }//GEN-LAST:event_u_findActionPerformed

    private void CreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreditActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String imagePath = selectedFile.getAbsolutePath();
        
        if (isValidImageFile(imagePath)) {
            try (Connection conn = dbconnection.getConnection()) {
                String sql = "UPDATE user SET user_pro_pic = ? WHERE user_id = ?";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, imagePath);
                pst.setString(2, u_username);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Profile picture updated successful");
                loadProfilePic();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving image path");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid file format Please select a JPG, JPEG, PNG, GIF, or BMP image.");
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private boolean isValidImageFile(String path) {
    String lowerPath = path.toLowerCase();
    return lowerPath.endsWith(".jpg") || 
           lowerPath.endsWith(".jpeg") || 
           lowerPath.endsWith(".png") || 
           lowerPath.endsWith(".gif") || 
           lowerPath.endsWith(".bmp");
}
    private void u_name_new_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_name_new_uActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_name_new_uActionPerformed

    private void u_name_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_name_newActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_name_newActionPerformed

    private void t_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_findActionPerformed
        String id = t_id_update.getText();

        String sql = "SELECT *  FROM time_table  WHERE time_table_id = ?";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    
                    t_course_up.setText(rs.getString("course_id"));
                    t_time_update_st.setText(rs.getString("start_time"));
                    t_time_update_end.setText(rs.getString("end_time"));
                    
                    t_lec_id_up.setText(rs.getString("lec_id"));
                    t_dep_up.setText(rs.getString("department"));
                     String sessFromDB = rs.getString("session_type");
                    t_sess_update.setSelectedItem(sessFromDB);
                     String dayFromDB = rs.getString("day");
                    t_day_update.setSelectedItem(dayFromDB);
                    tbload();
                }else{
                    JOptionPane.showMessageDialog(null, "User not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_t_findActionPerformed

    private void t_sess_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_sess_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_sess_updateActionPerformed

    private void t_time_update_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_time_update_endActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_time_update_endActionPerformed

    private void t_time_update_stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_time_update_stActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_time_update_stActionPerformed

    private void t_day_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_day_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_day_updateActionPerformed

    private void t_id_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_id_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_id_updateActionPerformed

    private void t_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_updateActionPerformed
        String t_table_id = t_id_update.getText().toLowerCase();
        String day = t_day_update.getSelectedItem().toString().toLowerCase();
        String course = t_course_up.getText();
        String st_time = t_time_update_st.getText();
        String end_time = t_time_update_end.getText();
        String Sesson_type = t_sess_update.getSelectedItem().toString().toLowerCase();
        String depart = t_dep_up.getText().toLowerCase();
        String lec_id = t_lec_id_up.getText();
        String addmin_id = u_username;

        try{
            if(!Admin.updateTimetable.validation(day, lec_id, depart, lec_id, course, st_time, end_time, Sesson_type)){
                return ;
            }
            
            if(Admin.updateTimetable.updateTimeTable(day, course, st_time, end_time, Sesson_type, lec_id, t_table_id, depart, addmin_id)){
                JOptionPane.showMessageDialog( this,"Time_table data update Success");
                time_table();
            }else{
                JOptionPane.showMessageDialog( this,"Time_table data not update Success");
            }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog( this,"Time_table data not update Success" + e.getMessage());
        }
    }//GEN-LAST:event_t_updateActionPerformed

    private void t_time_add_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_time_add_endActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_time_add_endActionPerformed

    private void t_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_addActionPerformed
        String day = t_day_add.getSelectedItem().toString();
        String time_id = t_id_add.getText().toLowerCase();
        String startTime = t_time_add_st.getText();
        String endTime = t_time_add_end.getText();
        String sess_type = t_sess_add.getSelectedItem().toString().toLowerCase();
        String dept = t_dep_add.getText();
        String addmin_id = u_username;
        String lec_id = t_lec_id_add.getText();
        String course_id = t_course_id_add.getText();

        try{
            if(!Admin.addTimetable.validation(day, time_id, dept, lec_id, course_id, startTime, endTime, sess_type, lec_id)){
                return;
            }
            if(Admin.addTimetable.addTimeTable(day, course_id, startTime, endTime, sess_type, lec_id, time_id, dept, addmin_id)){
                JOptionPane.showMessageDialog( this,"Time_table data add Success");
                t_id_add.setText("");
                t_time_add_st.setText("");
                t_lec_id_add.setText("");
                t_time_add_end.setText("");
                t_course_id_add.setText("");
                
                time_table();
            }else{
                JOptionPane.showMessageDialog( this,"Time_table data add not Success");
            }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog( this,"Time_table data error"+e.getMessage());
        }
    }//GEN-LAST:event_t_addActionPerformed

    private void t_sess_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_sess_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_sess_addActionPerformed

    private void t_time_add_stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_time_add_stActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_time_add_stActionPerformed

    private void t_day_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_day_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_day_addActionPerformed

    private void t_id_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_id_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_id_addActionPerformed

    private void t_id_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_id_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_id_deleteActionPerformed

    private void t_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_deleteActionPerformed
        String time_ID = t_id_delete.getText();

        try{
            if(!Admin.deleteTimeTable.validation(time_ID)){
                return;
            }
            if(!Admin.deleteTimeTable.timeTableExists(time_ID)){
                JOptionPane.showMessageDialog( this,"Time table id not found ");
                return;
            }
            if(Admin.deleteTimeTable.deleteTimetable(time_ID)){
                JOptionPane.showMessageDialog( this,"Time table data Remove Success");
                t_id_delete.setText("");
                time_table();
            }else{
                JOptionPane.showMessageDialog( this,"Time table data Remove not Success");
            }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog( this,"Time table data Remove not Success error" + e.getMessage());
        }
    }//GEN-LAST:event_t_deleteActionPerformed

    private void course_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_deleteActionPerformed
            String course_ID = Course_delete.getText();
            
            try{
        if(!Admin.deleteCourse.validation(course_ID)){
            return;
        }
        if(!Admin.deleteCourse.courseExists(course_ID)){
            JOptionPane.showMessageDialog(this, "Course  not  found");
            return;
        }
       
        if(Admin.deleteCourse.deleteUser(course_ID)){
            JOptionPane.showMessageDialog(this, "Course remove  success");
            course_table();
            Course_delete.setText(" ");
        }

    }
            catch(Exception e){
        JOptionPane.showMessageDialog(this, "Course delete not  successfully!"+ e.getMessage());
        }
        
    }//GEN-LAST:event_course_deleteActionPerformed

    private void n_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_findActionPerformed
        String n_id = n_id_update.getText().trim();
    
    if (n_id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a notice ID to find.");
        return;
    }
    
    String sql = "SELECT * FROM notice WHERE notice_id = ?";
    
    try (Connection conn = dbconnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setString(1, n_id);
        
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) { 
            n_title_update.setText(rs.getString("notice_title"));
            n_content_update.setText(rs.getString("notice_content"));
            
        } else {
            JOptionPane.showMessageDialog(this, "Notice not found!");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        System.out.println(e);
    }
        
        
    }//GEN-LAST:event_n_findActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        
            dispose();
            Login logform = new Login();
            logform.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed
    
    

   /*public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Course_delete;
    private javax.swing.JTextField Course_id;
    private javax.swing.JTextField Course_id_update;
    private javax.swing.JTextField Course_name;
    private javax.swing.JTextField Course_name_update;
    private javax.swing.JTable Course_table;
    private javax.swing.JComboBox<String> Course_type;
    private javax.swing.JComboBox<String> Course_type_update;
    private javax.swing.JTextField Credit;
    private javax.swing.JTextField Credit_update;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton Edit_User_profile;
    private javax.swing.JTextField Lec_Id;
    private javax.swing.JTextField Lec_Id_update;
    private javax.swing.JLabel Profile_Pic;
    private javax.swing.JTable Table1;
    private javax.swing.JButton addNotice;
    private javax.swing.JButton addUser;
    private javax.swing.JButton add_course;
    private javax.swing.JButton c_update;
    private javax.swing.JButton course_delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JButton logout;
    private javax.swing.JButton n_DELETE;
    private javax.swing.JTextArea n_content_adduser;
    private javax.swing.JTextArea n_content_update;
    private javax.swing.JButton n_find;
    private javax.swing.JTextField n_id;
    private javax.swing.JTextField n_id_update;
    private javax.swing.JTextField n_title_add;
    private javax.swing.JTextField n_title_update;
    private javax.swing.JButton n_update;
    private javax.swing.JTable noticeTable;
    private javax.swing.JLabel out_email;
    private javax.swing.JLabel out_pnumber;
    private javax.swing.JLabel out_role;
    private javax.swing.JLabel out_username;
    private javax.swing.JButton t_add;
    private javax.swing.JTextField t_course_id_add;
    private javax.swing.JTextField t_course_up;
    private javax.swing.JComboBox<String> t_day_add;
    private javax.swing.JComboBox<String> t_day_update;
    private javax.swing.JButton t_delete;
    private javax.swing.JTextField t_dep_add;
    private javax.swing.JTextField t_dep_up;
    private javax.swing.JButton t_find;
    private javax.swing.JTextField t_id_add;
    private javax.swing.JTextField t_id_delete;
    private javax.swing.JTextField t_id_update;
    private javax.swing.JTextField t_lec_id_add;
    private javax.swing.JTextField t_lec_id_up;
    private javax.swing.JComboBox<String> t_sess_add;
    private javax.swing.JComboBox<String> t_sess_update;
    private javax.swing.JTextField t_time_add_end;
    private javax.swing.JTextField t_time_add_st;
    private javax.swing.JTextField t_time_update_end;
    private javax.swing.JTextField t_time_update_st;
    private javax.swing.JButton t_update;
    private javax.swing.JTable time_table;
    private javax.swing.JTextField u_email;
    private javax.swing.JTextField u_email_u;
    private javax.swing.JButton u_find;
    private javax.swing.JTextField u_name;
    private javax.swing.JTextField u_name_d;
    private javax.swing.JTextField u_name_new;
    private javax.swing.JTextField u_name_new_u;
    private javax.swing.JTextField u_name_u;
    private javax.swing.JPasswordField u_pass;
    private javax.swing.JPasswordField u_pass_u;
    private javax.swing.JTextField u_phone;
    private javax.swing.JTextField u_phone_u;
    private javax.swing.JComboBox<String> u_role;
    private javax.swing.JComboBox<String> u_role_u;
    private javax.swing.JButton updateUser;
    // End of variables declaration//GEN-END:variables
}
