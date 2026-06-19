package edu.ifnmg.poo.sistemapagamento.dtos;

import edu.ifnmg.poo.sistemapagamento.models.Cliente;

public class ListarClienteResponse {
    private long id;
    private String nome;
    private String cpf;

    public ListarClienteResponse() {
    }

    public ListarClienteResponse(long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static ListarClienteResponse fromEntity(Cliente cliente){
        return new ListarClienteResponse(cliente.getId(), cliente.getNome(), cliente.getCpf());
    }
}
