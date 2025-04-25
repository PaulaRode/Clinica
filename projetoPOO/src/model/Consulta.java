package model;

import java.sql.Time;
import java.util.Date;

public class Consulta {

    private int id;
    // Referência ao objeto Cliente (tabela cliente)
    private Cliente cliente;
    // Referência ao objeto Medico (tabela medicos)
    private Medico medico;
    // Usando java.sql.Date para compatibilidade com MySQL
    private Date data;
    // Hora da consulta (java.sql.Time)
    private Time hora;

    public Consulta() {
    }

    public Consulta(int id, Cliente cliente, Medico medico, Date data, Time hora) {
        this.id = id;
        this.cliente = cliente;
        this.medico = medico;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
