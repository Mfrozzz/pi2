package controller;

import application.MainSisContract;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ModeloOffController {

    @FXML
    private ImageView btnInfo;

    @FXML
    private ImageView btnModelo;

    @FXML
    private ImageView btnNovo;

    @FXML
    private Label lblOff;

    @FXML
    private ImageView logout;
    /**
     * @param MouseEvent event
     * muda para a tela de informa��es/cria��o de curr�culos
     * */
    @FXML
    void btnInfoOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("InfoOff");
    }
    /**
     * @param MouseEvent event
     * muda para a tela de modelos de curr�culo
     * */
    @FXML
    void btnModeloOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ModeloOff");
    }
    /**
     * @param MouseEvent event
     * muda para a tela de informa��es/cria��o de curr�culos
     * */
    @FXML
    void btnNovoOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("NewOff");
    }
    /**
     * @param MouseEvent event
     * muda para a tela de login
     * */
    @FXML
    void logoutOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("Back");
    }
}