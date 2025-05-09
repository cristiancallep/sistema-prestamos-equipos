package main.java.estudiantes;

public class EstudianteIngenieria extends Estudiante {
    private int semestre;
    private float promedio;

    public EstudianteIngenieria(String cedula, String nombre, String apellido, String telefono,
                                int semestre, float promedio, String serialEquipo) {
        super(cedula, nombre, apellido, telefono, serialEquipo);
        this.semestre = semestre;
        this.promedio = promedio;
    }

    public int getSemestre() { return semestre; }
    public float getPromedio() { return promedio; }

    public void setSemestre(int semestre) { this.semestre = semestre; }
    public void setPromedio(float promedio) { this.promedio = promedio; }

    @Override
    public String toString() {
        return String.format("[Ingenieria] %s %s | Cedula: %s | Semestre: %d | Promedio: %.2f | Serial: %s",
                nombre, apellido, cedula, semestre, promedio, serialEquipo);
    }

    @Override
    public String toFileString() {
        return String.join(",",
                cedula, nombre, apellido, telefono,
                String.valueOf(semestre), String.valueOf(promedio), serialEquipo);
    }
}