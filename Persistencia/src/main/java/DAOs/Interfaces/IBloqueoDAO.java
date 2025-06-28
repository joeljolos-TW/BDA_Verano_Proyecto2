/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs.Interfaces;

import DAOs.Exception.PersistenciaException;
import DTOs.BloqueoDTO;
import Dominio.BloqueoDominio;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IBloqueoDAO {
    BloqueoDominio registrar(BloqueoDTO bloqueo) throws PersistenciaException;
    BloqueoDominio buscarId(int id) throws PersistenciaException ;
    BloqueoDominio buscar(BloqueoDTO bloqueo) throws PersistenciaException;
    List<BloqueoDominio> buscarAlumno(int id) throws PersistenciaException;
    
    
}
