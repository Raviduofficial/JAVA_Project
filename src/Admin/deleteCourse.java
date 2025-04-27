package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;
public class deleteCourse {
    public static boolean validation(String courseId){
        if(courseId.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill the field");
            return false;
        }
        return true;
    }

    public static boolean courseExists(String courseId)throws SQLException{
        String query = "SELECT course_id FROM course WHERE course_id = ?";
        try (Connection conn = dbconnection.getConnection();
             PreparedStatement check = conn.prepareStatement(query)){
            check.setString(1, courseId);
            ResultSet rs = check.executeQuery();
            return rs.next();
        }
    }

    public static boolean deleteUser(String courseId){
        String sql = "DELETE FROM course WHERE course_id = ?";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setString(1, courseId);
            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}