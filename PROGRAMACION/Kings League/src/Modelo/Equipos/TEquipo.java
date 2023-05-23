package Modelo.Equipos;

import Modelo.BaseDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TEquipo {

    //CRUD
    public static void insertar(Equipo eq) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Equipos(ID_EQUIPO,NOMBRE,COLOR_ESCUDO,EQUIPACION,PRESUPUESTO) values (?,?,?,?,?)");
        ps.setInt(1, eq.getIdEquipo());
        ps.setString(2, eq.getNombre());
        ps.setString(3, eq.getColorEscudo());
        ps.setString(4, eq.getColorEquipacion());
        ps.setInt(5, eq.getPresupuesto());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Equipo eq) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Equipos where Id_Equipo = ?");
        ps.setInt(1, eq.getIdEquipo());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Equipo eq) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Equipos set Nombre = ?, COLOR_ESCUDO = ?, EQUIPACION = ?, Presupuesto = ? where Id_Equipo = ?");
        ps.setString( 1, eq.getNombre());
        ps.setString(2, eq.getColorEscudo());
        ps.setString(3, eq.getColorEquipacion());
        ps.setInt(4, eq.getPresupuesto());
        ps.setInt(5, eq.getIdEquipo());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Equipo consultarEquipos(Equipo eq) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Equipos where Id_Equipo = ?");
        ps.setInt(1, eq.getIdEquipo());
        ResultSet resultado = ps.executeQuery();
        Equipo equipo;
        if (resultado.next())
        {
            equipo = new Equipo();
            equipo.setIdEquipo(resultado.getInt("IdEquipo"));
            equipo.setNombre(resultado.getString("Nombre"));
            equipo.setColorEscudo(resultado.getString("ColorEscudo"));
            equipo.setColorEquipacion(resultado.getString("ColorEquipacion"));
            equipo.setPresupuesto(resultado.getInt("Presupuesto"));
        }
        else
            equipo = null;
        BaseDatos.cerrarConexion();
        return equipo;
    }

    //ComboBoxes
    public static ArrayList<Equipo> llenarCBEquipo(){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT ID_EQUIPO FROM Equipos");
            ResultSet rs = ps.executeQuery();
            ArrayList <Equipo> lEquipo  = new ArrayList();
            Equipo e1 = null;
            while (rs.next())
            {
                e1 = new Equipo();
                e1.setIdEquipo(rs.getInt("ID_EQUIPO"));
                lEquipo.add(e1);
            }
            BaseDatos.cerrarConexion();

            return lEquipo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String nombreEquipo(Equipo eq){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT NOMBRE FROM Equipos WHERE ID_EQUIPO = ?");
            ps.setString(1, String.valueOf(eq.getIdEquipo()));
            ResultSet rs = ps.executeQuery();
            String e1 = null;
            if (rs.next())
            {
                e1 = rs.getString("NOMBRE");
            }
            BaseDatos.cerrarConexion();

            return e1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}