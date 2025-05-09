package main.java.estudiantes;

public abstract class Estudiante {
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String serialEquipo;

    public Estudiante(String cedula, String nombre, String apellido, String telefono, String serialEquipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.serialEquipo = serialEquipo;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public String getSerialEquipo() { return serialEquipo; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setSerialEquipo(String serialEquipo) { this.serialEquipo = serialEquipo; }

    public abstract String toFileString();
}