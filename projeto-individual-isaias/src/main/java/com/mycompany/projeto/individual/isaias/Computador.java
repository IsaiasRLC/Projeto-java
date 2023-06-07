/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.individual.isaias;

/**
 *
 * @author Isaias Resende
 */
public class Computador {

    private Integer idComputador;
    private Integer idEmpresa;
    private String macAddress;

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "Computador{" + "idComputador=" + idComputador + ", idEmpresa=" + idEmpresa + '}';
    }

    
    
}
