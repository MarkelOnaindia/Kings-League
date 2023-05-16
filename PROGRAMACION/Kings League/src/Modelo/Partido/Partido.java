package Modelo.Partido;

import java.time.LocalDate;

public class Partido {

    public int IdPartido;
    public int IdJor;
    public LocalDate Hora;
    public int GolesEq1;
    public  int GolesEq2;
    public int IdGanador;
    public int IdPerdedor;

    public Partido(int idPartido, int idJor, LocalDate hora, int golesEq1, int golesEq2, int idGanador, int idPerdedor) {
        IdPartido = idPartido;
        IdJor = idJor;
        Hora = hora;
        GolesEq1 = golesEq1;
        GolesEq2 = golesEq2;
        IdGanador = idGanador;
        IdPerdedor = idPerdedor;
    }

    public Partido() {

    }

    public int getIdPartido() {
        return IdPartido;
    }

    public void setIdPartido(int idPartido) {
        IdPartido = idPartido;
    }

    public int getIdJor() {
        return IdJor;
    }

    public void setIdJor(int idJor) {
        IdJor = idJor;
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

    public int getIdPerdedor() {
        return IdPerdedor;
    }

    public void setIdPerdedor(int idPerdedor) {
        IdPerdedor = idPerdedor;
    }
}
