/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs.Interfaces;

import DAOs.Exception.PersistenciaException;
import DTOs.SoftwareDTO;
import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface ISoftwareDAO {

    SoftwareDominio registrar(SoftwareDTO software) throws PersistenciaException;

    SoftwareDominio buscar(SoftwareDTO software) throws PersistenciaException;

    SoftwareDominio buscarId(int id) throws PersistenciaException;

    List<ComputadoraDominio> getComputadorasConSoftware(int idSoftware) throws PersistenciaException;    
}
