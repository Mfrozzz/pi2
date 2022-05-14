package controller;

import com.jfoenix.controls.JFXButton;

import application.MainSisContract;
import javafx.event.ActionEvent;
//import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class NovoOffController {

    @FXML
    private ImageView logout;

    @FXML
    private ImageView btnNovo;

    @FXML
    private ImageView btnInfo;
    
    @FXML
    private JFXButton btnSalvar;
    
    @FXML
    private ChoiceBox<?> cbxModelo;

    @FXML
    private ImageView btnModelo;

    @FXML
    private Label lblOff;

    @FXML
    void btnInfoOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("InfoOff");
    	//System.out.println("Info");
    }

    @FXML
    void btnModeloOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ModeloOff");
    }

    @FXML
    void btnNovoOnAction(MouseEvent event) {
    	System.out.println("new");
    }

    @FXML
    void logoutOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("Back");
    }

    @FXML
    void btnSalvarOnAction(ActionEvent event) {
    	System.out.println("salvar");
    }

}
