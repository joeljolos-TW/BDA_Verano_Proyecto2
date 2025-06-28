/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Dominio.CentroLaboratorioDominio;
import Dominio.ComputadoraDominio;
import Dominio.UnidadDominio;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class CentroLaboratorioDTO {

    private String nombre;

    private Date fechaInicio;

    private Date fechaFin;

    private String contraseñaMaster;

    private UnidadDominio unidad;

    private List<ComputadoraDominio> computadoras;

    public CentroLaboratorioDTO() {
    }

    public CentroLaboratorioDTO(String nombre, Date fechaInicio, Date fechaFin, String contraseñaMaster, UnidadDominio unidad, List<ComputadoraDominio> computadoras) {

        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.contraseñaMaster = contraseñaMaster;
        this.unidad = unidad;
        this.computadoras = computadoras;
    }
    
    public CentroLaboratorioDominio getDominio(){
        return new CentroLaboratorioDominio(nombre, fechaInicio, fechaFin, contraseñaMaster, unidad, computadoras);
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
        return "CentroLaboratorio{" + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", contrase\u00f1aMaster=" + contraseñaMaster + ", unidad=" + unidad + ", computadoras=" + computadoras + '}';
    }

}
