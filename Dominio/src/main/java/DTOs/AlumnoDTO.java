/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;


import Dominio.AlumnoDominio;
import Dominio.CarreraDominio;
import Enumeradores.EstadosAlumno;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class AlumnoDTO {


    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String contraseña;

    private EstadosAlumno estado;

    private CarreraDominio carrera;
    
    
    public AlumnoDominio getDominio(){
        return new AlumnoDominio(nombre,
                apellidoPaterno,
                apellidoMaterno,
                contraseña,
                estado,
                null,
                carrera);
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

    public EstadosAlumno getEstado() {
        return estado;
    }

    public void setEstado(EstadosAlumno estado) {
        this.estado = estado;
    }

    public CarreraDominio getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDominio carrera) {
        this.carrera = carrera;
    }

}
