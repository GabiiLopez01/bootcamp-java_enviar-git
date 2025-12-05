//Incorporacion Canciones y Artistas
package com.gabriela.controladores;

import com.gabriela.modelos.Artista;
import com.gabriela.servicios.ServicioArtistas;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Controlador para gestionar las vistas de artistas
@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicioArtistas;

    //Get/artistas - Muestra la lista de todos los artistas
    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        model.addAttribute("artistas", artistas);
        return "artistas";
    }

    //Get/artistas/detalle/{idArtista} - Muestra el detalle de un artista específico
    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable Long idArtista, Model model) {
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        model.addAttribute("artista", artista);
        return "detalleArtista";
    }

    //Get/artistas/formulario/agregar - Muestra el formulario para agregar un nuevo artista
    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(@ModelAttribute("artista") Artista artista) {
        return "agregarArtista";
    }

    //Post/artistas/procesa/agregar - Procesa el formulario y agrega el artista a la BD
    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(
        @Valid @ModelAttribute("artista") Artista artista, 
        BindingResult result) {
        
        if (result.hasErrors()) {
            return "agregarArtista";
        }
        
        servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
}
