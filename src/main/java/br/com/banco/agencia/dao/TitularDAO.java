package br.com.banco.agencia.dao;

import br.com.banco.agencia.model.Titular;

import java.sql.*;

public class TitularDAO {
    private Connection connection;

    public TitularDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Titular titular) {
        try {
            String sql = "INSERT INTO TITULAR (NOME, CPF, NOME_DA_MAE) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, titular.getNome());
                statement.setString(2, titular.getCpf());
                statement.setString(3, titular.getNomeDaMae());

                statement.execute();

                try (ResultSet result = statement.getGeneratedKeys()) {
                    while (result.next()) {
                        titular.setIdTitular(result.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Titular titular) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE TITULAR T SET T.NOME = ?, T.CPF = ?, T.NOME_DA_MAE = ? WHERE ID_TITULAR = ?")){
            statement.setString(1, titular.getNome());
            statement.setString(2, titular.getCpf());
            statement.setString(3, titular.getNomeDaMae());
            statement.setInt(4, titular.getIdTitular());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Integer idTitular) {
        try (PreparedStatement statement
                     = connection.prepareStatement("DELETE FROM TITULAR WHERE ID_TITULAR = ?")){
            statement.setInt(1, idTitular);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
