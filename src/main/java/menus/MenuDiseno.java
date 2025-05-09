package main.java.menus;

import main.java.estudiantes.EstudianteDiseno;
import main.java.estudiantes.EstudianteIngenieria;
import main.java.persistencia.GestorEquipos;
import main.java.validaciones.Validaciones;
import javax.swing.*;
import java.util.List;

public class MenuDiseno {
    private final List<EstudianteDiseno> estudiantes;
    private final List<EstudianteIngenieria> ingenieros;
    private final GestorEquipos gestorEquipos;
    public MenuDiseno(List<EstudianteDiseno> estudiantes, List<EstudianteIngenieria> ingenieros, GestorEquipos gestorEquipos) {
        this.estudiantes = estudiantes;
        this.ingenieros = ingenieros;
        this.gestorEquipos = gestorEquipos;
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
            DISEÑO - Submenú:
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

        String modalidad = Validaciones.seleccionarOpcion("Modalidad", "Seleccione la modalidad:",
                new String[]{"Virtual", "Presencial"});
        if (modalidad == null) return;

        String asignaturasStr = Validaciones.validarNumero("Ingrese cantidad de asignaturas:");
        if (asignaturasStr == null) return;
        int asignaturas = Integer.parseInt(asignaturasStr);

        String serial = Validaciones.validarSerial("Ingrese el serial del equipo:");
        if (serial == null) return;

        // Validar que no esté ya prestado
        if (estudiantes.stream().anyMatch(e -> e.getSerialEquipo().equals(serial)) ||
                ingenieros.stream().anyMatch(i -> i.getSerialEquipo().equals(serial))) {
            JOptionPane.showMessageDialog(null, "El equipo ya está prestado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que exista y sea tableta (para diseño)
        if (!gestorEquipos.existeTableta(serial)) {
            JOptionPane.showMessageDialog(null,
                    "No existe una tableta con ese serial o está asignada a ingeniería",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        estudiantes.add(new EstudianteDiseno(cedula, nombre, apellido, telefono, modalidad, asignaturas, serial));
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

                    String modalidad = Validaciones.seleccionarOpcion("Modalidad", "Seleccione nueva modalidad:",
                            new String[]{"Virtual", "Presencial"});
                    if (modalidad != null) {
                        estudiante.setModalidad(modalidad);
                    }

                    String asignaturasStr = Validaciones.validarNumero("Nueva cantidad de asignaturas:");
                    if (asignaturasStr != null) {
                        estudiante.setNumAsignaturas(Integer.parseInt(asignaturasStr));
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
                .ifPresentOrElse(estudiante -> JOptionPane.showMessageDialog(null, estudiante.toString(),
                        "Información del Estudiante", JOptionPane.INFORMATION_MESSAGE),
                        () -> JOptionPane.showMessageDialog(null,
                                "No se encontró estudiante con esa cédula", "Error", JOptionPane.ERROR_MESSAGE));
    }
}