/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import DTOs.CentroLaboratorioDTO;
import Dominio.CentroLaboratorioDominio;
import Facade.Interfaces.ICentroLaboratorioFacade;
import Negocio.CentroLaboratorioNegocio;
import Negocio.Interfaces.ICentroLaboratorioNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class CentroLaboratorioFacade implements ICentroLaboratorioFacade {
    private ICentroLaboratorioNegocio centro;

    public CentroLaboratorioFacade() {
        this.centro = new CentroLaboratorioNegocio();
    }

    @Override
    public CentroLaboratorioDominio registrarCentro(CentroLaboratorioDTO centroLaboratorio) throws NegocioException {
       return this.centro.registrarCentro(centroLaboratorio);
    }

    @Override
    public Long totalComputadorasEnCentro(CentroLaboratorioDominio centroLaboratorio) throws NegocioException {
        return this.centro.totalComputadorasEnCentro(centroLaboratorio);
    }

    @Override
    public List<CentroLaboratorioDominio> buscarCentrosPorUnidad(int idUnidad) throws NegocioException {
        return this.centro.buscarCentrosPorUnidad(idUnidad);
    }
}
