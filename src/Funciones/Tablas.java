/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Admin.Administracion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio Cruz
 */

/*
*/
public class Tablas {
    DBControl.SQL_fun funcion = new DBControl.SQL_fun();
    
    
    public void TablaProductos() throws SQLException{
        DefaultTableModel model = (DefaultTableModel) Administracion.tablaProd.getModel(); //Obtiene el Modelo
        model.setRowCount(0); //Reinicia el Contador de Filas
        String sql ="SELECT * FROM productos";
        
        String[] datos = new String[6];

        ResultSet rs = funcion.select(sql);
        if(!rs.isBeforeFirst()){
            JOptionPane.showMessageDialog(null, "La tabla no contiene ningun valor!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        while(rs.next()){
            datos[0] = rs.getString(1); //codigo
            datos[1] = rs.getString(2); //nombre
            datos[2] = "$"+rs.getString(4); //Precio Unitario
            datos[3] = "$"+rs.getString(5) + " ("+rs.getString(6)+" U)"; //Precio por Paquete ( $Precio(nUnidades) )
            datos[4] = rs.getString(7); //nombre
            datos[5] = rs.getString(8); //nombre
            model.addRow(datos);
        }
        
    }
    
}
