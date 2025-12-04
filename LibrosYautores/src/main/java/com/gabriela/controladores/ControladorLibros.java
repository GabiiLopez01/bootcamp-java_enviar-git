package com.gabriela.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

//Controlador para gestionar libros y autores

@Controller
public class ControladorLibros {

    //HashMap para almacenar libros y autores
    private static HashMap<String, String> listaLibros = new HashMap<String, String>();

    //Constructor que inicializa el Hashmap con datos de prueba
    public ControladorLibros(){
        listaLibros.put("Odisea", "Homero");
        listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
        listaLibros.put("El Codigo Da Vinci", "Dan Brown");
        listaLibros.put("Alicia en el pais de las maravillas", "Lewis Carroll");
        listaLibros.put("El Hobbit", "J.R.R. Tolkien");
        listaLibros.put("El Alquimista", "Paulo Coelho");
    }

    //Get/Libros - Muestra la lista de todos los libros
    @GetMapping("/libros")
    public String obtenerTodosLosLibros(Model modelo) {
        modelo.addAttribute("listaLibros", listaLibros);
        return "libros";
    }

    //Muestra la información de un libro especifico
    @GetMapping("/libros/{nombre}")
        public String obtenerInformacionDeLibro(@PathVariable String nombre, Model modelo) {
            if (listaLibros.containsKey(nombre)){
                String autor = listaLibros.get(nombre);
                modelo.addAttribute("nombreLibro", nombre);
                modelo.addAttribute("nombreAutor", autor);
                modelo.addAttribute("encontrado", true); 
            }else{
                modelo.addAttribute("encontrado", false);
                modelo.addAttribute("mensaje", "El libro no se encuentra en nuestra lista.");
            }
            return "detalleLibro";
        }

    //Muestra el formulario para agregar un nuevo libro
    @GetMapping("/libros/formulario")
    public String formularioLibro(){
        return "formularioLibro";
    }

    //Post/procesa/libro - procesa el formulario y agrega un nuevo libro en la lista
    @PostMapping("/procesa/libro")
    public String procesaLibro(
        @RequestParam String nombreLibro,
        @RequestParam String nombreAutor){

            //agrega el libro y su autor al Hashmap
            listaLibros.put(nombreLibro, nombreAutor);

            //redirecciona a la lista de libros
            return "redirect:/libros";
        }

}

