/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.IAlumnoDAO;
import DTOs.AlumnoDTO;
import Dominio.AlumnoDominio;
import Enumeradores.EstadoAlumnos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class AlumnoDAO implements IAlumnoDAO {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CISCO");
    private EntityManager manager= factory.createEntityManager();

    public AlumnoDAO() {
    }

    public AlumnoDominio registrarAlumno(AlumnoDTO alumno) throws PersistenciaException {
        try {
            
            manager.getTransaction().begin();
            
            manager.persist(alumno.getDominio());
            
            manager.getTransaction().commit();
            
            return manager.find(AlumnoDominio.class, alumno);
            
        } catch (Exception e) {
            manager.getTransaction().rollback();
            manager.close();
            throw new PersistenciaException(e.getMessage());
        }finally{
            manager.close();
        }

    }

    public AlumnoDominio buscarID(int id) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            String query = "SELECT a FROM Alumno a WHERE a.id = :id";
            TypedQuery<AlumnoDominio> typedQuery = manager.createQuery(query, AlumnoDominio.class);
            typedQuery.setParameter("id", id);
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        } finally {
            manager.close();
        }

    }

    public AlumnoDominio buscar(AlumnoDTO alumno) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            return manager.find(AlumnoDominio.class, alumno.getDominio());
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        } finally {
            manager.close();
        }

    }

    public AlumnoDominio actualizar(AlumnoDTO alumno) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            manager.getTransaction().begin();
            manager.merge(alumno.getDominio());
            manager.getTransaction().commit();
            return manager.find(AlumnoDominio.class, alumno.getDominio());
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            manager.close();
        }
    }

}
