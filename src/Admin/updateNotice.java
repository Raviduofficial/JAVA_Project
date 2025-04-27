package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class updateNotice {
    public static boolean validation(String title, String content, String noticeIdtext) {
        if (title.isEmpty() || content.isEmpty() || noticeIdtext.isEmpty() || noticeIdtext.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter title and content");
            return false;
        }
        return true;
    }


        public static boolean updateNotice ( int id, String title, String content, Date date){
            String sql = "UPDATE notice SET notice_title = ?, notice_content = ?, notice_date = ? WHERE notice_id = ?";

            try (Connection conn = dbconnection.getConnection();
                 PreparedStatement pst = conn.prepareStatement(sql)) {

                pst.setString(1, title);
                pst.setString(2, content);
                pst.setDate(3, new java.sql.Date(date.getTime()));
                pst.setInt(4, id);

                return pst.executeUpdate() > 0;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, " "+e.getMessage());
            }
            return true;
        }
       
}    
    

