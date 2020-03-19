package com.sulamerica.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String cpf;
    private String sexo;
    private LocalDate dataDeNascimento;
    @OneToOne
    private Cargo cargo;
    @OneToOne
    private Perfil perfil;
    private boolean active;

    public User(Integer id, String nome, String cpf, String sexo, LocalDate dataDeNascimento, Cargo cargo,
            Perfil perfil, boolean active) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.cargo = cargo;
        this.perfil = perfil;
        this.active = active;
    }

    public boolean isEmpty() {
        if (this.id > 0)
            return false;
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(final LocalDate dataDeNascimento) {
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

    @Override
    public String toString() {
        return "User [id=" + id + ", sexo=" + sexo + " cpf=" + cpf + ", dataDeNascimento=" + dataDeNascimento
                + ", nome=" + nome + ", perfil=" + perfil.getNome() + ", cargo=" + cargo.getNome() + ", active="
                + active + "]";
    }
}