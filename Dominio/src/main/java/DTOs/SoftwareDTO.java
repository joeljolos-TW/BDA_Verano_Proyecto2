/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;


import Dominio.ComputadoraDominio;
import Dominio.SoftwareDominio;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class SoftwareDTO {
    
    private String nombre;
    
    private List<ComputadoraDominio> computadoras;

    public SoftwareDTO() {
    }

    
    public SoftwareDTO( String nombre, List<ComputadoraDominio> computadoras) {

        this.nombre = nombre;
        this.computadoras = computadoras;
    }
    
    
    public SoftwareDominio getDominio(){
        return new SoftwareDominio(nombre, computadoras);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ComputadoraDominio> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<ComputadoraDominio> computadoras) {
        this.computadoras = computadoras;
    }

    @Override
    public String toString() {
        return "Software{" + ", nombre=" + nombre + ", computadoras=" + computadoras + '}';
    }
}
