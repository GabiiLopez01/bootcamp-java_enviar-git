//Incorporacion Canciones y Artistas
package com.gabriela.repositorios;

import com.gabriela.modelos.Artista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repositorio para gestionar operaciones de BD de Artistas
@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long> {
    
    //Obtiene todos los artistas de la BD
    List<Artista> findAll();
    
}
