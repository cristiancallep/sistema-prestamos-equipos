package main.java.menus;

import main.java.equipos.TabletaGrafica;
import main.java.validaciones.Validaciones;
import javax.swing.*;
import java.util.List;

public class MenuTabletas {
    private final List<TabletaGrafica> tabletas;

    public MenuTabletas(List<TabletaGrafica> tabletas) {
        this.tabletas = tabletas;
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
                    registrarTableta();
                    break;
                case "2":
                    modificarTableta();
                    break;
                case "3":
                    eliminarTableta();
                    break;
                case "4":
                    buscarTableta();
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
            TABLETAS GRÁFICAS - Submenú:
            1. Registrar tableta
            2. Modificar tableta
            3. Eliminar tableta
            4. Buscar tableta
            5. Volver
            Ingrese su opción:""";
    }

    private void registrarTableta() {
        String serial = Validaciones.validarSerial("Ingrese el serial de la tableta:");
        if (serial == null) return;

        if (tabletas.stream().anyMatch(t -> t.getSerial().equals(serial))) {
            JOptionPane.showMessageDialog(null, "Ya existe una tableta con ese serial", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String marca = Validaciones.validarTexto("Ingrese la marca:");
        if (marca == null) return;

        float tamano = Validaciones.validarFloat("Ingrese el tamaño en pulgadas:");
        if (tamano == -1) return;

        float precio = Validaciones.validarFloat("Ingrese el precio:");
        if (precio == -1) return;

        String almacenamiento = Validaciones.seleccionarOpcion("Almacenamiento", "Seleccione el almacenamiento:",
                new String[]{"256 GB", "512 GB", "1 TB"});
        if (almacenamiento == null) return;

        float peso = Validaciones.validarFloat("Ingrese el peso en kg:");
        if (peso == -1) return;

        tabletas.add(new TabletaGrafica(serial, marca, tamano, precio, almacenamiento, peso));
        JOptionPane.showMessageDialog(null, "Tableta registrada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void modificarTableta() {
        String serial = Validaciones.validarSerial("Ingrese el serial de la tableta a modificar:");
        if (serial == null) return;

        tabletas.stream()
                .filter(t -> t.getSerial().equals(serial))
                .findFirst()
                .ifPresentOrElse(tableta -> {
                    String marca = Validaciones.validarTexto("Nueva marca:");
                    if (marca == null) return;

                    float tamano = Validaciones.validarFloat("Nuevo tamaño:");
                    if (tamano == -1) return;

                    float precio = Validaciones.validarFloat("Nuevo precio:");
                    if (precio == -1) return;

                    String almacenamiento = Validaciones.seleccionarOpcion("Almacenamiento", "Seleccione el almacenamiento:",
                            new String[]{"256 GB", "512 GB", "1 TB"});
                    if (almacenamiento == null) return;

                    float peso = Validaciones.validarFloat("Nuevo peso:");
                    if (peso == -1) return;

                    tabletas.remove(tableta);
                    tabletas.add(new TabletaGrafica(serial, marca, tamano, precio, almacenamiento, peso));
                    JOptionPane.showMessageDialog(null, "Tableta modificada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }, () -> {
                    JOptionPane.showMessageDialog(null, "No se encontró tableta con ese serial", "Error", JOptionPane.ERROR_MESSAGE);
                });
    }

    private void eliminarTableta() {
        String serial = Validaciones.validarSerial("Ingrese el serial de la tableta a eliminar:");
        if (serial == null) return;

        if (tabletas.removeIf(t -> t.getSerial().equals(serial))) {
            JOptionPane.showMessageDialog(null, "Tableta eliminada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró tableta con ese serial", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarTableta() {
        String serial = Validaciones.validarSerial("Ingrese el serial de la tableta a buscar:");
        if (serial == null) return;

        tabletas.stream()
                .filter(t -> t.getSerial().equals(serial))
                .findFirst()
                .ifPresentOrElse(tableta -> {
                    JOptionPane.showMessageDialog(null, tableta.toString(), "Información de la Tableta", JOptionPane.INFORMATION_MESSAGE);
                }, () -> {
                    JOptionPane.showMessageDialog(null, "No se encontró tableta con ese serial", "Error", JOptionPane.ERROR_MESSAGE);
                });
    }
}
