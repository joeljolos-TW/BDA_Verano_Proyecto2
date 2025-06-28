/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import DTOs.ComputadoraDTO;
import DTOs.ReservaDTO;
import Dominio.ReservaDominio;
import Facade.Interfaces.IReservasFacade;
import Negocio.Interfaces.IReservasNegocio;
import Negocio.ReservasNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class ReservasFacade implements IReservasFacade {

    private IReservasNegocio reservas;

    public ReservasFacade() {
        this.reservas = new ReservasNegocio();
    }

    @Override
    public ReservaDominio registrarReserva(ReservaDTO reserva) throws NegocioException {
        return this.reservas.registrarReserva(reserva);
    }

    @Override
    public ReservaDominio buscarReservaPorId(int id) throws NegocioException {
        return this.reservas.buscarReservaPorId(id);
    }

    @Override
    public ReservaDominio buscarReserva(ReservaDTO reserva) throws NegocioException {
        return this.reservas.buscarReserva(reserva);
    }

    @Override
    public List<ReservaDominio> buscarReservasPorComputadora(ComputadoraDTO compu) throws NegocioException {
        return this.reservas.buscarReservasPorComputadora(compu);
    }

}
