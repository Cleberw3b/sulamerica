package com.sulamerica.demo.util.enums;

public enum Status {
    ATIVO("Ativo"), DESATIVO("Desativo");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}