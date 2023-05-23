package Modelo.Jugadores;

import Modelo.BaseDatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TJugador {

    public static void insertar(Jugador j) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Jugadores values (?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, j.getIdJug());
        ps.setString(2, j.getPieManoDominante());
        ps.setString(3, j.getTamañoCalzado());
        ps.setString(4, j.getPosicionDraft());
        ps.setString(5, j.getPosicion());
        ps.setString(6, j.getTipoJugador());
        ps.setString(7, j.getDNI());
        ps.setString(8, j.getNombre());
        ps.setString(9, j.getApellido1());
        ps.setString(10, j.getApellido2());
        ps.setString(11, j.getTelefono());
        ps.setString(12, j.getCorreo());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Jugador j) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Jugadores where IdJug = ?");
        ps.setInt(1,j.getIdJug());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Jugador j) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Jugadores set PieDominante = ?, TamañoCalzado = ?, PosicionDraft = ?, Posicion = ?, TipoJugador = ?, " +
                " DNI = ?, Nombre = ?, Apellido1 = ?, Apellido2 = ?, Telefono = ?, Correo = ?  where IdJug = ?");
        ps.setString(1, j.getPieManoDominante());
        ps.setString(2, j.getTamañoCalzado());
        ps.setString(3, j.getPosicionDraft());
        ps.setString(4, j.getPosicion());
        ps.setString(5, j.getTipoJugador());
        ps.setString(6, j.getDNI());
        ps.setString(7, j.getNombre());
        ps.setString(8, j.getApellido1());
        ps.setString(9, j.getApellido2());
        ps.setString(10, j.getTelefono());
        ps.setString(11, j.getCorreo());
        ps.setInt(12, j.getIdJug());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Jugador consultarJugadores(Jugador j) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Jugadores where IdJug = ?");
        ps.setInt(1, j.getIdJug());
        ResultSet resultado = ps.executeQuery();
        Jugador jug;
        if (resultado.next())
        {
            jug = new Jugador();
            jug.setIdJug(resultado.getInt("IdJugador"));
            jug.setPieManoDominante(resultado.getString("PieManoDominante"));
            jug.setTamañoCalzado(resultado.getString("TamañoCalzado"));
            jug.setPosicionDraft(resultado.getString("PosicionDraft"));
            jug.setPosicion(resultado.getString("Posicion"));
            jug.setTipoJugador(resultado.getString("TipoJugador"));
            jug.setDNI(resultado.getString("DNI"));
            jug.setNombre(resultado.getString("Nombre"));
            jug.setApellido1(resultado.getString("Apellido1"));
            jug.setApellido2(resultado.getString("Apellido2"));
            jug.setTelefono(resultado.getString("Telefono"));
            jug.setCorreo(resultado.getString("Correo"));
        }
        else
            jug = null;
        BaseDatos.cerrarConexion();
        return jug;
    }
}
