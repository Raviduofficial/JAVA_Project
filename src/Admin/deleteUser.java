package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;
public class deleteUser {
    public static boolean validation(String username){
        if(username.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill the field");
            return false;
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

    public static boolean deleteUser(String username){
        String sql = "DELETE FROM user WHERE user_id = ?";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setString(1, username);
            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
