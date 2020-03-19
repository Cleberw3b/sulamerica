package com.sulamerica.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.GeneratedValue;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Nome não informado")
    private String nome;

    @NotBlank(message = "CPF não informado")
    private String cpf;

    @NotBlank(message = "Sexo não informado")
    private String sexo;

    // Formatar a data para o padrão (dia/Mês/Ano)
    @NotNull(message = "Data de Nascimento não informado")
    @PastOrPresent(message = "Data deve ser no passado ou no presente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataDeNascimento;

    @OneToOne
    @NotNull(message = "Cargo não informado")
    private Cargo cargo;

    @OneToOne
    @NotNull(message = "Perfil não informado")
    private Perfil perfil;

    @NotNull(message = "Status não informado")
    private boolean active;

    public User() {
        super();
    }

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