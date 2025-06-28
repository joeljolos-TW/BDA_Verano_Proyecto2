/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DAOs.Exception.PersistenciaException;
import DAOs.Interfaces.IReservasDAO;
import DTOs.ComputadoraDTO;
import DTOs.ReservaDTO;
import Dominio.ComputadoraDominio;
import Dominio.ReservaDominio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.config.EntityManagerProperties;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class ReservasDAO implements IReservasDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("CISCO");
    EntityManager manager;

    public ReservasDAO() {
    }

    public ReservaDominio registrar(ReservaDTO reserva) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            manager.getTransaction().begin();
            manager.persist(reserva.getDominio());
            manager.getTransaction().commit();
            return manager.find(ReservaDominio.class, reserva);
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());

        } finally {
            manager.close();
        }
    }

    public ReservaDominio buscarId(int id) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            String query = "SELECT a FROM Reservas a WHERE a.id = :id";
            TypedQuery<ReservaDominio> typedQuery = manager.createQuery(query, ReservaDominio.class);
            typedQuery.setParameter("id", id);
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        } finally {
            manager.close();
        }
    }

    public ReservaDominio buscar(ReservaDTO reserva) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }

            return manager.find(ReservaDominio.class, reserva);

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    public List<ReservaDominio> ReservasComputadora(ComputadoraDTO compu) throws PersistenciaException {
        try {
            if (!manager.isOpen() || manager == null) {
                manager = factory.createEntityManager();
            }
            String query = "SELECT r FROM Reserva r WHERE r.computadora.id = :idComputadora";
            TypedQuery<ReservaDominio> typedQuery = manager.createQuery(query, ReservaDominio.class);
            ComputadoraDominio computadoraDominio = manager.find(ComputadoraDominio.class, compu.getDominio());

            typedQuery.setParameter("idComputadora", computadoraDominio.getId());
            return typedQuery.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage());

        }
    }

}
