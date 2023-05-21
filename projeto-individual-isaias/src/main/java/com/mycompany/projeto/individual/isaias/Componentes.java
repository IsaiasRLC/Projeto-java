/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.individual.isaias;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Isaias Resende
 */
public class Componentes {

    Looca looca = new Looca();
    ConexaoBancoLocal conexao = new ConexaoBancoLocal();
    JdbcTemplate con = conexao.getbanco();
    Funcionario func = new Funcionario();

    private String macAddress = null;
    private String modelo = looca.getSistema().getFabricante();
    private String processador = looca.getProcessador().getNome();
    private Long primeiroNumero = looca.getMemoria().getTotal();
    private Integer memoria_ram = primeiroNumero.toString().charAt(0) - '0';
    private List<RedeInterface> interfaces;

    public String metodoMacAdress() {
        interfaces = looca.getRede().getGrupoDeInterfaces().getInterfaces();
        if (interfaces.size() > 0) {
            RedeInterface iface = interfaces.get(0);
            macAddress = iface.getEnderecoMac();
        }
        return macAddress;
        
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
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

    public Long getPrimeiroNumero() {
        return primeiroNumero;
    }

    public void setPrimeiroNumero(Long primeiroNumero) {
        this.primeiroNumero = primeiroNumero;
    }

    public Integer getMemoria_ram() {
        return memoria_ram;
    }

    public void setMemoria_ram(Integer memoria_ram) {
        this.memoria_ram = memoria_ram;
    }
          
}
