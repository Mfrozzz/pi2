package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import application.MainSisContract;
import dao.EmpresaDBDAO;
import javafx.event.ActionEvent;
//import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EmpresaController {

    @FXML
    private ImageView btnCurriculos;

    @FXML
    private ImageView btnLogout;

    @FXML
    private ImageView btnContratar;

    @FXML
    private ImageView btnConfig;

    @FXML
    private Label lblEmpresaNome;

    @FXML
    private JFXButton btnID;
    
    private EmpresaDBDAO empdao;

    /**
     * @param MouseEvent event
     * muda para a tela de configurações
     * */
    @FXML
    void btnConfigOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ConfigEmp");
    }
    /**
     * @param MouseEvent event
     * abre um alert que informa
     * */
    @FXML
    void btnContratarOnAction(MouseEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("EM BREVE");
		alert.setHeaderText("Função prevista para o PI-III");
		alert.showAndWait();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de currículos
     * */
    @FXML
    void btnCurriculosOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("EmpCur");
    }
    /**
     * @param MouseEvent event
     * muda para a tela de login
     * */
    @FXML
    void btnLogoutOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("Back");
    }
    /**
     * @param MouseEvent event
     * muda o conteúdo da label
     * */
    @FXML
    void lblOnMouseClicked(MouseEvent event) {
    	lblEmpresaNome.setText(getLoginName());
    }
    /**
     * @return String ultimo
     * @exception IOException
     * pega o ultimo valor inserido no arquivo txt
     * */
    public String getLoginName() {
    	String ultimo = "";
		try {
			InputStream is = new FileInputStream("login.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			String line = "" ;
			while ((line=reader.readLine()) != null) {
					ultimo = line;
			}
			reader.close();
			return ultimo;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ultimo;
    }
    /**
     * @param ActionEvent event
     * abre um alert que mostra para a empresa o seu id
     * */
    @FXML
    void btnIDOnAction(ActionEvent event) {
    	empdao= new EmpresaDBDAO();
    	try {
			int id =  empdao.buscaPorCodigoEmpresa2(lblEmpresaNome.getText());
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Informação para a empresa");
    		alert.setHeaderText("Empresa Id");
    		alert.setContentText("Seu Id de Empresa é: "+id);
    		alert.showAndWait();
		} catch (SQLException e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Erro na Busca");
    		alert.setHeaderText("Falha ao busca Id");
    		alert.setContentText("erro: "+ e);
    		alert.showAndWait();
		}
    }

}
