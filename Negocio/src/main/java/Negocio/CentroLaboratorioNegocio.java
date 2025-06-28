/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.CentroLaboratorioDAO;
import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.ICentroLaboratorioDAO;
import DTOs.CentroLaboratorioDTO;
import Dominio.CentroLaboratorioDominio;
import Negocio.Interfaces.ICentroLaboratorioNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class CentroLaboratorioNegocio implements ICentroLaboratorioNegocio {

    ICentroLaboratorioDAO centro;

    public CentroLaboratorioNegocio() {
        this.centro = new CentroLaboratorioDAO();
    }

    public CentroLaboratorioDominio registrarCentro(CentroLaboratorioDTO centroLaboratorio) throws NegocioException {
        if (centroLaboratorio == null) {
            throw new NegocioException("El objeto CentroLaboratorio no puede ser nulo.");
        }

        if (centroLaboratorio.getNombre() == null || centroLaboratorio.getNombre().trim().isEmpty()) {
            throw new NegocioException("Debe proporcionar un nombre para el centro de laboratorio.");
        }

        if (centroLaboratorio.getContraseñaMaster() == null || centroLaboratorio.getContraseñaMaster().trim().isEmpty()) {
            throw new NegocioException("Debe establecer una contraseña maestra apropiada para el centro.");
        }

        if (centroLaboratorio.getFechaInicio() == null || centroLaboratorio.getFechaFin() == null) {
            throw new NegocioException("Debe indicar el horario de operación del centro.");
        }

        if (centroLaboratorio.getUnidad() == null || centroLaboratorio.getUnidad().getId() <= 0) {
            throw new NegocioException("Debe vincular una unidad académica válida al centro.");
        }

        try {
            return centro.registrar(centroLaboratorio);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar el centro de laboratorio: " + e.getMessage());
        }
    }

    public Long totalComputadorasEnCentro(CentroLaboratorioDominio centroLaboratorio) throws NegocioException {
        if (centroLaboratorio == null || centroLaboratorio.getId() <= 0) {
            throw new NegocioException("Debe proporcionar un centro de laboratorio válido.");
        }

        try {
            return centro.totalComputadoras(centroLaboratorio);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al contar computadoras del centro: " + e.getMessage());
        }
    }

    public List<CentroLaboratorioDominio> buscarCentrosPorUnidad(int idUnidad) throws NegocioException {
        if (idUnidad <= 0) {
            throw new NegocioException("Debe proporcionar un ID de unidad válido.");
        }

        try {
            List<CentroLaboratorioDominio> lista = centro.buscarPorId(idUnidad);
            if (lista == null || lista.isEmpty()) {
                throw new NegocioException("No se encontraron centros para la unidad indicada.");
            }
            return lista;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar centros por unidad: " + e.getMessage());
        }
    }

}
