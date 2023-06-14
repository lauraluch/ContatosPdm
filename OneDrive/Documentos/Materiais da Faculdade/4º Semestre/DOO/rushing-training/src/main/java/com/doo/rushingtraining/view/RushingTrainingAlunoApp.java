package com.doo.rushingtraining.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RushingTrainingAlunoApp extends Application {

    private static Scene scene;
    private static Object controller;


    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("LoginAluno"));
        stage.setTitle("Rushing Training - App do Aluno");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setRoot(String fxml) {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent parent = null;
        try {
            parent = fxmlLoader.load(Objects.requireNonNull(RushingTrainingFuncionarioApp.class.getResource(fxml + ".fxml")).openStream());
            controller = fxmlLoader.getController();
            return parent;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getController() {
        return controller;
    }

}
