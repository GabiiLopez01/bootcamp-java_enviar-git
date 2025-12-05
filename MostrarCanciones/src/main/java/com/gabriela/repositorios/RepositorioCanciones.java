package com.gabriela.repositorios;

import com.gabriela.modelos.Cancion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repositorio para gestionar operaciones de base de datos de Cancion
@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
    
    //Obtiene una lista de todas las canciones de la base de datos
    List<Cancion> findAll();
}
