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

/**
 *
 * @author joel_
 */
@Entity
public class ReservaDominio implements Serializable {

    @Id
    @Column(name = "idReserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaHoraInicio", nullable = false)
    private Date fechaHoraInicio;
    @Column(name = "fechaHoraFin", nullable = false)
    private Date fechaHoraFin;
    
    @ManyToOne()
    @JoinColumn(name = "idComputadora",nullable = false)
    private ComputadoraDominio computadora;
    @ManyToOne()
    @JoinColumn(name = "idAlumno", nullable = false)
    private AlumnoDominio alumno;

    public ReservaDominio() {
    }

    public ReservaDominio(Date fechaHoraInicio, Date fechaHoraFin, ComputadoraDominio computadora, AlumnoDominio alumno) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.computadora = computadora;
        this.alumno = alumno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public ComputadoraDominio getComputadora() {
        return computadora;
    }

    public void setComputadora(ComputadoraDominio computadora) {
        this.computadora = computadora;
    }

    public AlumnoDominio getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDominio alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "ReservaDominio{" + "id=" + id + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + ", computadora=" + computadora + ", alumno=" + alumno + '}';
    }
    
    
}
