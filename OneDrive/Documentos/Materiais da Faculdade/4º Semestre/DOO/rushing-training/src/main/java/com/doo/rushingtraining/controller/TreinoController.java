package com.doo.rushingtraining.controller;

import com.doo.rushingtraining.view.RushingTrainingFuncionarioApp;
import javafx.event.ActionEvent;

public class TreinoController {
    public void editar(ActionEvent event) {
    }

    public void sair(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("Instrutor");
    }

    public void criar(ActionEvent event) {
    }

    public void vincular(ActionEvent event) {
        RushingTrainingFuncionarioApp.setRoot("EscolherAlunoTreino");
        Object controller = RushingTrainingFuncionarioApp.getController();

    }

    public void confirmaVinculacao(ActionEvent event) {
    }
}
