package DBControl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mcruz
 */
//Aqi se van a ingresar las funciones para poder ejecutar las funciones de SQL
public class SQL_fun {
    Conexion conex = new Conexion();
    
    public boolean ExecSQL(String sql) throws SQLException{
        boolean r; 
        Connection conn = conex.conn();
        PreparedStatement statement = (PreparedStatement)
        conn.prepareStatement(sql);
        int rows = statement.executeUpdate();
        if (rows > 1){
            r=true;
        }else{
            r=false;
        }
        return r;
    }
    
    public ResultSet select(String sql) throws SQLException{
        Connection conn = conex.conn();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        return result;
    }
}
