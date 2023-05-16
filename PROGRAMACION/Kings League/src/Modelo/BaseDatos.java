package Modelo;

import java.sql.*;
import java.util.ArrayList;


public class BaseDatos {

    private static Connection con;

    public static void abrirConexion()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");

            String url = "jdbc:oracle:thin:@172.20.225.114:1521:orcl";
            String user = "eqdaw02";
            String passwd = "eqdaw02";
            con = DriverManager.getConnection(url,user,passwd);

        } catch (Exception e)
        {
            System.out.println("Problemas con la base de datos "+e.getClass());
        }
    }

    public static void cerrarConexion()
    {
        try
        {
            con.close();
        } catch (Exception e) {
            System.out.println("Problemas con la base de datos " + e.getClass());
        }
    }

    public static Connection getCon() {
        return con;
    }

    /*Sentencia que devuelve una lista con los nombres de las tablas referentes a la base de datos, al no pertenecer a ninguna tabla en especifico la coloco aqui*/
    public static ArrayList<String> llenarCBTablas(){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT table_name FROM all_tables WHERE upper(owner) = 'EQDAW02' AND upper(table_name) <> 'CAL_XML_RESULTADO'");
            ResultSet rs = ps.executeQuery();
            ArrayList <String> lTablas  = new ArrayList();
            while (rs.next())
            {
                lTablas.add(rs.getString("table_name"));
            }
            BaseDatos.cerrarConexion();

            return lTablas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
