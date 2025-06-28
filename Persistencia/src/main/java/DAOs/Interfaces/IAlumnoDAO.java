/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs.Interfaces;

import DAOs.Exception.PersistenciaException;
import DTOs.AlumnoDTO;
import Dominio.AlumnoDominio;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface IAlumnoDAO {

    AlumnoDominio registrarAlumno(AlumnoDTO alumno) throws PersistenciaException;

    AlumnoDominio buscarID(int id) throws PersistenciaException;

    AlumnoDominio buscar(AlumnoDTO alumno) throws PersistenciaException;

    AlumnoDominio actualizar(AlumnoDTO alumno) throws PersistenciaException;

}
