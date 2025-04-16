package lecturer;

import com.mysql.jdbc.PreparedStatement;
import connection.dbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import rojeru_san.complementos.RSTableMetro;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class GPAcal {
    private Connection getConnection() throws SQLException {
        Connection conn = dbConnection.connect();
        if (conn == null) {
            throw new SQLException("Failed to establish database connection");
        }
        return conn;
    }
    
    public void getGPA(RSTableMetro table, String searchValue){
        String sql = "SELECT * FROM studentsgpa where concat(ug_id , SGPA) like ? order by ug_id";
        
        try (Connection con = getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)){
            ps.setString(1, "%" + searchValue + "%");
            
            
            
            try(ResultSet result = ps.executeQuery()){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                
                model.setRowCount(0);
                
                while(result.next()){
                    model.addRow(new Object[]{
                        result.getString("ug_id"),
                        result.getString("SGPA")
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
