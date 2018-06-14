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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

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
        
        sql ="DELETE FROM productos WHERE codigo="+codigo;
        return funcion.ExecSQL(sql);
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
    
    public DefaultComboBoxModel llenarComboMarcas(DefaultComboBoxModel marcas) throws SQLException{
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
        return marcas;
    }
    
    
    
    
    
    
    
    //--------------------------------//---------------------------//
    public DefaultComboBoxModel llenarProvs(DefaultComboBoxModel comboProv) throws SQLException{
        
        comboProv.removeAllElements();
        
        if(dbProv1!=0){
           sql="SELECT prov_nombre FROM proveedores WHERE id="+dbProv1;
           ResultSet res = funcion.select(sql);
           while(res.next()){
               comboProv.addElement(res.getString(1));
           }
        }
        
        comboProv.addElement("--No Especificado--");
        
        sql="SELECT prov_nombre FROM proveedores";
        rs = funcion.select(sql);
        while(rs.next()){
            comboProv.addElement(rs.getString(1));
        }
        return comboProv;
    }
    
    public boolean solicitarProd(String origen, String destino, int cant, String marcaSend) throws SQLException{
        sql ="SELECT cantidad FROM prod_solicita WHERE cod_prod="+codigo+" AND destino='"+destino+"'";
        rs = funcion.select(sql);
        if (rs.next()){            
            sql = "UPDATE prod_solicita SET cantidad="+(rs.getInt(1)+cant)+" WHERE cod_prod="+codigo + " AND destino='"+destino+"'";
        }else{
            sql="INSERT INTO prod_solicita VALUES("+codigo+", '"+nombre+"', '"+marcaSend+"', '"+origen+"', '"+destino+"', "+cant+", "+(preCompra*cant)+")";
        }
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
    
    public boolean rmovSoliProc(String destino) throws SQLException{
        
        sql = "DELETE FROM prod_solicita WHERE cod_prod="+codigo + " AND destino='"+destino+"'";
        return funcion.ExecSQL(sql);
    }
    
    public boolean confirmPedido(String destino) throws SQLException{ // Para cofirmar en Tabla Prod Solicita
        //Extraer la cantidad actual para luego sumarle
        boolean r=false;
        String sqlUpd = "";
        int exisBodega =0, exisLocal=0, cantidad=0;
        sql="SELECT cantidad FROM prod_solicita WHERE cod_prod="+codigo + " AND destino='"+destino+"'";
        rs = funcion.select(sql);
        while(rs.next()){
            cantidad = rs.getInt(1);
        }
        
        //Determinar tipo de movimiento
        //Creara una consulta para cada uno
        if (destino.equals("Local")){
            
            if(bodegaCant>=cantidad){
                sqlUpd="UPDATE productos SET local_cant="+(localCant+cantidad)+", bodega_cant="+(bodegaCant-cantidad) + " WHERE codigo="+codigo;
                r = funcion.ExecSQL(sqlUpd);
                rmovSoliProc(destino);
            }else{
                ProdSolicita.mensaje="¡La Peticion Supera las Existencias en Bodega!";
            }
            
        }else{//Si es de Porveedor a Bodega
            
            sqlUpd="UPDATE productos SET bodega_cant="+(bodegaCant+cantidad) + " WHERE codigo="+codigo;
            r=funcion.ExecSQL(sqlUpd);
            rmovSoliProc(destino);
        }
        
        
        return r;
    }
    
}
