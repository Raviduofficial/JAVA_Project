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
    
    //insert data
    public void insert(String mark_id,String lec_id,String ug_id,String course_id,float quiz_1,float quiz_2,float quiz_3,float quiz_4,float assesment,float mid_term, float final_theory, float final_practical){
        String sql = "INSERT INTO marks VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, mark_id);
            ps.setString(2, lec_id);
            ps.setString(3, ug_id);
            ps.setString(4, course_id);
            ps.setFloat(5, quiz_1);
            ps.setFloat(6, quiz_2);
            ps.setFloat(7, quiz_3);
            ps.setFloat(8, quiz_4);
            ps.setFloat(9, assesment);
            ps.setFloat(10, mid_term);
            ps.setFloat(11, final_theory);
            ps.setFloat(12, final_practical);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "New Marks added Successfully!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, "Error inserting course", ex);
            JOptionPane.showMessageDialog(null, "Error adding course: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //update marks
    public boolean update(String mark_id,String lec_id,String ug_id,String course_id,float quiz_1,float quiz_2,float quiz_3,float quiz_4,float assesment,float mid_term, float final_theory, float final_practical){
        String sql = "UPDATE marks SET lec_id=? ,ug_id=?, course_id=?, quiz_1=?, quiz_2=?, quiz_3=?, quiz_4=?, assesment=?, mid_term=?, final_theory=?, final_practical=? WHERE mark_id=?";
        boolean isUpdate = false;
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, lec_id);
            ps.setString(1, ug_id);
            ps.setString(1, course_id);
            ps.setFloat(1, quiz_1);
            ps.setFloat(1, quiz_2);
            ps.setFloat(1, quiz_3);
            ps.setFloat(1, quiz_4);
            ps.setFloat(1, assesment);
            ps.setFloat(1, mid_term);
            ps.setFloat(1, final_theory);
            ps.setFloat(1, final_practical);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Marks Updates Successfully!!");
                isUpdate = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error updating marks!" + ex.getMessage());
        }
        return isUpdate;
    }
    
    //delete marks
    
    public boolean delete(String mark_id){
        String sql = "DELETE FROM marks WHERE mark_id = ?";
        boolean isDelete = false;
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, mark_id);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Marks deleted successfully!");
                isDelete = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, "Error deleting course", ex);
            JOptionPane.showMessageDialog(null, "Error deleting course: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return isDelete;
    }
    
    //get all data course table
    public void getMarksValues(JTable table,String searchValue){
        String sql = "SELECT * FROM marks WHERE CONCAT(mark_id,lec_id,ug_id,course_id,quiz_1,quiz_2,quiz_3,quiz_4,assesment,mid_term,final_theory,final_practical) LIKE ? ";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, "%" + searchValue + "%");
            
            try(ResultSet result = ps.executeQuery()){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while(result.next()){
                    model.addRow(new Object[]{
                        result.getString("mark_id"),
                        result.getString("lec_id"),
                        result.getString("ug_id"),
                        result.getString("course_id"),
                        result.getString("quiz_1"),
                        result.getString("quiz_2"),
                        result.getString("quiz_3"),
                        result.getString("quiz_4"),
                        result.getString("assesment"),
                        result.getString("mid_term"),
                        result.getString("final_theory"),
                        result.getString("final_practical")
                    });
                    
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
