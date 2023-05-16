package Modelo.Staff;

import Modelo.BaseDatos;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TContratoStaff {

    public static void insertar(ContratoStaff cs) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into ContratoStaff values (?,?,?,?)");
        ps.setInt(1, cs.getIdConst());
        ps.setInt(2, cs.getSueldo());
        ps.setDate(3, Date.valueOf(cs.getFechaInicio()));
        ps.setDate(4, Date.valueOf(cs.getFechaFin()));
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(ContratoStaff cs) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from ContratoStaff where IdConst = ?");
        ps.setInt(1, cs.getIdConst());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(ContratoStaff cs) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update ContratoStaff set IdStaff = ?, IdEquipo = ?, Sueldo = ?, FechaInicio = ?, fechaFin = ?  where IdConst = ?");
        ps.setInt(3, cs.getSueldo());
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
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from ContratoStaff where IdConst = ?");
        ps.setInt(1, cs.getIdConst());
        ResultSet resultado = ps.executeQuery();
        ContratoStaff constaff;
        if (resultado.next())
        {
            constaff = new ContratoStaff();
            constaff.setIdConst(resultado.getInt("IdContratoStaff"));
            constaff.setSueldo(resultado.getInt("Sueldo"));
            constaff.setFechaInicio(resultado.getDate("FechaInicio").toLocalDate());
            constaff.setFechaFin(resultado.getDate("FechaFin").toLocalDate());
        }
        else
            constaff = null;
        BaseDatos.cerrarConexion();
        return constaff;
    }
}
