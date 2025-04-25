package lecturer;

import connection.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import rojeru_san.complementos.RSTableMetro;

public class grade_point {
    private Connection getConnection() throws SQLException {
        Connection conn = dbConnection.connect();
        if (conn == null) {
            throw new SQLException("Failed to establish database connection");
        }
        return conn;
    }
    
    public void getGradePoint(RSTableMetro table , String searchValue , String userId){
        String sql = "SELECT * FROM exam_grades_view e "
                   +"join course c on c.course_id = e.course_id "
                   +"WHERE c.lec_id = ? "
                   +(searchValue.isEmpty() ? "" : "AND e.ug_id LIKE ? " ) + "ORDER BY e.ug_id ASC " ;
                  
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, userId);
            
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
                        result.getString("final_mark"),
                        result.getString("grade")
                    });
                }
            }
        } catch (SQLException ex) {
             Logger.getLogger(grade_point.class.getName()).log(Level.SEVERE,null,ex);

        }
    }
}
