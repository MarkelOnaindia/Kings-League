package Modelo.CAL_XML_Resultado;

import oracle.sql.CLOB;

public class CAL_XML_Resultado {

    public int IdXML;
    public CLOB Result;
    public String Tipo;

    public CAL_XML_Resultado(int idXML, CLOB result, String tipo) {
        IdXML = idXML;
        Result = result;
        Tipo = tipo;
    }

    public CAL_XML_Resultado() {

    }

    public int getIdXML() {
        return IdXML;
    }

    public void setIdXML(int idXML) {
        IdXML = idXML;
    }

    public CLOB getResult() {
        return Result;
    }

    public void setResult(CLOB result) {
        Result = result;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
