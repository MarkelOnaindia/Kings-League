package Modelo.Usuario;

import Controlador.Main;
import Modelo.BaseDatos;
import Modelo.Temporada.Temporada;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TUsuario {

    //CRUD
    public static void insertar(Usuario u) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("INSERT INTO Usuarios (NOMBRE, CONTRASENA, EMAIL, TEL, ADMIN) values (?,?,?,?,?)");
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getContraseña());
        ps.setString(3, u.getEmail());
        ps.setString(4, u.getTelefono());
        ps.setString(5, u.getAdmin());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Usuario u) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Usuarios where Id_Usuario = ?");
        ps.setInt(1, u.getIdUsuario());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Usuario u) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Usuarios set Nombre = ?, Contraseña = ?, Email = ?, Telefono = ?, Admin = ? where Id_Usuario = ?");
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getContraseña());
        ps.setString(3, u.getEmail());
        ps.setString(4,u.getTelefono());
        ps.setString(5, u.getAdmin());
        ps.setInt(6, u.getIdUsuario());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Usuario consultarUsuario(Usuario u) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Usuarios where Id_Usuario = ?");
        ps.setInt(1, u.getIdUsuario());
        ResultSet resultado = ps.executeQuery();
        Usuario us;
        if (resultado.next())
        {
            us = new Usuario();
            us.setIdUsuario(resultado.getInt("IdUsuario"));
            us.setNombre(resultado.getString("Nombre"));
            us.setContraseña(resultado.getString("Contraseña"));
            us.setEmail(resultado.getString("Email"));
            us.setTelefono(resultado.getString("Telefono"));
            us.setAdmin(resultado.getString("Admin"));
        }
        else
            us = null;
        BaseDatos.cerrarConexion();
        return us;
    }

    //Comprobacion inico de sesion
    public static Usuario inicioSesion(Usuario u) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("SELECT admin FROM USUARIOS WHERE Nombre = ? and Contrasena = ?");
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getContraseña());
        ResultSet resultSet = ps.executeQuery();
        Usuario us = null;
        if (resultSet.next()) {
            us = new Usuario();
            us.setAdmin(resultSet.getString("admin"));
        }else {
            throw new Exception();
        }
        BaseDatos.cerrarConexion();
        return us;
    }
}