/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import AdministradorVentanas.FRMAdmin;
import DTOs.AlumnoDTO;
import Enumeradores.EstadoAlumnos;
import Facade.AlumnoFacade;
import Facade.BloqueoFacade;
import Facade.CentroLaboratorioFacade;
import Facade.ComputadorasFacade;
import Facade.ReservasFacade;
import Facade.SoftwareFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author joel_
 */
public class Main {

    
    private AlumnoFacade alumFcd;
    private BloqueoFacade bloqFcd;
    private CentroLaboratorioFacade clFcd;
    private ComputadorasFacade comFcd;
    private ReservasFacade resFcd;
    private SoftwareFacade softFcd;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FRMAdmin admon = new FRMAdmin();
        admon.setVisible(true);
    }
    
    
   
}
