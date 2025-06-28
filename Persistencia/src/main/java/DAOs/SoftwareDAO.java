/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.ISoftwareDAO;
import DTOs.SoftwareDTO;
import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class SoftwareDAO implements ISoftwareDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("CISCO");
    EntityManager manager;

    public SoftwareDAO() {
    }

    public SoftwareDominio registrar(SoftwareDTO software) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            manager.getTransaction().begin();
            manager.persist(software.getDominio());
            manager.getTransaction().commit();
            return manager.find(SoftwareDominio.class, software.getDominio());

        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        }
    }

    public SoftwareDominio buscar(SoftwareDTO software) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            manager.find(SoftwareDominio.class, software.getDominio());

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
        throw new PersistenciaException("Error: error al buscar el software");
    }

    public SoftwareDominio buscarId(int id) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            String jpql = "SELECT s FROM Software s WHERE id = :id";
            TypedQuery<SoftwareDominio> query = manager.createQuery(jpql, SoftwareDominio.class);
            query.setParameter("id", id);
            return query.getSingleResult();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }

    }

    public List<ComputadoraDominio> getComputadorasConSoftware(int idSoftware) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            String query = "SELECT si.computadora FROM SoftwareInstalado si WHERE si.software.id = :id";
            TypedQuery<ComputadoraDominio> typedQuery = manager.createQuery(query, ComputadoraDominio.class);
            typedQuery.setParameter("id", idSoftware);
            return typedQuery.getResultList();

        } catch (Exception ex) {
            throw new PersistenciaException(ex.getMessage());
        } finally {
            manager.close();
        }
    }

}
