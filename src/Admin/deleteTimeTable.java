package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;

public class deleteTimeTable {
    public static boolean validation(String timeId){
        if(timeId == null || timeId.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter a valid time ID.");
            return false;
        }
        return true;
    }

    public static boolean timeTableExists(String timeId){
        String sql = "select * from time_table where time_table_id= ?";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,timeId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "  "+e.getMessage());
        }
        return false;
    }

    public static boolean deleteTimetable(String timeId){
        String sql = "delete from time_table where time_table_id= ?";
        try(Connection conn = dbconnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1,timeId);
            return pst.executeUpdate()>0;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "  "+e.getMessage());
        }
        return false;
    }
}
