package DBControl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mcruz
 */
//Aqi se van a ingresar las funciones para poder ejecutar las funciones de SQL
public class SQL_fun {
    Conexion conex = new Conexion();
    public boolean ExecSQL(String sql){
        
        try {
            com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) conex.conn();
            com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }
    
    public ResultSet select(String sql){
        ResultSet result=null;
        try {
            Connection conn = conex.conn();
            Statement statement = conn.createStatement();
            result = statement.executeQuery(sql);
            
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(SQL_fun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
