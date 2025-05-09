package main.java.persistencia;

import main.java.estudiantes.EstudianteIngenieria;
import main.java.estudiantes.EstudianteDiseno;
import main.java.equipos.ComputadorPortatil;
import main.java.equipos.TabletaGrafica;
import java.util.List;

public class CargadorDatos {

    public static List<EstudianteIngenieria> cargarIngenieros() {
        return Persistencia.cargarLista("ingenieros.txt", linea -> {
            String[] datos = linea.split(",");
            return new EstudianteIngenieria(
                    datos[0], datos[1], datos[2], datos[3],
                    Integer.parseInt(datos[4]), Float.parseFloat(datos[5]), datos[6]
            );
        });
    }

    public static List<EstudianteDiseno> cargarDisenadores() {
        return Persistencia.cargarLista("disenadores.txt", linea -> {
            String[] datos = linea.split(",");
            return new EstudianteDiseno(
                    datos[0], datos[1], datos[2], datos[3],
                    datos[4], Integer.parseInt(datos[5]), datos[6]
            );
        });
    }

    public static List<ComputadorPortatil> cargarPortatiles() {
        return Persistencia.cargarLista("portatiles.txt", linea -> {
            String[] datos = linea.split(",");
            return new ComputadorPortatil(
                    datos[0], datos[1], Float.parseFloat(datos[2]),
                    Float.parseFloat(datos[3]), datos[4], datos[5]
            );
        });
    }

    public static List<TabletaGrafica> cargarTabletas() {
        return Persistencia.cargarLista("tabletas.txt", linea -> {
            String[] datos = linea.split(",");
            return new TabletaGrafica(
                    datos[0], datos[1], Float.parseFloat(datos[2]),
                    Float.parseFloat(datos[3]), datos[4], Float.parseFloat(datos[5])
            );
        });
    }

    public static DatosSistema cargarTodosLosDatos() {
        return new DatosSistema(
                cargarIngenieros(),
                cargarDisenadores(),
                cargarPortatiles(),
                cargarTabletas()
        );
    }

    public record DatosSistema(List<EstudianteIngenieria> ingenieros, List<EstudianteDiseno> disenadores,
                               List<ComputadorPortatil> portatiles, List<TabletaGrafica> tabletas) {
    }
}