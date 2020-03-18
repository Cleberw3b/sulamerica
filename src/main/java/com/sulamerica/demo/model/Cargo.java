package com.sulamerica.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Cargo {

    @Id
    @GeneratedValue
    private int id;
    private String nome;

    public Cargo(String nome) {
        this.nome = nome;
    }

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

    @Override
    public String toString() {
        return "Cargo [id=" + id + ", nome=" + nome + "]";
    }
}
