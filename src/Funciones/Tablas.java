/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Admin.Administracion;
import Admin.ProdSolicita;
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
    String sql="";
    ResultSet rs;
    
    public void TablaProductos() throws SQLException{
        DefaultTableModel model = (DefaultTableModel) Administracion.tablaProd.getModel(); //Obtiene el Modelo
        model.setRowCount(0); //Reinicia el Contador de Filas
        sql ="SELECT * FROM productos"; String query;
        
        String[] datos = new String[7];
        ResultSet rsMarca;

        rs = funcion.select(sql);
        if(!rs.isBeforeFirst()){
            JOptionPane.showMessageDialog(null, "La tabla no contiene ningun valor!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        while(rs.next()){
            datos[0] = rs.getString(1); //codigo
            datos[1] = rs.getString(2); //nombre
            datos[2] = "---";
            if(rs.getInt(11) > 0){
                query = "SELECT marca FROM marcas WHERE id="+rs.getInt(11);
                rsMarca = funcion.select(query);
                if(rsMarca.next()){
                    datos[2] = rsMarca.getString(1);
                }
            }
            
            datos[3] = "$"+rs.getString(4); //Precio Unitario
            
            if(rs.getInt(6) > 0){
                datos[4] = "$"+rs.getString(5) + " ("+rs.getString(6)+" U)"; //Precio por Paquete ( $Precio(nUnidades) )
            }else{
                datos[4] = "";
            }
            
            
            datos[5] = rs.getString(7); //nombre
            datos[6] = rs.getString(8); //nombre
            model.addRow(datos);
        }
        
    }
    
    
    public void tablaProdSolicita() throws SQLException{
        sql = "SELECT * FROM prod_solicita";
        DefaultTableModel model = (DefaultTableModel) ProdSolicita.tablaProdSolicita.getModel();
        model.setRowCount(0);
        rs=funcion.select(sql);
        String datos[] = new String[7];
        while(rs.next()){
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            datos[4] = rs.getString(5);
            datos[5] = rs.getString(6);
            datos[6] = rs.getString(7);
            model.addRow(datos);
        }
        ProdSolicita.tablaProdSolicita.setModel(model);
    }

}
