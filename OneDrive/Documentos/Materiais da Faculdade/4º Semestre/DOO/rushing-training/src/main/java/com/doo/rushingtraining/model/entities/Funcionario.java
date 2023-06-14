package com.doo.rushingtraining.model.entities;

import com.doo.rushingtraining.model.enums.Cargo;
import com.doo.rushingtraining.model.enums.Estado;

import java.util.List;
import java.util.Objects;

public class Funcionario {
    private final com.example.rushingtraining.model.entities.utils.CPF cpf;
    private int hashSenha;
    private String nome;
    private List<String> telefones;
    private String email;
    private Cargo cargo;
    private Estado estadoFuncionario;

    public Funcionario(com.example.rushingtraining.model.entities.utils.CPF cpf, int hashSenha, String nome, List<String> telefones,
                       String email, Cargo cargo, Estado estadoFuncionario) {
        this.cpf = cpf;
        this.hashSenha = hashSenha;
        this.nome = nome;
        this.telefones = telefones;
        this.email = email;
        this.cargo = cargo;
        this.estadoFuncionario = estadoFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public com.example.rushingtraining.model.entities.utils.CPF getCpf() {
        return cpf;
    }

    public int getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(int hashSenha) {
        this.hashSenha = hashSenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Estado getEstadoFuncionario() {
        return estadoFuncionario;
    }

    public void setEstadoFuncionario(Estado estadoFuncionario) {
        this.estadoFuncionario = estadoFuncionario;
    }
}
