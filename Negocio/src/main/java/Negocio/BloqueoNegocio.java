/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.BloqueoDAO;
import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.IBloqueoDAO;
import DTOs.BloqueoDTO;
import Dominio.BloqueoDominio;
import Negocio.Interfaces.IBloqueoNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class BloqueoNegocio implements IBloqueoNegocio {

    IBloqueoDAO bloqueoDAO;

    public BloqueoNegocio() {
        this.bloqueoDAO = new BloqueoDAO();
    }

    public BloqueoDominio registrarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        if (bloqueo == null) {
            throw new NegocioException("El objeto Bloqueo no puede ser nulo.");
        }

        if (bloqueo.getFechaInicio() == null) {
            throw new NegocioException("Debes proporcionar la fecha del bloqueo.");
        }

        if (bloqueo.getMotivo() == null || bloqueo.getMotivo().trim().isEmpty()) {
            throw new NegocioException("Debes indicar el motivo del bloqueo.");
        }

        if (bloqueo.getAlumno() == null) {
            throw new NegocioException("Debes asociar un alumno válido al bloqueo.");
        }

        try {
            return bloqueoDAO.registrar(bloqueo);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar el bloqueo: " + e.getMessage());
        }
    }

    public BloqueoDominio buscarBloqueoPorId(int id) throws NegocioException {
        if (id <= 0) {
            throw new NegocioException("El ID del bloqueo debe ser mayor que cero.");
        }

        try {
            BloqueoDominio bloqueo = bloqueoDAO.buscarId(id);
            if (bloqueo == null) {
                throw new NegocioException("No se encontró ningún bloqueo con el ID proporcionado.");
            }
            return bloqueo;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar el bloqueo: " + e.getMessage());
        }
    }

    public BloqueoDominio buscarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        if (bloqueo == null || bloqueo.getDominio() == null) {
            throw new NegocioException("Debes proporcionar un objeto bloqueo válido para buscarlo.");
        }

        try {
            BloqueoDominio resultado = bloqueoDAO.buscar(bloqueo);
            if (resultado == null) {
                throw new NegocioException("El bloqueo solicitado no fue encontrado.");
            }
            return resultado;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar el bloqueo: " + e.getMessage());
        }
    }

    public List<BloqueoDominio> buscarBloqueosDeAlumno(int idAlumno) throws NegocioException {
        if (idAlumno <= 0) {
            throw new NegocioException("El ID del alumno debe ser mayor que cero.");
        }

        try {
            List<BloqueoDominio> bloqueos = bloqueoDAO.buscarAlumno(idAlumno);
            if (bloqueos == null || bloqueos.isEmpty()) {
                throw new NegocioException("No se encontraron bloqueos para este alumno.");
            }
            return bloqueos;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar bloqueos del alumno: " + e.getMessage());
        }
    }

}
