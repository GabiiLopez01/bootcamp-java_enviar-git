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

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


// Controlador para gestionar las vistas de canciones
@Controller
public class ControladorCanciones {
    
    // Inyección de dependencia del servicio
    @Autowired
    private ServicioCanciones servicioCanciones;
    
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
     @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion) {
        return "agregarCancion";
    }

    //Incorporación actividad Agregar Canciones
    //POST/canciones/procesa/agregar
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult resultado) {
        
        // Si hay errores de validación, volver al formulario
        if (resultado.hasErrors()) {
            return "agregarCancion";
        }
        
        // Guardar la canción en la base de datos
        servicioCanciones.agregarCancion(cancion);
        
        // Redireccionar a la lista de canciones
        return "redirect:/canciones";
    }

    //Incorporación actividad Actualizar Cancion
    //GET/canciones/formulario/editar{idCancion} - muestra formulario para editar una cancion existente
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        return "editarCancion";
    }

    //Incorporación actividad Actualizar Cancion
    //POST/canciones/formulario/editar{idCancion} - procesa formulario y actualiza cancion en BD
    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(
            @PathVariable Long idCancion,
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult resultado) {
        
        if (resultado.hasErrors()) {
            return "editarCancion";
        }
        
        // Asegurar que el ID se mantenga (para actualizar, no crear nuevo)
        cancion.setId(idCancion);
        
        // Actualizar la canción
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

