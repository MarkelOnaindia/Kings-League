package Modelo.Duenos;

import Modelo.BaseDatos;

import java.sql.PreparedStatement;

public class TContratoDueno {
    public static void insertar(ContratoDueno d) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into ContratoDueno values (?,?,?)");
        ps.setInt(1,d.getSueldo());
        ps.setDate(2, d.getFechainicio());
        ps.setString(3,d.getFechaFin());
        //ps.setString(3,"ww"); Si llegamos con un dni que no existe, se produce una excepción sql.
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

}
