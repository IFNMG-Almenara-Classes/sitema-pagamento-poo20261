package edu.ifnmg.poo.sistemapagamento.repository;

import edu.ifnmg.poo.sistemapagamento.config.DBConnection;
import edu.ifnmg.poo.sistemapagamento.models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {

    public Cliente inserir(Cliente cliente) {
        try {
            Connection conn = DBConnection.createConnection();
            System.out.println("Conexão estabelecida com sucesso!");

            String sql = "INSERT INTO clientes (nome, cpf) VALUES (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.execute();

        } catch(Exception e){
            System.out.println("Ocorreu um erro!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return cliente;
    }
}
