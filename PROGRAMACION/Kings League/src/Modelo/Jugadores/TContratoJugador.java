package Modelo.Jugadores;

import Modelo.BaseDatos;
import Modelo.Entrenadores.ContratoEntrena;
import Modelo.Equipos.Equipo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TContratoJugador {

    public static void insertar(ContratoJugador cj) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into ContratosJugador (ID_JUG, ID_EQUIPO, SUELDO, FECHA_INI, FECHA_FIN, CLAUSULA, DORSAL) values (?,?,?,?,?,?,?)");
        ps.setInt(1, cj.getID_JUG().getIdJug());
        ps.setInt(2, cj.getID_EQUIPO().getIdEquipo());
        ps.setFloat(3, cj.getSueldo());
        ps.setDate(4, Date.valueOf(cj.getFechaInicio()));
        ps.setDate(5, Date.valueOf(cj.getFechaFin()));
        ps.setInt(6, cj.getClausula());
        ps.setString(7, cj.getDorsal());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(ContratoJugador cj) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from ContratosJugador where Id_Conju = ?");
        ps.setInt(1, cj.getIdConju());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(ContratoJugador cj) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update ContratosJugador set Id_Equipo = ?, Id_Jug = ?, Sueldo = ?, Fecha_ini = ?, Fecha_Fin = ?, Clausula = ?, Dorsal = ? where Id_Conju = ?");
        ps.setFloat( 3, cj.getSueldo());
        ps.setDate(4, Date.valueOf(cj.getFechaInicio()));
        ps.setDate(5, Date.valueOf(cj.getFechaFin()));
        ps.setInt(6, cj.getClausula());
        ps.setString(7, cj.getDorsal());
        ps.setInt(8,cj.getIdConju());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static ContratoJugador consultarContratosJugadores(ContratoJugador cj) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from ContratosJugador where Id_Conju = ?");
        ps.setInt(1, cj.getIdConju());
        ResultSet resultado = ps.executeQuery();
        ContratoJugador conju = null;
        Equipo eq1 = null;
        Jugador j1 = null;
        if (resultado.next())
        {
            conju = new ContratoJugador();
            eq1 = new Equipo(resultado.getInt("ID_EQUIPO"));
            j1 = new Jugador(resultado.getInt("ID_JUG"));

            conju.setIdConju(resultado.getInt("Id_Conju"));
            conju.setID_JUG(j1);
            conju.setID_EQUIPO(eq1);
            conju.setSueldo(resultado.getInt("Sueldo"));
            conju.setFechaInicio(resultado.getString("fecha_ini"));
            conju.setFechaFin(resultado.getString("fecha_fin"));
            conju.setClausula(resultado.getInt("Clausula"));
            conju.setDorsal(resultado.getString("Dorsal"));
        }
        else
            conju = null;
        BaseDatos.cerrarConexion();
        return conju;
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