package com.doo.rushingtraining.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowInstrutor {
    public WindowInstrutor() {}

    public void startModal() throws IOException {
        FXMLLoader loader = new FXMLLoader();
            Pane pane = loader.load(getClass().getResource("/java/com/doo/rushingtraining/view/fxml/Instrutor.fxml").openStream());
        //InstrutorController ctrl = loader.getController();

        Stage stage = new Stage();

        stage.setTitle("Rushing Training App - Aluno");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(pane, 370, 670));
        stage.setResizable(false);
        stage.showAndWait();
    }
}
