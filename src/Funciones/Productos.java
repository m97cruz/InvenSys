/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Admin.Administracion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Mauricio Cruz
 */
public class Productos {
    int rID;// rID es solo para retornar el id Numerico de los proveedores y de las  marcas
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
    
    String sql="";
    ResultSet rs;
    //-------------- Metodos para hacer esto Mas Sukhulemtho---------------//
    
    //Metodo para retornar el ID de un proveedor de la base de datos
    //<editor-fold desc="Metodos para Obtener IDs y Nombre de Proveedor y marcas">
    private int getProvID(String prov) throws SQLException{ 
        String sql = "SELECT id FROM proveedores WHERE prov_nombre='"+prov+"'";
        
        ResultSet rs = funcion.select(sql);
        if(rs.next()){
            rID = rs.getInt(1);
        }else{
            rID=0;
        }
        return rID;
    }
    private String getProvNombre(int id) throws SQLException{ 
        String prov="",sql = "SELECT prov_nombre FROM proveedores WHERE id="+id;
        ResultSet rs = funcion.select(sql);
        if(rs.next()){
            prov = rs.getString(1);
        }else{
            prov = "-Sin Proveedor-";
        }
        return prov;
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
    private String getMarcaNombre(int marca) throws SQLException{ 
        String res ="", sql = "SELECT id FROM marcas WHERE marca='"+marca+"'";
        
        ResultSet rs = funcion.select(sql);
        if(rs.next()){
            res = rs.getString("nombre");
        }else{
            res="";
        }
        return res;
    }//</editor-fold>
    
    
    //Setear el id a todos los proveedores que se hayan enviado como parametros.
    //  Busca y setea los proveedores y las marcas
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
        
        sql = "INSERT INTO productos("+campo+") VALUES("+value+")";
        
        return funcion.ExecSQL(sql);
    }
    
    public boolean modProd() throws SQLException{
        setMarca_Prov();
        String campo = "";
        campo += "nombre='"+nombre+"'";
        //Floats y Enteros no van entre comilla simple
        campo += ", pre_compra="+preCompra;
        campo += ", pre_venta="+preVenta;
        campo += ", pre_pack="+prePack;
        
        campo += ", cant_pack="+cantPack;
        campo += ", local_cant="+localCant;
        campo += ", bodega_cant="+bodegaCant;
        campo += ", repo="+repo;
        campo += ", porce_gan="+porceGan;
        campo += ", marca="+marcaDB; //si da valor cero (Sin marca) se establece en el metodo SetMarca_Prov
        campo += ", proveedor1="+ dbProv1;
        campo += ", proveedor2="+ dbProv2;
        campo += ", proveedor3="+ dbProv3;
        campo += ", proveedor4="+ dbProv4;
        
        sql = "UPDATE productos SET "+campo+" WHERE codigo="+codigo;
        return funcion.ExecSQL(sql);
    }
    
    public boolean rmovProd() throws SQLException{
        
        
        
        return true;
    }
    
    public void selectProd() throws SQLException{
        sql ="SELECT * FROM productos WHERE codigo="+codigo;
        rs =funcion.select(sql);
        //Dar el numero de la columna para que sea mas rapido, (enlugar de comparar nombres, compara numero de columna)
        while(rs.next()){
            nombre=rs.getString(2); //nombre
            preCompra = rs.getFloat(3);
            preVenta = rs.getFloat(4);
            prePack = rs.getFloat(5);
            //Enteros;
            cantPack =rs.getInt(6);
            localCant =rs.getInt(7);
            bodegaCant =rs.getInt(8);
            repo =rs.getInt(9);
            porceGan =rs.getInt(10);
            marcaDB =rs.getInt(11);
            dbProv1 =rs.getInt(12);
            dbProv2 =rs.getInt(13);
            dbProv3 =rs.getInt(14);
            dbProv4 =rs.getInt(15);
        }
        //Si hay un proveedor, seleccionara su nombre en  la base de datos
        if(dbProv1 > 0){
            prov1 = getProvNombre(dbProv1);
        }else{
            prov1= "-Sin Especificar-";
        }
        
        if(dbProv2 > 0){
            prov2 = getProvNombre(dbProv2);
        }else{
            prov2= "-Sin Especificar-";
        }
        
        if(dbProv3 > 0){
            prov3 = getProvNombre(dbProv3);
        }else{
            prov3= "-Sin Especificar-";
        }
        
        if(dbProv4 > 0){
            prov4 = getProvNombre(dbProv4);
        }else{
            prov4= "-Sin Especificar-";
        }
        if(marcaDB > 0){
            marca= getMarcaNombre(marcaDB);
        }else{
            marca="-Sin Especificar-";
        }
        
    }
    
    public void deselectProd() {
        bodegaCant = 0;
        cantPack = 0;
        codigo=0;
        marcaDB=0;
        dbProv1 =0; dbProv2=0; dbProv3=0; dbProv4=0;
    }
    
    public void llenarComboMarcas() throws SQLException{
        DefaultComboBoxModel marcas = (DefaultComboBoxModel) Administracion.comboMarca.getModel();
        marcas.removeAllElements();
        if(marcaDB!=0){
           sql="SELECT marca FROM marcas WHERE id="+marcaDB;
           ResultSet res = funcion.select(sql);
           while(res.next()){
               marcas.addElement(res.getString(1));
           }
           
        }
        
        marcas.addElement("--No Especificado--");
        
        sql="SELECT marca FROM marcas";
        rs = funcion.select(sql);
        while(rs.next()){
            marcas.addElement(rs.getString(1));
        }
        Administracion.comboMarca.setModel(marcas);
    }
    //--------------------------------//---------------------------//
    public void llenarProvs() throws SQLException{
        DefaultComboBoxModel comboProv1 = (DefaultComboBoxModel) Administracion.comboProv1.getModel();
        DefaultComboBoxModel comboProv2 = (DefaultComboBoxModel) Administracion.comboProv2.getModel();
        DefaultComboBoxModel comboProv3 = (DefaultComboBoxModel) Administracion.comboProv3.getModel();
        DefaultComboBoxModel comboProv4 = (DefaultComboBoxModel) Administracion.comboProv4.getModel();
        
        comboProv1.removeAllElements();
        comboProv2.removeAllElements(); 
        comboProv3.removeAllElements(); 
        comboProv4.removeAllElements();
        
        if(dbProv1!=0){
           sql="SELECT prov_nombre FROM proveedores WHERE id="+dbProv1;
           ResultSet res = funcion.select(sql);
           while(res.next()){
               comboProv1.addElement(res.getString(1));
           }
        }
        if(dbProv2!=0){
           sql="SELECT prov_nombre FROM proveedores WHERE id="+dbProv2;
           ResultSet res = funcion.select(sql);
           while(res.next()){
               comboProv2.addElement(res.getString(1));
           }
        }
        if(dbProv3!=0){
           sql="SELECT prov_nombre FROM proveedores WHERE id="+dbProv3;
           ResultSet res = funcion.select(sql);
           while(res.next()){
               comboProv3.addElement(res.getString(1));
           }
        }
        if(dbProv4!=0){
           sql="SELECT prov_nombre FROM proveedores WHERE id="+dbProv4;
           ResultSet res = funcion.select(sql);
           while(res.next()){
               comboProv4.addElement(res.getString(1));
           }
        }
        
        comboProv1.addElement("--No Especificado--");
        comboProv2.addElement("--No Especificado--");
        comboProv3.addElement("--No Especificado--");
        comboProv4.addElement("--No Especificado--");
        
        sql="SELECT prov_nombre FROM proveedores";
        rs = funcion.select(sql);
        while(rs.next()){
            comboProv1.addElement(rs.getString(1));
            comboProv2.addElement(rs.getString(1));
            comboProv3.addElement(rs.getString(1));
            comboProv4.addElement(rs.getString(1));
        }
        Administracion.comboProv1.setModel(comboProv1);
        Administracion.comboProv2.setModel(comboProv2);
        Administracion.comboProv3.setModel(comboProv3);
        Administracion.comboProv4.setModel(comboProv4);
    }
    
    public boolean solicitarProd(String origen, String destino, int cant, String marcaSend) throws SQLException{
        
        sql="INSERT INTO prod_solicita VALUES("+codigo+", '"+nombre+"', '"+marcaSend+"', '"+origen+"', '"+destino+"', "+cant+", "+preCompra+")";
        return funcion.ExecSQL(sql);
    }
    public int getSoliCant() throws SQLException{
        rs = funcion.select("SELECT cod_prod FROM prod_solicita");
        int cont=0;
        while(rs.next()){
            cont++;
        }
        return cont;
    }
    
}
