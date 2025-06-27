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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author joel_
 */
@Entity
@Table(name = "Software")
public class SoftwareDominio implements Serializable {

    @Id
    @Column(name = "idSoftware")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;
    
    @ManyToMany(mappedBy = "softwares")
    private List<ComputadoraDominio> computadoras;

    public SoftwareDominio() {
    }

    
    public SoftwareDominio( String nombre, List<ComputadoraDominio> computadoras) {

        this.nombre = nombre;
        this.computadoras = computadoras;
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

    public List<ComputadoraDominio> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<ComputadoraDominio> computadoras) {
        this.computadoras = computadoras;
    }

    @Override
    public String toString() {
        return "Software{" + "id=" + id + ", nombre=" + nombre + ", computadoras=" + computadoras + '}';
    }
    
    
}
