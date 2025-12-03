package com.clases;

//Clase Computador Portatil que hereda Producto Electrodomestico
//Representa computador portatil con las características específicas

public class ComputadorPortatil extends ProductoElectrodomestico {
    //Atributos específicos
    private String marca;
    private String memoriaRAM;
    private String numeroSerie;

    //Constructor para inicializar los atributos de computador
    public ComputadorPortatil(String nombre, double precio, int cantidadDisponible,
                              String marca, String memoriaRAM, String numeroSerie){
            super(nombre, precio, cantidadDisponible);
            this.marca = marca;
            this.memoriaRAM = memoriaRAM;
            this.numeroSerie = numeroSerie;
    }

    //Getters para Atributos de Marca, MemoriaRAM y numeroSerie

    public String getMarca() {
        return marca;
    }

    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    //Setters para atributos de Marca, MemoriaRAM y numeroSerie
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }
    
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    //Sobreescribir método mostrarInformación para incorporar información específica del Computador
    @Override
    public void mostrarInformacion(){
        System.out.println("Computador Portatil");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad disponible: " + cantidadDisponible);
        System.out.println("Marca: " + marca);
        System.out.println("Memoria RAM: " + memoriaRAM);
        System.out.println("Numero de Serie: " + numeroSerie);
    }

}
