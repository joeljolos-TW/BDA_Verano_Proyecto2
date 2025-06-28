/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;

/**
 *
 * @author joel_
 */
import Enumeradores.EstadoAlumnos;
import java.io.Serializable;
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
@Table(name = "Alumno")
public class AlumnoDominio implements Serializable {

    @Id
    @Column(name = "idAlumno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidoPaterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = true)
    private String apellidoMaterno;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "estado", nullable = false)
    private EstadoAlumnos estado;

    @OneToMany(mappedBy = "alumno", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<BloqueoDominio> bloqueos;

    @OneToMany(mappedBy = "alumno", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<ReservaDominio> reservas;

    @ManyToOne()
    @JoinColumn(name = "idCarrera", nullable = false)
    private CarreraDominio carrera;

    public AlumnoDominio() {
    }

    public AlumnoDominio(String nombre, String apellidoPaterno, String apellidoMaterno, String contraseña, EstadoAlumnos estado, List<ReservaDominio> reservas, CarreraDominio carrera) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
        this.estado = estado;
        this.reservas = reservas;
        this.carrera = carrera;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public EstadoAlumnos getEstado() {
        return estado;
    }

    public void setEstado(EstadoAlumnos estado) {
        this.estado = estado;
    }

    public List<BloqueoDominio> getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(List<BloqueoDominio> bloqueos) {
        this.bloqueos = bloqueos;
    }
    

    public List<ReservaDominio> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaDominio> reservas) {
        this.reservas = reservas;
    }

    public CarreraDominio getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDominio carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "AlumnoDominio{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", contrase\u00f1a=" + contraseña + ", estado=" + estado + ", reservas=" + reservas + ", carrera=" + carrera + '}';
    }

}
