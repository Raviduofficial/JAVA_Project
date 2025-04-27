package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class addNotice {
    public static boolean validation(String title, String content) {
        if(title.isEmpty() || content.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter title and content");
            return false;
        }
        return true;
    }

    public static boolean addNotice(String title, String content , Date date) {
        String sql = "INSERT INTO notice (notice_title, notice_content,notice_date) VALUES (?, ?, ?)";

        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,title);
            pst.setString(2,content);
            pst.setDate(3,new java.sql.Date(date.getTime()));

            return pst.executeUpdate() > 0;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }

}

