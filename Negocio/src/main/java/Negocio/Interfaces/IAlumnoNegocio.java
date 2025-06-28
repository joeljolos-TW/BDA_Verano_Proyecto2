/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.Interfaces;

import DTOs.AlumnoDTO;
import Dominio.AlumnoDominio;
import NegocioException.NegocioException;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IAlumnoNegocio {

    AlumnoDominio registrar(AlumnoDTO alumno) throws NegocioException;

    AlumnoDominio buscarPorId(int id) throws NegocioException;

    AlumnoDominio buscar(AlumnoDTO alumno) throws NegocioException;

    AlumnoDominio actualizar(AlumnoDTO alumno) throws NegocioException;

}
