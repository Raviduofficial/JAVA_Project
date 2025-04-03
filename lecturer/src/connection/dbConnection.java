package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class dbConnection {
    public static com.mysql.jdbc.Connection connect(){
        com.mysql.jdbc.Connection conn = null;
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/jtechmis","root","");
            System.out.println(conn);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,""+ex,"",JOptionPane.WARNING_MESSAGE);
        }
        return conn;       
    }
}
