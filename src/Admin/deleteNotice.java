package Admin;
import Database.dbconnection;
import javax.swing.*;
import java.sql.*;
public class deleteNotice {
    public static boolean validation(String noticeIdtext) {
        if (noticeIdtext.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter notice id");
            return false;
        }
        return true;
    }

    public static boolean noticeExists(int noticeId)throws SQLException  {
        String sql = "select notice_id from notice WHERE notice_id = ?";
        try (Connection conn = dbconnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, noticeId);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        }
    }

    public static boolean deleteNotice(int noticeId) throws SQLException {
        String sql = "delete from notice where notice_id = ?";

        try (Connection conn = dbconnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, noticeId);
            return pst.executeUpdate() > 0;
        }
    }

}

