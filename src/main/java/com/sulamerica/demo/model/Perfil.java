package com.sulamerica.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;

@Entity
public class Perfil {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Nome não informado")
    private String nome;

    public Perfil() {
        super();
    }

    public Perfil(Integer id) {
        this.id = id;
    }

    public Perfil(String nome) {
        this.nome = nome;
    }

    public Perfil(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Perfil [id=" + id + ", nome=" + nome + "]";
    }
}