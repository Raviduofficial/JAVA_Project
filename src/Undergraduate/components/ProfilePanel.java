package Undergraduate.components;

import Database.dbconnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ProfilePanel extends JPanel {

    private String userId;
    private dbconnection mdc;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    private JLabel pNameLbl, pUserIdLbl, pPasswordLbl, pEmailLbl, pPhoneLbl, pRoleLbl;
    private JLabel pNameLbl2, pUserIdLbl2, pPasswordLbl2, pEmailLbl2;
    private JButton profileEditBtn, phoneEditBtn;
    private ImageIcon editIcon;
    private String name, password, email, phone, profilePicPath,role;

    public ProfilePanel(String userId) {
        this.userId = userId;
        setLayout(null);
        setBackground(Color.WHITE);

        getUserDetails();
        initUI();


    }
    private void initUI(){
        if (profilePicPath == null || profilePicPath.trim().isEmpty()) {
            profilePicPath = "src/Undergraduate/Profile_images/defaultUser.jpeg";
        }


        CircularImagePanel profilePic = new CircularImagePanel(profilePicPath, 150);
        profilePic.setBounds(450, 50, 150, 150);
        add(profilePic);

        editIcon = new ImageIcon("src/Undergraduate/icons/edit.png");

        profileEditBtn = new JButton(editIcon);
        profileEditBtn.setBounds(450, 180, 20, 20);
        profileEditBtn.setBackground(Color.WHITE);
        profileEditBtn.setFocusable(false);
        profileEditBtn.setBorderPainted(false);

        phoneEditBtn = new JButton(editIcon);
        phoneEditBtn.setBounds(600, 260, 15, 15);
        phoneEditBtn.setBackground(Color.WHITE);
        phoneEditBtn.setFocusable(false);
        phoneEditBtn.setBorderPainted(false);

        Font labelFont = new Font("MV Boli", Font.BOLD, 20);
        Font labelFont2 = new Font("MV Boli", Font.PLAIN, 15);

        pNameLbl = new JLabel("Name");
        pNameLbl.setFont(labelFont);
        pNameLbl.setBounds(50, 70, 100, 30);
        add(pNameLbl);

        pNameLbl2 = new JLabel(name);
        pNameLbl2.setFont(labelFont2);
        pNameLbl2.setBounds(100, 100, 200, 30);
        add(pNameLbl2);

        pUserIdLbl = new JLabel("User ID");
        pUserIdLbl.setFont(labelFont);
        pUserIdLbl.setBounds(50, 170, 100, 30);
        add(pUserIdLbl);

        pUserIdLbl2 = new JLabel(userId);
        pUserIdLbl2.setFont(labelFont2);
        pUserIdLbl2.setBounds(100, 200, 200, 30);
        add(pUserIdLbl2);

        pEmailLbl = new JLabel("Email");
        pEmailLbl.setFont(labelFont);
        pEmailLbl.setBounds(50, 270, 100, 30);
        add(pEmailLbl);

        pEmailLbl2 = new JLabel(email);
        pEmailLbl2.setFont(labelFont2);
        pEmailLbl2.setBounds(100, 300, 200, 30);
        add(pEmailLbl2);

        pPasswordLbl = new JLabel("Password");
        pPasswordLbl.setFont(labelFont);
        pPasswordLbl.setBounds(50, 370, 100, 30);
        add(pPasswordLbl);

        pPasswordLbl2 = new JLabel(password);
        pPasswordLbl2.setFont(labelFont2);
        pPasswordLbl2.setBounds(100, 400, 200, 30);
        add(pPasswordLbl2);

        pRoleLbl = new JLabel(role);
        pRoleLbl.setFont(labelFont);
        pRoleLbl.setBounds(450, 200, 200, 50);
        add(pRoleLbl);

        pPhoneLbl = new JLabel("0" + phone);
        pPhoneLbl.setFont(labelFont2);
        pPhoneLbl.setForeground(Color.GRAY);
        pPhoneLbl.setBounds(475, 250, 200, 50);
        add(pPhoneLbl);

        add(profileEditBtn);
        add(phoneEditBtn);


        profileEditBtn.addActionListener(e -> changeProfilePicture());
        phoneEditBtn.addActionListener(e -> updatePhoneDialog());
    }

    private void getUserDetails() {
        mdc = new dbconnection();
        con = dbconnection.getConnection();

        try {
            String myQuery = "SELECT * FROM user WHERE user_id = ?";
            ps = con.prepareStatement(myQuery);
            ps.setString(1, userId);
            rs = ps.executeQuery();

            if (rs.next()) {
                password = rs.getString("user_password");
                name = rs.getString("user_name");
                email = rs.getString("user_email");
                phone = rs.getString("user_phone");
                role = rs.getString("user_role");
                profilePicPath = rs.getString("user_pro_pic");
            }
        } catch (SQLException e) {
            System.out.println("Error loading user profile: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeProfilePicture() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Profile Picture");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String selectedImagePath = fileChooser.getSelectedFile().getAbsolutePath();
            updateProfilePicInDatabase(userId, selectedImagePath);
            JOptionPane.showMessageDialog(this, "Profile picture updated! Please reopen the app to see changes.");
        }
    }

    private void updateProfilePicInDatabase(String userId, String imagePath) {
        try {
            con = dbconnection.getConnection();
            String updateQuery = "UPDATE user SET user_pro_pic = ? WHERE user_id = ?";
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, imagePath);
            ps.setString(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void updatePhoneDialog() {
        String newPhone = JOptionPane.showInputDialog(this, "Enter new phone number:", phone);
        if (newPhone != null && newPhone.matches("\\d{10}")) {
            updatePhoneInDatabase(userId, newPhone);
            pPhoneLbl.setText("0" + newPhone);
            JOptionPane.showMessageDialog(this, "Phone number updated!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid phone number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatePhoneInDatabase(String userId, String newPhone) {
        try {
            con = dbconnection.getConnection();
            String query = "UPDATE user SET user_phone = ? WHERE user_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, newPhone);
            ps.setString(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
