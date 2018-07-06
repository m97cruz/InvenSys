/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Admin.ProdSolicita;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio Cruz
 */
public class Productos {
    DecimalFormat df = new DecimalFormat("########.##");
    int rID;// rID es solo para retornar el id Numerico de los proveedores y de las  marcas
    int codigo, marcaDB, localCant, bodegaCant, repo, porceGan, cantPack, dbProv1, dbProv2, dbProv3, dbProv4; //Todos los parametros
    String nombre, marca, prov1, prov2, prov3, prov4; //Estos parametros se reciben como String para Conertirse con el valor correspondiente de la llave primaria en la tabla
    float preCompra, preVenta, prePack;

    DBControl.SQL_fun funcion = new DBControl.SQL_fun();
    
    // <editor-fold defaultstate="collapsed" desc="Getters y Setters"> 
    public String getNombre() {
        return nombre;
    }

    public int getMarcaDB() {
        return marcaDB;
    }

    public void setMarcaDB(int marcaDB) {
        this.marcaDB = marcaDB;
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
    public int getDbProv1() {
        return dbProv1;
    }

    public int getDbProv2() {
        return dbProv2;
    }

    public int getDbProv3() {
        return dbProv3;
    }

    public int getDbProv4() {
        return dbProv4;
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
    }
    public void setDbProv1(int dbProv1) {
        this.dbProv1 = dbProv1;
    }

    public void setDbProv2(int dbProv2) {
        this.dbProv2 = dbProv2;
    }

    public void setDbProv3(int dbProv3) {
        this.dbProv3 = dbProv3;
    }

    public void setDbProv4(int dbProv4) {
        this.dbProv4 = dbProv4;
    }
    

//</editor-fold>
    
    String sql="";
    ResultSet rs;
    //-------------- Metodos para hacer esto Mas Sukhulemtho---------------//
    
    //Metodo para retornar el ID de un proveedor de la base de datos
    //<editor-fold defaultstate="collapsed" desc="Metodos para Obtener IDs y Nombre de Proveedor y marcas">
    public String getProvNombre(int id) throws SQLException{ 
        String prov="";
        sql = "SELECT prov_nombre FROM proveedores WHERE id="+id;
        rs = funcion.select(sql);
        if(rs.next()){
            prov = rs.getString(1) + " || ";
        }
        return prov;
    }
    
    public int getMarcaID(String marca) throws SQLException{ 
        String sql = "SELECT id FROM marcas WHERE marca='"+marca+"'";
        
        ResultSet rs = funcion.select(sql);
        if(rs.next()){
            rID = rs.getInt("id");
        }else{
            rID=0;
        }
        return rID;
    }
    public String getMarcaNombre() throws SQLException{ 
        String res =""; sql = "SELECT marca FROM marcas WHERE id="+marcaDB;
        
        rs = funcion.select(sql);
        if(rs.next()){
            res = rs.getString(1);
        }
        return res;
    }//</editor-fold>
    
    
    //Setear el id a todos los proveedores que se hayan enviado como parametros.
    //  Busca y setea los proveedores y las marcas
    
    //Preparacion de Consultas SQL
    //<editor-fold defaultstate="collapsed" desc="CRUD para los productos">
    public boolean addProd() throws SQLException{
        //setMarca_Prov();
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
            prov1= "";
        }
        
        if(dbProv2 > 0){
            prov2 = getProvNombre(dbProv2);
        }else{
            prov2= "";
        }
        
        if(dbProv3 > 0){
            prov3 = getProvNombre(dbProv3);
        }else{
            prov3= "";
        }
        
        if(dbProv4 > 0){
            prov4 = getProvNombre(dbProv4);
        }else{
            prov4= "";
        }
        if(marcaDB > 0){
            marca= getMarcaNombre();
        }else{
            marca="";
        }
        
    }
    
    public void deselectProd() {
        bodegaCant = 0;
        cantPack = 0;
        codigo=0;
        marcaDB=0;
        dbProv1 =0; dbProv2=0; dbProv3=0; dbProv4=0;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Retorno de Modelos para marcars y para tablas">
    public DefaultTableModel llenarMarcas(DefaultTableModel model) throws SQLException{
        model.setRowCount(0);
        String datos[] = new String [2];
        
        sql="SELECT id, marca FROM marcas";
        rs = funcion.select(sql);
        while(rs.next()){
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            model.addRow(datos);
        }
        return model;
    }
    
    
    public DefaultTableModel llenarProvs_(DefaultTableModel model, String cadena) throws SQLException{
        model.setRowCount(0);
        
        if(cadena.equals("")){
            sql ="SELECT id, prov_nombre FROM proveedores"; 
        }else{
            sql = "SELECT id, prov_nombre FROM proveedores WHERE MATCH(prov_nombre) AGAINST('"+cadena+"');";
        }
        
        rs=funcion.select(sql);
        String datos[] = new String[2];
        while(rs.next()){
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            model.addRow(datos);
        }
        
        return model;
    }
    
    public DefaultTableModel getProvProd(DefaultTableModel model) throws SQLException{
        model.setRowCount(0);
        String datos[] = new String [2];
        if(dbProv1>0){
            sql ="SELECT id, prov_nombre FROM proveedores WHERE id="+dbProv1;
            rs=funcion.select(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                model.addRow(datos);
            }
        }
        if(dbProv2>0){
            sql ="SELECT id, prov_nombre FROM proveedores WHERE id="+dbProv2;
            rs=funcion.select(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                model.addRow(datos);
            }
        }
        if(dbProv3>0){
            sql ="SELECT id, prov_nombre FROM proveedores WHERE id="+dbProv3;
            rs=funcion.select(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                model.addRow(datos);
            }
        }
        if(dbProv4>0){
            sql ="SELECT id, prov_nombre FROM proveedores WHERE id="+dbProv4;
            rs=funcion.select(sql);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                model.addRow(datos);
            }
        }
        
        return model;
    }


//</editor-fold>
       
    
    //--------------------------------//---------------------------//
    
    //<editor-fold defaultstate="collapsed" desc="Metodos para gestionar solicitud de Productos">
    public boolean solicitarProd(String origen, String destino, int cant, String marcaSend, String provs, Float precioU) throws SQLException{
        
        float total;
        if(precioU == null){
            total = preCompra*cant;
            precioU=preCompra;
            
        }else{
            total = precioU*cant;
        }
        sql ="SELECT cantidad, precio FROM prod_solicita WHERE cod_prod="+codigo+" AND destino='"+destino+"' AND provs='"+provs+"';";
        rs = funcion.select(sql);
        if (rs.next()){
            while(rs.next()){
                total= rs.getFloat(2)*(rs.getInt(1)+cant);
                sql = "UPDATE prod_solicita SET cantidad="+(rs.getInt(1)+cant)+", precio="+Float.valueOf(df.format(total))+" WHERE cod_prod="+codigo + " AND destino='"+destino+"'";
            }
            
        }else{
            sql="INSERT INTO prod_solicita VALUES("+codigo+", '"+nombre+"', '"+marcaSend+"', '"+provs+"', '"+origen+"', '"+destino+"', "+precioU+", "+cant+", "+Float.valueOf(df.format(total))+")";
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
    
    public boolean rmovSoliProc(String destino, String prov) throws SQLException{
        
        sql = "DELETE FROM prod_solicita WHERE cod_prod="+codigo + " AND destino='"+destino+"' AND provs='"+prov+"'";
        return funcion.ExecSQL(sql);
    }
    
    public boolean confirmPedido(String destino, String provs) throws SQLException{ // Para cofirmar en Tabla Prod Solicita
        //Extraer la cantidad actual para luego sumarle
        boolean r=false;
        String sqlUpd = "";
        int cantidad=0; float total=0.00f;
        sql="SELECT cantidad, precio FROM prod_solicita WHERE cod_prod="+codigo +" AND destino='"+destino+"' AND provs='"+provs+"'";
        rs = funcion.select(sql);
        while(rs.next()){
            cantidad = rs.getInt(1);
            total = rs.getFloat(2);
        }
        
        //Determinar tipo de movimiento
        //Creara una consulta para cada uno
        if (destino.equals("Local")){
            
            if(bodegaCant>=cantidad){
                sqlUpd="UPDATE productos SET local_cant="+(localCant+cantidad)+", bodega_cant="+(bodegaCant-cantidad) + " WHERE codigo="+codigo;
                r = funcion.ExecSQL(sqlUpd);
                rmovSoliProc(destino, provs);
            }else{
                ProdSolicita.mensaje="¡La Peticion Supera las Existencias en Bodega!";
            }
            
        }else{//Si es de Porveedor a Bodega
            
            sqlUpd="UPDATE productos SET bodega_cant="+(bodegaCant+cantidad) + " WHERE codigo="+codigo;
            r=funcion.ExecSQL(sqlUpd);
            
            rmovSoliProc(destino, provs);
            
            //Vamo a Comprobar si ya existe una compra de este mismo producto en este mismo dia
            sql = "SELECT cantidad, precio FROM compras WHERE fecha='"+LocalDate.now().toString()+"' AND cod_prod="+codigo+" AND proveedor='"+provs+"'";
            rs = funcion.select(sql);
            sql="INSERT INTO compras VALUES(null, '"+(LocalDate.now().toString())+"', "+codigo+", '"+nombre+"', '"+provs+"', "+preCompra+", "+cantidad+", "+Float.valueOf(df.format(total))+");";

            while(rs.next()){
                sql="UPDATE compras SET cantidad="+(rs.getInt(1)+cantidad)+", precio="+Float.valueOf(df.format(rs.getFloat(2)+total));
                sql+=" WHERE fecha='"+LocalDate.now().toString()+"' AND cod_prod="+codigo+" AND proveedor='"+provs+"'";
            }

            
            
            r = funcion.ExecSQL(sql);  
        }
        
        
        return r;
    }//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CRUD para las MARCAS">
    
    public boolean addMarca(String marca){
        sql ="INSERT INTO marcas VALUES(null, '"+marca+"')";
        return funcion.ExecSQL(sql);
    }
    
    public boolean rmMarca(int id) throws SQLException{
        boolean r=false;
        sql="SELECT codigo FROM productos WHERE marca="+id;
        rs = funcion.select(sql);
        if(!rs.next()){
            sql="DELETE FROM marcas WHERE id="+id;
            r = funcion.ExecSQL(sql);
        }
        
        return r;
    }
    
    //</editor-fold>
    
    
    //----------------------Esta madre de aca, va a ser para el Modulo del Vendedor ------------------------//
    
    public float getTotal(int cantidad, String tipo) throws SQLException{  //Solitica: la cantidad de Productos solicitados. Tipo: Mayoreo, Por Paquete, o Sin Descuento. por defecto es "Sin Descuento"
        float total = 0.00f;
        //Primero lo primero, Seleccionar el Producto despues haber seteado antes el ID del enttity class.....
        this.selectProd();
        
        //Seleccionando Modo
        switch(tipo.toLowerCase()){  //usar esta vaina con un slolo caracter para incrementear eficiencia
            case "p": //Descuento por paquetes
                if(cantPack>0){
                    //aplicar precio por paquete unicamente a los paquetes formados
                    int sobrante = cantidad % cantPack;
                    
                    if(sobrante==0){
                        total=cantidad*prePack;
                    } else{
                        total=(cantidad-sobrante)*prePack;
                        total+=sobrante*preVenta;
                    }
                }else{
                    total= cantidad*preVenta;
                }
                break;
                
            case "m": //Precio de mayoreo
                if(cantPack>0){
                    if(cantidad>=cantPack){
                        total=cantidad*prePack;
                    }else{
                        total= cantidad*preVenta;
                    } 
                }else{
                    total= cantidad*preVenta;
                }
                break;
        }
        
       return total;
    }
    
    
    
}
