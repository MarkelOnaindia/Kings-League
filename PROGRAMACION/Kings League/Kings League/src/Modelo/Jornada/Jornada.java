package Modelo.Jornada;

import java.time.LocalDate;

public class Jornada {
    public String numero;
    public LocalDate Dia;
    public  String Tipo;

    public Jornada(String numero, LocalDate dia, String tipo) {
        this.numero = numero;
        Dia = dia;
        Tipo = tipo;
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
