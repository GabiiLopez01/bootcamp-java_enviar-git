package com.gabriela.servicios;

import com.gabriela.modelos.Cancion;
import com.gabriela.repositorios.RepositorioCanciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Servicio para la logica del negocio de cancion
@Service
public class ServicioCanciones {
    
    //Inyecta el respositorio
    @Autowired
    private RepositorioCanciones repositorioCanciones;
     
    
    //Obtiene todas las canciones de la base de datos
    public List<Cancion> obtenerTodasLasCanciones() {
        return repositorioCanciones.findAll();
    }
    
    // Obtiene una canción por su ID
    public Cancion obtenerCancionPorId(Long id) {
        Optional <Cancion> cancion = repositorioCanciones.findById(id); 
            return cancion.orElse(null);
    }

    //Incorporación actividad Agregar Canciones
    //Agrega una canción a la base de datos
    public Cancion agregarCancion(Cancion cancion){
        return repositorioCanciones.save(cancion);
    }

    //Incorporación actividad Actualiza Cancion
    //Actualiza canción a la base de datos
    public Cancion actualizaCancion(Cancion cancion) {
        return repositorioCanciones.save(cancion);
    }

    //Incorporación actividad Eliminar Cancion
    //Elimina una canción de la BD
    public void eliminaCancion(Long id){
        repositorioCanciones.deleteById(id);
    }

}