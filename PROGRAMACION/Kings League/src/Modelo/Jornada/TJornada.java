package Modelo.Jornada;

import  Modelo.BaseDatos;
import Modelo.Temporada.Temporada;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TJornada {

    public static void insertar(Jornada jo) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Jornadas(ID_JOR,NUMERO,Dia,TIPO) values (?,?,?,?)");
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
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Jornadas where Id_Jor = ?");
        ps.setInt(1, jo.getIdJor());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Jornada jo) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Jornadas set NUMERO = ?, Dia = ?, TIPO = ? where Id_Jor = ?");
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
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Jornadas where Id_Jor = ?");
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

    public static ArrayList<Jornada> llenarCBJornadas(int ID_TEMP){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT numero FROM Jornadas where id_temp = ?");
            ps.setInt(1, ID_TEMP);
            ResultSet rs = ps.executeQuery();
            ArrayList <Jornada> lJornada  = new ArrayList();
            Jornada j1 = null;
            while (rs.next())
            {
                j1 = new Jornada();
                j1.setNumero(rs.getString("numero"));
                lJornada.add(j1);
            }
            BaseDatos.cerrarConexion();

            return lJornada;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
