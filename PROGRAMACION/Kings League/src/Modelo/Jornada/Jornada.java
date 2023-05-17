package Modelo.Jornada;

import java.time.LocalDate;

public class Jornada {

    public int IdJor;
    public String numero;
    public LocalDate Dia;
    public  String TipoJornada;

    public Jornada(int idJor, String numero, LocalDate dia, String tipoJornada) {
        IdJor = idJor;
        this.numero = numero;
        Dia = dia;
        TipoJornada = tipoJornada;
    }

    public Jornada() {

    }

    public int getIdJor() {
        return IdJor;
    }

    public void setIdJor(int idJor) {
        IdJor = idJor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDia() {
        return Dia;
    }

    public void setDia(LocalDate dia) {
        Dia = dia;
    }

    public String getTipoJornada() {
        return TipoJornada;
    }

    public void setTipoJornada(String tipoJornada) {
        TipoJornada = tipoJornada;
    }
}
