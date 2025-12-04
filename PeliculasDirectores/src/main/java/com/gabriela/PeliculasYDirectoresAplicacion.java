package com.gabriela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Clase principal aplicación Spring Boot
// punto de entrada

@SpringBootApplication
public class PeliculasYDirectoresAplicacion {

    public static void main(String[] args) {
        SpringApplication.run(PeliculasYDirectoresAplicacion.class, args);
        System.out.println("Aplicacion iniciada correctamente");
        System.out.println("Accede a través http://localhost:8081");
    }
}