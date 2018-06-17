package Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author mcruz
 */

//Aaqiii se va a meter tooooodo lo que tenga que ver con los usuarios....

public class Usuarios {
    DBControl.SQL_fun funSQL = new DBControl.SQL_fun();
    /*Info de la base de datos: 
        - Posee los campos aqi mostrados,...
        - Se usará el rol para determinar hacia que ventana enviarlo, a travez de la misma ventana de login
        - Unicamente setear el ID en selecion para el usuario Actual para reseleccionarse cuando sea necesario
        - No se que mas poner aqi xD*/
    public static int id;
    public static String nombre, apellido, user, pass, direccion, telefono, correo, rol;
        //<editor-fold desc="Getters y Setters">
    public static String getNombre() {
        return nombre;
    }
    public static void setNombre(String nombre) {
        Usuarios.nombre = nombre;
    }
    public static String getApellido() {
        return apellido;
    }
    public static void setApellido(String apellido) {
        Usuarios.apellido = apellido;
    }
    public static String getUser() {
        return user;
    }
    public static void setUser(String user) {
        Usuarios.user = user;
    }
    public static String getPass() {
        return pass;
    }
    public static void setPass(String pass) {
        Usuarios.pass = pass;
    }
    public static String getDireccion() {
        return direccion;
    }
    public static void setDireccion(String direccion) {
        Usuarios.direccion = direccion;
    }
    public static String getTelefono() {
        return telefono;
    }
    public static void setTelefono(String telefono) {
        Usuarios.telefono = telefono;
    }
    public static String getCorreo() {
        return correo;
    }
    public static void setCorreo(String correo) {
        Usuarios.correo = correo;
    }
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Usuarios.id = id;
    }
    public static String getRol() {
        return rol;
    }
    public static void setRol(String rol) {
        Usuarios.rol = rol;
    }//</editor-fold>
    
    
    
    public boolean login() throws SQLException{
        rol = "";
        id = 0;
        boolean login = false;
        String sql = "SELECT * FROM `usuarios` WHERE `usuario`='"+user+"' AND `passwd`='"+pass+"';";
        ResultSet result = funSQL.select(sql);
        if (result != null){
            if(result.next()){
            id = result.getInt("id");
            rol = result.getString("rol");
            login=true;
            //Lo que necesitamos por ahora :)
            }
        }
        
        return login;
    }
    public ResultSet selectAll() throws SQLException{
        ResultSet rs= null;
        String sql= "Select * FROM usuarios";
        rs = funSQL.select(sql);
        return rs; 
    }
    public void selectUsr() throws SQLException{
        String sql = "SELECT * FROM `usuarios` WHERE `id`="+id;
        ResultSet result = funSQL.select(sql);
        while(result.next()){
            //Seleccion Full Duplex del Usuario_ Selecionamos todo, menos el Password
            id = result.getInt("id");
            nombre = result.getString("nombre");
            apellido = result.getString("apellido");
            telefono = result.getString("telefono");
            direccion = result.getString("direccion");
            correo = result.getString("correo");
            user = result.getString("user");
            rol = result.getString("rol");
            //Luego vemos qe mas le metemos
        }
    }
    public void addUser()throws SQLException {
        String sql="INSERT into usuarios VALUES (NULL,'"+this.user+"','"+this.nombre+"','"+this.pass+"','"+this.rol+"','"+this.apellido+"','"+this.direccion+"','"+this.telefono+"','"+this.correo+"');";
        funSQL.ExecSQL(sql);
    }
    public void updateUser(int id)throws SQLException {
        String sql="UPDATE usuarios SET usuario='"+this.user+"', nombre='"+this.nombre+"',rol='"+this.rol+"',apellido='"+this.apellido+"',direccion='"+this.direccion+"',telefono='"+this.telefono+"',correo='"+this.correo+"' Where id="+id+";";
        funSQL.ExecSQL(sql);
    }
    public void updatePass(int id)throws SQLException {
        String sql="UPDATE usuarios SET passwd='"+this.pass+"'Where id="+id+";";
        funSQL.ExecSQL(sql);
    }
}
