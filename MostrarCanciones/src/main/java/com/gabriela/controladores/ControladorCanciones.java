package com.gabriela.controladores;

import com.gabriela.modelos.Cancion;
import com.gabriela.servicios.ServicioCanciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
    
    // GET /canciones/detalle/{idCancion}
    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion";
    }
}

