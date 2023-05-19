package Modelo.Entrenadores;

import Modelo.BaseDatos;
import Modelo.Equipos.Equipo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TContratoEntrena {

    public static void insertar(ContratoEntrena ce) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into ContratosEntrena (SUELDO, FECHA_INI, FECHA_FIN) values (?,?,?)");
        ps.setFloat(1, ce.getSueldo());
        ps.setString(2, ce.getFechaInicio());
        ps.setString(3, ce.getFechaFin());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(ContratoEntrena ce) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from ContratosEntrena where IdConen = ?");
        ps.setInt(1, ce.getIdConen());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(ContratoEntrena ce) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update ContratosEntrena set IdEnt = ?, IdEquipo = ?, Sueldo = ?, Fechainicio = ?, Fechafin = ? where IdConen = ?");
        ps.setFloat(3, ce.getSueldo());
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
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from ContratosEntrena where IdConen = ?");
        ps.setInt(1, ce.getIdConen());
        ResultSet resultado = ps.executeQuery();
        ContratoEntrena conen = null;
        Equipo eq1 = null;
        Entrenador e1 = null;
        if (resultado.next())
        {
            conen = new ContratoEntrena();
            eq1 = new Equipo(resultado.getInt("ID_EQUIPO"));
            e1 = new Entrenador(resultado.getInt("ID_ENT"));

            conen.setIdConen(resultado.getInt("IdConen"));
            conen.setID_ENT(e1);
            conen.setID_EQUIPO(eq1);
            conen.setSueldo(resultado.getInt("Sueldo"));
            conen.setFechaInicio(resultado.getString("FechaInicio"));
            conen.setFechaFin(resultado.getString("FechaFin"));
        }
        else
            conen = null;
        BaseDatos.cerrarConexion();
        return conen;
    }


    //ComboBoxes

    public static ArrayList<ContratoEntrena> llenarCBContratoEntrenador(){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT ID_CONEN FROM ContratosENTRENA");
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

    public static String nenIDCONEN(ContratoEntrena cd){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT ENTRENADORES.NOMBRE AS NombreENTRENADOR FROM ContratosENTRENA JOIN ENTRENADORES ON ContratosENTRENA.ID_ENT = ENTRENADORES.ID_ENT WHERE ContratosENTRENA.ID_ENT = ?");
            ps.setString(1, String.valueOf(cd.getIdConen()));
            ResultSet rs = ps.executeQuery();
            String np = null;
            if (rs.next())
            {
                np = rs.getString("NombreEntrenador");
            }
            BaseDatos.cerrarConexion();

            return np;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static String neIDCONEN(ContratoEntrena cd){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT Equipos.NOMBRE AS NombreEquipo FROM ContratosENTRENA JOIN Equipos ON ContratosENTRENA.ID_EQUIPO = Equipos.ID_EQUIPO WHERE ContratosENTRENA.ID_CONEN = ?");
            ps.setString(1, String.valueOf(cd.getIdConen()));
            ResultSet rs = ps.executeQuery();
            String ne = null;
            if (rs.next())
            {

                ne = rs.getString("NombreEquipo");
            }
            BaseDatos.cerrarConexion();

            return ne;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
