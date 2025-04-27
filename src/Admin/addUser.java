package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author User
 */
public class addUser {

    public static boolean validation(String username,char [] password, String role , String name , String email , String phone){
        if(username.isEmpty() || password.length == 0 || role.isEmpty() || name.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
            return false;
        }
        if(email.isEmpty() && !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w+]{2,4}$")){
            JOptionPane.showMessageDialog(null, "Please enter a valid email address");
            return false;
        }
        if(phone.isEmpty() && !phone.matches("^(\\d{9}|\\d{10})$")){
            JOptionPane.showMessageDialog(null, "Please enter a valid phone number only 9 or 10 digits");
            return false;
        }
        if(password.length < 5 || !new String(password).matches("^(?=.*[A-Za-z])(?=.*\\d).+$")){
            JOptionPane.showMessageDialog(null, "Please enter a valid password 5 characters and numbers");
        }
        return true;
    }

    public static boolean usernameExists(String username)throws SQLException{
        String query = "SELECT user_name FROM user WHERE user_id = ?";
        try (Connection conn = dbconnection.getConnection();
            PreparedStatement check = conn.prepareStatement(query)){
            check.setString(1, username);
            ResultSet rs = check.executeQuery();
            return rs.next();
        }
    }

    public  static boolean addUser(String username, String name, char[] password , String role , String email , String phone)throws SQLException{
        String hashedPassword = Admin.encryption.hashpassword(new String(password));
        String sql = "Insert into user(user_password, user_id, user_email, user_phone, user_role, user_name) values(?,?,?,?,?,?)";
        try (Connection conn = dbconnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setString(1, hashedPassword);
            pst.setString(2, username);
            pst.setString(3, email);
            pst.setString(4, phone);
            pst.setString(5, role);
            pst.setString(6, name);

            return pst.executeUpdate() > 0;

        }

    }

}
