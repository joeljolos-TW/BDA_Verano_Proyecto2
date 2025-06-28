/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.IComputadorasDAO;
import DTOs.ComputadoraDTO;
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
public class ComputadoraDAO implements IComputadorasDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("CISCO");
    EntityManager manager;

    public ComputadoraDAO() {
    }

    public ComputadoraDominio registrar(ComputadoraDTO compu) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            manager.getTransaction().begin();
            manager.persist(compu.getDominio());
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            manager.close();
        }
        throw new PersistenciaException("Error: error en registrar computadora");
    }

    public List<ComputadoraDominio> BuscarActivas() throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            String querry = """
                            SELECT c FROM Computadora c WHERE c.estatus = 'activa'
                            """;
            TypedQuery typedQuery = manager.createNamedQuery(querry, ComputadoraDominio.class);
            return typedQuery.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        } finally {
            manager.close();
        }

    }

    public List<ComputadoraDominio> BuscarInactivas() throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            String querry = """
                            SELECT c FROM Computadora c WHERE c.estatus = 'Inactiva'
                            """;
            TypedQuery typedQuery = manager.createNamedQuery(querry, ComputadoraDominio.class);
            return typedQuery.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        } finally {
            manager.close();
        }

    }

    public ComputadoraDominio buscarId(int id) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            String query = "SELECT a FROM computadoras a WHERE a.id = :id";
            TypedQuery<ComputadoraDominio> typedQuery = manager.createQuery(query, ComputadoraDominio.class);
            typedQuery.setParameter("id", id);
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }

    }

    public ComputadoraDominio buscar(ComputadoraDTO compu) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            return manager.find(ComputadoraDominio.class, compu);
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    public List<SoftwareDominio> getSoftwareEnComputadoras(int idComputadora) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }

            String query = "SELECT si.software FROM SoftwareInstalado si WHERE si.computadora.id = :id";
            TypedQuery<SoftwareDominio> typedQuery = manager.createQuery(query, SoftwareDominio.class);
            typedQuery.setParameter("idComputadora", idComputadora);
            return typedQuery.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException(ex.getMessage());
        } finally {
            manager.close();
        }
    }

}
