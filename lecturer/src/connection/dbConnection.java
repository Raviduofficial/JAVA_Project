package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;


public class dbConnection {
    public static Connection connect(){
        Connection conn = null;
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/projectTest","root","");
            System.out.println(conn);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,""+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return conn;       
    }
}
