package Modelo.Partido;

import java.time.LocalDate;

public class Partido {
    public LocalDate Hora;
    public int GolesEq1;
    public  int GolesEq2;
    public int IdGanador;

    public Partido(LocalDate hora, int golesEq1, int golesEq2, int idGanador) {
        Hora = hora;
        GolesEq1 = golesEq1;
        GolesEq2 = golesEq2;
        IdGanador = idGanador;
    }

    public LocalDate getHora() {
        return Hora;
    }

    public void setHora(LocalDate hora) {
        Hora = hora;
    }

    public int getGolesEq1() {
        return GolesEq1;
    }

    public void setGolesEq1(int golesEq1) {
        GolesEq1 = golesEq1;
    }

    public int getGolesEq2() {
        return GolesEq2;
    }

    public void setGolesEq2(int golesEq2) {
        GolesEq2 = golesEq2;
    }

    public int getIdGanador() {
        return IdGanador;
    }

    public void setIdGanador(int idGanador) {
        IdGanador = idGanador;
    }
}
