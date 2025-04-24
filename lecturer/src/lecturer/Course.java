package lecturer;

import connection.dbConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojeru_san.complementos.RSTableMetro;

public class Course {
    
    private Connection getConnection() throws SQLException {
        Connection conn = dbConnection.connect();
        if (conn == null) {
            throw new SQLException("Failed to establish database connection");
        }
        return conn;
    }

    public boolean insert(String course_id, String course_name, String lec_id, int credit, String course_type, String course_content) {
        String sql = "INSERT INTO course VALUES(?,?,?,?,?,?)";
        boolean success = false;
        
        //try-with-resources feature - con and ps automatically closed after block ends
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, course_id);
            ps.setString(2, course_name);
            ps.setString(3, lec_id);
            ps.setInt(4, credit);
            ps.setString(5, course_type);
            ps.setString(6, course_content);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Course added successfully!");
                success = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, "Error inserting course", ex);
            JOptionPane.showMessageDialog(null, "Error adding course: " + ex.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public boolean isCourseCodeExist(String course_id) {
        String sql = "SELECT course_id FROM course WHERE course_id = ?";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, course_id);
            try (ResultSet result = ps.executeQuery()) {
                return result.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, "Error checking course existence", ex);
            JOptionPane.showMessageDialog(null, "Database error while checking course","Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    //get all data course table
    public void getCourseValue(RSTableMetro table, String lecId) {
        String sql = "SELECT * FROM course WHERE lec_id = ? ORDER BY course_id ASC";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, lecId);
            try (ResultSet result = ps.executeQuery()) {
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); 
                
                while (result.next()) {
                    model.addRow(new Object[]{
                        result.getString("course_id"),
                        result.getString("course_name"),
                        result.getString("lec_id"),
                        result.getInt("credit"),
                        result.getString("course_type"),
                        result.getString("course_content")
                    });
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error loading courses: " + ex.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean update(String course_id, String course_name, String lec_id, int credit, String course_type, String course_content) {
        String sql = "UPDATE course SET course_name=?, lec_id=?, credit=?, course_type=?, course_content=? WHERE course_id=?";
        boolean success = false;
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, course_name);
            ps.setString(2, lec_id);
            ps.setInt(3, credit);
            ps.setString(4, course_type);
            ps.setString(5, course_content);
            ps.setString(6, course_id);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Course updated successfully!");
                success = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating course: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public boolean delete(String course_id) {
        String sql = "DELETE FROM course WHERE course_id = ?";
        boolean success = false;
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, course_id);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Course deleted successfully!");
                success = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, "Error deleting course", ex);
            JOptionPane.showMessageDialog(null, "Error deleting course: " + ex.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }
}