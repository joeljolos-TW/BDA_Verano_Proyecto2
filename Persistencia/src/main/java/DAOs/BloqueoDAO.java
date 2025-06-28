/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.IBloqueoDAO;
import DTOs.BloqueoDTO;
import Dominio.BloqueoDominio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class BloqueoDAO implements IBloqueoDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("CISCO");
    EntityManager manager;

    public BloqueoDAO() {
    }

    public BloqueoDominio registrar(BloqueoDTO bloqueo) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager==null) {
                manager= factory.createEntityManager();
            }
            manager.getTransaction().begin();
            manager.persist(bloqueo);
            manager.getTransaction().commit();
            return manager.find(BloqueoDominio.class, bloqueo.getDominio());
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        }
        finally {
            manager.close();
        }
    }

    public BloqueoDominio buscarId(int id) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager==null) {
                manager= factory.createEntityManager();
            }
            String query = "SELECT a FROM bloqueos a WHERE a.id = :id";
            TypedQuery<BloqueoDominio> typedQuery = manager.createQuery(query, BloqueoDominio.class);
            typedQuery.setParameter("id", id);
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
        finally {
            manager.close();
        }

    }

    public BloqueoDominio buscar(BloqueoDTO bloqueo) throws PersistenciaException {
        try {
            return manager.find(BloqueoDominio.class, bloqueo.getDominio());
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
        finally {
            manager.close();
        }
    }

    public List<BloqueoDominio> buscarAlumno(int id) throws PersistenciaException {
        try {
            String query = "SELECT b FROM Bloqueo b WHERE b.alumno.id = :id";
            TypedQuery typedQuery= manager.createNamedQuery(query, BloqueoDominio.class);
            typedQuery.setParameter("id", id);
            return typedQuery.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
        finally {
            manager.close();
        }

    }
    
    
    
    
    
    
    

}
