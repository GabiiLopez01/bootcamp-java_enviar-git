package com.gabriela.modelos;

import jakarta.persistence.*;
import java.util.Date;

//Modelo de dominio para Cancion
//Representa una canción en la base de datos

@Entity
@Table(name = "canciones")
public class Cancion {
    
    // Id: Identificador de la canción para la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Título: El nombre de la canción
    @Column(nullable = false)
    private String titulo;
    
    // Artista: El nombre del artista o banda que interpreta la canción
    @Column(nullable = false)
    private String artista;
    
    // Álbum: El álbum en el que se encuentra la canción
    @Column(nullable = false)
    private String album;
    
    // Género: El género musical de la canción (rock, pop, jazz, etc.)
    @Column(nullable = false)
    private String genero;
    
    // Idioma: El idioma en el que está escrita la canción
    @Column(nullable = false)
    private String idioma;
    
    // Fecha de creación: Se crea automáticamente al insertar el registro
    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    // Fecha de actualización: Se actualiza automáticamente al modificar el registro
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    
    //Constructor vacío
    public Cancion() {
    }
    
    //Método que se ejecuta antes de persistir (INSERT)
    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = new Date();
        this.fechaActualizacion = new Date();
    }
    
    //Método que se ejecuta antes de actualizar (UPDATE)
    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = new Date();
    }
    
    //Getters para cada atributo
        
    public Long getId() {
        return id;
    }
      
    public String getTitulo() {
        return titulo;
    }
       
    public String getArtista() {
        return artista;
    }
    
    public String getAlbum() {
        return album;
    }
       
    public String getGenero() {
        return genero;
    }
    
    public String getIdioma() {
        return idioma;
    }
       
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
        
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    //Setters para cada atributo
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}