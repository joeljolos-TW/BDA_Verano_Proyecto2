/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import Dominio.AlumnoDominio;
import Dominio.ComputadoraDominio;
import Dominio.ReservaDominio;
import java.util.Date;

/**
 *
 * @author joel_
 */
public class ReservaDTO {

    private Date fechaHoraInicio;

    private Date fechaHoraFin;

    private ComputadoraDominio computadora;

    private AlumnoDominio alumno;

    public ReservaDTO() {
    }

    public ReservaDTO(Date fechaHoraInicio, Date fechaHoraFin, ComputadoraDominio computadora, AlumnoDominio alumno) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.computadora = computadora;
        this.alumno = alumno;
    }

    public ReservaDominio getDominio() {
        return new ReservaDominio(fechaHoraInicio, fechaHoraFin, computadora, alumno);
        
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
        return "ReservaDominio{" + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + ", computadora=" + computadora + ", alumno=" + alumno + '}';
    }

}
