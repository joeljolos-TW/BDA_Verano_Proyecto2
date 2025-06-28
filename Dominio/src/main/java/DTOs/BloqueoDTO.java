/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Dominio.AlumnoDominio;
import Dominio.BloqueoDominio;

import java.util.Date;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class BloqueoDTO {
    
    private Date fechaInicio;
    
    private Date fechaFin;
    
    private String motivo;
    
    private AlumnoDominio alumno;

    public BloqueoDTO() {
    }

    
    public BloqueoDTO( Date fechaInicio, Date fechaFin, String motivo, AlumnoDominio alumno) {
        
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.motivo = motivo;
        this.alumno = alumno;
    }
    
    public BloqueoDominio getDominio(){
        return new BloqueoDominio(fechaInicio, fechaFin, motivo, alumno);
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public AlumnoDominio getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDominio alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "BloqueoDominio{" + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", motivo=" + motivo + ", alumno=" + alumno + '}';
    }
    
    
}
