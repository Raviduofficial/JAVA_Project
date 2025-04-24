package lecturer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connection.dbConnection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UserId {
    
    Connection con = (Connection) dbConnection.connect();
    PreparedStatement ps;
    ResultSet result;
     String userName;
     String userEmail;
     String userPhone;
     String userPass;
     String userProPic;

    
    public String getUserId(String userId){
        String id  = "";
        String sql = "SELECT userId from user where userId=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, userId);
            result = ps.executeQuery();
            if(result.next()){
                id = result.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error getuserId");
        }
       return id;
    }
    
    
    public void getUserDetails(String userId){
        String sql = "select user_id, user_email, user_password, user_phone, user_pro_pic, user_name from user where user_id = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,userId);
            result = ps.executeQuery();
            
            while(result.next()){
                userName = result.getString(6);
                userEmail = result.getString(2);
                userPhone = result.getString(4);
                userPass = result.getString(3);
                userProPic = result.getString(5);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error getuserId");
        }
    }

}
