/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs.Interfaces;

import DAOs.Exception.PersistenciaException;
import DTOs.CentroLaboratorioDTO;
import Dominio.CentroLaboratorioDominio;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface ICentroLaboratorioDAO {

    CentroLaboratorioDominio registrar(CentroLaboratorioDTO centro) throws PersistenciaException;

    Long totalComputadoras(CentroLaboratorioDominio centro) throws PersistenciaException;

    List<CentroLaboratorioDominio> buscarPorId(int id) throws PersistenciaException;
}
