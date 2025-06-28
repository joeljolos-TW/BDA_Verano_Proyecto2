/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade.Interfaces;

import DTOs.ComputadoraDTO;
import DTOs.ReservaDTO;
import Dominio.ReservaDominio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IReservasFacade {

    ReservaDominio registrarReserva(ReservaDTO reserva) throws NegocioException;

    ReservaDominio buscarReservaPorId(int id) throws NegocioException;

    ReservaDominio buscarReserva(ReservaDTO reserva) throws NegocioException;

    List<ReservaDominio> buscarReservasPorComputadora(ComputadoraDTO compu) throws NegocioException;
}
