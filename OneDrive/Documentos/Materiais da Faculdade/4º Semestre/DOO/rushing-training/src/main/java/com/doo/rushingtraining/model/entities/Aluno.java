package com.doo.rushingtraining.model.entities;

import com.doo.rushingtraining.model.enums.Estado;
import com.example.rushingtraining.model.entities.utils.CPF;

import java.time.LocalDate;
import java.util.Objects;

public class Aluno {
    private String matricula;
    private final int hashSenha;
    private String nome;
    private final CPF cpf;
    private String telefone;
    private LocalDate dataNasc;
    private double peso;
    private double altura;
    private Estado estadoAluno;

    public Aluno(String matricula, int hashSenha, String nome, CPF cpf,
                 String telefone, LocalDate dataNasc, float peso, float altura, Estado estadoAluno) {
        this.matricula = matricula;
        this.hashSenha = hashSenha;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.peso = peso;
        this.altura = altura;
        this.estadoAluno = estadoAluno;
    }

    public Aluno(int hashSenha, CPF cpf) {
        this.hashSenha = hashSenha;
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(cpf, aluno.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public String getMatricula() {
        return matricula;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Estado getEstadoAluno() {
        return estadoAluno;
    }

    public void setEstadoAluno(Estado estadoAluno) {
        this.estadoAluno = estadoAluno;
    }
}
