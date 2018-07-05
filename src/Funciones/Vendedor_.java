/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mauricio Cruz
 */
public class Vendedor_ {
    int id;
    String fecha, producto, lugar, sql;
    ResultSet rs;
    DBControl.SQL_fun SQL_fun = new DBControl.SQL_fun();

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    int cantidad;
    float total=0.00f;
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    //</editor-fold>
    
    
    public boolean procesarVenta() throws SQLException{
        int canActu=0;
        float totalActu= 0.00f;
        //determinar si este producto ya fue registrado en esta fecha
        sql="SELECT * FROM ventas WHERE producto='"+producto+"' AND fecha='"+fecha+"'";
        rs=SQL_fun.select(sql);
        if(rs.next()){
            //Si ya hay un registro para este fecha se procedera a actualizarse
            System.out.println("Si existe");
            
            canActu=rs.getInt("cantidad");
            totalActu=rs.getInt("total");
            canActu+=cantidad;
            totalActu+=total;
            sql="UPDATE ventas SET cantidad="+canActu+", total="+totalActu+" WHERE id="+rs.getInt("id");
            SQL_fun.ExecSQL(sql);
        } else{
            //si no hay un registro para este producto en esta fecha se procedera a insertarlo
            System.out.println("No existe");
            sql="INSERT ventas (fecha,producto,cantidad,total) VALUES('"+fecha+"','"+producto+"',"+cantidad+","+total+")";
            SQL_fun.ExecSQL(sql);
        }
        //Se procede ha hacer la debida actualizacion del inventario de productos;
        
        if(lugar.equalsIgnoreCase("Local")){
            lugar="local_cant";
        }else{
            lugar="bodega_cant";
        }
        
        sql="SELECT "+lugar+" from productos WHERE codigo="+id;
        rs=SQL_fun.select(sql);
        while(rs.next()){//iniciar el ResultSet
            canActu=rs.getInt(lugar);//obtener la cantidad actual
        }
        canActu-=cantidad;//hacer la deduccion del inventario
        sql="UPDATE productos SET "+lugar+"="+canActu+" WHERE codigo="+id;
        return SQL_fun.ExecSQL(sql);
    }
}
