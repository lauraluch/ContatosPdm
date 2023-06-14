package com.doo.rushingtraining.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Treino {
    private final int id;
    private String nome;
    private String descricao;
    private List<GrupoTreino> listaGrupoTreinos = new ArrayList<>();

    public Treino(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        id = this.hashCode();
    }

    public Treino(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Treino{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treino treino = (Treino) o;
        return id == treino.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<GrupoTreino> getListaGrupoTreinos() {
        return listaGrupoTreinos;
    }

    public void setListaGrupoTreinos(List<GrupoTreino> listaGrupoTreinos) {
        this.listaGrupoTreinos = listaGrupoTreinos;
    }
}
