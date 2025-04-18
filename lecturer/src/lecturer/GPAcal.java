package lecturer;

import com.mysql.jdbc.PreparedStatement;
import connection.dbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import rojeru_san.complementos.RSTableMetro;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GPAcal {
    private Connection getConnection() throws SQLException {
        Connection conn = dbConnection.connect();
        if (conn == null) {
            throw new SQLException("Failed to establish database connection");
        }
        return conn;
    }
        
    public void getGPA(RSTableMetro table, String searchValue) {
    
        String sql = "SELECT s.ug_id, s.SGPA, c.CGPA " +
                     "FROM SGPA_view s " +
                     "JOIN CGPA_view c ON s.ug_id = c.ug_id " +
                     "WHERE CONCAT(s.ug_id, s.SGPA, c.CGPA) LIKE ? " +
                     "ORDER BY s.ug_id";

        try (Connection con = getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {

            ps.setString(1, "%" + searchValue + "%");

            try(ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while(result.next()) {
                    model.addRow(new Object[]{
                        result.getString("ug_id"),
                        result.getDouble("SGPA"), 
                        result.getDouble("CGPA")  
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GPAcal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error loading GPA data: " + ex.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
