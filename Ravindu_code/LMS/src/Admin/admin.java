
package Admin;
import java.sql.*;
import Database.dbconnection;
import Admin.editprofiledailog;
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
        String sql = "SELECT user_pro_pic FROM users WHERE username = ?";
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
        String sql ="select * from users where username = ?";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,username);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                       out_username.setText(rs.getString("username"));
                       out_email.setText(rs.getString("Email"));
                       out_role.setText(rs.getString("role"));
                       out_pnumber.setText(rs.getString("Phone"));
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
                    ResultSet rs = stmt.executeQuery("SELECT * FROM users");){

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
                        v.add(rs.getInt(1));
                        v.add(rs.getString(2));
                        v.add(rs.getString(3));
                        v.add(rs.getTime(4));
                        v.add(rs.getTime(5));
                        v.add(rs.getString(6));
                        
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
                        v.add(rs.getString(6));
                        
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
        jLabel36 = new javax.swing.JLabel();
        Course_content = new javax.swing.JTextField();
        add_course = new javax.swing.JButton();
        Course_type = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        Course_id_update = new javax.swing.JTextField();
        Course_name_update = new javax.swing.JTextField();
        Lec_Id_update = new javax.swing.JTextField();
        Credit_update = new javax.swing.JTextField();
        Course_type_update = new javax.swing.JComboBox<>();
        Course_content_update = new javax.swing.JTextField();
        c_update = new javax.swing.JButton();
        u_find = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        out_username = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        out_email = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        out_role = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        out_pnumber = new javax.swing.JLabel();
        Edit_User_profile = new javax.swing.JButton();
        profile_pic = new javax.swing.JPanel();
        Profile_Pic = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        time_table = new javax.swing.JTable();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        t_day_add = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        t_sub_add = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        t_time_add_st = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        t_sess_add = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        t_add = new javax.swing.JButton();
        t_time_add_end = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        t_update = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        t_id_update = new javax.swing.JTextField();
        t_day_update = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        t_sub_update = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        t_time_update_st = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        t_time_update_end = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        t_sess_update = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        t_find = new javax.swing.JButton();
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

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

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

        jLabel8.setText("Notice ID");

        n_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_idActionPerformed(evt);
            }
        });

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
                .addComponent(n_id, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(51, 51, 51))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(n_DELETE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(n_update))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))))
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
                        .addComponent(n_update))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane6)
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
                .addContainerGap(181, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1850, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Notice", jPanel2);

        Course_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Course_Id", "Course_name", "lec_id", "Credit", "Course_type", "Course_content"
            }
        ));
        jScrollPane3.setViewportView(Course_table);

        jLabel6.setText("Course_Id");

        jLabel30.setText("Course_name");

        jLabel32.setText("Lec_Id");

        jLabel34.setText("Credit");

        Credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditActionPerformed(evt);
            }
        });

        jLabel35.setText("Course_type");

        jLabel36.setText("Course_content");

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
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel35))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Course_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Course_name, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(Course_id)
                                        .addComponent(Lec_Id)
                                        .addComponent(Credit))
                                    .addComponent(Course_content, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(add_course)))
                .addContainerGap(51, Short.MAX_VALUE))
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
                .addGap(7, 7, 7)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Course_content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add_course)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Add", jPanel13);

        jLabel37.setText("Course_Id");

        jLabel38.setText("Course_name");

        jLabel39.setText("Lec_Id");

        jLabel40.setText("Credit");

        jLabel41.setText("Course_type");

        jLabel42.setText("Course_content");

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
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(58, 58, 58)
                                .addComponent(Course_id_update, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
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
                        .addComponent(jLabel42)
                        .addGap(27, 27, 27)
                        .addComponent(Course_content_update, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Course_content_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_update)
                    .addComponent(u_find))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Update", jPanel14);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1988, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Courses", jPanel3);

        out_username.setText("out_username");

        jLabel23.setText("Email Address");

        out_email.setText("out_email");

        jLabel31.setText("Role");

        out_role.setText("out_role");

        jLabel33.setText("Phone Number");

        out_pnumber.setText("out_pnumber");

        Edit_User_profile.setText("Edit User profile");
        Edit_User_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_User_profileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profile_picLayout = new javax.swing.GroupLayout(profile_pic);
        profile_pic.setLayout(profile_picLayout);
        profile_picLayout.setHorizontalGroup(
            profile_picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        profile_picLayout.setVerticalGroup(
            profile_picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Profile_Pic.setText("Profile pic");
        Profile_Pic.setMaximumSize(new java.awt.Dimension(150, 150));
        Profile_Pic.setMinimumSize(new java.awt.Dimension(150, 150));
        Profile_Pic.setPreferredSize(new java.awt.Dimension(150, 150));

        jButton2.setText("Add Profile Pic");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(profile_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(out_role)
                        .addComponent(jLabel31)
                        .addComponent(jLabel23)
                        .addComponent(out_pnumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(out_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(out_username, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Edit_User_profile)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButton2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(Profile_Pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2107, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(out_username)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(out_email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(out_role)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(out_pnumber)
                .addGap(18, 18, 18)
                .addComponent(Edit_User_profile)
                .addContainerGap(174, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(profile_pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(Profile_Pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profile", jPanel5);

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

        time_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Day", "Subject", "Session_type", "Start Time", "End Time"
            }
        ));
        jScrollPane5.setViewportView(time_table);

        t_day_add.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Thuesdat", "Wenesday", "Thuresday", "Friday" }));
        t_day_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_day_addActionPerformed(evt);
            }
        });

        jLabel15.setText("Day");

        jLabel14.setText("Subject ");

        t_time_add_st.setText("00:00:00");
        t_time_add_st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_time_add_stActionPerformed(evt);
            }
        });

        jLabel16.setText("Start Time");

        t_sess_add.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "theory", "Patrical" }));
        t_sess_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_sess_addActionPerformed(evt);
            }
        });

        jLabel17.setText("Session Type");

        t_add.setText("Add");
        t_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_addActionPerformed(evt);
            }
        });

        t_time_add_end.setText("00:00:00");
        t_time_add_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_time_add_endActionPerformed(evt);
            }
        });

        jLabel22.setText("End Time");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel14)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_time_add_end, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_sess_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_time_add_st, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_sub_add, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_day_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(t_add)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_day_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_sub_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_time_add_st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_time_add_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_sess_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(46, 46, 46)
                .addComponent(t_add)
                .addGap(28, 28, 28))
        );

        jTabbedPane3.addTab("Add", jPanel10);

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

        jLabel25.setText("Subject ");

        jLabel26.setText("Start Time");

        t_time_update_st.setText("00:00:00");
        t_time_update_st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_time_update_stActionPerformed(evt);
            }
        });

        jLabel27.setText("End Time");

        t_time_update_end.setText("00:00:00");
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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel5))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_day_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_id_update, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(40, 40, 40)
                                .addComponent(t_sub_update, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(t_update)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(t_time_update_end, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t_sess_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t_time_update_st, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(30, Short.MAX_VALUE)))
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
                    .addComponent(t_sub_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(t_update)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(t_time_update_st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(t_time_update_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_sess_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(72, 72, 72)))
        );

        jTabbedPane3.addTab("Update", jPanel11);

        t_find.setText("Find");
        t_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_findActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(t_find)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(t_find)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("", jPanel12);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
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
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Time Table", jPanel4);

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "USER NAME", "Name", "PASSWORD", "ROLE", "Email", "Phone Number"
            }
        ));
        Table1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(Table1);
        Table1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (Table1.getColumnModel().getColumnCount() > 0) {
            Table1.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setText("USER NAME");

        jLabel7.setText("NAME");

        u_name_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_name_newActionPerformed(evt);
            }
        });

        jLabel2.setText("PASSWORD");

        u_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Undergraduate", "To", "Lecturer" }));

        jLabel3.setText("ROLE");

        jLabel9.setText("EMAIL");

        jLabel10.setText("PHONE");

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
                    .addComponent(u_email)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(u_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(u_name_new)
                            .addComponent(u_name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addUser)
                            .addComponent(u_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(u_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("ADD USER", jPanel15);

        jLabel18.setText("USER NAME");

        jLabel21.setText("NAME");

        u_name_new_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_name_new_uActionPerformed(evt);
            }
        });

        jLabel29.setText("PASSWORD");

        jLabel43.setText("ROLE");

        u_role_u.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Undergraduate", "To", "Lecturer" }));

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
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(u_name_new_u)
                            .addComponent(u_name_u, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(u_phone_u, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(u_role_u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(u_pass_u, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(u_email_u))))
                .addContainerGap())
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(updateUser)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
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
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("UPDATE", jPanel16);

        jLabel46.setText("USER NAME");

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
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(u_name_d, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DELETE)
                .addGap(69, 69, 69))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(u_name_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(DELETE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("DELETE", jPanel17);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1761, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("User", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addGap(392, 392, 392))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void n_DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_DELETEActionPerformed
        // TODO add your handling code here:
        String noticeText = n_id.getText().trim();
        if (noticeText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Notice ID is required!");
            return;
        }
        
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
        
        String noticeText = n_id_update.getText().trim();
        if (noticeText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Notice ID is required!");
            return;
        }

        int notice_id = Integer.parseInt(n_id_update.getText());
        String Notice_title = n_title_update.getText();
        String Notice_content = n_content_update.getText();
        Date sqlDate = Date.valueOf(localdate);
        
        if(Notice_title.isEmpty()|| Notice_content.isEmpty()){
        JOptionPane.showMessageDialog(this, "All fields are required!");
        return;
        }

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

        String Notice_title = n_title_add.getText();
        String Notice_content = n_content_adduser.getText();
        Date sqlDate = Date.valueOf(localdate);
        
        if(Notice_title.isEmpty()|| Notice_content.isEmpty()){
        JOptionPane.showMessageDialog(this, "All fields are required!");
        return;
        }
             
        String sql = "INSERT INTO notice (notice_title, notice_content,notice_date) VALUES (?, ?, ?)";

        try (Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            
            pst.setString(1, Notice_title);
            pst.setString(2, Notice_content);
            pst.setDate(3, sqlDate);

           
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Notice saved successfully!");
                n_title_add.setText("");
                n_content_adduser.setText("");
                notice_tbload();
            } else {
                JOptionPane.showMessageDialog(this, "Notice could not be saved.");
            }

        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_addNoticeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              String username = u_name_u.getText();

        String sql = "SELECT * FROM users WHERE username = ?";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, username);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    
                    u_name_u.setText(rs.getString("username"));
                    u_name_new_u.setText(rs.getString("name"));
                    u_pass_u.setText(rs.getString("password"));
                    
                    u_email_u.setText(rs.getString("email"));
                    u_phone_u.setText(rs.getString("phone"));
                     String roleFromDB = rs.getString("role");
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
        String username = u_name_u.getText().trim();
        String name = u_name_new_u.getText().trim();
        char[] password = u_pass_u.getPassword(); 
        String role = u_role_u.getSelectedItem().toString().toLowerCase();
        String email = u_email_u.getText();
        String phone = u_phone_u.getText();
        
        if (username.isEmpty() || password.length == 0 || role.isEmpty() ||name.isEmpty()) {
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
        
     
        String hashedPassword = Admin.encryption.hashpassword(new String(password));

        String sql = "UPDATE users SET name=? ,password = ?, role = ?, email = ?, phone = ? WHERE username = ?";

        try (Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, name);
            pst.setString(2, hashedPassword);
            pst.setString(3, role);
            pst.setString(4, email);
            pst.setString(5, phone);
             pst.setString(6, username);

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
        String name = u_name_new.getText().trim().toLowerCase();
        char[] password = u_pass.getPassword(); 
        String role = u_role.getSelectedItem().toString().toLowerCase();;
        String email = u_email.getText();
        String phone = u_phone.getText();
        
        if (username.isEmpty() || password.length == 0 || role.isEmpty()||name.isEmpty()) {
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
        String sql = "INSERT INTO users VALUES (?, ?, ?, ? , ?, ?)";

        try (Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            // Set parameter values
            pst.setString(1, username);
            pst.setString(2, name);
            pst.setString(3, hashedPassword);
            pst.setString(4, role);
            pst.setString(5, email);
            pst.setString(6, phone);
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

    private void n_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_idActionPerformed

    private void n_id_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_id_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_id_updateActionPerformed

    private void t_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_findActionPerformed
        // TODO add your handling code here:
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
        int id = Integer.parseInt(t_id_update.getText());
        String day = t_day_update.getSelectedItem().toString().toLowerCase();
        String sub = t_sub_update.getText();
        String st_time = t_time_update_st.getText();
        String end_time = t_time_update_end.getText();
        String Sesson_type = t_sess_update.getSelectedItem().toString().toLowerCase();
        
        try {
    id = Integer.parseInt(t_id_update.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Invalid ID. Please enter a valid number.");
    return;
}

if (day.equals("select day") || day.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please select a valid day.");
    return;
}

if (sub.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Subject cannot be empty.");
    return;
}

if (st_time.isEmpty() || !st_time.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d$")) {
    JOptionPane.showMessageDialog(this, "Start time must be in HH:mm format (e.g., 09:00).");
    return;
}

if (end_time.isEmpty() || !end_time.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d$")) {
    JOptionPane.showMessageDialog(this, "End time must be in HH:mm format (e.g., 10:30).");
    return;
}

if (Sesson_type.equals("select session") || Sesson_type.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please select a valid session type.");
    return;
}


        
        String sql = "Update time_table set day = ?, subject = ?,Start_time = ?,End_time = ?,Session_type = ? where id = ?";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql) ){

            pst.setString(1, day);
            pst.setString(2, sub);
            pst.setString(3,st_time);
            pst.setString(4,end_time);
            pst.setString(5,Sesson_type);
            pst.setInt(6,id);

            pst.executeUpdate();

        }catch(Exception e){

        }
    }//GEN-LAST:event_t_updateActionPerformed

    private void t_time_add_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_time_add_endActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_time_add_endActionPerformed

    private void t_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_addActionPerformed
        String day = t_day_add.getSelectedItem().toString();
        String subject = t_sub_add.getText();
        String startTime = t_time_add_st.getText();
        String endTime = t_time_add_end.getText();
        String sess_type = t_sess_add.getSelectedItem().toString();
        
        if (day.equals("Select Day") || day.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please select a valid day.");
    return;
}

if (subject.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Subject cannot be empty.");
    return;
}

if (startTime.isEmpty() || !startTime.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d$")) {
    JOptionPane.showMessageDialog(this, "Start Time must be in HH:mm format (e.g., 09:30).");
    return;
}

if (endTime.isEmpty() || !endTime.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d$")) {
    JOptionPane.showMessageDialog(this, "End Time must be in HH:mm format (e.g., 11:00).");
    return;
}

if (sess_type.equals("Select Session") || sess_type.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please select a valid session type.");
    return;
}

        

        String sql = "insert into time_table (day,subject,Start_time,End_time,session_type)values(?,?,?,?,?)";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,day);
            stmt.setString(2,subject);
            stmt.setString(3,startTime);
            stmt.setString(4,endTime);
            stmt.setString(5,sess_type);
            
            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
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

    private void Edit_User_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_User_profileActionPerformed
       editprofiledailog dialog = new editprofiledailog(this, true, u_username); // true = modal
       dialog.setVisible(true);
  
    }//GEN-LAST:event_Edit_User_profileActionPerformed

    private void add_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_courseActionPerformed
        String c_id = Course_id.getText();
    String c_name = Course_name.getText();
    String lec_id = Lec_Id.getText();
    int credit = Integer.parseInt(Credit.getText());
    String c_type = Course_type.getSelectedItem().toString().toLowerCase();
    String c_content = Course_content.getText();
    
    if (c_id.isEmpty() || c_name.isEmpty() || lec_id.isEmpty() || Credit.getText().isEmpty() || c_content.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please fill all required fields!");
    return; }

    
    String sql = "Insert into course values (?,?,?,?,?,?)";
    
    try(Connection conn = dbconnection.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql)){
        
        
        pst.setString(1, c_id);
        pst.setString(2, c_name);
        pst.setString(3, lec_id);
        pst.setInt(4, credit);
        pst.setString(5, c_type);
        pst.setString(6, c_content);
        
        
        int rowsInserted = pst.executeUpdate();
        
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Course added successfully!");
           
            Course_id.setText("");
            Course_name.setText("");
            Lec_Id.setText("");
            Credit.setText("");
            Course_content.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add course.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    } catch(Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e);
    }
        
    }//GEN-LAST:event_add_courseActionPerformed

    private void c_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_updateActionPerformed
    String c_id = Course_id_update.getText();
    String c_name = Course_name_update.getText();
    String lec_id = Lec_Id_update.getText();
    int credit = Integer.parseInt(Credit_update.getText());
    String c_type = Course_type_update.getSelectedItem().toString().toLowerCase();
    String c_content = Course_content_update.getText();
    
    if (c_id.isEmpty() || c_name.isEmpty() || lec_id.isEmpty() || c_content.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please fill  fields!");
    return; }

    String sql = "UPDATE course SET course_name = ?, lec_id = ?, credit = ?, course_type= ?, course_content = ? WHERE course_id =?";

    try (Connection conn = dbconnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        
        pst.setString(1, c_name);
        pst.setString(2, lec_id);
        pst.setInt(3, credit);
        pst.setString(4, c_type);
        pst.setString(5, c_content);
        pst.setString(6, c_id); 

        int rowsUpdated = pst.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog( this,"Course updated successfully!" );
            course_table();
            
            Course_id.setText("");
            Course_name.setText("");
            Lec_Id.setText("");
            Credit.setText("");
            Course_content.setText("");
        } else {
            JOptionPane.showMessageDialog(this,"No course found with ID: " + c_id
            );
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog( this, "Database Error: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
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
            Course_content_update.setText(rs.getString("course_content"));
        } else {
            JOptionPane.showMessageDialog(this, "Course not found!");
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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

            // Resize and preview
            //lblProfilePic.setIcon(resizeImage(imagePath, lblProfilePic));

            // Save image path to database
            try (Connection conn = dbconnection.getConnection()) {
                String sql = "UPDATE users SET user_pro_pic = ? WHERE username = ?";
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, imagePath);
                pst.setString(2, u_username);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Profile picture updated successfully!");
                loadProfilePic();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving image path!");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void u_name_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_name_newActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_name_newActionPerformed

    private void u_name_new_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_name_new_uActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_name_new_uActionPerformed
    
    

   /*public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Course_content;
    private javax.swing.JTextField Course_content_update;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JButton n_DELETE;
    private javax.swing.JTextArea n_content_adduser;
    private javax.swing.JTextArea n_content_update;
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
    private javax.swing.JPanel profile_pic;
    private javax.swing.JButton t_add;
    private javax.swing.JComboBox<String> t_day_add;
    private javax.swing.JComboBox<String> t_day_update;
    private javax.swing.JButton t_find;
    private javax.swing.JTextField t_id_update;
    private javax.swing.JComboBox<String> t_sess_add;
    private javax.swing.JComboBox<String> t_sess_update;
    private javax.swing.JTextField t_sub_add;
    private javax.swing.JTextField t_sub_update;
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
