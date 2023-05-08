package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;


public class BaseDatos {

    private static Connection con;

    public static void abrirConexion()
    {
        try
        {
            Class.forName("oracle.jdbc. OracleDriver ");

            String url = "jdbc:oracle:thin:@172.20.225.114:1521:orcl";
            String user = "eqdaw02";
            String passwd = "eqdaw02";
            con = DriverManager.getConnection (url, user, passwd);

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
}
