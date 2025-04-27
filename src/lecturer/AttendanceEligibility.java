package lecturer;

import java.sql.PreparedStatement;
import Database.dbconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojeru_san.complementos.RSTableMetro;

public class AttendanceEligibility {
    
    public void All_attendance(RSTableMetro table,String lecId) {
        String sql = "SELECT * FROM attendance a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id = ? " +
                    "ORDER BY ug_id ASC";
        
        try (Connection con = dbconnection.getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {
            
            ps.setString(1, lecId);
            
            try(ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                
                while(result.next()) {
                    model.addRow(new Object[]{
                        result.getString("ug_id"),
                        result.getString("course_id"),
                        result.getString("atten_date"),
                        result.getString("session_type"),
                        result.getString("atten_status")
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceEligibility.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error loading attendance data: " + ex.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void witoutMedical_attendance(RSTableMetro table,String lecId) {
        String sql = "SELECT * FROM attendance a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id = ? AND a.atten_status!='medical'" +
                    "ORDER BY ug_id ASC";
        
        try (Connection con = dbconnection.getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {
            
            ps.setString(1, lecId);
            
            try(ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                
                while(result.next()) {
                    model.addRow(new Object[]{
                        result.getString("ug_id"),
                        result.getString("course_id"),
                        result.getString("atten_date"),
                        result.getString("session_type"),
                        result.getString("atten_status")
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceEligibility.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error loading attendance data: " + ex.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void getStudentAttendanceEligibility(RSTableMetro table, String ugid, String course_code, String lecId) {
        String sql = "SELECT * FROM attendance_eligibility a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id = ? " +
                    (ugid.isEmpty() ? "" : " AND a.ug_id LIKE ? ") +
                    (course_code.isEmpty() ? "" : " AND a.course_id LIKE ? ") +
                    "ORDER BY ug_id ASC";
        
        try (Connection con = dbconnection.getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {
            
            ps.setString(1, lecId);
            
            if(!ugid.isEmpty()) {
                ps.setString(2, "%" + ugid + "%");
            }
            if(!course_code.isEmpty()) {
                ps.setString(3, "%" + course_code + "%");
            }
            
            try(ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                
                while(result.next()) {
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
            Logger.getLogger(AttendanceEligibility.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error loading attendance data: " + ex.getMessage(),
                                        "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void getMedicalStudentsEligibility(RSTableMetro table, String searchValue, String course_code, String lecId) {
        String sql = "SELECT ae.* FROM attendance_eligibility ae " +
                    "JOIN course c ON c.course_id = ae.course_id " +
                    "WHERE c.lec_id = ? " +
                    (searchValue.isEmpty() ? "" : " AND ae.ug_id LIKE ? ") +
                    (course_code.isEmpty() ? "" : " AND ae.course_id LIKE ? ") +
                    "AND EXISTS (SELECT 1 FROM attendance a " +
                    "            WHERE a.ug_id = ae.ug_id " +
                    "            AND a.course_id = ae.course_id " +
                    "            AND a.atten_status = 'medical') " +
                    "ORDER BY ae.ug_id ASC";

        try (Connection con = dbconnection.getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {

            ps.setString(1, lecId);
            
            if (!searchValue.isEmpty()) {
                ps.setString(2, "%" + searchValue + "%");
            }
            if (!course_code.isEmpty()) {
                ps.setString(3, "%" + course_code + "%");
            }

            try (ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while (result.next()) {
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
            Logger.getLogger(AttendanceEligibility.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error loading medical eligibility: " + ex.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //------------------
    public void WithUgId_WithMedical(RSTableMetro table, String ugId) {
        String sql = "SELECT " +
                     "course_id, " +
                     "session_type, " +
                     "COUNT(*) AS total_classes, " +
                     "SUM(CASE WHEN atten_status IN ('present', 'medical') THEN 1 ELSE 0 END) AS attended, " +
                     "ROUND(100.0 * SUM(CASE WHEN atten_status IN ('present', 'medical') THEN 1 ELSE 0 END) / COUNT(*), 2) AS attendance_percentage " +
                     "FROM attendance " +
                     "WHERE ug_id = ? " +
                     "GROUP BY course_id, session_type";

        try (Connection con = dbconnection.getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {

            ps.setString(1, ugId);

            try (ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while (result.next()) {
                    model.addRow(new Object[]{
                        result.getString("course_id"),
                        result.getString("session_type"),
                        result.getInt("total_classes"),
                        result.getInt("attended"),
                        result.getDouble("attendance_percentage") + "%"
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceEligibility.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error loading attendance with medical data: " + ex.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void filterAttendanceWithMedical(RSTableMetro table, String ugId, String courseCode, String lecId) {
        String sql = "SELECT * FROM attendance a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id = ? " +
                    (ugId.isEmpty() ? "" : " AND a.ug_id LIKE ? ") +
                    (courseCode.isEmpty() ? "" : " AND a.course_id LIKE ? ") +
                    "ORDER BY ug_id ASC";

        try (Connection con = dbconnection.getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {

            int paramIndex = 1;
            ps.setString(paramIndex++, lecId);

            if(!ugId.isEmpty()) {
                ps.setString(paramIndex++, "%" + ugId + "%");
            }
            if(!courseCode.isEmpty()) {
                ps.setString(paramIndex++, "%" + courseCode + "%");
            }

            try(ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while(result.next()) {
                    model.addRow(new Object[]{
                        result.getString("ug_id"),
                        result.getString("course_id"),
                        result.getString("atten_date"),
                        result.getString("session_type"),
                        result.getString("atten_status")
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceEligibility.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error filtering attendance data: " + ex.getMessage(),
                                        "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filterAttendanceWithoutMedical(RSTableMetro table, String ugId, String courseCode, String lecId) {
        String sql = "SELECT * FROM attendance a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id = ? AND a.atten_status!='medical'" +
                    (ugId.isEmpty() ? "" : " AND a.ug_id LIKE ? ") +
                    (courseCode.isEmpty() ? "" : " AND a.course_id LIKE ? ") +
                    "ORDER BY ug_id ASC";

        try (Connection con = dbconnection.getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {

            int paramIndex = 1;
            ps.setString(paramIndex++, lecId);

            if(!ugId.isEmpty()) {
                ps.setString(paramIndex++, "%" + ugId + "%");
            }
            if(!courseCode.isEmpty()) {
                ps.setString(paramIndex++, "%" + courseCode + "%");
            }

            try(ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while(result.next()) {
                    model.addRow(new Object[]{
                        result.getString("ug_id"),
                        result.getString("course_id"),
                        result.getString("atten_date"),
                        result.getString("session_type"),
                        result.getString("atten_status")
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceEligibility.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error filtering attendance data: " + ex.getMessage(),
                                        "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public void filterTheoryWithMedical(RSTableMetro table, String ugId, String courseCode, String lecId) {
        String sql = "SELECT * FROM attendance a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id = ? AND a.session_type = 'theory' " +
                    (ugId.isEmpty() ? "" : " AND a.ug_id LIKE ? ") +
                    (courseCode.isEmpty() ? "" : " AND a.course_id LIKE ? ") +
                    "ORDER BY ug_id ASC";

        executeAttendanceFilterQuery(table, sql, lecId, ugId, courseCode);
    }

    public void filterPracticalWithMedical(RSTableMetro table, String ugId, String courseCode, String lecId) {
        String sql = "SELECT * FROM attendance a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id = ? AND a.session_type = 'practical' " +
                    (ugId.isEmpty() ? "" : " AND a.ug_id LIKE ? ") +
                    (courseCode.isEmpty() ? "" : " AND a.course_id LIKE ? ") +
                    "ORDER BY ug_id ASC";

        executeAttendanceFilterQuery(table, sql, lecId, ugId, courseCode);
    }

    public void filterTheoryWithoutMedical(RSTableMetro table, String ugId, String courseCode, String lecId) {
        String sql = "SELECT * FROM attendance a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id = ? AND a.session_type = 'theory' AND a.atten_status!='medical' " +
                    (ugId.isEmpty() ? "" : " AND a.ug_id LIKE ? ") +
                    (courseCode.isEmpty() ? "" : " AND a.course_id LIKE ? ") +
                    "ORDER BY ug_id ASC";

        executeAttendanceFilterQuery(table, sql, lecId, ugId, courseCode);
    }

    public void filterPracticalWithoutMedical(RSTableMetro table, String ugId, String courseCode, String lecId) {
        String sql = "SELECT * FROM attendance a " +
                    "JOIN course c on c.course_id = a.course_id " +
                    "WHERE c.lec_id = ? AND a.session_type = 'practical' AND a.atten_status!='medical' " +
                    (ugId.isEmpty() ? "" : " AND a.ug_id LIKE ? ") +
                    (courseCode.isEmpty() ? "" : " AND a.course_id LIKE ? ") +
                    "ORDER BY ug_id ASC";

        executeAttendanceFilterQuery(table, sql, lecId, ugId, courseCode);
    }

    private void executeAttendanceFilterQuery(RSTableMetro table, String sql, String lecId, String ugId, String courseCode) {
        try (Connection con = dbconnection.getConnection();
             PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql)) {

            int paramIndex = 1;
            ps.setString(paramIndex++, lecId);

            if(!ugId.isEmpty()) {
                ps.setString(paramIndex++, "%" + ugId + "%");
            }
            if(!courseCode.isEmpty()) {
                ps.setString(paramIndex++, "%" + courseCode + "%");
            }

            try(ResultSet result = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while(result.next()) {
                    model.addRow(new Object[]{
                        result.getString("ug_id"),
                        result.getString("course_id"),
                        result.getString("atten_date"),
                        result.getString("session_type"),
                        result.getString("atten_status")
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceEligibility.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error filtering attendance data: " + ex.getMessage(),
                                        "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}