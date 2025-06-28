/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author joel_
 */
@Entity
@Table(name = "CentroLaboratorio")
public class CentroLaboratorioDominio implements Serializable {

    @Id
    @Column(name = "idCentroLaboratorio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fechaFin", nullable = false)
    private Date fechaFin;

    @Column(name = "contraseñaMaestra", nullable = false)
    private String contraseñaMaster;

    @ManyToOne
    @JoinColumn(name = "idUnidad", nullable = false)
    private UnidadDominio unidad;

    @OneToMany(mappedBy = "centroLaboratorio", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<ComputadoraDominio> computadoras;
    

    public CentroLaboratorioDominio() {
    }

    public CentroLaboratorioDominio(String nombre, Date fechaInicio, Date fechaFin, String contraseñaMaster, UnidadDominio unidad, List<ComputadoraDominio> computadoras) {

        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.contraseñaMaster = contraseñaMaster;
        this.unidad = unidad;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getContraseñaMaster() {
        return contraseñaMaster;
    }

    public void setContraseñaMaster(String contraseñaMaster) {
        this.contraseñaMaster = contraseñaMaster;
    }

    public UnidadDominio getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDominio unidad) {
        this.unidad = unidad;
    }

    public List<ComputadoraDominio> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<ComputadoraDominio> computadoras) {
        this.computadoras = computadoras;
    }

    @Override
    public String toString() {
        return "CentroLaboratorio{" + "id=" + id + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", contrase\u00f1aMaster=" + contraseñaMaster + ", unidad=" + unidad + ", computadoras=" + computadoras + '}';
    }

}
