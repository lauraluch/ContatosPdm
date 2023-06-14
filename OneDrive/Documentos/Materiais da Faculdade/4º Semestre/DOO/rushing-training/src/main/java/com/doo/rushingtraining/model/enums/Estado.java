package com.doo.rushingtraining.model.enums;

public enum Estado {
    ATIVO("Ativo"),
    INATIVO("Inativado");

    private final String estado;

    Estado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
