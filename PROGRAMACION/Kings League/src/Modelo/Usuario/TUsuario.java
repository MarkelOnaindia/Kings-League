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
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Usuario values (?,?,?,?,?,?)");
        ps.setInt(1, u.getIdUsuario());
        ps.setString(2, u.getNombre());
        ps.setString(3, u.getContraseña());
        ps.setString(4, u.getEmail());
        ps.setString(5, u.getTelefono());
        ps.setString(6, u.getAdmin());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Usuario u) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Usuario where IdUsuario = ?");
        ps.setInt(1, u.getIdUsuario());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Usuario u) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Usuario set Nombre = ?, Contraseña = ?, Email = ?, Telefono = ?, Admin = ? where IdUsuario = ?");
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
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Usuario where IdUsuario = ?");
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
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("SELECT admin FROM USUARIO WHERE Nombre = ? and Contrasena = ?");
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
