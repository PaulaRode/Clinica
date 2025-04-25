package model;

public class Medico {

    private int id;
    private String nome;
    private String especialidade;
    private String crm;

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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return crm;
    }

    public void setCRM(String CRM) {
        this.crm = CRM;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
