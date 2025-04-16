package lecturer;

import connection.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import rojeru_san.complementos.RSTableMetro;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Student_details {
    private Connection getConnection() throws SQLException {
        Connection conn = dbConnection.connect();
        if (conn == null) {
            throw new SQLException("Failed to establish database connection");
        }
        return conn;
    }
    
    public void getStudentDetails(RSTableMetro table , String searchValue){
        String sql = "SELECT * FROM user WHERE CONCAT(user_id,user_name,user_phone,user_email) LIKE ? AND user_role = 'undergraduate' ORDER BY user_id ASC";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, "%" + searchValue + "%");
            
            try(ResultSet result = ps.executeQuery()){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                
                model.setRowCount(0);
                
                while(result.next()){
                    model.addRow(new Object[]{
                        result.getString("user_id"),
                        result.getString("user_name"),
                        result.getString("user_phone"),
                        result.getString("user_email")
                    });
                }
            }
        } catch (SQLException ex) {
             Logger.getLogger(Course.class.getName()).log(Level.SEVERE,null,ex);

        }
    }
}
