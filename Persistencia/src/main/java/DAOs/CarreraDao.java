/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import Dominio.CarreraDominio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
/**
 *
 * @author joel_
 */
public class CarreraDao {
    
    private static final EntityManagerFactory factory = 
        Persistence.createEntityManagerFactory("CISCO");
   

   public List<CarreraDominio> obtenerCarreras() {
        EntityManager manager = factory.createEntityManager();
        List<CarreraDominio> carreras = new ArrayList<>();

        try {
            TypedQuery<CarreraDominio> query = 
                manager.createQuery("SELECT c FROM CarreraDominio c", CarreraDominio.class);
            carreras = query.getResultList();
        } finally {
            manager.close(); // se cierra el manager, pero el factory sigue activo
        }

        return carreras;
    }

    public CarreraDominio buscarPorNombre(String nombre) throws PersistenceException{
        EntityManager manager = factory.createEntityManager();
        CarreraDominio carrera = null;

        try {
            TypedQuery<CarreraDominio> query = manager.createQuery(
                "SELECT c FROM CarreraDominio c WHERE c.nombre = :nombre", CarreraDominio.class);
            query.setParameter("nombre", nombre);
            carrera = query.getSingleResult();
        } catch (PersistenceException e) {
            System.out.println("No se encontró una carrera con ese nombre.");
        } finally {
            manager.close();
        }

        return carrera;
    }

}
