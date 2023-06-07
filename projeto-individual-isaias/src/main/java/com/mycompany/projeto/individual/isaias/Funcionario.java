package com.mycompany.projeto.individual.isaias;

import javax.swing.Timer;

/**
 *
 * @author Isaias Resende
 */
public class Funcionario {

    private Integer idFuncionario;
    private String email;
    private String senha;
    private Integer idEmpresa;

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
      public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
      
      

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", email=" + email + ", senha=" + senha + ", idEmpresa=" + idEmpresa + '}';
    }

}
