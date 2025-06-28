/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import DTOs.SoftwareDTO;
import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import Facade.Interfaces.ISoftwareFacade;
import Negocio.Interfaces.ISoftwareNegocio;
import Negocio.SoftwareNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class SoftwareFacade implements ISoftwareFacade {

    private SoftwareNegocio softwareNegocio;

    public SoftwareFacade() {
        this.softwareNegocio = new SoftwareNegocio();
    }

    @Override
    public SoftwareDominio registrarSoftware(SoftwareDTO software) throws NegocioException {
        return this.softwareNegocio.registrarSoftware(software);
    }

    @Override
    public SoftwareDominio buscarSoftware(SoftwareDTO software) throws NegocioException {
        return this.softwareNegocio.buscarSoftware(software);
    }

    @Override
    public SoftwareDominio buscarSoftwarePorId(int id) throws NegocioException {
        return this.softwareNegocio.buscarSoftwarePorId(id);
    }

    @Override
    public List<ComputadoraDominio> obtenerComputadorasConSoftware(int idSoftware) throws NegocioException {
        return this.softwareNegocio.obtenerComputadorasConSoftware(idSoftware);
    }

}
