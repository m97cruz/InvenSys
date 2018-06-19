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
    Funciones.Productos aProd = new Funciones.Productos();
    String sql="";
    ResultSet rs;
    //<editor-fold defaultstate="collapsed" desc="Tablas para Listar Productos">
    public void TablaProductos() throws SQLException{
        DefaultTableModel model = (DefaultTableModel) Administracion.tablaProd.getModel(); //Obtiene el Modelo
        model.setRowCount(0); //Reinicia el Contador de Filas
        sql ="SELECT * FROM productos"; 
        
        String[] datos = new String[9];

        rs = funcion.select(sql);
        if(!rs.isBeforeFirst()){
            JOptionPane.showMessageDialog(null, "La tabla no contiene ningun valor!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        while(rs.next()){
            datos[0] = rs.getString(1); //codigo
            datos[1] = rs.getString(2); //nombre
            datos[2] = "---";
            if(rs.getInt(11) > 0){
                aProd.setMarcaDB(rs.getInt(11));
                datos[2] = aProd.getMarcaNombre();
            }
            
            //------Setear la lista de Proveedores------//
            datos[3] = "";
            if(rs.getInt(12)>0){
                datos[3] += aProd.getProvNombre(rs.getInt(12));
            }
            if(rs.getInt(13)>0){
                datos[3] += aProd.getProvNombre(rs.getInt(13));
            }
            if(rs.getInt(14)>0){
                datos[3] += aProd.getProvNombre(rs.getInt(14));
            }
            if(rs.getInt(15)>0){
                datos[3] += aProd.getProvNombre(rs.getInt(15));
            }
            datos[4] = "$"+rs.getString(3);
            datos[5] = "$"+rs.getString(4); //Precio Unitario
            
            if(rs.getInt(6) > 0){
                datos[6] = "$"+rs.getString(5) + " ("+rs.getString(6)+" U)"; //Precio por Paquete ( $Precio(nUnidades) )
            }else{
                datos[6] = "";
            }
            
            
            datos[7] = rs.getString(7); //Stock de Local
            datos[8] = rs.getString(8); //Stock de Bodega
            model.addRow(datos);
        }
        
    }
    
    
    public DefaultTableModel tablaProdSolicita(DefaultTableModel model) throws SQLException{
        sql = "SELECT * FROM prod_solicita";
        model.setRowCount(0);
        rs=funcion.select(sql);
        String datos[] = new String[8];
        while(rs.next()){
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            datos[4] = rs.getString(5);
            datos[5] = rs.getString(6);
            datos[6] = rs.getString(7);
            datos[7] = rs.getString(8);
            model.addRow(datos);
        }
        return model;
    }
    
    

    public void tablaProdVendedor() throws  SQLException{
        DefaultTableModel model = (DefaultTableModel) Vendedor.Vendedor.tablaProds.getModel(); //Obtiene el Modelo
        model.setRowCount(0); //Reinicia el Contador de Filas
        sql ="SELECT * FROM productos"; String query;
        
        String[] datos = new String[7];
        ResultSet rsMarca;

        rs = funcion.select(sql);
        if(!rs.isBeforeFirst()){
            JOptionPane.showMessageDialog(null, "La tabla no contiene algun valor!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
            
            datos[3] = rs.getString(4); //Precio Unitario
            
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
    //</editor-fold>
    

    
    //<editor-fold defaultstate="collapsed" desc="Esta madre es para va vaina de proveedores">
    public DefaultTableModel tablaProveedor(DefaultTableModel model) throws SQLException{
        model.setRowCount(0);
        String datos[] = new String [6];
        sql ="SELECT * FROM proveedores";
        rs=funcion.select(sql);
        while(rs.next()){
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            datos[2] = rs.getString(3);
            datos[3] = rs.getString(4);
            datos[4] = rs.getString(5);
            model.addRow(datos);
        }
        return model;
    }
    
    public DefaultTableModel prodVinculados(DefaultTableModel model, int cod) throws SQLException{
        model.setRowCount(0); //Reinicia el Contador de Filas
        sql ="SELECT * FROM productos WHERE proveedor1="+cod+" OR proveedor2="+cod+" OR proveedor3="+cod+" OR proveedor4="+cod+";";
        rs = funcion.select(sql);
        String[] datos = new String[9];
        
        while(rs.next()){
            datos[0] = rs.getString(1); //codigo
            datos[1] = rs.getString(2); //nombre
            datos[2] = "---";
            if(rs.getInt(11) > 0){
                aProd.setMarcaDB(rs.getInt(11));
                datos[2] = aProd.getMarcaNombre();
            }
            
            //------Setear la lista de Proveedores------//
            datos[3] = "";
            if(rs.getInt(12)>0){
                datos[3] += aProd.getProvNombre(rs.getInt(12));
            }
            if(rs.getInt(13)>0){
                datos[3] += aProd.getProvNombre(rs.getInt(13));
            }
            if(rs.getInt(14)>0){
                datos[3] += aProd.getProvNombre(rs.getInt(14));
            }
            if(rs.getInt(15)>0){
                datos[3] += aProd.getProvNombre(rs.getInt(15));
            }
            datos[4] = "$"+rs.getString(3);//precio de COmpra
            datos[5] = "$"+rs.getString(4); //Precio Unitario
            
            if(rs.getInt(6) > 0){
                datos[6] = "$"+rs.getString(5) + " ("+rs.getString(6)+" U)"; //Precio por Paquete ( $Precio(nUnidades) )
            }else{
                datos[6] = "";
            }
            
            
            datos[7] = rs.getString(7); //Stock de Local
            datos[8] = rs.getString(8); //Stock de Bodega
            model.addRow(datos);
        }
        return model;
        
    }
    //</editor-fold>
    
    
    public float getTotal(String codigo,int cantidad,boolean check) throws SQLException{
        float total=0.0f;//total a pagar por este producto
        int cantPack=0;//cantidad considerada como paquete
        float precioPack=0.00f;//precio por paquete
        float precioUni=0.00f;//precio unitario
        //Obtener la cantidad considerada como paquete para este producto
        sql="SELECT cant_pack from productos WHERE codigo='"+codigo+"'";
        rs=funcion.select(sql);
        if(rs!=null){
            while(rs.next()){
                cantPack=rs.getInt(1);
            }
        }
        //obtener el precio de venta unitario para este producto
        sql="SELECT pre_venta from productos WHERE codigo='"+codigo+"'";
        rs=funcion.select(sql);
        if(rs!=null){
            while(rs.next()){
                precioUni=rs.getFloat(1);
            }
        }
       //Si cantidad considerada como paquete es igual a cero se aplicara precio unitario
       if(cantPack==0){
            total=cantidad*precioUni;
       } else{
            //Se verifica la si la cantidad solicitada es igual
            //O mayor a la cantidad por paquetes
            if(cantidad>=cantPack){
                //Se aplican operaciones con precio por paquete
                //Obtener el precio por paquete
                System.out.println("Operaciones por paquete");
                sql="SELECT pre_pack from productos WHERE codigo='"+codigo+"'";
                rs=funcion.select(sql);
                if(rs!=null){
                    while(rs.next()){
                        precioPack=rs.getFloat(1);
                    }
                }
                //variable check indica si se aplicara precio por paquete todos los productos
                //verificar si esta activado
                if(check==true){
                //aplicar precio por paquete a todos los productos
                    total=cantidad*precioPack;
                } else{
                    //aplicar precio por paquete unicamente a los paquetes formados
                    int sobrante = cantidad % cantPack;
                    if(sobrante==0){
                        total=cantidad*precioPack;
                    } else{
                        total+=(cantidad-sobrante)*precioPack;
                        total+=sobrante*precioUni;
                    }
                }
            } else{
                //Se aplican operaciones con precio normal de venta
                total=cantidad*precioUni;
            }
       }
       return total;
    }
    
    public DefaultTableModel Marcas(DefaultTableModel model) throws SQLException{
        model.setRowCount(0);
        sql = "SELECT * FROM marcas";
        rs = funcion.select(sql);
        String datos[] = new String[2];
        while(rs.next()){
            datos[0]= rs.getString(1);
            datos[1] = rs.getString(2);
            model.addRow(datos);
        }
        
        return model;
    }
    
    public void tablaProdVend(DefaultTableModel model) throws  SQLException{
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
            
            datos[3] = rs.getString(4); //Precio Unitario
            
            if(rs.getInt(6) > 0){
                datos[4] = "$"+rs.getString(5) + " ("+rs.getString(6)+" U)"; //Precio por Paquete ( $Precio(nUnidades) )
            }else{
                datos[4] = "";
            }
            
            
            datos[5] = rs.getString(7); //nombre
            datos[6] = rs.getString(8); //nombre
            model.addRow(datos);
        }
        //return model;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Esto es para el Control de Ventas y Compras de Productos">
     public DefaultTableModel EstadVentas(DefaultTableModel model,String fecha1,String fecha2) throws SQLException{
        model.setRowCount(0);
        if(fecha1.equals("") && fecha2.equals("")){
            sql="SELECT * FROM ventas";
        } else{
            sql="SELECT * FROM ventas WHERE fecha BETWEEN '"+fecha1+"' and '"+fecha2+"'";
        }
        rs=funcion.select(sql);
        String datos[]= new String[4];
        while(rs.next()){
            datos[0]=rs.getString("producto");
            datos[1]=rs.getString("cantidad");
            datos[2]=rs.getString("total");
            datos[3]=rs.getString("fecha");
            model.addRow(datos);
        }
        return model;
    }
     
     public DefaultTableModel EstadCompras(DefaultTableModel model,String fecha1,String fecha2) throws SQLException{
        model.setRowCount(0);
        if(fecha1.equals("") && fecha2.equals("")){
            sql="SELECT * FROM compras";
        } else{
            sql="SELECT * FROM compras WHERE fecha BETWEEN '"+fecha1+"' and '"+fecha2+"'";
        }
        rs=funcion.select(sql);
        String datos[]= new String[6];
        while(rs.next()){
            datos[0]=rs.getString("producto");
            datos[1]=rs.getString("proveedor");
            datos[2]=rs.getString("pre_compra");
            datos[3]=rs.getString("cantidad");
            datos[4]=rs.getString("precio");
            datos[5]=rs.getString("fecha");
            model.addRow(datos);
        }
        return model;
    }
   
}
