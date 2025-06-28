/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.IReservasDAO;
import DAOs.ReservasDAO;
import DTOs.ComputadoraDTO;
import DTOs.ReservaDTO;
import Dominio.ReservaDominio;
import Negocio.Interfaces.IReservasNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class ReservasNegocio implements IReservasNegocio {

    IReservasDAO reservaDAO;

    public ReservasNegocio() {
        this.reservaDAO = new ReservasDAO();
    }

    public ReservaDominio registrarReserva(ReservaDTO reserva) throws NegocioException {
        if (reserva == null) {
            throw new NegocioException("Debes proporcionar una reserva válida.");
        }

        if (reserva.getFechaHoraInicio() == null || reserva.getFechaHoraInicio() == null) {
            throw new NegocioException("Debes indicar la fecha de inicio y fin de la reserva.");
        }

        if (reserva.getFechaHoraFin().before(reserva.getFechaHoraFin())) {
            throw new NegocioException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }

        if (reserva.getAlumno() == null) {
            throw new NegocioException("Debe indicar un alumno válido para esta reserva.");
        }

        if (reserva.getComputadora() == null || reserva.getComputadora().getId() <= 0) {
            throw new NegocioException("Debe seleccionar una computadora válida para esta reserva.");
        }

        try {
            return reservaDAO.registrar(reserva);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar reserva: " + e.getMessage());
        }
    }

    public ReservaDominio buscarReservaPorId(int id) throws NegocioException {
        if (id <= 0) {
            throw new NegocioException("El ID de la reserva debe ser mayor que cero.");
        }

        try {
            ReservaDominio reserva = reservaDAO.buscarId(id);
            if (reserva == null) {
                throw new NegocioException("No se encontró ninguna reserva con ese ID.");
            }
            return reserva;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la reserva por ID: " + e.getMessage());
        }
    }

    public ReservaDominio buscarReserva(ReservaDTO reserva) throws NegocioException {
        if (reserva == null || reserva.getDominio() == null) {
            throw new NegocioException("Debes proporcionar una reserva válida para buscar.");
        }

        try {
            ReservaDominio resultado = reservaDAO.buscar(reserva);
            if (resultado == null) {
                throw new NegocioException("No se encontró la reserva especificada.");
            }
            return resultado;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la reserva: " + e.getMessage());
        }
    }

    public List<ReservaDominio> buscarReservasPorComputadora(ComputadoraDTO compu) throws NegocioException {
        if (compu == null || compu.getDominio() == null) {
            throw new NegocioException("Debes proporcionar una computadora válida para consultar sus reservas.");
        }

        try {
            List<ReservaDominio> reservas = reservaDAO.ReservasComputadora(compu);
            if (reservas == null || reservas.isEmpty()) {
                throw new NegocioException("No hay reservas registradas para esta computadora.");
            }
            return reservas;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar reservas de la computadora: " + e.getMessage());
        }
    }

}
