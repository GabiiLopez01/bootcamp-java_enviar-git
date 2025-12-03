package clases;

public class Persona {
    //Atributos
    private String nombre;
    private int edad;

    //Constructor
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    // Getters y Setters - atajo botón secundario -> Source Action -> Generate Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Método para mostrar información generada anteriormente
    public void despliegaInformacion(){
        System.out.println("Nombre: " + nombre + "| Edad: " + edad);
    }
    

}