package br.com.banco.agencia.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private String url = "jdbc:mysql://localhost:3306/AGENCIA";
    private String username = "root";
    private String password = "root";

    private DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource combo = new ComboPooledDataSource();

        combo.setJdbcUrl(url);
        combo.setUser(username);
        combo.setPassword(password);

        combo.setMaxPoolSize(50);

        this.dataSource = combo;
    }

    public Connection recuperarConexao() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
