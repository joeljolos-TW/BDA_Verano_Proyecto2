/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Enumeradores.EstadoComputadoras;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author joel_
 */
@Entity
@Table(name = "Computadoras")
public class ComputadoraDominio implements Serializable {

    @Id
    @Column(name = "idComputadora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direccionIP", nullable = false)
    private String direccionIP;

    @Column(name = "numMaquina", nullable = false)
    private int numMaquina;

    @Column(name = "Estado", nullable = false)
    private EstadoComputadoras estado;

    @ManyToMany
    @JoinTable(name = "computadoras_softwares",
            joinColumns = @JoinColumn(name = "computadora_id"),
            inverseJoinColumns = @JoinColumn(name = "software_id"))
    private List<SoftwareDominio> softwares;

    @OneToMany(mappedBy = "computadora", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ReservaDominio> reservas;

    public ComputadoraDominio() {
    }

    public ComputadoraDominio(String direccionIP, int numMaquina, EstadoComputadoras estado, List<SoftwareDominio> softwares) {

        this.direccionIP = direccionIP;
        this.numMaquina = numMaquina;
        this.estado = estado;
        this.softwares = softwares;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EstadoComputadoras getEstado() {
        return estado;
    }

    public void setEstado(EstadoComputadoras estado) {
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
        return "Computadora{" + "id=" + id + ", direccionIP=" + direccionIP + ", numMaquina=" + numMaquina + ", estado=" + estado + ", softwares=" + softwares + '}';
    }

}
