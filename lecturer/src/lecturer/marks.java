package lecturer;

import connection.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class marks {
    private Connection getConnection() throws SQLException {
        Connection conn = dbConnection.connect();
        if (conn == null) {
            throw new SQLException("Failed to establish database connection");
        }
        return conn;
    }
    
    public void insert(String mark_id,String lec_id,String ug_id,String course_id,float quiz_1,float quiz_2,float quiz_3,float quiz_4,float assesment,float mid_term, float final_theory, float final_practical){
        String sql = "INSERT INTO marks VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, mark_id);
            ps.setString(2, lec_id);
            ps.setString(3, ug_id);
            ps.setString(3, course_id);
            ps.setFloat(3, quiz_1);
            ps.setFloat(3, quiz_2);
            ps.setFloat(3, quiz_3);
            ps.setFloat(3, quiz_4);
            ps.setFloat(3, assesment);
            ps.setFloat(3, mid_term);
            ps.setFloat(3, final_theory);
            ps.setFloat(3, final_practical);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "New Marks added Successfully!!");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //get all data course table
    public void getCourseValues(JTable table,String searchValue){
        String sql = "SELECT * FROM marks WHERE CONCAT(mark_id,lec_id,ug_id,course_id,quiz_1,quiz_2,quiz_3,quiz_4,assesment,mid_term,final_theory,final_practical) LIKE ? ORDER BY course_id DESC";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, "%" + searchValue + "%");
            ResultSet result = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            
            while(result.next()){
                row = new Object[13];
                row[0] = result.getString(1);
                row[1] = result.getString(2);
                row[2] = result.getString(3);
                row[3] = result.getString(4);
                row[4] = result.getString(5);
                row[5] = result.getString(6);
                row[6] = result.getString(7);
                row[7] = result.getString(8);
                row[8] = result.getString(9);
                row[9] = result.getString(10);  
                row[10] = result.getString(11);
                row[11] = result.getString(12);
                row[12] = result.getString(13);
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
