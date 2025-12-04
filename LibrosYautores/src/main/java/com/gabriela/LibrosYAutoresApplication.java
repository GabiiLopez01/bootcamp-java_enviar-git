package com.gabriela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Clase principal de la aplicación
//Libros y Autores

@SpringBootApplication
public class LibrosYAutoresApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LibrosYAutoresApplication.class, args);

        System.out.println("Aplicacion Libros y Autores iniciada");
    }
}
