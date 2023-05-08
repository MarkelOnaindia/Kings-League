package Modelo.Jugadores;

import java.time.LocalDate;

public class ContratoJugador {


    public int Sueldo;
    public LocalDate FechaInicio;
    public LocalDate FechaFin;
    public int Clausula;
    public String Dorsal;

    public ContratoJugador( int sueldo, LocalDate fechaInicio, LocalDate fechaFin, int clausula, String dorsal) {
        Sueldo = sueldo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        Clausula = clausula;
        Dorsal = dorsal;
    }


    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int sueldo) {
        Sueldo = sueldo;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }

    public int getClausula() {
        return Clausula;
    }

    public void setClausula(int clausula) {
        Clausula = clausula;
    }

    public String getDorsal() {
        return Dorsal;
    }

    public void setDorsal(String dorsal) {
        Dorsal = dorsal;
    }
}
