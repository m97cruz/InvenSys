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
public class Productos {
    int rID;
    int codigo, marcaDB, localCant, bodegaCant, repo, porceGan, cantPack, dbProv1, dbProv2, dbProv3, dbProv4; //Todos los parametros
    String nombre, marca, prov1, prov2, prov3, prov4; //Estos parametros se reciben como String para Conertirse con el valor correspondiente de la llave primaria en la tabla
    float preCompra, preVenta, prePack;

    DBControl.SQL_fun funcion = new DBControl.SQL_fun();
    
    // <editor-fold defaultstate="collapsed" desc="Getters y Setters"> 
    public String getNombre() {
        return nombre;
    }
    public String getMarca() {
        return marca;
    }
    public float getPreCompra() {
        return preCompra;
    }
    public float getPreVenta() {
        return preVenta;
    }
    public float getPrePack() {
        return prePack;
    }
    public int getCantPack() {
        return cantPack;
    }
    public int getPorceGan() {
        return porceGan;
    }
    public int getLocalCant() {
        return localCant;
    }
    public int getBodegaCant() {
        return bodegaCant;
    }
    public int getRepo() {
        return repo;
    }
    public String getProv1() {
        return prov1;
    }
    public String getProv2() {
        return prov2;
    }
    public String getProv3() {
        return prov3;
    }
    public String getProv4() {
        return prov4;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setPreCompra(float preCompra) {
        this.preCompra = preCompra;
    }
    public void setPreVenta(float preVenta) {
        this.preVenta = preVenta;
    }
    public void setPrePack(float prePack) {
        this.prePack = prePack;
    }
    public void setCantPack(int cantPack) {
        this.cantPack = cantPack;
    }
    public void setPorceGan(int porceGan) {
        this.porceGan = porceGan;
    }
    public void setLocalCant(int localCant) {
        this.localCant = localCant;
    }
    public void setBodegaCant(int bodegaCant) {
        this.bodegaCant = bodegaCant;
    }
    public void setRepo(int repo) {
        this.repo = repo;
    }
    public void setProv1(String prov1) {
        this.prov1 = prov1;
    }
    public void setProv2(String prov2) {
        this.prov2 = prov2;
    }
    public void setProv3(String prov3) {
        this.prov3 = prov3;
    }
    public void setProv4(String prov4) {
        this.prov4 = prov4;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }//</editor-fold>
    
    
    //-------------- Metodos para hacer esto Mas Sukhulemtho---------------//
    //Metodo para retornar el ID de un proveedor de la base de datos
    private int getProvID(String prov) throws SQLException{ 
        String sql = "SELECT id FROM proveedores WHERE prov_nombre='"+prov+"'";
        
        ResultSet rs = funcion.select(sql);
        if(rs.next()){
            rID = rs.getInt("id");
        }else{
            rID=0;
        }
        return rID;
    }
    private int getMarcaID(String marca) throws SQLException{ 
        String sql = "SELECT id FROM marcas WHERE marca='"+marca+"'";
        
        ResultSet rs = funcion.select(sql);
        if(rs.next()){
            rID = rs.getInt("id");
        }else{
            rID=0;
        }
        return rID;
    }
    
    //Setear el id a todos los proveedores que se hayan enviado como parametros.
    // Los ID se insertane el campo correspondiente de la tabla de productos (Llave Foranea)
    private void setMarca_Prov() throws SQLException{ //Tambien incluye la marca ademas de los proveedores
        if(!prov1.equals("")){
            dbProv1 = getProvID(prov1);
        }else{
            dbProv1 = 0;
        }
        
        if(!prov2.equals("")){
            dbProv2 = getProvID(prov2);
        }else{
            dbProv2 = 0;
        }
        
        if(!prov3.equals("")){
            dbProv3 = getProvID(prov3);
        }else{
            dbProv3 = 0;
        }
        
        if(!prov4.equals("")){
            dbProv4 = getProvID(prov4);
        }else{
            dbProv4 = 0;
        }
        
        if (!marca.equals("")){
            marcaDB=getMarcaID(marca);
        }else{
            marcaDB = 0;
        }
    }
    
    
    
    //Preparacion de Consultas SQL
    
    public boolean addProd() throws SQLException{
        setMarca_Prov();
        String campo = "codigo";
        String value = "null";
            campo += ", nombre"; value += ", '"+nombre+"'";
        //Floats y Enteros no van entre comilla simple
        campo += ", pre_compra"; value += ", "+preCompra;
        campo += ", pre_venta"; value += ", "+preVenta;
        campo += ", pre_pack"; value += ", "+prePack;
        
        campo += ", cant_pack"; value += ", "+cantPack;
        campo += ", local_cant"; value += ", "+localCant;
        campo += ", bodega_cant"; value += ", "+bodegaCant;
        campo += ", repo"; value += ", "+repo;
        campo += ", porce_gan"; value += ", "+porceGan;
        campo += ", marca"; value += ", "+marcaDB; //si da valor cero (Sin marca) se establece en el metodo SetMarca_Prov
        campo += ", proveedor1"; value += ", "+ dbProv1;
        campo += ", proveedor2"; value += ", "+ dbProv2;
        campo += ", proveedor3"; value += ", "+ dbProv3;
        campo += ", proveedor4"; value += ", "+ dbProv4;
        
        String sql = "INSERT INTO productos("+campo+") VALUES("+value+")";
        
        return funcion.ExecSQL(sql);
    }
    
    public boolean modProd() throws SQLException{
        setMarca_Prov();
        String campo = "";
        campo += "nombre='"+nombre+"'";
        //Floats y Enteros no van entre comilla simple
        campo += " pre_compra="+preCompra;
        campo += " pre_venta="+preVenta;
        campo += " pre_pack="+prePack;
        
        campo += " cant_pack="+cantPack;
        campo += " local_cant="+localCant;
        campo += " bodega_cant="+bodegaCant;
        campo += " repo="+repo;
        campo += " porceGan="+porceGan;
        campo += " marca="+marcaDB; //si da valor cero (Sin marca) se establece en el metodo SetMarca_Prov
        campo += " proveedor1="+ dbProv1;
        campo += " proveedor2="+ dbProv2;
        campo += " proveedor3="+ dbProv3;
        campo += " proveedor4="+ dbProv4;
        
        String sql = "UPDATE productos SET "+campo+" WHERE id="+codigo;
        return funcion.ExecSQL(sql);
    }
    
    
}
