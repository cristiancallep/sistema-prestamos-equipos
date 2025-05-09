package main.java.menus;

import main.java.estudiantes.*;
import main.java.equipos.*;
import main.java.persistencia.*;
import main.java.validaciones.*;
import javax.swing.*;
import java.util.List;

public class MenuPrincipal {
    private final List<EstudianteIngenieria> ingenieros;
    private final List<EstudianteDiseno> disenadores;
    private final List<ComputadorPortatil> portatiles;
    private final List<TabletaGrafica> tabletas;

    public MenuPrincipal(List<EstudianteIngenieria> ingenieros, List<EstudianteDiseno> disenadores,
                         List<ComputadorPortatil> portatiles, List<TabletaGrafica> tabletas) {
        this.ingenieros = ingenieros;
        this.disenadores = disenadores;
        this.portatiles = portatiles;
        this.tabletas = tabletas;
    }

    public void mostrar() {
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(crearMenuPrincipal());

            if (opcion == null) {
                opcion = "6"; // Salir si se presiona Cancelar
            }

            switch (opcion) {
                case "1":
                    new MenuIngenieria(ingenieros).mostrar();
                    break;
                case "2":
                    new MenuDiseno(disenadores).mostrar();
                    break;
                case "3":
                    new MenuPortatiles(portatiles).mostrar();
                    break;
                case "4":
                    new MenuTabletas(tabletas).mostrar();
                    break;
                case "5":
                    imprimirInventario();
                    break;
                case "6":
                    guardarDatos();
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String crearMenuPrincipal() {
        return """
            MENÚ PRINCIPAL:
            1. Estudiantes de Ingeniería
            2. Estudiantes de Diseño
            3. Computadores Portátiles
            4. Tabletas Gráficas
            5. Imprimir Inventario Total
            6. Salir
            Ingrese su opción:""";
    }

    private void imprimirInventario() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== INVENTARIO TOTAL ===\n\n");

        sb.append("--- ESTUDIANTES DE INGENIERÍA ---\n");
        ingenieros.forEach(e -> sb.append(e.toString()).append("\n"));

        sb.append("\n--- ESTUDIANTES DE DISEÑO ---\n");
        disenadores.forEach(e -> sb.append(e.toString()).append("\n"));

        sb.append("\n--- COMPUTADORES PORTÁTILES ---\n");
        portatiles.forEach(p -> sb.append(p.toString()).append("\n"));

        sb.append("\n--- TABLETAS GRÁFICAS ---\n");
        tabletas.forEach(t -> sb.append(t.toString()).append("\n"));

        JOptionPane.showMessageDialog(null, sb.toString(), "Inventario Total", JOptionPane.INFORMATION_MESSAGE);
        Persistencia.guardarInventario(sb.toString());
    }

    private void guardarDatos() {
        Persistencia.guardarLista(ingenieros, "ingenieros.txt", EstudianteIngenieria::toFileString);
        Persistencia.guardarLista(disenadores, "disenadores.txt", EstudianteDiseno::toFileString);
        Persistencia.guardarLista(portatiles, "portatiles.txt", ComputadorPortatil::toFileString);
        Persistencia.guardarLista(tabletas, "tabletas.txt", TabletaGrafica::toFileString);
    }
}