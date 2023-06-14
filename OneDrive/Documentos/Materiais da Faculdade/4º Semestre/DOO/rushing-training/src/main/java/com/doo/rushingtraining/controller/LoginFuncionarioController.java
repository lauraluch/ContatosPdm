package com.doo.rushingtraining.controller;

import com.doo.rushingtraining.view.RushingTrainingFuncionarioApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginFuncionarioController {

    @FXML
    TextField tfCPF = new TextField();
    public void login() {
        if (getCPF().equals("adm")){
            System.out.println("ADM CORNO KKKK");
            RushingTrainingFuncionarioApp.setRoot("Admin");
        }
        else {
            RushingTrainingFuncionarioApp.setRoot("Instrutor");
        }
        Object controller = RushingTrainingFuncionarioApp.getController();
        // erro de cast; falar com o prof. Lucas
        System.out.println("TESTE 2!");
    }


    public String getCPF() {
        return tfCPF.getText();
    }
}
