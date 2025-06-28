/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.Interfaces;

import DTOs.CentroLaboratorioDTO;
import Dominio.CentroLaboratorioDominio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface ICentroLaboratorioNegocio {

    CentroLaboratorioDominio registrarCentro(CentroLaboratorioDTO centroLaboratorio) throws NegocioException;

    Long totalComputadorasEnCentro(CentroLaboratorioDominio centroLaboratorio) throws NegocioException;

    List<CentroLaboratorioDominio> buscarCentrosPorUnidad(int idUnidad) throws NegocioException;

}
