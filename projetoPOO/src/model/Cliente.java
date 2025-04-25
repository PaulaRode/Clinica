package model;

import java.util.Date;

public class Cliente {

    private int id;
    private String nome;
    private String emailCli;
    private String cpf;
    private Date dataNasc;

    // Construtor padrão
    public Cliente() {
    }

    // Construtor com parâmetros
    public Cliente(int id, String nome, String emailCli, String cpf, Date dataNasc) {
        this.id = id;
        this.nome = nome;
        this.emailCli = emailCli;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }

}
