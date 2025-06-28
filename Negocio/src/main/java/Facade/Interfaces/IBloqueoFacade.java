/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Facade.Interfaces;

import DTOs.BloqueoDTO;
import Dominio.BloqueoDominio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IBloqueoFacade {
    
    BloqueoDominio registrarBloqueo(BloqueoDTO bloqueo) throws NegocioException;

    BloqueoDominio buscarBloqueoPorId(int id) throws NegocioException;

    BloqueoDominio buscarBloqueo(BloqueoDTO bloqueo) throws NegocioException;
    
    List<BloqueoDominio> buscarBloqueosDeAlumno (int idAlumno) throws NegocioException;
}
