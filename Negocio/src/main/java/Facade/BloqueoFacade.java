/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import DTOs.BloqueoDTO;
import Dominio.BloqueoDominio;
import Facade.Interfaces.IBloqueoFacade;
import Negocio.BloqueoNegocio;
import Negocio.Interfaces.IBloqueoNegocio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class BloqueoFacade implements IBloqueoFacade {
     private IBloqueoNegocio bloqueoNegocio;

    public BloqueoFacade() {
        this.bloqueoNegocio = new BloqueoNegocio();
    }
     
    
     
    @Override
    public BloqueoDominio registrarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        return bloqueoNegocio.registrarBloqueo(bloqueo);
                
    }

    @Override
    public BloqueoDominio buscarBloqueoPorId(int id) throws NegocioException {
        return this.bloqueoNegocio.buscarBloqueoPorId(id);
}

    @Override
    public BloqueoDominio buscarBloqueo(BloqueoDTO bloqueo) throws NegocioException {
        return this.bloqueoNegocio.buscarBloqueo(bloqueo);
        }

    @Override
    public List<BloqueoDominio> buscarBloqueosDeAlumno(int idAlumno) throws NegocioException {
        return this.bloqueoNegocio.buscarBloqueosDeAlumno(idAlumno);
    }
    
}
