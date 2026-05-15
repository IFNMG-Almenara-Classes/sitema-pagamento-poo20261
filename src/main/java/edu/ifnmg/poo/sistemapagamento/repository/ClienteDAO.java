package edu.ifnmg.poo.sistemapagamento.repository;

import edu.ifnmg.poo.sistemapagamento.config.DBConnection;
import edu.ifnmg.poo.sistemapagamento.models.Cliente;

import java.sql.Connection;

public class ClienteDAO {

    public Cliente inserir(Cliente cliente){
        try {
            Connection conn = DBConnection.createConnection();
        } catch(Exception e){
            System.out.println("Ocorreu um erro!");
        }

        return cliente;
    }
}
