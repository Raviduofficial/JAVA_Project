package lecturer;

import Database.dbconnection;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Login.Login;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Lecture_profile extends javax.swing.JFrame {

    private String userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userPass;
    private String userProPic;
    private Connection con;
    private PreparedStatement ps;
    private dbconnection mdc;
    private ResultSet rs;

    public Lecture_profile(String userId) {
        this.userId = userId;
        initComponents();
        setResizable(false);
        lecPass.setEditable(false);
        lecId.setEditable(false);
        getUserDetails(userId);
        loadUserDetails();
    }

    public Lecture_profile() {
        initComponents();
    }

    public void getUserDetails(String userId) {
        String sql = "select user_id, user_email, user_password, user_phone, user_pro_pic, user_name from user where user_id = ?";
        try ( Connection con = dbconnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.userName = rs.getString("user_name");
                this.userEmail = rs.getString("user_email");
                this.userPhone = rs.getString("user_phone");
                this.userPass = rs.getString("user_password");
                this.userProPic = rs.getString("user_pro_pic");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error getuserId");
        }
    }

    public void loadUserDetails() {
        lecId.setText(userId);
        //ProPicPath.setText(userProPic);
        lecEmail.setText(userEmail);
        lecPass.setText(userPass);
        lecPhone.setText(userPhone);
        lecName.setText(userName);
        if (userProPic != null && !userProPic.isEmpty()) {
            ImageIcon icon = new ImageIcon(userProPic);
            Image img = icon.getImage().getScaledInstance(lecPhoto.getWidth(), lecPhoto.getHeight(), Image.SCALE_SMOOTH);
            lecPhoto.setIcon(new ImageIcon(img));
        }

    }

    public void update(String name, String email, String phone, String userId) {
        String sql = "UPDATE user SET user_name=?, user_email=?, user_phone=?, WHERE user_id=?";

        try ( Connection con = dbconnection.getConnection();  
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(5, userId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No changes updated.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating profile: ");
        }
    }

    public void changeProfilePicture() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Profile Picture");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png"));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Destination folder and file name
            String destinationFolder = "src/SystemImages/";
            String newFileName = "profile_" + userId + "_" + selectedFile.getName(); // Unique filename
            File destinationFile = new File(destinationFolder + newFileName);

            try {
                // Create directories if not exist
                new File(destinationFolder).mkdirs();

                // Copy the file
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Save the relative path in database
                String newImagePath = destinationFolder + newFileName;
                updateProfilePicInDatabase(userId, newImagePath);

                // Update the displayed image
                ImageIcon icon = new ImageIcon(newImagePath);
                Image img = icon.getImage().getScaledInstance(lecPhoto.getWidth(), lecPhoto.getHeight(), Image.SCALE_SMOOTH);
                lecPhoto.setIcon(new ImageIcon(img));

                JOptionPane.showMessageDialog(this, "Profile picture updated successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to update profile picture.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void updateProfilePicInDatabase(String userId, String imagePath) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = dbconnection.getConnection(); // Use static method instead of uninitialized mdc
            String updateQuery = "UPDATE user SET user_pro_pic = ? WHERE user_id = ?";
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, imagePath);
            ps.setString(2, userId);
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                this.userProPic = imagePath; // Update the instance variable
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database update failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        jPanel3 = new javax.swing.JPanel();
        lecPhoto = new javax.swing.JLabel();
        lbl_name2 = new javax.swing.JLabel();
        lbl_name3 = new javax.swing.JLabel();
        lbl_name4 = new javax.swing.JLabel();
        lbl_name5 = new javax.swing.JLabel();
        btn_update = new rojeru_san.complementos.RSButtonHover();
        lecPass = new javax.swing.JPasswordField();
        lecId = new app.bolivia.swing.JCTextField();
        lecEmail = new app.bolivia.swing.JCTextField();
        lecPhone = new app.bolivia.swing.JCTextField();
        lbl_name6 = new javax.swing.JLabel();
        lecName = new app.bolivia.swing.JCTextField();
        editIcon = new javax.swing.JLabel();

        jButton8.setText("Grades & Final Marks");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 187, 187));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LECTURER  PROFILE");

        jLabel2.setBackground(new java.awt.Color(153, 187, 187));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/LOGO_OF_RUHUNA-Alt3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(153, 187, 187));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dashboard.setBackground(new java.awt.Color(0, 0, 0));
        lbl_dashboard.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lbl_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dashboard.setText("Profile");
        lbl_dashboard.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(255, 255, 255)));
        lbl_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_dashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashboardMouseClicked(evt);
            }
        });
        jPanel13.add(lbl_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 30));

        lbl_marks.setBackground(new java.awt.Color(0, 0, 0));
        lbl_marks.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
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
        jPanel13.add(lbl_marks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 200, 30));

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
        jPanel13.add(lbl_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 30));

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
        jPanel13.add(lbl_eligibility, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 30));

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
        jPanel13.add(lbl_gpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, 30));

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
        jPanel13.add(lbl_grades, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, 30));

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
        jPanel13.add(lbl_attendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 200, 30));

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
        jPanel13.add(lbl_medical, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 200, 30));

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
        jPanel13.add(lbl_notices, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 200, 30));

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
        jPanel13.add(lbl_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 200, 30));

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
        jPanel13.add(lbl_course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 30));

        jPanel3.setBackground(new java.awt.Color(140, 140, 140));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setFocusable(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lecPhoto.setBackground(new java.awt.Color(0, 0, 0));
        lecPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/user.png"))); // NOI18N
        lecPhoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(lecPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 150, 160));

        lbl_name2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name2.setFont(new java.awt.Font("Algerian", 2, 18)); // NOI18N
        lbl_name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name2.setText("Name");
        jPanel3.add(lbl_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 205, 34));

        lbl_name3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name3.setFont(new java.awt.Font("Algerian", 2, 18)); // NOI18N
        lbl_name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name3.setText("Password");
        jPanel3.add(lbl_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 205, 34));

        lbl_name4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name4.setFont(new java.awt.Font("Algerian", 2, 18)); // NOI18N
        lbl_name4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name4.setText("Phone Number");
        jPanel3.add(lbl_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 205, 34));

        lbl_name5.setBackground(new java.awt.Color(0, 0, 0));
        lbl_name5.setFont(new java.awt.Font("Algerian", 2, 18)); // NOI18N
        lbl_name5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name5.setText("Lecture ID");
        jPanel3.add(lbl_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 60, 205, 34));

        btn_update.setBorder(null);
        btn_update.setText("Update");
        btn_update.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_update.setName(""); // NOI18N
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel3.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, -1, -1));

        lecPass.setEditable(false);
        lecPass.setBackground(new java.awt.Color(140, 140, 140));
        lecPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lecPass.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel3.add(lecPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 300, 30));

        lecId.setBackground(new java.awt.Color(140, 140, 140));
        lecId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lecId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(lecId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 102, 300, 30));

        lecEmail.setBackground(new java.awt.Color(140, 140, 140));
        lecEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lecEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(lecEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 300, 30));

        lecPhone.setBackground(new java.awt.Color(140, 140, 140));
        lecPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lecPhone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(lecPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 300, 30));

        lbl_name6.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name6.setFont(new java.awt.Font("Algerian", 2, 18)); // NOI18N
        lbl_name6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name6.setText("Email");
        jPanel3.add(lbl_name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 205, 34));

        lecName.setBackground(new java.awt.Color(140, 140, 140));
        lecName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lecName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(lecName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 300, -1));

        editIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SystemImages/edit.png"))); // NOI18N
        editIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editIconMouseClicked(evt);
            }
        });
        jPanel3.add(editIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
        // TODO add your handling code here:
        Lecture_profile lectureDashboard = new Lecture_profile(this.userId);
        lectureDashboard.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lbl_marksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_marksMouseClicked
        // TODO add your handling code here:
        UploadMarksExams uploadMarksExams = new UploadMarksExams(this.userId);
        uploadMarksExams.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_marksMouseClicked

    private void lbl_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_studentMouseClicked
        // TODO add your handling code here:
        StudentDetails studentDetails = new StudentDetails(this.userId);
        studentDetails.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_studentMouseClicked

    private void lbl_eligibilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_eligibilityMouseClicked
        // TODO add your handling code here:
        CAEligibility cAEligibility = new CAEligibility(this.userId);
        cAEligibility.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_eligibilityMouseClicked

    private void lbl_gpaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gpaMouseClicked
        // TODO add your handling code here:
        GPAcalculation gPAcalculation = new GPAcalculation(this.userId);
        gPAcalculation.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_gpaMouseClicked

    private void lbl_gradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gradesMouseClicked
        // TODO add your handling code here:
        GradePoint gradePoint = new GradePoint(this.userId);
        gradePoint.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_gradesMouseClicked

    private void lbl_attendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_attendanceMouseClicked
        // TODO add your handling code here:
        Attendance attendance = new Attendance(this.userId);
        attendance.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_attendanceMouseClicked

    private void lbl_medicalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_medicalMouseClicked
        // TODO add your handling code here:
        MedicalLEC medicalLEC = new MedicalLEC(this.userId);
        medicalLEC.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_medicalMouseClicked

    private void lbl_noticesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_noticesMouseClicked
        Notice notice = new Notice(this.userId);
        notice.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_noticesMouseClicked

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        int a = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void lbl_course1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_course1MouseClicked
        AddCourseMaterials addCourseMaterials = new AddCourseMaterials(this.userId);
        addCourseMaterials.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_course1MouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        update(userName, userEmail, userPhone, userId);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void editIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editIconMouseClicked
        changeProfilePicture();
    }//GEN-LAST:event_editIconMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btn_update;
    private javax.swing.JLabel editIcon;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_attendance;
    private javax.swing.JLabel lbl_course1;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_eligibility;
    private javax.swing.JLabel lbl_gpa;
    private javax.swing.JLabel lbl_grades;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_marks;
    private javax.swing.JLabel lbl_medical;
    private javax.swing.JLabel lbl_name2;
    private javax.swing.JLabel lbl_name3;
    private javax.swing.JLabel lbl_name4;
    private javax.swing.JLabel lbl_name5;
    private javax.swing.JLabel lbl_name6;
    private javax.swing.JLabel lbl_notices;
    private javax.swing.JLabel lbl_student;
    private app.bolivia.swing.JCTextField lecEmail;
    private app.bolivia.swing.JCTextField lecId;
    private app.bolivia.swing.JCTextField lecName;
    private javax.swing.JPasswordField lecPass;
    private app.bolivia.swing.JCTextField lecPhone;
    private javax.swing.JLabel lecPhoto;
    // End of variables declaration//GEN-END:variables
}
