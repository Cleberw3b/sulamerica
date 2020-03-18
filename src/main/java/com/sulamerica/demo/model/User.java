package com.sulamerica.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cpf;
    private String sexo;
    private Date dataDeNascimento;
    private Cargo cargo;
    private Perfil perfil;
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(final String sexo) {
        this.sexo = sexo;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(final Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(final Cargo cargo) {
        this.cargo = cargo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(final Perfil perfil) {
        this.perfil = perfil;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }
}