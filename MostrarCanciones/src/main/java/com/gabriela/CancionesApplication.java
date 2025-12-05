package com.gabriela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Clase principal de la aplicación
//Canciones

@SpringBootApplication
public class CancionesApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(CancionesApplication.class, args);

        System.out.println("Aplicacion Canciones iniciada");
    }
}
