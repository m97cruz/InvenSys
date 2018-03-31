
package DBControl;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mcruz
 */
public class Conexion {
    public Connection conn(){
        String dbURL = "jdbc:mysql://localhost:3306/ferre_torres";
        String usr = "root";
        String pass= "";
        Connection conn = null;
        
        try{
            conn = (Connection) DriverManager.getConnection(dbURL, usr, pass);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return conn;
    }
    
}
