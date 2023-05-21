package com.mycompany.projeto.individual.isaias;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Isaias Resende
 */
public class Teste {

    public static void main(String[] args) {

        Looca looca = new Looca();
        ConexaoBancoLocal conexao = new ConexaoBancoLocal();
        JdbcTemplate con = conexao.getbanco();
        Funcionario func = new Funcionario();

        String macAddress = null;
        String modelo = looca.getSistema().getFabricante();
        String processador = looca.getProcessador().getNome();
        Long primeiroNumero = looca.getMemoria().getTotal();
        Integer memoria_ram = primeiroNumero.toString().charAt(0) - '0';

        List<RedeInterface> interfaces = looca.getRede().getGrupoDeInterfaces().getInterfaces();
        
        if (interfaces.size() > 0) {
            RedeInterface iface = interfaces.get(0);
            macAddress = iface.getEnderecoMac();
        }

        //       DadosComputer computer01 = new DadosComputer(macAddress, 1,
//               modelo, processador,
        //              memoria_ram);
           List <Funcionario> ListaDeFuncionarios = con.query("select funcionario.nome,funcionario.sobrenome,funcionario.email, funcionario.senha from funcionario;",
                new BeanPropertyRowMapper(Funcionario.class));
        //  System.out.println(ListaDeFuncionarios);
        
        
//        for (Funcionario funcionarioDaVez : ListaDeFuncionarios) {
//            if( funcionarioDaVez.getEmail().equals(usuarioEntrar.getEmailDigitado()) && funcionarioDaVez.getSenha().equals(usuarioEntrar.getSenhaDigitada())){
//                System.out.println("deu certo");
//                validar = true;
//            }else{
//                System.out.println("vix  nao deu");
//                
//            }
//        }
//        for (Funcionario funcionarioDaVez : ListaDeFuncionarios) {
//            if (funcionarioDaVez.getEmail().equals(usuarioEntrar.getEmailDigitado()) && funcionarioDaVez.getSenha().equals(usuarioEntrar.getSenhaDigitada())) {
//                validar = true;
//            }
//        }
//System.out.println(ListaDeFuncionarios.get(0));
        con.update("insert into Computador values (?,?,?,?,?,?)",
                null, macAddress, 1, modelo, processador, memoria_ram
        );
    }
}
