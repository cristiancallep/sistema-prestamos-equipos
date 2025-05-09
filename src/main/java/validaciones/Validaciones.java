package main.java.validaciones;

import javax.swing.*;
import java.util.regex.Pattern;

public class Validaciones {
    private static final Pattern SOLO_LETRAS = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
    private static final Pattern SOLO_NUMEROS = Pattern.compile("^\\d+$");
    private static final Pattern TELEFONO = Pattern.compile("^\\d{7,15}$");
    private static final Pattern SERIAL = Pattern.compile("^[a-zA-Z0-9-]+$");
    private static final Pattern FLOAT = Pattern.compile("^\\d+(\\.\\d+)?$");

    public static String validarTexto(String mensaje) {
        String input;
        do {
            input = JOptionPane.showInputDialog(mensaje);
            if (input == null) return null;
            if (!SOLO_LETRAS.matcher(input).matches()) {
                JOptionPane.showMessageDialog(null, "Solo se permiten letras y espacios", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!SOLO_LETRAS.matcher(input).matches());
        return input.trim();
    }

    public static String validarNumero(String mensaje) {
        String input;
        do {
            input = JOptionPane.showInputDialog(mensaje);
            if (input == null) return null;
            if (!SOLO_NUMEROS.matcher(input).matches()) {
                JOptionPane.showMessageDialog(null, "Solo se permiten números enteros", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!SOLO_NUMEROS.matcher(input).matches());
        return input.trim();
    }

    public static String validarTelefono(String mensaje) {
        String input;
        do {
            input = JOptionPane.showInputDialog(mensaje);
            if (input == null) return null;
            if (!TELEFONO.matcher(input).matches()) {
                JOptionPane.showMessageDialog(null, "Teléfono inválido (7-15 dígitos)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!TELEFONO.matcher(input).matches());
        return input.trim();
    }

    public static String validarSerial(String mensaje) {
        String input;
        do {
            input = JOptionPane.showInputDialog(mensaje);
            if (input == null) return null;
            if (!SERIAL.matcher(input).matches()) {
                JOptionPane.showMessageDialog(null, "Serial inválido (solo letras, números y guiones)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!SERIAL.matcher(input).matches());
        return input.trim();
    }

    public static float validarFloat(String mensaje) {
        String input;
        do {
            input = JOptionPane.showInputDialog(mensaje);
            if (input == null) return -1;
            if (!FLOAT.matcher(input).matches()) {
                JOptionPane.showMessageDialog(null, "Debe ser un número decimal válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!FLOAT.matcher(input).matches());
        return Float.parseFloat(input.trim());
    }

    public static String seleccionarOpcion(String titulo, String mensaje, String[] opciones) {
        return (String) JOptionPane.showInputDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);
    }
}