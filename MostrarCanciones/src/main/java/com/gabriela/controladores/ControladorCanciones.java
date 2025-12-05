package com.gabriela.controladores;


import com.gabriela.modelos.Cancion;
import com.gabriela.servicios.ServicioCanciones;
//Incorporación actividad Agregar Canciones
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//Incorporación actividad Agregar Canciones
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//Incorporación actividad Agregar Canciones
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//Incorporación actividad Agregar Canciones
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Incorporación actividad Canciones y Artistas
import com.gabriela.modelos.Artista;
import com.gabriela.servicios.ServicioArtistas;

import java.util.List;


// Controlador para gestionar las vistas de canciones
@Controller
public class ControladorCanciones {
    
    // Inyección de dependencia del servicio
    @Autowired
    private ServicioCanciones servicioCanciones;
    
    // Inyección servicio de artistas
    @Autowired
    private ServicioArtistas servicioArtistas;

    //GET/canciones
    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
        modelo.addAttribute("canciones", canciones);
        return "canciones";
    }
    
    //GET/canciones/detalle/{idCancion}
    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion";
    }

    //Incorporación actividad Agregar Canciones
    //GET/canciones/formulario/agregar
    // @GetMapping("/canciones/formulario/agregar")
    // public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion) {
    //     return "agregarCancion";
    // }

    //Incorporación actividad Canciones y Artistas
    //GET/canciones/formulario/agregar - envía lista de artistas al formulario
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion, Model modelo) {
        // Obtener todos los artistas para el select
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        modelo.addAttribute("artistas", artistas);
        return "agregarCancion";
    }

    //Incorporación actividad Agregar Canciones
    //POST/canciones/procesa/agregar
    // @PostMapping("/canciones/procesa/agregar")
    // public String procesarAgregarCancion(
    //         @Valid @ModelAttribute("cancion") Cancion cancion,
    //         BindingResult resultado) {
    //     
    //     // Si hay errores de validación, volver al formulario
    //     if (resultado.hasErrors()) {
    //        return "agregarCancion";
    //    }
    //    
    //    // Guardar la canción en la base de datos
    //    servicioCanciones.agregarCancion(cancion);
    //    
    //    // Redireccionar a la lista de canciones
    //    return "redirect:/canciones";
    //}

    //Incorporación actividad Canciones y Artistas
    //POST/canciones/procesa/agregar - recibe artistaID y enlaza el objeto
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult resultado,
            @RequestParam("artistaId") Long artistaId,
            Model modelo) {
        
        if (resultado.hasErrors()) {
            // Si hay errores, volver a cargar la lista de artistas
            List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
            modelo.addAttribute("artistas", artistas);
            return "agregarCancion";
        }
        
        // Obtener el artista por ID y enlazarlo a la canción
        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        cancion.setArtista(artista);
        
        servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    //Incorporación actividad Actualizar Cancion
    //GET/canciones/formulario/editar{idCancion} - muestra formulario para editar una cancion existente
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        
        // Agregar lista de artistas para poder cambiar el artista - incorporacion Canciones y Artistas
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        modelo.addAttribute("artistas", artistas);
    
        return "editarCancion";
    }

    //Incorporación actividad Actualizar Cancion
    //POST/canciones/formulario/editar{idCancion} - procesa formulario y actualiza cancion en BD
    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(
            @PathVariable Long idCancion,
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult resultado,
            //incorporacion Canciones y Artistas 
            @RequestParam("artistaId") Long artistaId,
            Model modelo) {
        
        if (resultado.hasErrors()) {
            List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
            modelo.addAttribute("artistas", artistas);
            return "editarCancion";
        }
        
        cancion.setId(idCancion);
        
        // Enlazar el artista seleccionado
        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        cancion.setArtista(artista);
        
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    //Incorporación actividad Eliminar Cancion
    //Elimina una canción de la BD
    @GetMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable Long idCancion) {
        servicioCanciones.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }
    

}

