package com.gabriela.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Controlador Rest para gestionar películas y directores
//Expone endpoints para consultar información sobre películas


@RestController
public class ControladorPeliculas {
    
    //Hashmap para almacenar películas y directores
    private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

    //Constructor que inicializa el Hashmap con datos de películas
    public ControladorPeliculas() {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");	
	    listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
	    listaPeliculas.put("Tarzán", "Kevin Lima");		
	    listaPeliculas.put("Mulán", "Barry Cook");
	    listaPeliculas.put("Oliver", "Kevin Lima");	
	    listaPeliculas.put("Big Hero 6", "Don Hall");
    }

    //Endpoint Get/peliculas - retorna lista completa de todas las películas y directores
    @GetMapping("/peliculas")
    public String obtenerTodasLasPeliculas() {
        //respuesta con todas las peliculas
        StringBuilder respuesta = new StringBuilder();
        respuesta.append("Lista de películas");

        //recorre Hashmap y agrega cada película
        for(Map.Entry<String, String> entrada : listaPeliculas.entrySet()){
            String pelicula = entrada.getKey();
            String director = entrada.getValue();
            respuesta.append("Pelicula: ").append(pelicula);
            respuesta.append(". Director: ").append(director);
        }
        respuesta.append("Total de peliculas: ").append(listaPeliculas.size());
        return respuesta.toString();
    }

    //Retorna información de pelicula especifica por su nombre
    @GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculaPorNombre(@PathVariable String nombre) {
        //buscar pelicula en Hashmap
        if(listaPeliculas.containsKey(nombre)) {
            String director = listaPeliculas.get(nombre);
            return "Pelicula: "+ nombre + ". Director: " + director;
        }else{
            return "La pelicula no se encuentra en nuestra lista";
        }    
    }
    //Retorna las peliculas que tiene ese director asignado
    @GetMapping("/peliculas/director/{nombre}")
    public String obtenerPeliculasPorDirector(@PathVariable String nombre) {
        //buscar peliculas del director
        StringBuilder respuesta = new StringBuilder();
        boolean encontrado = false;

        respuesta.append("Peliculas de: ").append(nombre);

        //recorrer Hashmap para buscar peliculas del director
        for (Map.Entry<String, String> entrada : listaPeliculas.entrySet()){
            if(entrada.getValue().equals(nombre)){
                respuesta.append("pelicula").append(entrada.getKey());
                encontrado = true;
            }
        }

        if(encontrado) {
            return respuesta.toString();
        }else{
            return "No contamos con películas de ese director en nuestra lista";
        }
    }

}
