/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs.Interfaces;

import DAOs.Exception.PersistenciaException;
import DTOs.ComputadoraDTO;
import DTOs.ReservaDTO;
import Dominio.ReservaDominio;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IReservasDAO {
    ReservaDominio registrar(ReservaDTO reserva) throws PersistenciaException;
    ReservaDominio buscarId(int id) throws PersistenciaException;
    ReservaDominio buscar(ReservaDTO reserva) throws PersistenciaException;
    List<ReservaDominio> ReservasComputadora(ComputadoraDTO compu) throws PersistenciaException;
}
