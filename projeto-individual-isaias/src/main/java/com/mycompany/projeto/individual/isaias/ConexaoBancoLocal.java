package com.mycompany.projeto.individual.isaias;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Isaias Resende
 */
public class ConexaoBancoLocal {

    private JdbcTemplate banco;

    public ConexaoBancoLocal() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://54.166.183.80/HemeraTech"); // trocar o localhost:3306 pelo endereço do banco e o tecflix pelo nome do banco

        dataSource.setUsername("root");
        dataSource.setPassword("sptech");

        this.banco = new JdbcTemplate(dataSource);
      
    }

    public JdbcTemplate getbanco() {
        return banco;
    }

}
