package com.doo.rushingtraining.controller;

import com.doo.rushingtraining.view.RushingTrainingFuncionarioApp;
import javafx.event.ActionEvent;

public class AdminController {
    public void sair(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("Admin");
    }

    public void sairLogin(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("LoginFuncionario");
    }

    public void addInstrutor(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("AddInstrutor");
    }

    public void selecionaInstrutor(ActionEvent event) {
        System.out.println("a");
        RushingTrainingFuncionarioApp.setRoot("SelecionaInstrutor");
    }
    public void selecionaInstrutorEdicao(ActionEvent event) {
        System.out.println("b");
        RushingTrainingFuncionarioApp.setRoot("EditaInstrutor");
    }
    public void editaInstrutor(ActionEvent event) {
        System.out.println("c");
    }

    public void addAluno(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("AddAluno");
    }
    public void selecionaAluno(ActionEvent event) {
        System.out.println("a");
        RushingTrainingFuncionarioApp.setRoot("SelecionaAluno");
    }

    public void selecionaAlunoEdicao(ActionEvent event) {
        System.out.println("b");
        RushingTrainingFuncionarioApp.setRoot("EditaAluno");

    }

    public void editaAluno(ActionEvent event) {
        System.out.println("c");
    }

}
