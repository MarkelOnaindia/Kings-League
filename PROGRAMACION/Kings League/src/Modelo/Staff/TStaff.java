package Modelo.Staff;

import Modelo.BaseDatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TStaff {

    public static void insertar(Staff stf) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Staffs values (?,?,?,?,?,?,?,?)");
        ps.setInt(1, stf.getIdStaff());
        ps.setString(2, stf.getDNI());
        ps.setString(3, stf.getNombre());
        ps.setString(4, stf.getApellido1());
        ps.setString(5, stf.getApellido2());
        ps.setString(6, stf.getTelefono());
        ps.setString(7, stf.getCorreo());
        ps.setString(8, stf.getRol());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Staff stf) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Staffs where IdStaff = ?");
        ps.setInt(1, stf.getIdStaff());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Staff stf) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Staffs set DNI = ?, Nombre = ?, Apellido1 = ?, Apellido2 = ?, Telefono = ?, Correo = ?, Rol = ?  where IdStaff = ?");
        ps.setString(1,stf.getDNI() );
        ps.setString(2, stf.getNombre());
        ps.setString(3, stf.getApellido1());
        ps.setString(4, stf.getApellido2());
        ps.setString(5, stf.getTelefono());
        ps.setString(6, stf.getCorreo());
        ps.setString(7, stf.getRol());
        ps.setInt(8, stf.getIdStaff());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Staff consultarStaff(Staff stf) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Staffs where IdStaff = ?");
        ps.setInt(1, stf.getIdStaff());
        ResultSet resultado = ps.executeQuery();
        Staff staff;
        if (resultado.next())
        {
            staff = new Staff();
            staff.setIdStaff(resultado.getInt("IdStaff"));
            staff.setDNI(resultado.getString("DNI"));
            staff.setNombre(resultado.getString("Nombre"));
            staff.setApellido1(resultado.getString("Apellido1"));
            staff.setApellido2(resultado.getString("Apellido2"));
            staff.setTelefono(resultado.getString("Telefono"));
            staff.setCorreo(resultado.getString("Correo"));
            staff.setRol(resultado.getString("Rol"));
        }
        else
            staff = null;
        BaseDatos.cerrarConexion();
        return staff;
    }
}
