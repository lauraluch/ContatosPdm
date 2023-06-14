package com.doo.rushingtraining.controller;

import com.doo.rushingtraining.view.RushingTrainingAlunoApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginAlunoController {

    @FXML
    private Button btLogin;
    @FXML
    private Button button;

    public void mudarScene(){
        RushingTrainingAlunoApp.setRoot("outraScene");
        OutraSceneController controller = (OutraSceneController) RushingTrainingAlunoApp.getController();
        controller.setH1Text("Biboca");
        // Imagine que é a janela de controle de usuários. Nessa janela, terei uma tabela de usuários.
        // Preciso pegar o objeto Usuário da minha tabela e passar por parâmetro para a janela de edição
        // do usuário. Nesse caso, o OutraSceneController seria a janela de edição do Usuário.
        // Logo, no controller da cena recém aberta, precisarei de um método setUsuarioIntoView
        // da mesma forma como fiz setText, mas passando Usuário.


    }

    public void login() {
        RushingTrainingAlunoApp.setRoot("Aluno");
        AlunoController controller = (AlunoController) RushingTrainingAlunoApp.getController();
        System.out.println("TESTE!");
    }
}
