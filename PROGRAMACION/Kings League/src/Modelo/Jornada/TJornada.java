package Modelo.Jornada;

import Modelo.BaseDatos;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TJornada {

    public static void insertar(Jornada jo) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Jornada values (?,?,?,?)");
        ps.setInt(1, jo.getIdJor());
        ps.setString(2, jo.getNumero());
        ps.setDate(3, Date.valueOf(jo.getDia()));
        ps.setString(4, jo.getTipoJornada());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Jornada jo) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Jornada where IdJor = ?");
        ps.setInt(1, jo.getIdJor());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Jornada jo) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Jornada set Numero = ?, Dia = ?, Tipo = ? where IdJor = ?");
        ps.setString( 1, jo.getNumero());
        ps.setDate(2, Date.valueOf(jo.getDia()));
        ps.setString(3, jo.getTipoJornada());
        ps.setInt(4, jo.getIdJor());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Jornada consultarJornadas(Jornada jo) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Jornada where IdJor = ?");
        ps.setInt(1, jo.getIdJor());
        ResultSet resultado = ps.executeQuery();
        Jornada jor;
        if (resultado.next())
        {
            jor = new Jornada();
            jor.setIdJor(resultado.getInt("IdJornada"));
            jor.setNumero(resultado.getString("Numero"));
            jor.setDia(resultado.getDate("Dia").toLocalDate());
            jor.setTipoJornada(resultado.getString("TipoJornada"));
        }
        else
            jor = null;
        BaseDatos.cerrarConexion();
        return jor;
    }
}
