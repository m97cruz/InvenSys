/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio Cruz
 */
public class Proveedores {
    DBControl.SQL_fun funcion = new DBControl.SQL_fun();
    String correo, nombre, encargado, tel, direc, sql;
    ResultSet rs;
    int id;
    
    //<editor-fold defaultstate="callapsed" desc="Getter y Setters">
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
    
    //</editor-fold>
    
    //////////-----------------------------------------------------------------------------------------////////////
    //<editor-fold defaultstate="collapsed" desc="CRUD para los Proveedores">
    public boolean addProv(){
        sql ="INSERT INTO proveedores VALUES(null, '"+nombre+"', '"+encargado+"', '"+tel+"', '"+direc+"', '"+correo+"')";
        return funcion.ExecSQL(sql);
    }
    
    public boolean modProv(){
        sql="UPDATE proveedores SET prov_nombre='"+nombre+"', encargado='"+encargado+"', telefono='"+tel+"', direccion='"+direc+"', correo='"+correo+"' WHERE id="+id+";";
        return funcion.ExecSQL(sql);
    }
    
    public boolean rmProv(){
        boolean ok; // OK para proceder a eliminar
        
        sql = "SELECT codigo FROM productos WHERE proveedor1="+id+" OR proveedor2="+id+" OR proveedor3="+id+" OR proveedor4="+id+";";
        if (funcion.select(sql) != null){
            ok = false;
        }else{
            ok = true;
        }
        
        if(ok){
            sql ="DELETE FROM proveedores WHERE id="+id;
            ok= funcion.ExecSQL(sql);
        }
        
        return ok;
    }
    
    public void selectProv(){
        sql="SELECT * FROM proveedores WHERE id="+id;
        rs = funcion.select(sql);
        if(rs != null){
            try {
                while(rs.next()){
                    nombre = rs.getString(2);
                    encargado = rs.getString(3);
                    tel = rs.getString(4);
                    direc = rs.getString(5);
                    correo = rs.getString(6);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    //</editor-fold>
    
    public boolean desvincular(int cod) throws SQLException{
        boolean r = false;
        sql="SELECT proveedor1, proveedor2, proveedor3, proveedor4 FROM productos WHERE codigo="+cod;
        rs = funcion.select(sql);
        while(rs.next()){
            
            if(rs.getInt(1) == id){
                sql = "UPDATE productos SET proveedor1=0 WHERE codigo="+cod;
                r = funcion.ExecSQL(sql);
            }
            if(rs.getInt(2) == id){
                sql = "UPDATE productos SET proveedor2=0 WHERE codigo="+cod;
                r = funcion.ExecSQL(sql);
            }
            if(rs.getInt(3) == id){
                sql = "UPDATE productos SET proveedor3=0 WHERE codigo="+cod;
                r = funcion.ExecSQL(sql);
            }
            if(rs.getInt(4) == id){
                sql = "UPDATE productos SET proveedor4=0 WHERE codigo="+cod;
                r = funcion.ExecSQL(sql);
            }
            
        }
        
        return r;
    }
    
}
