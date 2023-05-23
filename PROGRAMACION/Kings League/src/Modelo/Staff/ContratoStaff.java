package Modelo.Staff;

import Modelo.Equipos.Equipo;

public class ContratoStaff {

    public int IdConst;
    public Staff ID_STAFF;
    public Equipo ID_EQUIPO;
    public  float Sueldo;
    public String FechaInicio;
    public  String FechaFin;

    public ContratoStaff(Staff ID_STAFF, Equipo ID_EQUIPO, float sueldo, String fechaInicio, String fechaFin) {
        this.ID_STAFF = ID_STAFF;
        this.ID_EQUIPO = ID_EQUIPO;
        Sueldo = sueldo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
    }

    public ContratoStaff() {
    }

    public int getIdConst() {
        return IdConst;
    }

    public void setIdConst(int idConst) {
        IdConst = idConst;
    }

    public Staff getID_STAFF() {
        return ID_STAFF;
    }

    public void setID_STAFF(Staff ID_STAFF) {
        this.ID_STAFF = ID_STAFF;
    }

    public Equipo getID_EQUIPO() {
        return ID_EQUIPO;
    }

    public void setID_EQUIPO(Equipo ID_EQUIPO) {
        this.ID_EQUIPO = ID_EQUIPO;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float sueldo) {
        Sueldo = sueldo;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }
}

