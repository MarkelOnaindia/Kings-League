package Modelo.Propietario;

import Modelo.BaseDatos;
import Modelo.Equipos.Equipo;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TPropietario {


    //CRUD
    public static void insertar(Propietario pro) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Propietario values (?,?,?,?,?,?,?)");
        ps.setInt(1,pro.getIdPro());
        ps.setString(2,pro.getDNI() );
        ps.setString(3, pro.getNombre());
        ps.setString(4, pro.getApellido1());
        ps.setString(5, pro.getApellido2());
        ps.setString(6, pro.getTelefono());
        ps.setString(7,pro.getCorreo());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Propietario pro) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Propietario where IdPro = ?");
        ps.setInt(1, pro.getIdPro());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Propietario pro) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Propietario set DNI = ?, Nombre = ?, Apellido1 = ?, Apellido2 = ?, Telefono = ?, " +
                " Correo = ?  where IdPro = ?");
        ps.setString(1, pro.getDNI());
        ps.setString(2, pro.getNombre());
        ps.setString(3, pro.getApellido1());
        ps.setString(4, pro.getApellido2());
        ps.setString(5, pro.getTelefono());
        ps.setString(6, pro.getCorreo());
        ps.setInt(7, pro.getIdPro());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Propietario consultarPropietarios(Propietario pro) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Propietario where IdPro = ?");
        ps.setInt(1, pro.getIdPro());
        ResultSet resultado = ps.executeQuery();
        Propietario prop;
        if (resultado.next())
        {
            prop = new Propietario();
            prop.setIdPro(resultado.getInt("IdPropietario"));
            prop.setDNI(resultado.getString("DNI"));
            prop.setNombre(resultado.getString("Nombre"));
            prop.setApellido1(resultado.getString("Apellido1"));
            prop.setApellido2(resultado.getString("Apellido2"));
            prop.setTelefono(resultado.getString("Telefono"));
            prop.setCorreo(resultado.getString("Correo"));
        }
        else
            prop = null;
        BaseDatos.cerrarConexion();
        return prop;
    }

    //ComboBoxes
    public static ArrayList<Propietario> llenarCBPropietario(){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT ID_PRO, NOMBRE FROM PROPIETARIO");
            ResultSet rs = ps.executeQuery();
            ArrayList <Propietario> lPropietario  = new ArrayList();
            Propietario p1 = null;
            while (rs.next())
            {
                p1 = new Propietario();
                p1.setIdPro(rs.getInt("ID_PRO"));
                p1.setNombre(rs.getString("NOMBRE"));
                lPropietario.add(p1);
            }
            BaseDatos.cerrarConexion();

            return lPropietario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String nombrePropietario(Propietario pr) {
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT NOMBRE FROM PROPIETARIO WHERE ID_PRO = ?");
            ps.setString(1, String.valueOf(pr.getIdPro()));
            ResultSet rs = ps.executeQuery();
            String p1 = null;
            if (rs.next()) {
                p1 = rs.getString("NOMBRE");
            }
            BaseDatos.cerrarConexion();

            return p1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
