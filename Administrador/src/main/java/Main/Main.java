/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import javax.swing.SwingUtilities;
import AdministradorVentanas.FRMAdmin;
/**
 *
 * @author joel_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            FRMAdmin admin = new FRMAdmin();            
        });
        
    }
    
}
