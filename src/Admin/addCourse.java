
package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;


public class addCourse {
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
    public static boolean addCourses (String courseid,String courseName,String lecId,int credit,String courseType) {
        String sql = "Insert into course (course_id,course_name,lec_id,credit,course_type)   values (?,?,?,?,?)";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, courseid);
            pst.setString(2, courseName);
            pst.setString(3, lecId);
            pst.setInt(4, credit);
            pst.setString(5, courseType);
            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}