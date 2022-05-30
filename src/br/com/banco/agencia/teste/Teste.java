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

        Titular t2 = new Titular(2,"Matheus", "49191139966", "Claudineia");

        Conta c1 = new Conta(5, 7777,777,777.77);

        contaDAO.buscarPorNome("joao");
    }
}
