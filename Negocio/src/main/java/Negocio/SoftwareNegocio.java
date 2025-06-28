/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.ISoftwareDAO;
import DAOs.SoftwareDAO;
import DTOs.SoftwareDTO;
import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import Negocio.Interfaces.ISoftwareNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class SoftwareNegocio implements ISoftwareNegocio{

    ISoftwareDAO softwareDAO;

    public SoftwareNegocio() {
        this.softwareDAO = new SoftwareDAO();
    }

    public SoftwareDominio registrarSoftware(SoftwareDTO software) throws NegocioException {
        if (software == null || software.getDominio() == null) {
            throw new NegocioException("Debes proporcionar un objeto Software válido.");
        }

        if (software.getNombre() == null || software.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre del software no puede estar vacío.");
        }

        try {
            return softwareDAO.registrar(software);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar software: " + e.getMessage());
        }
    }

    public SoftwareDominio buscarSoftware(SoftwareDTO software) throws NegocioException {
        if (software == null || software.getDominio() == null) {
            throw new NegocioException("El objeto Software no puede ser nulo.");
        }

        try {
            SoftwareDominio resultado = softwareDAO.buscar(software);
            if (resultado == null) {
                throw new NegocioException("No se encontró el software especificado.");
            }
            return resultado;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar software: " + e.getMessage());
        }
    }

    public SoftwareDominio buscarSoftwarePorId(int id) throws NegocioException {
        if (id <= 0) {
            throw new NegocioException("El ID del software debe ser mayor a cero.");
        }

        try {
            SoftwareDominio resultado = softwareDAO.buscarId(id);
            if (resultado == null) {
                throw new NegocioException("No se encontró ningún software con ese ID.");
            }
            return resultado;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar software por ID: " + e.getMessage());
        }
    }

    public List<ComputadoraDominio> obtenerComputadorasConSoftware(int idSoftware) throws NegocioException {
        if (idSoftware <= 0) {
            throw new NegocioException("El ID del software debe ser válido (mayor a cero).");
        }

        try {
            List<ComputadoraDominio> lista = softwareDAO.getComputadorasConSoftware(idSoftware);
            if (lista == null || lista.isEmpty()) {
                throw new NegocioException("No se encontraron computadoras con este software instalado.");
            }
            return lista;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar computadoras con el software: " + e.getMessage());
        }
    }

}
