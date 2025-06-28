/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdministradorVentanas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author joel_
 */
public class PanelMenuReportes extends JPanel{
    private Image fondoImagen;

    public PanelMenuReportes() {
        try {
            fondoImagen = new ImageIcon(getClass().getResource("/img/MenuReportes.png")).getImage();
        } catch (Exception e) {
            System.err.println("Imagen no encontrada");
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondoImagen != null) {
            g.drawImage(fondoImagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
