package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import application.MainSisContract;
import dao.UsuarioDBDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class UsuarioController {

    @FXML
    private ImageView btnLogout;

    @FXML
    private ImageView btnInfo;

    @FXML
    private ImageView btnModelo;

    @FXML
    private ImageView btnConfig;

    @FXML
    private ImageView btnNew;

    @FXML
    private Label lblUserName;
    
    @FXML
    private JFXButton btnVerStatus;
    
    private UsuarioDBDAO userdao;
    /**
     * @param ActionEvent event
     * @throws SQLException
     * busca o status do usuário
     * */
    @FXML
    void btnVerStatusOnAction(ActionEvent event) throws SQLException {
    	userdao = new UsuarioDBDAO();
    	String resultado = userdao.statusUser(lblUserName.getText());
    	if(resultado.equals("empregado")) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Usuario Contratado");
    		alert.setHeaderText("Contratação realizada");
    		alert.setContentText("Entre em contato com a empresa");
    		alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Usuario ainda não Contratado");
    		alert.setHeaderText("Contratação ainda não realizada");
    		alert.setContentText("Aguarde a resposta da empresa");
    		alert.showAndWait();
    	}
    }
    /**
     * @param MouseEvent event
     * muda para a tela de configurações 
     * */
    @FXML
    void btnConfigOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ConfigUser");
    }
    /**
     * @param MouseEvent event
     * muda para a tela de informações
     * */
    @FXML
    void btnInfoOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("InfoUser");
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
     * muda para a tela de modelos
     * */
    @FXML
    void btnModeloOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ModeloUser");
    }
    /**
     * @param MouseEvent event
     * muda para a tela de criação de currículos
     * */
    @FXML
    void btnNewOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("NewUser");
    }
    /**
     * @param MouseEvent event
     * muda o conteudo da label
     * */
    @FXML
    void lblEmalONMouseClicked(MouseEvent event) {
    	lblUserName.setText(getLoginName());
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

}
