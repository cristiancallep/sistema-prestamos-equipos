package main.java.estudiantes;

public class EstudianteDiseno extends Estudiante {
    private String modalidad;
    private int numAsignaturas;

    public EstudianteDiseno(String cedula, String nombre, String apellido, String telefono,
                            String modalidad, int numAsignaturas, String serialEquipo) {
        super(cedula, nombre, apellido, telefono, serialEquipo);
        this.modalidad = modalidad;
        this.numAsignaturas = numAsignaturas;
    }

    public String getModalidad() { return modalidad; }
    public int getNumAsignaturas() { return numAsignaturas; }

    public void setModalidad(String modalidad) { this.modalidad = modalidad; }
    public void setNumAsignaturas(int numAsignaturas) { this.numAsignaturas = numAsignaturas; }

    @Override
    public String toString() {
        return String.format("[Diseño] %s %s | Cedula: %s | Modalidad: %s | Asignaturas: %d | Serial: %s",
                nombre, apellido, cedula, modalidad, numAsignaturas, serialEquipo);
    }

    @Override
    public String toFileString() {
        return String.join(",",
                cedula, nombre, apellido, telefono,
                modalidad, String.valueOf(numAsignaturas), serialEquipo);
    }
}