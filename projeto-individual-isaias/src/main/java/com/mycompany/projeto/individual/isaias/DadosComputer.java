/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.individual.isaias;

/**
 *
 * @author Isaias Resende
 */
public class DadosComputer {


    private Integer idComputador;
    private String MacAddress;
    private Integer idEmpresa;
    private String modelo;
    private String processador;
    private Integer memoriaRam;


    public DadosComputer(String MacAddress,Integer idEmpresa, String modelo, String processador, Integer memoriaRam) {
        this.idComputador = null;
        this.MacAddress = MacAddress;
        this.idEmpresa = idEmpresa;
        this.modelo = modelo;
        this.processador = processador;
        this.memoriaRam = memoriaRam;
    }

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }

    public String getMacAddress() {
        return MacAddress;
    }

    public void setMacAddress(String MacAddress) {
        this.MacAddress = MacAddress;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public Integer getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Integer memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    @Override
    public String toString() {
        return "DadosComputer{" + "idComputador=" + idComputador + ", MacAddress=" + MacAddress + ", idEmpresa=" + idEmpresa + ", modelo=" + modelo + ", processador=" + processador + ", memoriaRam=" + memoriaRam + '}';
    }
    
    
    
}
