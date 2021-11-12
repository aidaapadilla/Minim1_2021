package edu.upc.dsa.models;

public class Producto implements Comparable<Producto>{

    private String nombre;
    private double precio;
    private double ventas;

    public Producto(String nombre, double precio) {
        this.precio = precio;
        this.nombre = nombre;
        this.ventas = 0;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void ventaRealizada(int numero){
        this.ventas = this.ventas + numero;
    }

    public double getPrecio(){
        return this.precio;
    }
    public int compareTo(Producto a)
    {
        int res = (int) (this.getPrecio()-a.getPrecio());
        return res;
    }

    public double getVentas() {
        return ventas;
    }
}
