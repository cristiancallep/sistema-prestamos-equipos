package main;

import main.java.menus.MenuPrincipal;
import main.java.persistencia.CargadorDatos;

public class Main {
    public static void main(String[] args) {
        // Cargar todos los datos
        CargadorDatos.DatosSistema datos = CargadorDatos.cargarTodosLosDatos();

        // Iniciar la aplicación con los datos cargados
        new MenuPrincipal(datos.ingenieros(), datos.disenadores(), datos.portatiles(), datos.tabletas()).mostrar();
    }
}