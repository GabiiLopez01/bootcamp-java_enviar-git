package com.gabriela.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.HashMap;


// Marca la clase como un componente Spring que maneja peticiones web
// devuelve nombres de vistas 

@Controller
public class ControladorRecetas {
    
    //Agrega atributos para el arreglo de los nombres de las recetas y un hashmap
    // para almacenar recetas y sus ingredientes
    private static final String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
    private static final HashMap<String, String[]> recetasConIngredientes = new HashMap<>();

    //Constructor que se encarga del HashMap con información de recetas y sus ingredientes
    public ControladorRecetas(){
        String[] pizza = {"Pan", "Salsa de tomate", "Queso", "Peperoni"};
        recetasConIngredientes.put("Pizza", pizza);

        String[] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
        recetasConIngredientes.put("Espagueti", espagueti);

        String[] lasana = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
        recetasConIngredientes.put("Lasaña", lasana);
    }

    //Métodos de enrutamiento
    //toma la lista de recetas y la agrega como atributo “listaRecetas” a un objeto Modelo
    // para enviar hacia el JSP
    @GetMapping("/recetas")
    public String obtenerTodasLasRecetas(Model modelo){
        //convierte el arreglo en una lista para facilitar uso en el JSP
        modelo.addAttribute ("listaRecetas", listaRecetas);
        return "recetas";
    }

    //busca el nombre de la receta y agrega su nombre y sus ingredientes en dos atributos 
    // respectivamente a un objeto Modelo para enviar hacía el JSP llamado detalleReceta.jsp
    // caso contrario «La receta no se encuentra en nuestra lista.»

    @GetMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable String nombre, Model modelo){
        
        if(recetasConIngredientes.containsKey(nombre)){
            String[] ingredientes = recetasConIngredientes.get(nombre);
            modelo.addAttribute("nombreReceta", nombre);
            modelo.addAttribute("ingredientes", ingredientes);
            modelo.addAttribute("encontrada", true);
        }else{
            //si la receta no existe muestra «La receta no se encuentra en nuestra lista.
            modelo.addAttribute("encontrada", false);
            modelo.addAttribute("mensaje", "La receta no se encuentra en nuestra lista.");
        }
        return "detalleReceta";
    }
}
