/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.ICentroLaboratorioDAO;
import DTOs.CentroLaboratorioDTO;
import Dominio.CentroLaboratorioDominio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class CentroLaboratorioDAO implements ICentroLaboratorioDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("CISCO");
    EntityManager manager;

    public CentroLaboratorioDAO() {
    }

    public CentroLaboratorioDominio registrar(CentroLaboratorioDTO centro) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager==null) {
                manager= factory.createEntityManager();
            }
            manager.getTransaction().begin();
            manager.persist(centro);
            manager.getTransaction().commit();
            return manager.find(CentroLaboratorioDominio.class, centro.getDominio());
        } catch (Exception e) {
            manager.getTransaction().begin();
            throw new PersistenciaException(e.getMessage());
        }
        finally {
            manager.close();
        }
    }

    public Long totalComputadoras(CentroLaboratorioDominio centro) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager==null) {
                manager = factory.createEntityManager();
            }
            String query = "SELECT COUNT(c) FROM Computadora c WHERE c.centroLaboratorio.id = :id";
            TypedQuery<Long> typedQuery = manager.createQuery(query, Long.class);
            typedQuery.setParameter("id", centro.getId());
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
        finally {
            manager.close();
        }
    }

    public List<CentroLaboratorioDominio> buscarPorId(int id) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager==null) {
                manager= factory.createEntityManager();
            }
            String jpql = "SELECT c FROM CentroLaboratorio c WHERE c.unidad.id = :id";
            TypedQuery<CentroLaboratorioDominio> typedQuery = manager.createQuery(jpql, CentroLaboratorioDominio.class);
            typedQuery.setParameter("id", id);
            return typedQuery.getResultList();

        } catch (Exception ex) {
            throw new PersistenciaException(ex.getMessage());
        }
        finally {
            manager.close();
        }

    }
    
    

}
