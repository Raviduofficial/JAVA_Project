
package Admin;
import Admin.admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;
public class updateCourse {
    public static boolean validation(String courseId, String courseName, String lecId, String creditText, String couse_type) {
        if (courseId.isEmpty() || courseName.isEmpty() || lecId.isEmpty() || creditText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all required fields!");
            return false;
        }
        try {
            int creditInt = Integer.parseInt(creditText);
            if (creditInt < 1 || creditInt > 4) {
                JOptionPane.showMessageDialog(null, "credit must be between 1 and 4 invalid input");
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "credit must be between 1 and 4 invalid input");
        }
        return true;
    }
    public static boolean updateCourses (String courseid,String courseName,String lecId,int credit,String courseType) {
        String sql = "Update course set course_name =?,lec_id = ?,credit = ?,course_type =? where course_id = ?";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, courseName);
            pst.setString(2, lecId);
            pst.setInt(3, credit);
            pst.setString(4, courseType);
            pst.setString(5, courseid);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
