package com.doo.rushingtraining.controller;

import com.doo.rushingtraining.view.RushingTrainingFuncionarioApp;
import javafx.event.ActionEvent;

public class InstrutorController {
    public void criaExercicio(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("AddExercicio");
        Object controller = RushingTrainingFuncionarioApp.getController();
        // erro de cast; falar com o prof. Lucas
        System.out.println("TESTE!");
    }

    public void editaExercicio(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("EscolheExercicio");
        Object controller = RushingTrainingFuncionarioApp.getController();
        // erro de cast; falar com o prof. Lucas
    }

    public void criaTreino(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("CriaTreino");
        Object controller = RushingTrainingFuncionarioApp.getController();
        // erro de cast; falar com o prof. Lucas
    }

    public void editaTreino(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("EditaTreino");
        Object controller = RushingTrainingFuncionarioApp.getController();
        // erro de cast; falar com o prof. Lucas
    }

    public void vinculaTreinoAluno(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("VincTreinoAluno");
        Object controller = RushingTrainingFuncionarioApp.getController();
        // erro de cast; falar com o prof. Lucas
    }

    public void desvinculaTreinoAluno(ActionEvent event) {
    }

    public void sair(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("LoginFuncionario");
    }

}
