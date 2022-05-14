package controller;

import application.MainSisContract;
//import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class OfflineController {

    @FXML
    private ImageView logout;

    @FXML
    private ImageView btnNovo;

    @FXML
    private ImageView btnInfo;

    @FXML
    private ImageView btnModelo;

    @FXML
    private Label lblOff;
    /**
     * @param MouseEvent event
     * muda para a tela de informações/criação de currículos
     * */
    @FXML
    void btnInfoOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("InfoOff");
    }
    /**
     * @param MouseEvent event
     * muda para a tela de modelos de currículo
     * */
    @FXML
    void btnModeloOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ModeloOff");
    }
    /**
     * @param MouseEvent event
     * muda para a tela de informações/criação de currículos
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