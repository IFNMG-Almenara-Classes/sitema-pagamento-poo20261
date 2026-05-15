package edu.ifnmg.poo.sistemapagamento.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    public static Connection createConnection() throws SQLException {
        String url = "jdbc:h2:file:./data/loja";
        String user = "sa";
        String password = "";
        return DriverManager.getConnection(
                url,
                user,
                password
        );
    }


    private static void initialize() {

        String sql = """
            CREATE TABLE IF NOT EXISTS clients (
                id INTEGER(255) PRIMARY KEY AUTO_INCREMENT,
                nome VARCHAR(250),
                cpf VARCHAR(14),
                status VARCHAR(50)
            )
        """;
        try (
                Connection conn =
                        DBConnection.createConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        initialize();
    }
}
