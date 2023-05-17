package Modelo.Entrenadores;

import Modelo.BaseDatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.IdentityHashMap;

public class TEntrenador {

    public static void insertar(Entrenador e) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Entrenador values (?,?,?,?,?,?,?)");
        ps.setInt(1, e.getIdEnt());
        ps.setString(2, e.getDNI());
        ps.setString(3, e.getNombre());
        ps.setDate(4, Date.valueOf(e.getApellido1()));
        ps.setDate(5, Date.valueOf(e.getApellido2()));
        ps.setString(6, e.getTelefono());
        ps.setString(7, e.getCorreo());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Entrenador e) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Entrenador where IdEnt = ?");
        ps.setInt(1, e.getIdEnt());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Entrenador e) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Entrenador set DNI = ?, Nombre = ?, Apellido1 = ?, Apellido2 = ?, Telefono = ?, Correo = ? where IdEnt = ?");
        ps.setString( 1, e.getDNI());
        ps.setString(2, e.getNombre());
        ps.setString(3, e.getApellido1());
        ps.setString(4, e.getApellido2());
        ps.setString(5, e.getTelefono());
        ps.setString(6, e.getCorreo());
        ps.setInt(7, e.getIdEnt());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Entrenador consultarEntrenadores(Entrenador e) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Entrenador where IdEnt = ?");
        ps.setInt(1, e.getIdEnt());
        ResultSet resultado = ps.executeQuery();
        Entrenador entrena;
        if (resultado.next())
        {
            entrena = new Entrenador();
            entrena.setIdEnt(resultado.getInt("IdEnt"));
            entrena.setDNI(resultado.getString("Dni"));
            entrena.setNombre(resultado.getString("Nombre"));
            entrena.setApellido1(resultado.getString("Apellido1"));
            entrena.setApellido2(resultado.getString("Apellido2"));
            entrena.setTelefono(resultado.getString("Telefono"));
            entrena.setCorreo(resultado.getString("Correo"));
        }
        else
            entrena = null;
        BaseDatos.cerrarConexion();
        return entrena;
    }
}
