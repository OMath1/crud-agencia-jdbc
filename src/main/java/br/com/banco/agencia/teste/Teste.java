package br.com.banco.agencia.teste;

import br.com.banco.agencia.dao.ContaDAO;
import br.com.banco.agencia.dao.TitularDAO;
import br.com.banco.agencia.factory.ConnectionFactory;
import br.com.banco.agencia.model.Conta;
import br.com.banco.agencia.model.Titular;

import java.sql.Connection;

public class Teste {
    public static void main(String[] args) {
        Connection connection = new ConnectionFactory().recuperarConexao();

        System.out.println("conectadooo");

        TitularDAO titularDAO = new TitularDAO(connection);
        ContaDAO contaDAO = new ContaDAO(connection);

        Titular t2 = new Titular(2,"John", "49923464300", "Joana");

        Conta c1 = new Conta(1000,111,1111.11);

//        contaDAO.cadastrar(c1);
//        contaDAO.atualizar(c1);

//        contaDAO.remove(11);

        contaDAO.buscarTodos();

    }
}
