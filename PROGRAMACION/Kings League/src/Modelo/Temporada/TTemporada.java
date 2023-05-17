package Modelo.Temporada;

import Modelo.BaseDatos;
import Modelo.Staff.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TTemporada {

    public static void insertar(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Temporada values (?,?,?)");
        ps.setInt(1, t.getIdTemp());
        ps.setString(2, t.getTipo());
        ps.setString(3, t.getEstado());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Temporada where IdTemp = ?");
        ps.setInt(1, t.getIdTemp());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Temporada set Tipo = ?, Estado = ? where IdTemp = ?");
        ps.setString(1, t.getTipo());
        ps.setString(2, t.getEstado());
        ps.setInt(3, t.getIdTemp());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Temporada consultarTemporada(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Temporada where IdTemp = ?");
        ps.setInt(1, t.getIdTemp());
        ResultSet resultado = ps.executeQuery();
        Temporada temp;
        if (resultado.next())
        {
            temp = new Temporada();
            temp.setIdTemp(resultado.getInt("IdTemporada"));
            temp.setTipo(resultado.getString("Tipo"));
            temp.setEstado(resultado.getString("Estado"));
        }
        else
            temp = null;
        BaseDatos.cerrarConexion();
        return temp;
    }
}
