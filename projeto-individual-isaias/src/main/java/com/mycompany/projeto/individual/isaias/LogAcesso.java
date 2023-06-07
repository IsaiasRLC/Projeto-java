/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.individual.isaias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Isaias Resende
 */
public class LogAcesso {

    ConexaoBancoLocal conexaoLocal = new ConexaoBancoLocal();
    ConexaoBancoNuvem conexaoNuvem = new ConexaoBancoNuvem();

    JdbcTemplate conLocal = conexaoLocal.getbanco();
    JdbcTemplate conNuvem = conexaoNuvem.getBancoNuvem();

    Componentes comp01 = new Componentes();

    private Integer idLogAcesso;

    private LocalDateTime dataHoraInicio;

    

    public void salvar(String email, Boolean logou) {
        dataHoraInicio = LocalDateTime.now();
        System.out.println(dataHoraInicio);
        String horaAtual = String.format("%d:%02d:%02d", dataHoraInicio.getHour(), dataHoraInicio.getMinute(), dataHoraInicio.getSecond());
        String diaAtual = dataHoraInicio.toLocalDate().toString();

        //CRIA INSTANCIA DA PASTA
        File pasta = new File("logsDeAcesso");
        //SE A PASTA NAO EXISTIR ELE CRIA;
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
        //CRIA O ARQUIVO NA PASTA DEFINIDA
        File arquivo = new File(pasta, diaAtual);

        try {
            arquivo.createNewFile();
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter escrever = new BufferedWriter(fw);

            if (logou) {
                escrever.write(diaAtual + " - " + horaAtual + " - " + email + " - " + " login feito com sucesso \n");
            } else {
                escrever.write(diaAtual + " - " + horaAtual + " - " + email + " - " + " tentativa de login não bem sucedida\n");
            }
            escrever.close();
            fw.close();
            System.out.println("Cadastrei no log");

        } catch (IOException ex) {
            System.out.println("deu erro ao criar");
        }
    }

    public void inserirLoginBanco(Funcionario u, Computador c) {
        dataHoraInicio = LocalDateTime.now();
        System.out.println("Cadastrar esse log no banco");
        System.out.println(u);
        String insertTabelaLogAcesso = "insert into LogAcesso (idFuncionario, MacAddress, idComputador, idEmpresa, horario_inicio) values( ?, ?, ?,?, ?)";
        conNuvem.update(insertTabelaLogAcesso, u.getIdFuncionario(), comp01.macAddress(), c.getIdComputador(), c.getIdEmpresa(),dataHoraInicio);
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }
}
