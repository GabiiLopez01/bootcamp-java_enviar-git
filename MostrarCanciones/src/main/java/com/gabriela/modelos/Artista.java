//Incorporacion Canciones y Artistas
package com.gabriela.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;

//Modelo de dominio para Artista
//Representa un Artista en la base de datos

@Entity
@Table(name = "artistas")
public class Artista {

    //Id: Identificador del artista para la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre: El nombre del artista
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    @Column(nullable = false)
    private String nombre;

    // Apellido: El apellido del artista
    @Size(min = 3, message = "El apellido debe tener al menos 3 caracteres")
    @Column(nullable = false)
    private String apellido;

    // Biografia: Una breve biografía del artista
    @Size(min = 10, message = "La biografía debe tener al menos 10 caracteres")
    @Column(columnDefinition = "TEXT")
    private String biografia;

    //Fecha de creacion se crea automaticamente al insertar el registro
    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    //Fecha de actualizacion se crea automaticamente al modificar el registro
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    // RELACIÓN: Un artista puede tener muchas canciones (1:N)
    @OneToMany(mappedBy = "artista", fetch = FetchType.LAZY) //, cascade = CascadeType.ALL)
    private List<Cancion> canciones;

    // Constructor Vacío
    public Artista() {
    }

    // Metodo que se ejecuta antes de persistir (INSERT)
    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = new Date();
        this.fechaActualizacion = new Date();
    }

    //Metodo que se ejecuta antes de actualizar (UPDATE)
    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = new Date();
    }

    //Getters para cada atributo
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getBiografia() {
        return biografia;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    //Setters para cada atributo
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}