/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.individual.isaias;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Isaias Resende
 */
public class Componentes {

    Looca looca = new Looca();
    ConexaoBancoLocal conexaoLocal = new ConexaoBancoLocal();
    ConexaoBancoNuvem conexaoNuvem = new ConexaoBancoNuvem();

    JdbcTemplate conLocal = conexaoLocal.getbanco();
    JdbcTemplate conNuvem = conexaoNuvem.getBancoNuvem();

 
    public Sistema sistema = looca.getSistema();
    public Processador processador = looca.getProcessador();
    public Memoria memoria = looca.getMemoria();

    public List<Disco> discos = looca.getGrupoDeDiscos().getDiscos();
    public Long tamanhioTotal = looca.getGrupoDeDiscos().getTamanhoTotal();
    //SETADO EM 0 PQ TENHO APENAS UM DISCO NO NOTE
    public Disco discoAtual = discos.get(0);
    //PRECISO DO VOLUME PQ É NELE QUE CONTEM O DISPONIVEL PRA CALCULO DE USO
    public List<Volume> volumes = looca.getGrupoDeDiscos().getVolumes();
    public Volume volume = volumes.get(0);

    
    
    
    public Rede rede = looca.getRede();
    //PEGANDO TODA O GRUPO DE INTERFACES
    public List<RedeInterface> interfacesRede = rede.getGrupoDeInterfaces().getInterfaces();

    //FILTRANDO APENAS A INTERFACE QUE TEM DOWLOAD E UPLOAD MAIOR QUE 0
    public List<RedeInterface> dadosRede = interfacesRede.stream().filter(rede -> rede.getBytesEnviados() > 0 && rede.getBytesRecebidos() > 0).toList();
    //PEGANDO A UNICA INTERFACE QUE TEM DOWLOAD E UPLOAD
    public RedeInterface redeAtual = dadosRede.get(0);

    //RECEBE UM VALOR E FAZ UMA CONTA DE CONVERSAO 
    //TRANFORMA O VALOR EM GIGABYTE
    private static Double byteConverter(long bytes) {
        return (double) bytes / (1024 * 1024 * 1024);
    }

    // TRANFORMA O VALOR EM MEGABYTE
    private static Double byteConverterMega(long bytes) {
        return (double) bytes / (1024 * 1024);
    }

    //Informações computador
    public String sistemaOperacional() {
        return sistema.getSistemaOperacional();
    }

    public String modeloProcessador() {
        return processador.getFabricante();
    }

    public String macAddress() {
        return redeAtual.getEnderecoMac();
    }

    public String totalMemoria() {
        return String.format("%.2f", byteConverter(memoria.getTotal()));
    }

    public String totalDisco() {
        return String.format("%.2f", byteConverter(discoAtual.getTamanho()));
    }

    //INFORMAÇÕES PARA TABELA REGISTROS
    public Double usoCpu() {
        return processador.getUso() < 10.0 ? processador.getUso() * 10 : processador.getUso();
    }

    public Double usoRam() {
        return (memoria.getEmUso().doubleValue() / memoria.getTotal().doubleValue()) * 100;
    }

    public Double usoDisco() {
        return ((volume.getTotal().doubleValue() - volume.getDisponivel().doubleValue()) / volume.getTotal().doubleValue()) * 100;
    }

    public Double velocidadeDowload() {
        try {
            Long velocidadeDowloadInicioSegundo = redeAtual.getBytesRecebidos();
            TimeUnit.SECONDS.sleep(1);
            Long velocidadeDowloadFinalSegundo = redeAtual.getBytesRecebidos();

            Long diferencaInicioFimSegundoDowload = velocidadeDowloadInicioSegundo - velocidadeDowloadFinalSegundo;
            return byteConverterMega(diferencaInicioFimSegundoDowload);
        } catch (InterruptedException e) {
            System.out.println("Sleep deu errado");
            return 0.0;
        }
    }

    public Double velocidadeUpload() {
        try {
            Long velocidadeUploadInicioSegundo = redeAtual.getBytesRecebidos();
            TimeUnit.SECONDS.sleep(1);
            Long velocidadeUploadFinalSegundo = redeAtual.getBytesRecebidos();

            Long diferencaInicioFimSegundoUpload = velocidadeUploadInicioSegundo - velocidadeUploadFinalSegundo;
            return byteConverterMega(diferencaInicioFimSegundoUpload);
        } catch (InterruptedException e) {
            System.out.println("Sleep deu errado");
            return 0.0;
        }   
    }

    public void inserirDadosAzure(Computador comp) {
        String insertTabelaRegistro = "insert into Registros(uso_cpu,utilizado_memoria,utilizado_armazenamento, download_rede, upload_rede, idComputador, MacAddress, idEmpresa) values (?,?,?,?,?,?,?,?)";
        conNuvem.update(insertTabelaRegistro, usoCpu(), usoRam(), usoDisco(), velocidadeDowload(), velocidadeUpload(), comp.getIdComputador(), macAddress(), comp.getIdEmpresa());
    }
    
    public void inserirDadosMySql() {
        String insertTabelaRegistro2 = "insert into Registro (uso_cpu, uttlizamento_memoria, utilizamento_armazenamento, download_rede, upload_rede, MacAddress) values (?,?,?,?,?,?)";
        conLocal.update(insertTabelaRegistro2, usoCpu(), usoRam(), usoDisco(), velocidadeDowload(), velocidadeUpload(),  macAddress());

    }


}
