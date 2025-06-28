/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade.Interfaces;

import DTOs.ComputadoraDTO;
import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IComputadorasFacade {

    ComputadoraDominio registrarComputadora(ComputadoraDTO compu) throws NegocioException;

    List<ComputadoraDominio> buscarComputadorasActivas() throws NegocioException;

    List<ComputadoraDominio> buscarComputadorasInactivas() throws NegocioException;

    ComputadoraDominio buscarComputadoraPorId(int id) throws NegocioException;

    ComputadoraDominio buscarComputadora(ComputadoraDTO compu) throws NegocioException;

    List<SoftwareDominio> obtenerSoftwareEnComputadora(int idComputadora) throws NegocioException;
}
