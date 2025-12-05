//Incorporacion Canciones y Artistas
package com.gabriela.servicios;

import com.gabriela.modelos.Artista;
import com.gabriela.repositorios.RepositorioArtistas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Servicio para la logica del negocio de Artistas
@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repositorioArtistas;

    //Obtiene todos los artistas de la BD
    public List<Artista> obtenerTodosLosArtistas() {
        return repositorioArtistas.findAll();
    }

    //Obtiene un artista por su ID
    public Artista obtenerArtistaPorId(Long id) {
        Optional<Artista> artista = repositorioArtistas.findById(id);
        return artista.orElse(null); // Devuelve el Artista o null si no existe
    }

    //Agrega un artista a la BD
    public Artista agregarArtista(Artista artista) {
        return repositorioArtistas.save(artista);
    }
}
