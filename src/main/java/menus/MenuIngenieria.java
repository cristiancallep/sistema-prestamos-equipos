package main.java.menus;

import main.java.estudiantes.EstudianteIngenieria;
import main.java.validaciones.Validaciones;
import javax.swing.*;
import java.util.List;

public class MenuIngenieria {
    private final List<EstudianteIngenieria> estudiantes;

    public MenuIngenieria(List<EstudianteIngenieria> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void mostrar() {
        boolean volver = false;
        while (!volver) {
            String opcion = JOptionPane.showInputDialog(crearMenu());

            if (opcion == null) {
                volver = true;
                continue;
            }

            switch (opcion) {
                case "1":
                    registrarEstudiante();
                    break;
                case "2":
                    modificarEstudiante();
                    break;
                case "3":
                    eliminarEstudiante();
                    break;
                case "4":
                    buscarEstudiante();
                    break;
                case "5":
                    volver = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String crearMenu() {
        return """
            INGENIERÍA - Submenú:
            1. Registrar préstamo
            2. Modificar préstamo
            3. Devolver equipo
            4. Buscar equipo
            5. Volver
            Ingrese su opción:""";
    }

    private void registrarEstudiante() {
        String cedula = Validaciones.validarNumero("Ingrese la cédula:");
        if (cedula == null) return;

        if (estudiantes.stream().anyMatch(e -> e.getCedula().equals(cedula))) {
            JOptionPane.showMessageDialog(null, "Ya existe un estudiante con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = Validaciones.validarTexto("Ingrese el nombre:");
        if (nombre == null) return;

        String apellido = Validaciones.validarTexto("Ingrese el apellido:");
        if (apellido == null) return;

        String telefono = Validaciones.validarTelefono("Ingrese el teléfono:");
        if (telefono == null) return;

        String semestreStr = Validaciones.validarNumero("Ingrese el semestre actual:");
        if (semestreStr == null) return;
        int semestre = Integer.parseInt(semestreStr);

        float promedio = Validaciones.validarFloat("Ingrese el promedio acumulado:");
        if (promedio == -1) return;

        String serial = Validaciones.validarSerial("Ingrese el serial del equipo:");
        if (serial == null) return;

        if (estudiantes.stream().anyMatch(e -> e.getSerialEquipo().equals(serial))) {
            JOptionPane.showMessageDialog(null, "Ya hay un equipo con ese serial registrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        estudiantes.add(new EstudianteIngenieria(cedula, nombre, apellido, telefono, semestre, promedio, serial));
        JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void modificarEstudiante() {
        String cedula = Validaciones.validarNumero("Ingrese la cédula del estudiante a modificar:");
        if (cedula == null) return;

        estudiantes.stream()
                .filter(e -> e.getCedula().equals(cedula))
                .findFirst()
                .ifPresentOrElse(estudiante -> {
                    estudiante.setNombre(Validaciones.validarTexto("Nuevo nombre:"));
                    estudiante.setApellido(Validaciones.validarTexto("Nuevo apellido:"));
                    estudiante.setTelefono(Validaciones.validarTelefono("Nuevo teléfono:"));

                    String semestreStr = Validaciones.validarNumero("Nuevo semestre:");
                    if (semestreStr != null) {
                        estudiante.setSemestre(Integer.parseInt(semestreStr));
                    }

                    float promedio = Validaciones.validarFloat("Nuevo promedio:");
                    if (promedio != -1) {
                        estudiante.setPromedio(promedio);
                    }

                    JOptionPane.showMessageDialog(null, "Estudiante modificado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }, () -> JOptionPane.showMessageDialog(null, "No se encontró estudiante con esa cédula", "Error", JOptionPane.ERROR_MESSAGE));
    }

    private void eliminarEstudiante() {
        String cedula = Validaciones.validarNumero("Ingrese la cédula del estudiante a eliminar:");
        if (cedula == null) return;

        if (estudiantes.removeIf(e -> e.getCedula().equals(cedula))) {
            JOptionPane.showMessageDialog(null, "Estudiante eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró estudiante con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarEstudiante() {
        String cedula = Validaciones.validarNumero("Ingrese la cédula del estudiante a buscar:");
        if (cedula == null) return;

        estudiantes.stream()
                .filter(e -> e.getCedula().equals(cedula))
                .findFirst()
                .ifPresentOrElse(estudiante -> JOptionPane.showMessageDialog(null, estudiante.toString(), "Información del Estudiante", JOptionPane.INFORMATION_MESSAGE), () -> JOptionPane.showMessageDialog(null, "No se encontró estudiante con esa cédula", "Error", JOptionPane.ERROR_MESSAGE));
    }
}