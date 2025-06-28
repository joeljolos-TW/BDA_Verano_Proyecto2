/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.ComputadoraDAO;
import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.IComputadorasDAO;
import DTOs.ComputadoraDTO;
import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import Negocio.Interfaces.IComputadorasNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class ComputadorasNegocio implements IComputadorasNegocio {

    IComputadorasDAO computadoraDAO;

    public ComputadorasNegocio() {
        this.computadoraDAO = new ComputadoraDAO();
    }

    public ComputadoraDominio registrarComputadora(ComputadoraDTO compu) throws NegocioException {
        if (compu == null || compu.getDominio() == null) {
            throw new NegocioException("Debes proporcionar una computadora válida.");
        }

        if (compu.getNumMaquina() <= 0) {
            throw new NegocioException("El número de máquina debe ser mayor que cero.");
        }

        if (compu.getDireccionIP() == null || compu.getDireccionIP().trim().isEmpty()) {
            throw new NegocioException("La dirección IP no puede estar vacía.");
        }

        if (compu.getEstado() == null) {
            throw new NegocioException("Debes especificar el estatus de la computadora.");
        }

        try {
            return computadoraDAO.registrar(compu);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar la computadora: " + e.getMessage());
        }
    }

    public List<ComputadoraDominio> buscarComputadorasActivas() throws NegocioException {
        try {
            List<ComputadoraDominio> lista = computadoraDAO.BuscarActivas();
            if (lista == null || lista.isEmpty()) {
                throw new NegocioException("No se encontraron computadoras activas.");
            }
            return lista;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar computadoras activas: " + e.getMessage());
        }
    }

    public List<ComputadoraDominio> buscarComputadorasInactivas() throws NegocioException {
        try {
            List<ComputadoraDominio> lista = computadoraDAO.BuscarInactivas();
            if (lista == null || lista.isEmpty()) {
                throw new NegocioException("No se encontraron computadoras inactivas.");
            }
            return lista;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar computadoras inactivas: " + e.getMessage());
        }
    }

    public ComputadoraDominio buscarComputadoraPorId(int id) throws NegocioException {
        if (id <= 0) {
            throw new NegocioException("El ID de la computadora debe ser mayor que cero.");
        }

        try {
            ComputadoraDominio compu = computadoraDAO.buscarId(id);
            if (compu == null) {
                throw new NegocioException("No se encontró ninguna computadora con el ID proporcionado.");
            }
            return compu;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar computadora por ID: " + e.getMessage());
        }
    }

    public ComputadoraDominio buscarComputadora(ComputadoraDTO compu) throws NegocioException {
        if (compu == null || compu.getDominio() == null) {
            throw new NegocioException("Debe proporcionar un objeto Computadora válido.");
        }

        try {
            ComputadoraDominio resultado = computadoraDAO.buscar(compu);
            if (resultado == null) {
                throw new NegocioException("No se encontró la computadora especificada.");
            }
            return resultado;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar la computadora: " + e.getMessage());
        }
    }

    public List<SoftwareDominio> obtenerSoftwareEnComputadora(int idComputadora) throws NegocioException {
        if (idComputadora <= 0) {
            throw new NegocioException("Debe proporcionar un ID de computadora válido.");
        }

        try {
            List<SoftwareDominio> lista = computadoraDAO.getSoftwareEnComputadoras(idComputadora);
            if (lista == null || lista.isEmpty()) {
                throw new NegocioException("La computadora no tiene software instalado.");
            }
            return lista;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener software instalado: " + e.getMessage());
        }
    }

}
