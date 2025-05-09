package main.java.persistencia;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Persistencia {
    public static <T> void guardarLista(List<T> lista, String archivo, Function<T, String> conversor) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            lista.stream().map(conversor).forEach(writer::println);
        } catch (IOException e) {
            mostrarError("Error al guardar " + archivo + ": " + e.getMessage());
        }
    }

    public static <T> List<T> cargarLista(String archivo, Function<String, T> constructor) {
        List<T> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    lista.add(constructor.apply(linea));
                }
            }
        } catch (IOException e) {
            // Archivo no existe aún, se creará al guardar
        }
        return lista;
    }

    public static void guardarInventario(String contenido) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("inventario_total.txt"))) {
            writer.println(contenido);
        } catch (IOException e) {
            mostrarError("Error al guardar inventario: " + e.getMessage());
        }
    }

    private static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}