package com.doo.rushingtraining.model.entities;

import java.util.ArrayList;
import java.util.List;

public class GrupoTreino {
    private final int id;
    private String nome;
    private List<Exercicio> listaExercicios = new ArrayList<>();

    GrupoTreino(String nome) {
        this.nome = nome;
        id = this.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoTreino that = (GrupoTreino) o;
        return id == that.id;
    }

    @Override
    public String toString() {
        return "GrupoTreino{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Exercicio> getListaExercicios() {
        return listaExercicios;
    }

    public void setListaExercicios(List<Exercicio> listaExercicios) {
        this.listaExercicios = listaExercicios;
    }
}
