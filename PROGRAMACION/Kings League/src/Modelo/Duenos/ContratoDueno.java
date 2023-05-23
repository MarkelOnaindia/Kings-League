package Modelo.Duenos;

import Modelo.Equipos.Equipo;
import Modelo.Propietario.Propietario;

public class ContratoDueno {

    public int IdCondu;
    public Equipo equipo;
    public Propietario propietario;
    public float Sueldo;
    public String Fechainicio;
    public String FechaFin;

    public ContratoDueno(Equipo equipo, Propietario propietario, float sueldo, String fechainicio, String fechaFin) {
        this.equipo = equipo;
        this.propietario = propietario;
        Sueldo = sueldo;
        Fechainicio = fechainicio;
        FechaFin = fechaFin;
    }

    public ContratoDueno(int idCondu) {
        IdCondu = idCondu;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public ContratoDueno() {

    }

    public ContratoDueno(String id_pro, String id_equipo, String sueldo, String fechaInicio, String fechaFin) {
    }

    public int getIdCondu() {
        return IdCondu;
    }

    public void setIdCondu(int idCondu) {
        IdCondu = idCondu;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float sueldo) {
        Sueldo = sueldo;
    }

    public String getFechainicio() {
        return Fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        Fechainicio = fechainicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }
}
