package com.doo.rushingtraining.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowLoginManager extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/java/com/doo/rushingtraining/view/fxml/FXMLClientManager.fxml"));
        stage.setTitle("Rushing Training App");
        stage.setScene(new Scene(root, 370, 670));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
