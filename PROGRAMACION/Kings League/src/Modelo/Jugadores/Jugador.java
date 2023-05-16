package Modelo.Jugadores;

public class Jugador {


    public int IdJug;
    public String PieManoDominante;
    public String TamañoCalzado;
    public String PosicionDraft;
    public String Posicion;
    public String TipoJugador;
    public String DNI;
    public String Nombre;
    public String Apellido1;
    public String Apellido2;
    public String Telefono;
    public String Correo;

    public Jugador(int idJug, String pieManoDominante, String tamañoCalzado, String posicionDraft, String posicion, String tipoJugador, String DNI, String nombre, String apellido1, String apellido2, String telefono, String correo) {

        IdJug = idJug;
        PieManoDominante = pieManoDominante;
        TamañoCalzado = tamañoCalzado;
        PosicionDraft = posicionDraft;
        Posicion = posicion;
        TipoJugador = tipoJugador;
        this.DNI = DNI;
        Nombre = nombre;
        Apellido1 = apellido1;
        Apellido2 = apellido2;
        Telefono = telefono;
        Correo = correo;
    }

    public Jugador() {

    }


    public int getIdJug() {
        return IdJug;
    }

    public void setIdJug(int idJug) {
        IdJug = idJug;
    }

    public String getPieManoDominante() {
        return PieManoDominante;
    }

    public void setPieManoDominante(String pieManoDominante) {
        PieManoDominante = pieManoDominante;
    }

    public String getTamañoCalzado() {
        return TamañoCalzado;
    }

    public void setTamañoCalzado(String tamañoCalzado) {
        TamañoCalzado = tamañoCalzado;
    }

    public String getPosicionDraft() {
        return PosicionDraft;
    }

    public void setPosicionDraft(String posicionDraft) {
        PosicionDraft = posicionDraft;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String posicion) {
        Posicion = posicion;
    }

    public String getTipoJugador() {
        return TipoJugador;
    }

    public void setTipoJugador(String tipoJugador) {
        TipoJugador = tipoJugador;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
