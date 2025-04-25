package lecturer;

import com.mysql.jdbc.PreparedStatement;
import connection.dbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import rojeru_san.complementos.RSTableMetro;

public class AttendanceEligibility {
    private Connection getConnection() throws SQLException {
        Connection conn = dbConnection.connect();
        if (conn == null) {
            throw new SQLException("Failed to establish database connection");
        }
        return conn;
    }
    
    public void getStudentAttendance(RSTableMetro table, String searchValue,String lecId){
        String sql = "SELECT * FROM attendance_eligibility a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id=?" +
                    (searchValue.isEmpty() ? "" : " AND a.ug_id LIKE ? " ) + 
                    "ORDER BY ug_id ASC";
        
        try (Connection con = getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)){
            
            ps.setString(1, lecId);
            if(!searchValue.isEmpty()){
                ps.setString(2, "%" + searchValue + "%");
            }
            
            try(ResultSet result = ps.executeQuery()){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                
                model.setRowCount(0);
                
                while(result.next()){
                    model.addRow(new Object[]{
                        result.getString("ug_id"),
                        result.getString("course_id"),
                        result.getString("session_type"),
                        result.getString("80% Percentage"),
                        result.getString("Eligibility")
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceEligibility.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
