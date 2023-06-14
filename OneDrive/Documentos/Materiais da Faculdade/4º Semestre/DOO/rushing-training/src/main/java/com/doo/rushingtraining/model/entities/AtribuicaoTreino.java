package com.doo.rushingtraining.model.entities;

public class AtribuicaoTreino {
    private DiaTreino treinoDoDia;

    private final Treino treino;

    private final Aluno aluno;

    private final String nomeProfessor;

    private int treinosRestantes;

    public AtribuicaoTreino(DiaTreino treinoDoDia, Treino treino, Aluno aluno, String nomeProfessor, int treinosRestantes) {
        this.treinoDoDia = treinoDoDia;
        this.treino = treino;
        this.aluno = aluno;
        this.nomeProfessor = nomeProfessor;
        this.treinosRestantes = treinosRestantes;
    }

    @Override
    public String toString() {
        return "AtribuicaoTreino{" +
                "treinoDoDia=" + treinoDoDia +
                ", treino=" + treino +
                ", aluno=" + aluno +
                ", professor=" + nomeProfessor +
                ", treinosRestantes=" + treinosRestantes +
                '}';
    }

    public DiaTreino getTreinoDoDia() {
        return treinoDoDia;
    }

    public Treino getTreino() {
        return treino;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public int getTreinosRestantes() {
        return treinosRestantes;
    }
}
