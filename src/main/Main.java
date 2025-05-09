package main;

import main.java.estudiantes.*;
import main.java.equipos.*;
import main.java.persistencia.*;
import main.java.menus.*;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Cargar datos iniciales
        List<EstudianteIngenieria> ingenieros = Persistencia.cargarLista("ingenieros.txt", linea -> {
            String[] datos = linea.split(",");
            return new EstudianteIngenieria(
                    datos[0], datos[1], datos[2], datos[3],
                    Integer.parseInt(datos[4]), Float.parseFloat(datos[5]), datos[6]
            );
        });

        List<EstudianteDiseno> disenadores = Persistencia.cargarLista("disenadores.txt", linea -> {
            String[] datos = linea.split(",");
            return new EstudianteDiseno(
                    datos[0], datos[1], datos[2], datos[3],
                    datos[4], Integer.parseInt(datos[5]), datos[6]
            );
        });

        List<ComputadorPortatil> portatiles = Persistencia.cargarLista("portatiles.txt", linea -> {
            String[] datos = linea.split(",");
            return new ComputadorPortatil(
                    datos[0], datos[1], Float.parseFloat(datos[2]),
                    Float.parseFloat(datos[3]), datos[4], datos[5]
            );
        });

        List<TabletaGrafica> tabletas = Persistencia.cargarLista("tabletas.txt", linea -> {
            String[] datos = linea.split(",");
            return new TabletaGrafica(
                    datos[0], datos[1], Float.parseFloat(datos[2]),
                    Float.parseFloat(datos[3]), datos[4], Float.parseFloat(datos[5])
            );
        });

        // Mostrar menú principal
        new MenuPrincipal(ingenieros, disenadores, portatiles, tabletas).mostrar();
    }
}