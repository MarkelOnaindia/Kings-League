package Modelo.Entrenadores;

import Modelo.BaseDatos;
import Modelo.Duenos.ContratoDueno;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TContratoEntrena {

    public static void insertar(ContratoEntrena ce) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("INSERT INTO ContratoEntrena (ID_ENT, ID_EQUIPO," +
                " Sueldo, Fecha_ini, Fecha_fin) VALUES (?, ?, ?, ?, ?)");
        ps.setInt(1, ce.getIdConen());
        ps.setInt(2, ce.getSueldo());
        ps.setDate(3, Date.valueOf(ce.getFechaInicio()));
        ps.setDate(4, Date.valueOf(ce.getFechaFin()));
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(ContratoEntrena ce) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from ContratoEntrena where IdConen = ?");
        ps.setInt(1, ce.getIdConen());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(ContratoEntrena ce) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update ContratoEntrena set IdEnt = ?, IdEquipo = ?, Sueldo = ?, Fechainicio = ?, Fechafin = ? where IdConen = ?");
        ps.setInt(3, ce.getSueldo());
        ps.setDate(4, Date.valueOf(ce.getFechaInicio()));
        ps.setDate(5, Date.valueOf(ce.getFechaFin()));
        ps.setInt(6, ce.getIdConen());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static ContratoEntrena consultarContratosEntrena(ContratoEntrena ce) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from ContratoEntrena where IdConen = ?");
        ps.setInt(1, ce.getIdConen());
        ResultSet resultado = ps.executeQuery();
        ContratoEntrena conen;
        if (resultado.next())
        {
            conen = new ContratoEntrena();
            conen.setIdConen(resultado.getInt("IdConen"));
            conen.setSueldo(resultado.getInt("Sueldo"));
            conen.setFechaInicio(resultado.getDate("FechaInicio").toLocalDate());
            conen.setFechaFin(resultado.getDate("FechaFin").toLocalDate());
        }
        else
            conen = null;
        BaseDatos.cerrarConexion();
        return conen;
    }

    public static ArrayList<ContratoEntrena> llenarCBContratoEntrenador(){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT ID_CONEN FROM CONTRATOENTRENA");
            ResultSet rs = ps.executeQuery();
            ArrayList <ContratoEntrena> lContratoEntrena  = new ArrayList();
            ContratoEntrena cd1 = null;
            while (rs.next())
            {
                cd1 = new ContratoEntrena();
                cd1.setIdConen(rs.getInt("ID_CONEN"));
                lContratoEntrena.add(cd1);
            }
            BaseDatos.cerrarConexion();

            return lContratoEntrena;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
