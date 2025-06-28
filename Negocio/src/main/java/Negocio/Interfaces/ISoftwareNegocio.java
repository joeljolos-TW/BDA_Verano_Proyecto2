/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.Interfaces;

import DTOs.SoftwareDTO;
import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import NegocioException.NegocioException;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface ISoftwareNegocio {

    SoftwareDominio registrarSoftware(SoftwareDTO software) throws NegocioException;

    SoftwareDominio buscarSoftware(SoftwareDTO software) throws NegocioException;

    SoftwareDominio buscarSoftwarePorId(int id) throws NegocioException;

    List<ComputadoraDominio> obtenerComputadorasConSoftware(int idSoftware) throws NegocioException;
}
