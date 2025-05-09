package main.java.equipos;

public class TabletaGrafica {
    private final String serial;
    private final String marca;
    private final float tamano;
    private final float precio;
    private final String almacenamiento;
    private final float peso;

    public TabletaGrafica(String serial, String marca, float tamano, float precio,
                          String almacenamiento, float peso) {
        this.serial = serial;
        this.marca = marca;
        this.tamano = tamano;
        this.precio = precio;
        this.almacenamiento = almacenamiento;
        this.peso = peso;
    }

    public String getSerial() { return serial; }
    public String getMarca() { return marca; }
    public float getTamano() { return tamano; }
    public float getPrecio() { return precio; }
    public String getAlmacenamiento() { return almacenamiento; }
    public float getPeso() { return peso; }

    @Override
    public String toString() {
        return String.format("[Tableta] Serial: %s, Marca: %s, Tamaño: %.1f\", Precio: $%.2f, Almacenamiento: %s, Peso: %.2f kg",
                serial, marca, tamano, precio, almacenamiento, peso);
    }

    public String toFileString() {
        return String.join(",",
                serial, marca, String.valueOf(tamano), String.valueOf(precio),
                almacenamiento, String.valueOf(peso));
    }
}