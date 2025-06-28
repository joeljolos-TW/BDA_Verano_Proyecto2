/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.AlumnoDAO;
import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.IAlumnoDAO;
import DTOs.AlumnoDTO;
import Dominio.AlumnoDominio;
import Negocio.Interfaces.IAlumnoNegocio;
import NegocioException.NegocioException;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class AlumnoNegocio implements IAlumnoNegocio {

    IAlumnoDAO alumnoDAO;

    public AlumnoNegocio() {
        this.alumnoDAO = new AlumnoDAO();
    }

    public AlumnoDominio registrar(AlumnoDTO alumno) throws NegocioException {
        try {
            if (alumno == null) {
                throw new NegocioException("El alumno a registrar no puede estar nulo/vacio");
            }
            if (alumno.getEstado() == null) {
                throw new NegocioException("no puede ingresar un alumno con estatus nulo");
            }
            if (alumno.getNombre() == null || alumno.getNombre().trim().length() == 0) {
                throw new NegocioException("No puede ingresar un alumno sin nombre");
            }
            if (alumno.getApellidoPaterno() == null || alumno.getApellidoPaterno().trim().length() == 0) {
                throw new NegocioException("No puede ingresar un alumno sin apellido paterno");
            }
            if (alumno.getContraseña() == null || alumno.getContraseña().trim().length() == 0) {
                throw new NegocioException("No puede ingresar un alumno sin contraseña");
            }
            if (alumno.getCarrera() == null || alumno.getCarrera().getId() < 1 || alumno.getCarrera().getId() > 5) {
                throw new NegocioException("No puede ingresar un alumno sin alguna carrera");
            }
            alumnoDAO.registrarAlumno(alumno);
        } catch (PersistenciaException | NegocioException e) {
            throw new NegocioException(e.getMessage());
        }
        throw new NegocioException("Error:error hubo un problema al registrar un alumno");
    }

    public AlumnoDominio buscarPorId(int id) throws NegocioException {
        if (id <= 0) {
            throw new NegocioException("El ID del alumno debe ser mayor que cero.");
        }

        try {
            AlumnoDominio alumno = alumnoDAO.buscarID(id);
            if (alumno == null) {
                throw new NegocioException("No se encontró ningún alumno con el ID proporcionado.");
            }
            return alumno;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar el alumno: " + e.getMessage());
        }
    }

    public AlumnoDominio buscar(AlumnoDTO alumno) throws NegocioException {
        if (alumno == null) {
            throw new NegocioException("Debe proporcionar un alumno válido para realizar la búsqueda.");
        }

        try {
            AlumnoDominio resultado = alumnoDAO.buscar(alumno);
            if (resultado == null) {
                throw new NegocioException("No se encontró el alumno solicitado.");
            }
            return resultado;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar el alumno: " + e.getMessage());
        }
    }

    public AlumnoDominio actualizar(AlumnoDTO alumno) throws NegocioException {
        try {
            if (alumno == null || alumno.getDominio() == null) {
                throw new NegocioException("Debe proporcionar un alumno válido para actualizar.");
            }

            if (alumno.getNombre() == null || alumno.getNombre().trim().isEmpty()) {
                throw new NegocioException("El nombre del alumno no puede estar vacío.");
            }

            if (alumno.getApellidoPaterno() == null || alumno.getApellidoPaterno().trim().isEmpty()) {
                throw new NegocioException("Debe ingresar el apellido paterno del alumno.");
            }

            if (alumno.getContraseña() == null || alumno.getContraseña().trim().isEmpty()) {
                throw new NegocioException("Debe proporcionar una contraseña.");
            }

            if (alumno.getEstado() == null) {
                throw new NegocioException("Debe especificar el estatus del alumno.");
            }

            return alumnoDAO.actualizar(alumno);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar el alumno: " + e.getMessage());
        }
    }

}
