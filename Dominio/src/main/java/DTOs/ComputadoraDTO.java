/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;


import Dominio.ComputadoraDominio;
import Dominio.ReservaDominio;
import Dominio.SoftwareDominio;
import Enumeradores.EstadosComputadora;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class ComputadoraDTO {

    private String direccionIP;

    private int numMaquina;

    private EstadosComputadora estado;

    private List<SoftwareDominio> softwares;

    private List<ReservaDominio> reservas;

    public ComputadoraDTO() {
    }

    public ComputadoraDTO(String direccionIP, int numMaquina, EstadosComputadora estado, List<SoftwareDominio> softwares) {

        this.direccionIP = direccionIP;
        this.numMaquina = numMaquina;
        this.estado = estado;
        this.softwares = softwares;
    }

    public ComputadoraDominio getDominio() {
        return new ComputadoraDominio(direccionIP, numMaquina, estado, softwares);
    }

    public List<ReservaDominio> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaDominio> reservas) {
        this.reservas = reservas;
    }
    
    
    
    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public int getNumMaquina() {
        return numMaquina;
    }

    public void setNumMaquina(int numMaquina) {
        this.numMaquina = numMaquina;
    }

    public EstadosComputadora getEstado() {
        return estado;
    }

    public void setEstado(EstadosComputadora estado) {
        this.estado = estado;
    }

    public List<SoftwareDominio> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(List<SoftwareDominio> softwares) {
        this.softwares = softwares;
    }

    @Override
    public String toString() {
        return "Computadora{" + " direccionIP=" + direccionIP + ", numMaquina=" + numMaquina + ", estado=" + estado + ", softwares=" + softwares + '}';
    }

}
