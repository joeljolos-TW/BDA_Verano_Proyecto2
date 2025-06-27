/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joel_
 */
@Entity
@Table(name = "Bloqueo")
public class BloqueoDominio implements Serializable {


    @Id
    @Column(name = "idBloqueo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;
    
    @Column(name = "fechaFin", nullable = false)
    private Date fechaFin;
    
    @Column(name = "motivo", nullable = false)
    private String motivo;
    
    @ManyToOne()
    @JoinColumn(name = "idAlumno",nullable = false)
    private AlumnoDominio alumno;

    public BloqueoDominio() {
    }

    
    public BloqueoDominio( Date fechaInicio, Date fechaFin, String motivo, AlumnoDominio alumno) {
        
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.motivo = motivo;
        this.alumno = alumno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "BloqueoDominio{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", motivo=" + motivo + ", alumno=" + alumno + '}';
    }
    
    
    
}
