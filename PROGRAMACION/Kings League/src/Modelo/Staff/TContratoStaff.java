package Modelo.Staff;

import Modelo.BaseDatos;
import Modelo.Equipos.Equipo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TContratoStaff {

    public static void insertar(ContratoStaff cs) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into ContratosStaff (ID_STAFF, ID_EQUIPO, SUELDO, FECHA_INI, FECHA_FIN,) values (?,?,?,?,?)");
        ps.setInt(1, cs.getID_STAFF().getIdStaff());
        ps.setInt(2, cs.getID_EQUIPO().getIdEquipo());
        ps.setFloat(3, cs.getSueldo());
        ps.setDate(4, Date.valueOf(cs.getFechaInicio()));
        ps.setDate(5, Date.valueOf(cs.getFechaFin()));
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(ContratoStaff cs) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from ContratosStaff where Id_Const = ?");
        ps.setInt(1, cs.getIdConst());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(ContratoStaff cs) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update ContratosStaff set Id_Staff = ?, Id_Equipo = ?, Sueldo = ?, Fecha_ini = ?, fecha_Fin = ?  where Id_Const = ?");
        ps.setFloat(3, cs.getSueldo());
        ps.setDate(4, Date.valueOf(cs.getFechaInicio()));
        ps.setDate(5, Date.valueOf(cs.getFechaFin()));
        ps.setInt(6, cs.getIdConst());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static ContratoStaff consultarContratoStaff(ContratoStaff cs) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from ContratosStaff where Id_Const = ?");
        ps.setInt(1, cs.getIdConst());
        ResultSet resultado = ps.executeQuery();
        ContratoStaff constaff = null;
        Equipo eq1 = null;
        Staff stf1 = null;
        if (resultado.next())
        {
            constaff = new ContratoStaff();
            eq1 = new Equipo(resultado.getInt("ID_EQUIPO"));
            stf1 = new Staff(resultado.getInt("ID_STAFF"));

            constaff.setIdConst(resultado.getInt("IdConst"));
            constaff.setID_STAFF(stf1);
            constaff.setID_EQUIPO(eq1);
            constaff.setSueldo(resultado.getInt("Sueldo"));
            constaff.setFechaInicio(resultado.getString("FechaInicio"));
            constaff.setFechaFin(resultado.getString("FechaFin"));
        }
        else
            constaff = null;
        BaseDatos.cerrarConexion();
        return constaff;
    }
}