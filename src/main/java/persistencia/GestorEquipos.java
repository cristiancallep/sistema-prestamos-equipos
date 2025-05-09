package main.java.persistencia;

import main.java.equipos.ComputadorPortatil;
import main.java.equipos.TabletaGrafica;
import java.util.List;

public class GestorEquipos {
    private List<ComputadorPortatil> portatiles;
    private List<TabletaGrafica> tabletas;

    public GestorEquipos(List<ComputadorPortatil> portatiles, List<TabletaGrafica> tabletas) {
        this.portatiles = portatiles;
        this.tabletas = tabletas;
    }

    public boolean existePortatil(String serial) {
        return portatiles.stream().anyMatch(p -> p.getSerial().equals(serial));
    }

    public boolean existeTableta(String serial) {
        return tabletas.stream().anyMatch(t -> t.getSerial().equals(serial));
    }

    public boolean equipoDisponible(String serial) {
        // Verifica que exista y no esté prestado
        return existePortatil(serial) || existeTableta(serial);
    }

    public String getTipoEquipo(String serial) {
        if (existePortatil(serial)) return "PORTATIL";
        if (existeTableta(serial)) return "TABLETA";
        return null;
    }
}