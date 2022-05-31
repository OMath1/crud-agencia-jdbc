package br.com.banco.agencia.dao;

import br.com.banco.agencia.model.Conta;
import br.com.banco.agencia.model.Titular;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    private Connection connection;

    public ContaDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Conta conta) {
        try {
            String sql = "INSERT INTO CONTA (AGENCIA, NUMERO, SALDO) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, conta.getAgencia());
                statement.setInt(2, conta.getNumero());
                statement.setDouble(3, conta.getSaldo());

                statement.execute();

                try (ResultSet result = statement.getGeneratedKeys()) {
                    while (result.next()) {
                        conta.setIdConta(result.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Conta conta) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE CONTA C SET C.AGENCIA = ?, C.NUMERO = ?, SALDO = ? WHERE ID_CONTA = ?")){
            statement.setInt(1, conta.getAgencia());
            statement.setInt(2, conta.getNumero());
            statement.setDouble(3, conta.getSaldo());
            statement.setInt(4, conta.getIdConta());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Integer idConta) {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM CONTA WHERE ID_CONTA = ?")){
            statement.setInt(1, idConta);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Conta> buscarTodos() {
        try {
            List<Conta> contas = new ArrayList<Conta>();
            String sql = "SELECT * FROM CONTA";

            try(PreparedStatement statement =
                    connection.prepareStatement(sql)) {
                statement.execute();

                trasformarResultSetEmConta(contas, statement);
                contas.forEach(c -> System.out.println(c.toString()));
            }
            return contas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Conta> buscarPorNome(String nome) {
        try {
            List<Conta> contas = new ArrayList<Conta>();
            String sql = "SELECT * FROM CONTA C WHERE C.NOME = ?";

            try(PreparedStatement statement =
                    connection.prepareStatement(sql)) {
                statement.setString(1, nome);
                statement.execute();

                trasformarResultSetEmConta(contas, statement);
                contas.forEach(c -> System.out.println(c.toString()));
            }
            return contas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void trasformarResultSetEmConta(List<Conta> contas, PreparedStatement statement) {
        try (ResultSet rst = statement.getResultSet()) {
            while (rst.next()) {
                Conta conta = new Conta(rst.getInt(1), rst.getInt(2), rst.getInt(3), rst.getDouble(4));

                contas.add(conta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
