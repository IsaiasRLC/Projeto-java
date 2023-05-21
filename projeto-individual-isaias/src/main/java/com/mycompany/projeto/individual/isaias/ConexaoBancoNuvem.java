/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.individual.isaias;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Isaias Resende
 */
public class ConexaoBancoNuvem {

    private JdbcTemplate bancoNuvem;


    public ConexaoBancoNuvem() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

//     dataSource​.setUrl("jdbc:h2:file:/banco_teste");
//jdbc:sqlserver://hemeratech.database.windows.net:1433;database=hemeratech;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;
        dataSource​.setUrl("jdbc:sqlserver://hemeratech.database.windows.net:1433;database=hemeratech;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;");
        //("jdbc:mysql://localhost:3306/teste123")

        dataSource​.setUsername("hemeratech");

        dataSource​.setPassword("#Gfgrupo7");

        this.bancoNuvem = new JdbcTemplate(dataSource);

    }
    public JdbcTemplate getBancoNuvem() {
        return bancoNuvem;
    }

    
}
