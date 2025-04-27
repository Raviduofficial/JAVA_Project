package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;
public class updateUser {

    public static boolean validation(String username, String role , String name , String email , String phone){

        if(username.isEmpty() ||  role.isEmpty() || name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
            return false;
        }
        if(!email.isEmpty() && !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w+]{2,4}$")){
            JOptionPane.showMessageDialog(null, "Please enter a valid email address");
            return false;
        }
        if(!phone.isEmpty() && !phone.matches("^(\\d{9}|\\d{10})$")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid phone number only 9 or 10 digits");
            return false;
        }
        return true;
    }
    public static boolean updateUserWithPassword(String username,char [] password, String role , String name , String email , String phone)throws SQLException{
        String hashedPassword = Admin.encryption.hashpassword(new String(password));
        String sql = "Update user set user_name=?,user_password=?,user_role = ?, user_email = ?, user_phone = ? WHERE user_id = ?";
        try(Connection conn = dbconnection.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setString(2, hashedPassword);
            pst.setString(3, role);
            pst.setString(4, email);
            pst.setString(5, phone);
            pst.setString(6, username);
            return pst.executeUpdate() > 0;
        }

    }

    public static boolean updateUserWithoutPassword(String username, String role , String name , String email , String phone)throws SQLException{
        
        String sql = "Update user set user_name=?,user_role = ?, user_email = ?, user_phone = ? WHERE user_id = ?";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setString(2, role);
            pst.setString(3, email);
            pst.setString(4, phone);
            pst.setString(5, username);
            return pst.executeUpdate() > 0;
        }

    }
}
