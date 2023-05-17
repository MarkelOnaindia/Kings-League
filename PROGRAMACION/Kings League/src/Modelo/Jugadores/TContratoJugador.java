package Modelo.Jugadores;

import Modelo.BaseDatos;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TContratoJugador {

    public static void insertar(ContratoJugador cj) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into ContratoJugador values (?,?,?,?,?,?)");
        ps.setInt(1,cj.getIdConju());
        ps.setInt(2, cj.getSueldo());
        ps.setDate(3, Date.valueOf(cj.getFechaInicio()));
        ps.setDate(4, Date.valueOf(cj.getFechaFin()));
        ps.setInt(5, cj.getClausula());
        ps.setString(6, cj.getDorsal());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(ContratoJugador cj) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from ContratoJugador where IdConju = ?");
        ps.setInt(1, cj.getIdConju());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(ContratoJugador cj) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update ContratoJugador set IdEquipo = ?, IdJug = ?, Sueldo = ?, FechaInicio = ?, FechaFin = ?, Clausula = ?, Dorsal = ? where IdConju = ?");
        ps.setInt( 1, cj.getSueldo());
        ps.setDate(2, Date.valueOf(cj.getFechaInicio()));
        ps.setDate(3, Date.valueOf(cj.getFechaFin()));
        ps.setInt(4, cj.getClausula());
        ps.setString(5, cj.getDorsal());
        ps.setInt(6,cj.getIdConju());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static ContratoJugador consultarContratosJugadores(ContratoJugador cj) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from ContratoJugador where IdConju = ?");
        ps.setInt(1, cj.getIdConju());
        ResultSet resultado = ps.executeQuery();
        ContratoJugador conju;
        if (resultado.next())
        {
            conju = new ContratoJugador();
            conju.setSueldo(resultado.getInt("Sueldo"));
            conju.setFechaInicio(resultado.getDate("Dia").toLocalDate());
            conju.setFechaFin(resultado.getDate("Tipo").toLocalDate());
            conju.setClausula(resultado.getInt("Clausula"));
            conju.setDorsal(resultado.getString("Dorsal"));
        }
        else
            conju = null;
        BaseDatos.cerrarConexion();
        return conju;
    }
}
