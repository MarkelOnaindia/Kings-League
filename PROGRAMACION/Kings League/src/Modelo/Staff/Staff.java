package Modelo.Staff;

public class Staff {

    public int IdStaff;
    public String DNI;
    public String Nombre;
    public String Apellido1;
    public String Apellido2;
    public String Telefono;
    public String Correo;
    public String Rol;

    public Staff(int idStaff, String DNI, String nombre, String apellido1, String apellido2, String telefono, String correo, String rol) {
        IdStaff = idStaff;
        this.DNI = DNI;
        Nombre = nombre;
        Apellido1 = apellido1;
        Apellido2 = apellido2;
        Telefono = telefono;
        Correo = correo;
        Rol = rol;
    }

    public Staff() {

    }

    public int getIdStaff() {
        return IdStaff;
    }

    public void setIdStaff(int idStaff) {
        IdStaff = idStaff;
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

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }
}
