package com.doo.rushingtraining.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OutraSceneController {
    @FXML private Label lbH1;

    public void setH1Text(String text){
        lbH1.setText(text);
    }
}
