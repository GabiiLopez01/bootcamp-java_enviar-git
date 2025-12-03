package com.clases;

//Clase Televisor que hereda de Producto Electrodomestico
//Televisor con características específicas

public class Televisor extends ProductoElectrodomestico {
    //Atributos adicionales de Televisor
    private String dimensionPantalla;
    private String resolucion;

    //Constructor para inicializar atributos de Televisor
    public Televisor(String nombre, double precio, int cantidadDisponible, String dimensionPantalla,
                     String resolucion){
        super(nombre, precio, cantidadDisponible);
        this.dimensionPantalla = dimensionPantalla;
        this.resolucion = resolucion;
        }

    //Getters de Tamaño Pantalla y Resolución (atributos adicionales)
    public String getDimensionPantalla() {
        return dimensionPantalla;
    }

    public String getResolucion() {
        return resolucion;
    }

    //Setters de Tamaño Pantalla y Resolucion
    public void setDimensionPantalla(String dimensionPantalla) {
        this.dimensionPantalla = dimensionPantalla;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    
    //Sobreescribir método mostrarInformación para incorporar información específica de Televisor
    @Override
    public void mostrarInformacion(){
        System.out.println("Televisor");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad disponible: " + cantidadDisponible);
        System.out.println("Tamaño de pantalla: " + dimensionPantalla);
        System.out.println("Resolución: " + resolucion);

    }
    
    
}
