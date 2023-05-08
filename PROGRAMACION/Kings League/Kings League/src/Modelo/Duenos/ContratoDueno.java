package Modelo.Duenos;

import java.time.LocalDate;

public class ContratoDueno {


    public int Sueldo;
    public LocalDate Fechainicio;
    public LocalDate FechaFin;

    public ContratoDueno( int sueldo, LocalDate fechainicio, LocalDate fechaFin) {
        Sueldo = sueldo;
        Fechainicio = fechainicio;
        FechaFin = fechaFin;
    }



    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int sueldo) {
        Sueldo = sueldo;
    }

    public LocalDate getFechainicio() {
        return Fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        Fechainicio = fechainicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }
}
