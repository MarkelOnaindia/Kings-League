package Modelo.Partido;

import Modelo.BaseDatos;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TPartido {

    public static void insertar(Partido p) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Partido values (?,?,?,?,?,?,?)");
        ps.setInt(1, p.getIdPartido());
        ps.setInt(2, p.getIdJor());
        ps.setDate(3, Date.valueOf(p.getHora()));
        ps.setInt(4, p.getGolesEq1());
        ps.setInt(5, p.getGolesEq2());
        ps.setInt(6, p.getIdGanador());
        ps.setInt(7, p.getIdPerdedor());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Partido p) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Partido where IdPartido = ?");
        ps.setInt(1, p.getIdPartido());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Partido p) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Partido set IdJor = ?, Hora = ?, GolesEq1 = ?, GolesEq2 = ?, IdGanador = ? " +
                " IdPerdedor = ?  where IdPartido = ?");
        ps.setInt(1,p.getIdJor());
        ps.setDate(2, Date.valueOf(p.getHora()));
        ps.setInt(3, p.getGolesEq1());
        ps.setInt(4, p.getGolesEq2());
        ps.setInt(5, p.getIdGanador());
        ps.setInt(6, p.getIdPerdedor());
        ps.setInt(7, p.getIdPartido());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Partido consultarPartidos(Partido p) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Partido where IdPartido = ?");
        ps.setInt(1,p.getIdPartido());
        ResultSet resultado = ps.executeQuery();
        Partido par;
        if (resultado.next())
        {
            par = new Partido();
            par.setIdPartido(resultado.getInt("IdPartido"));
            par.setIdJor(resultado.getInt("IdJornada"));
            par.setHora(resultado.getDate("Hora").toLocalDate());
            par.setGolesEq1(resultado.getInt("GolesEq1"));
            par.setGolesEq2(resultado.getInt("Goleseq2"));
            par.setIdGanador(resultado.getInt("IdGanador"));
            par.setIdPerdedor(resultado.getByte("IdPerdedor"));
        }
        else
            par = null;
        BaseDatos.cerrarConexion();
        return par;
    }
}
