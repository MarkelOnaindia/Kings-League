package Modelo.Duenos;

import Modelo.BaseDatos;
import Modelo.Equipos.Equipo;
import Modelo.Propietario.Propietario;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TContratoDueno {


    //CRUD
    public static void insertar(ContratoDueno cd) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("INSERT INTO ContratoDueno (ID_PRO, ID_EQUIPO, SUELDO, FECHA_INI, FECHA_FIN) VALUES (?,?,?,?,?)");
        ps.setInt(1,cd.getPropietario().getIdPro());
        ps.setFloat(2,cd.getEquipo().getIdEquipo());
        ps.setFloat(3,cd.getSueldo());
        ps.setString(4,cd.getFechainicio());
        ps.setString(5,cd.getFechaFin());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(ContratoDueno cd) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from ContratoDueno where Id_Condu = ?");
        ps.setInt(1, cd.getIdCondu());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(ContratoDueno cd) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update ContratoDueno set IdPropietario = ?, IdJugador = ?, Sueldo = ?, Fechainicio = ?, Fechafin = ? where IdCondu = ?");
        ps.setFloat(3, cd.getSueldo());
        ps.setDate(4, Date.valueOf(cd.getFechainicio()));
        ps.setDate(5, Date.valueOf(cd.getFechaFin())); //clases de java
        ps.setInt(6, cd.getIdCondu());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static ContratoDueno consultarContratoDueno(ContratoDueno cd) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from ContratoDueno where Id_Condu = ?");
        ps.setInt(1,cd.getIdCondu());
        ResultSet resultado = ps.executeQuery();
        ContratoDueno condu = null;
        Equipo eq1 = null;
        Propietario pro1 = null;
        if (resultado.next())
        {
            condu = new ContratoDueno();
            eq1 = new Equipo(resultado.getInt("ID_EQUIPO"));
            pro1 = new Propietario(resultado.getInt("ID_PRO"));

            condu.setIdCondu(resultado.getInt("Id_Condu"));
            condu.setPropietario(pro1);
            condu.setEquipo(eq1);
            condu.setSueldo(resultado.getInt("Sueldo"));
            condu.setFechainicio(resultado.getString("Fecha_ini"));
            condu.setFechaFin(resultado.getString("Fecha_fin"));
        }
        else
            condu = null;
        BaseDatos.cerrarConexion();
        return condu;
    }


    //ComboBoxes
    public static ArrayList<ContratoDueno> llenarCBContratoDueno(){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT ID_CONDU FROM CONTRATODUENO");
            ResultSet rs = ps.executeQuery();
            ArrayList <ContratoDueno> lContratoDueno  = new ArrayList();
            ContratoDueno cd1 = null;
            while (rs.next())
            {
                cd1 = new ContratoDueno();
                cd1.setIdCondu(rs.getInt("ID_CONDU"));
                lContratoDueno.add(cd1);
            }
            BaseDatos.cerrarConexion();

            return lContratoDueno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String npIDCONDU(ContratoDueno cd){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT Propietario.NOMBRE AS NombrePropietario FROM ContratoDueno JOIN Propietario ON ContratoDueno.ID_PRO = Propietario.ID_PRO WHERE ContratoDueno.ID_CONDU = ?");
            ps.setString(1, String.valueOf(cd.getIdCondu()));
            ResultSet rs = ps.executeQuery();
            String np = null;
            if (rs.next())
            {
                np = rs.getString("NombrePropietario");
            }
            BaseDatos.cerrarConexion();

            return np;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static String neIDCONDU(ContratoDueno cd){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT Equipo.NOMBRE AS NombreEquipo FROM ContratoDueno JOIN Equipo ON ContratoDueno.ID_EQUIPO = Equipo.ID_EQUIPO WHERE ContratoDueno.ID_CONDU = ?");
            ps.setString(1, String.valueOf(cd.getIdCondu()));
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
