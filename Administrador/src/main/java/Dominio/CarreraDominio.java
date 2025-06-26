/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author joel_
 */
@Entity
public class CarreraDominio implements Serializable {

    @Id
    @Column(name = "idCarrera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column (name = "tiempoLimite", nullable = false)
    private float tiempoLimite;
    
    @OneToMany(mappedBy = "Carrera")
    private List<AlumnoDominio> alumnos;

    public CarreraDominio() {
    }

    
    public CarreraDominio(String nombre, float tiempoLimite, List<AlumnoDominio> alumnos) {
        this.nombre = nombre;
        this.tiempoLimite = tiempoLimite;
        this.alumnos = alumnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(float tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    public List<AlumnoDominio> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoDominio> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "CarreraDominio{" + "id=" + id + ", nombre=" + nombre + ", tiempoLimite=" + tiempoLimite + ", alumnos=" + alumnos + '}';
    }
    
    
}
