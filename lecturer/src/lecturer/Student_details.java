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
    
    
    public void getStudentDetails(RSTableMetro table, String searchValue) {
        String sql = "SELECT u.user_id, u.user_name, u.user_phone, u.user_email " 
                + "FROM user u "
                + "JOIN undergraduate ug ON u.user_id = ug.ug_id "
                + "WHERE u.user_role = 'undergraduate' "
                + "AND (u.user_id LIKE ? OR u.user_name LIKE ? OR u.user_email LIKE ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String searchPattern = "%" + searchValue + "%";
            ps.setString(1, searchPattern);  // user_id
            ps.setString(2, searchPattern);  // user_name
            ps.setString(3, searchPattern);  // user_email

            try(ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while(result.next()) {
                    model.addRow(new Object[]{
                        result.getString("user_id"),
                        result.getString("user_name"),
                        result.getString("user_phone"), 
                        result.getString("user_email")
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
