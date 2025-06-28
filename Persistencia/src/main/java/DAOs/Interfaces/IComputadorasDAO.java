/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs.Interfaces;

import DAOs.Exception.PersistenciaException;
import DTOs.ComputadoraDTO;
import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IComputadorasDAO {

    ComputadoraDominio registrar(ComputadoraDTO compu) throws PersistenciaException;

    List<ComputadoraDominio> BuscarActivas() throws PersistenciaException;

    List<ComputadoraDominio> BuscarInactivas() throws PersistenciaException;

    ComputadoraDominio buscarId(int id) throws PersistenciaException;

    ComputadoraDominio buscar(ComputadoraDTO compu) throws PersistenciaException;

    List<SoftwareDominio> getSoftwareEnComputadoras(int idComputadora) throws PersistenciaException;
}
