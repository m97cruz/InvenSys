/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.sql.SQLException;

/**
 *
 * @author Mauricio Cruz
 */
public class Productos {
    int codigo;
    String nombre, marca, preCompra, preVenta, prePack, cantPack, porceGan, localCant, bodegaCant, repo, prov1, prov2, prov3, prov4;

    DBControl.SQL_fun funcion = new DBControl.SQL_fun();
    
    // <editor-fold defaultstate="collapsed" desc="Getters y Setters"> 
    public String getNombre() {
        return nombre;
    }
    public String getMarca() {
        return marca;
    }
    public String getPreCompra() {
        return preCompra;
    }
    public String getPreVenta() {
        return preVenta;
    }
    public String getPrePack() {
        return prePack;
    }
    public String getCantPack() {
        return cantPack;
    }
    public String getPorceGan() {
        return porceGan;
    }
    public String getLocalCant() {
        return localCant;
    }
    public String getBodegaCant() {
        return bodegaCant;
    }
    public String getRepo() {
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
    public void setPreCompra(String preCompra) {
        this.preCompra = preCompra;
    }
    public void setPreVenta(String preVenta) {
        this.preVenta = preVenta;
    }
    public void setPrePack(String prePack) {
        this.prePack = prePack;
    }
    public void setCantPack(String cantPack) {
        this.cantPack = cantPack;
    }
    public void setPorceGan(String porceGan) {
        this.porceGan = porceGan;
    }
    public void setLocalCant(String localCant) {
        this.localCant = localCant;
    }
    public void setBodegaCant(String bodegaCant) {
        this.bodegaCant = bodegaCant;
    }
    public void setRepo(String repo) {
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
    
    public boolean addProd() throws SQLException{ //Deja el espacio al principio del String
        String sql = "INSERT INTO productos VALUES(null, "
                + "'"+nombre+"', "
                + ""+preCompra+", "
                + ""+preVenta+", "
                + ""+prePack+", "
                + ""+cantPack+", "
                + ""+localCant+", "
                + ""+bodegaCant+", "
                + ""+repo+", "
                + ""+porceGan+", "
                + ""+marca+", "
                + ""+prov1+", "
                + ""+prov2+", "
                + ""+prov3+", "
                + ""+prov4+")";
        
        return funcion.ExecSQL(sql);
    }
    
    
    
}
