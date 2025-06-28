/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import DTOs.ComputadoraDTO;
import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import Facade.Interfaces.IComputadorasFacade;
import Negocio.Interfaces.IAlumnoNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class ComputadorasFacade implements IComputadorasFacade {
    
    private IComputadorasFacade computadora;

    public ComputadorasFacade() {
        this.computadora = new ComputadorasFacade();
    }
    
    
    
    @Override
    public ComputadoraDominio registrarComputadora(ComputadoraDTO compu) throws NegocioException {
        return this.computadora.registrarComputadora(compu);
    }

    @Override
    public List<ComputadoraDominio> buscarComputadorasActivas() throws NegocioException {
        return this.computadora.buscarComputadorasActivas();
        }

    @Override
    public List<ComputadoraDominio> buscarComputadorasInactivas() throws NegocioException {
        return this.computadora.buscarComputadorasInactivas();
        }

    @Override
    public ComputadoraDominio buscarComputadoraPorId(int id) throws NegocioException {
        return this.computadora.buscarComputadoraPorId(id);
    }

    @Override
    public ComputadoraDominio buscarComputadora(ComputadoraDTO compu) throws NegocioException {
        return this.computadora.buscarComputadora(compu);
    }

    @Override
    public List<SoftwareDominio> obtenerSoftwareEnComputadora(int idComputadora) throws NegocioException {
        return this.computadora.obtenerSoftwareEnComputadora(idComputadora);
    }
    
}
