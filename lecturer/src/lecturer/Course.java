package lecturer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import connection.dbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojeru_san.complementos.RSTableMetro;



public class Course {
    Connection con = dbConnection.connect();
    PreparedStatement ps;
    
    public String getMax(){
        String id = "";
        Statement st;
        
        try{
           st = (Statement) con.createStatement();
           ResultSet result =  st.executeQuery("select max(userId) from User");
           while(result.next()){
               id = result.getString("userId");
           }             
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    //insert data into course table
    
    public void insert(String course_id,String course_name,String lec_id,int credit,String course_type){
        String sql = "insert into course values(?,?,?,?,?)";
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, course_id);
            ps.setString(2, course_name);
            ps.setString(3, lec_id);
            ps.setInt(4, credit);
            ps.setString(5, course_type);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New course Material added Successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isCourseCodeExist(String course_id){
        try{
            ps = (PreparedStatement) con.prepareStatement("select * from course where course_id = ?");
            ps.setString(1, course_id);
            ResultSet result = ps.executeQuery();
            if(result.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //get all data course table
    public void getCourseValue(RSTableMetro table,String searchValue){
        String sql = "select * from course where CONCAT(course_id,course_name,lec_id,credit,course_type) like ? order by course_id desc";
        
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,"%" + searchValue + "%" );
            ResultSet result = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while(result.next()){
                row = new Object[7];
                row[0] = result.getString(1);
                row[1] = result.getString(2);
                row[2] = result.getString(3);
                row[3] = result.getString(4);
                row[4] = result.getString(5);
                
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //update course table
    public void update(String course_id,String course_name,String lec_id,int credit,String course_type){
        String sql = "update course set course_name = ?, lec_id = ?, credit = ?, course_type = ? where course_id = ?";
        
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, course_name);
            ps.setString(2, lec_id);
            ps.setInt(3, credit);
            ps.setString(4, course_type);
            ps.setString(5, course_id);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Student data updated Successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
