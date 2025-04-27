package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;
public class updateTimetable {
    public static boolean validation(String day, String TimeId, String dept,String lecID,String courseId,String stratTime, String endTime , String sessType){
        if (day.isEmpty() ||TimeId.isEmpty() ||dept.isEmpty() ||lecID.isEmpty() || courseId.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please fill all the feld.");
            return false;
        }
        if (stratTime.isEmpty() || !stratTime.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d$")) {
            JOptionPane.showMessageDialog(null, "Start Time must be in HH:mm format (09:30).");
            return false;
        }
        if (endTime.isEmpty() || !endTime.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d$")) {
            JOptionPane.showMessageDialog(null, "Start Time must be in HH:mm format (09:30).");
            return false;
        }
        if (sessType.equals("Select Session") || sessType.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a valid session type.");
            return false;
        }
        return true;
    }

    public static boolean updateTimeTable(String day,String courseId,String stratTime,String endTime,String sessType,String lecId,String timeId,String dept ,String adminId){
        String sql = "Update time_table set day = ?, course_id = ?,start_time = ?,end_time = ?,Session_type = ?,lec_id = ? ,admin_id = ? ,department= ? where time_table_id = ?";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, day);
            stmt.setString(2, courseId);
            stmt.setString(3, stratTime);
            stmt.setString(4, endTime);
            stmt.setString(5, sessType);
            stmt.setString(6, lecId);
            stmt.setString(7, adminId);
            stmt.setString(8, dept);
            stmt.setString(9, timeId);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
