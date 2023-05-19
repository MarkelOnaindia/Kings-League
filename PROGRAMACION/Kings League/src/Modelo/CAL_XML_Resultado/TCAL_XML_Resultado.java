package Modelo.CAL_XML_Resultado;

import Modelo.BaseDatos;
import Modelo.Usuario.Usuario;
import oracle.sql.CLOB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TCAL_XML_Resultado {

    public static void insertar(CAL_XML_Resultado xml) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into CAL_XML_Resultados values (?,?,?)");
        ps.setInt(1, xml.getIdXML());
        ps.setClob(2, xml.getResult());
        ps.setString(3, xml.getTipo());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(CAL_XML_Resultado xml) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from CAL_XML_Resultados where IdXML = ?");
        ps.setInt(1, xml.getIdXML());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(CAL_XML_Resultado xml) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update CAL_XML_Resultados set Result = ?, Tipo = ? where IdXML = ?");
        ps.setClob(1, xml.getResult());
        ps.setString(2, xml.getTipo());
        ps.setInt(3, xml.getIdXML());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static CAL_XML_Resultado consultarXML(CAL_XML_Resultado xml) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from CAL_XML_Resultados where IdXML = ?");
        ps.setInt(1, xml.getIdXML());
        ResultSet resultado = ps.executeQuery();
        CAL_XML_Resultado calXml;
        if (resultado.next())
        {
            calXml = new CAL_XML_Resultado();
            calXml.setIdXML(resultado.getInt("IdXML"));
            calXml.setResult((CLOB) resultado.getClob("Result"));
            calXml.setTipo(resultado.getString("Tipo"));
        }
        else
            calXml = null;
        BaseDatos.cerrarConexion();
        return calXml;
    }
}
