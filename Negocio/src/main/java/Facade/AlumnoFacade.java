/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import DTOs.AlumnoDTO;
import Dominio.AlumnoDominio;
import Facade.Interfaces.IAlumnoFacade;
import Negocio.AlumnoNegocio;
import Negocio.Interfaces.IAlumnoNegocio;
import NegocioException.NegocioException;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class AlumnoFacade implements IAlumnoFacade {

    private IAlumnoNegocio alumnoNegocio;

    public AlumnoFacade() {

        this.alumnoNegocio = new AlumnoNegocio();
    }

    @Override
    public AlumnoDominio Registrar(AlumnoDTO alumno) throws NegocioException {
        return this.alumnoNegocio.registrar(alumno);
    }

    @Override
    public AlumnoDominio buscarPorId(int id) throws NegocioException {
        return this.alumnoNegocio.buscarPorId(id);
    }

    @Override
    public AlumnoDominio buscar(AlumnoDTO alumno) throws NegocioException {
        return this.alumnoNegocio.buscar(alumno);
    }

    @Override
    public AlumnoDominio actualizar(AlumnoDTO alumno) throws NegocioException {
        return this.alumnoNegocio.actualizar(alumno);
    }

}
