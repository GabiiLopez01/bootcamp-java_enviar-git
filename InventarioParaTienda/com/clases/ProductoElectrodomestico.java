package com.clases;

// Clase Productos Electrodomésticos
public class ProductoElectrodomestico {
    //Atributos para que las clases hijas puedan acceder
    protected String nombre;
    protected double precio;
    protected int cantidadDisponible;
    
    //Constructor que inicializa los atributos
    public ProductoElectrodomestico(String nombre, double precio, int cantidadDisponible){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    //Constructor sobrecargado que inicializa nombre y precio - cantidad se establece 0 por defecto
    public ProductoElectrodomestico(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = 0;  
    }
    //Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }  

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    
    //Mostrar la información del producto
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad disponible: " + cantidadDisponible);
    }
}
