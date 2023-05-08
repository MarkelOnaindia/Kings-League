package Modelo.Staff;

import java.time.LocalDate;

public class ContratoStaff {

    public  int Sueldo;
    public LocalDate FechaInicio;
    public  LocalDate FechaFin;

    public ContratoStaff(int sueldo, LocalDate fechaInicio, LocalDate fechaFin) {
        Sueldo = sueldo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
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
}

