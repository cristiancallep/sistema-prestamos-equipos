package main.java.equipos;

public class ComputadorPortatil {
    private final String serial;
    private final String marca;
    private final float tamano;
    private final float precio;
    private final String sistemaOperativo;
    private final String procesador;

    public ComputadorPortatil(String serial, String marca, float tamano, float precio,
                              String sistemaOperativo, String procesador) {
        this.serial = serial;
        this.marca = marca;
        this.tamano = tamano;
        this.precio = precio;
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public String getSerial() { return serial; }
    public String getMarca() { return marca; }
    public float getTamano() { return tamano; }
    public float getPrecio() { return precio; }
    public String getSistemaOperativo() { return sistemaOperativo; }
    public String getProcesador() { return procesador; }

    @Override
    public String toString() {
        return String.format("[Portátil] Serial: %s, Marca: %s, Tamaño: %.1f\", Precio: $%.2f, SO: %s, CPU: %s",
                serial, marca, tamano, precio, sistemaOperativo, procesador);
    }

    public String toFileString() {
        return String.join(",",
                serial, marca, String.valueOf(tamano), String.valueOf(precio),
                sistemaOperativo, procesador);
    }
}