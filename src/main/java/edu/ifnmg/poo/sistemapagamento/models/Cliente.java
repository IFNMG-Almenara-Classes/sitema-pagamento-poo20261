package edu.ifnmg.poo.sistemapagamento.models;

public class Cliente {
    private long id;
    private String nome;
    private String cpf;

    public Cliente(long id, String nome, String cpf) {
        this(nome, cpf);
        this.id = id;
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
