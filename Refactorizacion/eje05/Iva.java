package eje05;
// Clase que representa el cálculo del IVA (Impuesto al Valor Agregado)
public class Iva {
    private double precioSinIVA; // Atributo que almacena el precio sin IVA
    private double iva;          // Atributo que almacena el porcentaje de IVA

    // Constructor: recibe el precio sin IVA y el porcentaje de IVA
    public Iva(double precioSinIVA, double iva) {
        this.precioSinIVA = precioSinIVA;
        this.iva = iva;
    }

    // Getter: devuelve el precio sin IVA
    public double getPrecioSinIVA() {
        return precioSinIVA;
    }

    // Getter: devuelve el porcentaje de IVA
    public double getIVA() {
        return iva;
    }

    // Método que calcula y devuelve el precio con IVA
    // Fórmula: precioSinIVA * (1 + (iva / 100))
    public double getPrecioConIVA() {
        return precioSinIVA * (1 + (iva / 100));
    }
}
