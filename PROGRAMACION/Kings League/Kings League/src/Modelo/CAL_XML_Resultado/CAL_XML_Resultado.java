package Modelo.CAL_XML_Resultado;

import oracle.sql.CLOB;

public class CAL_XML_Resultado {
    public CLOB Result;
    public String Tipo;

    public CAL_XML_Resultado(CLOB result, String tipo) {
        Result = result;
        Tipo = tipo;
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
