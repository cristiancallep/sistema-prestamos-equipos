package main.java.menus;

import main.java.equipos.ComputadorPortatil;
import main.java.validaciones.Validaciones;
import javax.swing.*;
import java.util.List;

public class MenuPortatiles {
    private final List<ComputadorPortatil> portatiles;

    public MenuPortatiles(List<ComputadorPortatil> portatiles) {
        this.portatiles = portatiles;
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
                    registrarPortatil();
                    break;
                case "2":
                    modificarPortatil();
                    break;
                case "3":
                    eliminarPortatil();
                    break;
                case "4":
                    buscarPortatil();
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
            COMPUTADORES PORTÁTILES - Submenú:
            1. Registrar portátil
            2. Modificar portátil
            3. Eliminar portátil
            4. Buscar portátil
            5. Volver
            Ingrese su opción:""";
    }

    private void registrarPortatil() {
        String serial = Validaciones.validarSerial("Ingrese el serial del portátil:");
        if (serial == null) return;

        if (portatiles.stream().anyMatch(p -> p.getSerial().equals(serial))) {
            JOptionPane.showMessageDialog(null, "Ya existe un portátil con ese serial", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String marca = Validaciones.validarTexto("Ingrese la marca:");
        if (marca == null) return;

        float tamano = Validaciones.validarFloat("Ingrese el tamaño en pulgadas:");
        if (tamano == -1) return;

        float precio = Validaciones.validarFloat("Ingrese el precio:");
        if (precio == -1) return;

        String so = Validaciones.seleccionarOpcion("Sistema Operativo", "Seleccione el SO:",
                new String[]{"Windows 7", "Windows 10", "Windows 11"});
        if (so == null) return;

        String cpu = Validaciones.seleccionarOpcion("Procesador", "Seleccione el procesador:",
                new String[]{"AMD Ryzen", "Intel Core i5"});
        if (cpu == null) return;

        portatiles.add(new ComputadorPortatil(serial, marca, tamano, precio, so, cpu));
        JOptionPane.showMessageDialog(null, "Portátil registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void modificarPortatil() {
        String serial = Validaciones.validarSerial("Ingrese el serial del portátil a modificar:");
        if (serial == null) return;

        portatiles.stream()
                .filter(p -> p.getSerial().equals(serial))
                .findFirst()
                .ifPresentOrElse(portatil -> {
                    String marca = Validaciones.validarTexto("Nueva marca:");
                    if (marca == null) return;

                    float tamano = Validaciones.validarFloat("Nuevo tamaño:");
                    if (tamano == -1) return;

                    float precio = Validaciones.validarFloat("Nuevo precio:");
                    if (precio == -1) return;

                    String so = Validaciones.seleccionarOpcion("Sistema Operativo", "Seleccione el SO:",
                            new String[]{"Windows 7", "Windows 10", "Windows 11"});
                    if (so == null) return;

                    String cpu = Validaciones.seleccionarOpcion("Procesador", "Seleccione el procesador:",
                            new String[]{"AMD Ryzen", "Intel Core i5"});
                    if (cpu == null) return;

                    portatiles.remove(portatil);
                    portatiles.add(new ComputadorPortatil(serial, marca, tamano, precio, so, cpu));
                    JOptionPane.showMessageDialog(null, "Portátil modificado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }, () -> {
                    JOptionPane.showMessageDialog(null, "No se encontró portátil con ese serial", "Error", JOptionPane.ERROR_MESSAGE);
                });
    }

    private void eliminarPortatil() {
        String serial = Validaciones.validarSerial("Ingrese el serial del portátil a eliminar:");
        if (serial == null) return;

        if (portatiles.removeIf(p -> p.getSerial().equals(serial))) {
            JOptionPane.showMessageDialog(null, "Portátil eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró portátil con ese serial", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPortatil() {
        String serial = Validaciones.validarSerial("Ingrese el serial del portátil a buscar:");
        if (serial == null) return;

        portatiles.stream()
                .filter(p -> p.getSerial().equals(serial))
                .findFirst()
                .ifPresentOrElse(portatil -> {
                    JOptionPane.showMessageDialog(null, portatil.toString(), "Información del Portátil", JOptionPane.INFORMATION_MESSAGE);
                }, () -> {
                    JOptionPane.showMessageDialog(null, "No se encontró portátil con ese serial", "Error", JOptionPane.ERROR_MESSAGE);
                });
    }
}