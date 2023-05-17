package Modelo.Usuario;

public class Usuario {

    public int IdUsuario;
    public String Nombre;
    public String Contraseña;
    public String Email;
    public String Telefono;
    public String Admin;

    public Usuario(int idUsuario, String nombre, String contraseña, String email, String telefono, String admin) {
        IdUsuario = idUsuario;
        Nombre = nombre;
        Contraseña = contraseña;
        Email = email;
        Telefono = telefono;
        Admin = admin;
    }

    public Usuario(String nombre, String contraseña) {
        Nombre = nombre;
        Contraseña = contraseña;
    }

    public Usuario() {

    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String admin) {
        Admin = admin;
    }
}
