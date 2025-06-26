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
import javax.persistence.Table;

/**
 *
 * @author joel_
 */
@Entity
@Table(name = "Unidad")
public class UnidadDominio implements Serializable {

    @Id
    @Column(name = "idUnidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "Unidad")
    private List<CentroLaboratorioDominio> centros;

    public UnidadDominio() {
    }

    public UnidadDominio( String nombre, List<CentroLaboratorioDominio> centros) {
        
        this.nombre = nombre;
        this.centros = centros;
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

    public List<CentroLaboratorioDominio> getCentros() {
        return centros;
    }

    public void setCentros(List<CentroLaboratorioDominio> centros) {
        this.centros = centros;
    }

    @Override
    public String toString() {
        return "Unidad{" + "id=" + id + ", nombre=" + nombre + ", centros=" + centros + '}';
    }
    
    
}
