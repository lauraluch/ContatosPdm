package com.doo.rushingtraining.controller;

import com.doo.rushingtraining.view.RushingTrainingFuncionarioApp;
import javafx.event.ActionEvent;

public class ExercicioController {
    public void sair(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("Instrutor");
    }

    public void criar(ActionEvent event) {
    }

    public void selecionarExercicio(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("EditaExercicio");
    }

    public void editar(ActionEvent event) {
        System.out.println("aaaaaa");
    }

    public void excluir(ActionEvent event) {
    }
}
