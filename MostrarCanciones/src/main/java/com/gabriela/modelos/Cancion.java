package com.gabriela.modelos;

import jakarta.persistence.*;
//incorporación actividad Agregar Canciones
import jakarta.validation.constraints.Size;
import java.util.Date;

import com.gabriela.modelos.Artista;

//Modelo de dominio para Cancion
//Representa una canción en la base de datos

@Entity
@Table(name = "canciones")
public class Cancion {
    
    //Id: Identificador de la canción para la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    //Incorporación actividad Agregar Canciones
    @Size(min = 5, message = "El titulo debe tener al menos 5 caracteres")
    // Título: El nombre de la canción   
    @Column(nullable = false)
    private String titulo;
    
    //Incorporacion actividad Canciones y Artistas - Artista es objeto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artista_id")
    private Artista artista;
    
    //Incorporación actividad Agregar Canciones
    // @Size(min = 3, message = "El artista debe tener al menos 3 caracteres")
    // Artista: El nombre del artista o banda que interpreta la canción
    // @Column(nullable = false)
    // private String artista;
    
    //Incorporación actividad Agregar Canciones
    @Size(min = 3, message = "El album debe tener al menos 3 caracteres")
    // Álbum: El álbum en el que se encuentra la canción
    @Column(nullable = false)
    private String album;
    
    //Incorporación actividad Agregar Canciones
    @Size(min = 3, message = "El genero debe tener al menos 3 caracteres")
    // Género: El género musical de la canción (rock, pop, jazz, etc.)
    @Column(nullable = false)
    private String genero;
    
    //Incorporación actividad Agregar Canciones
    @Size(min = 3, message = "El idioma debe tener al menos 3 caracteres")
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
       
    public Artista getArtista() {
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

    public void setArtista(Artista artista) {
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