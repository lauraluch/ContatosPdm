package com.doo.rushingtraining.controller;

import com.doo.rushingtraining.view.RushingTrainingAlunoApp;
import com.doo.rushingtraining.view.RushingTrainingFuncionarioApp;
import javafx.event.ActionEvent;

public class AlunoController {
    public void sair(ActionEvent event) {
        RushingTrainingAlunoApp.setRoot("LoginAluno");
    }
}
