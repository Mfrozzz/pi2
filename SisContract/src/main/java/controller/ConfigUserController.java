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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ConfigUserController {

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
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private JFXButton btnAttLogin;

    @FXML
    private JFXButton btnAttSenha;
    
    private UsuarioDBDAO userdao;

    /**
     * @param MouseEvent event
     * muda para a tela de configura��es 
     * */
    @FXML
    void btnConfigOnAction(MouseEvent event) {
    	System.out.println("Config");
    	txtLogin.clear();
    	txtPassword.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de informa��es
     * */
    @FXML
    void btnInfoOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("InfoUser");
    	txtLogin.clear();
    	txtPassword.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de login
     * */
    @FXML
    void btnLogoutOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("Back");
    	txtLogin.clear();
    	txtPassword.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de modelos
     * */
    @FXML
    void btnModeloOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ModeloUser");
    	txtLogin.clear();
    	txtPassword.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de cria��o de curr�culos
     * */
    @FXML
    void btnNewOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("NewUser");
    	txtLogin.clear();
    	txtPassword.clear();
    }
    /**
     * @param ActionEvent event
     * Atualiza a configura��o de login do usu�rio
     * */
    @FXML
    void btnAttLoginOnAction(ActionEvent event) {
    	userdao = new UsuarioDBDAO();
    	String rlogin = txtLogin.getText();
    	String usaLogin = lblUserName.getText();
		try {
			userdao.atualizaConfigLogin(usaLogin,rlogin);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("REDEFINIR");
				alert.setHeaderText("Informa��o para o Usu�rio");
				alert.setContentText("Login redefinido");
				alert.showAndWait();
			} catch (SQLException e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("REDEFINIR");
				alert.setHeaderText("Informa��o para o Usu�rio");
				alert.setContentText("Falha na altera��o");
				alert.showAndWait();
				e.printStackTrace();
			}finally {
				txtLogin.clear();
			}
    }
    /**
     * @param ActionEvent event
     * Atualiza a configura��o de senha do usu�rio
     * */
    @FXML
    void btnAttSenhaOnAction(ActionEvent event) {
    	userdao = new UsuarioDBDAO();
    	String rSenha = txtPassword.getText();
    	String usaLogin = lblUserName.getText();
		try {
			userdao.atualizaConfigSenha(usaLogin,rSenha);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("REDEFINIR");
			alert.setHeaderText("Informa��o para o Usu�rio");
			alert.setContentText("Senha redefinida");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("REDEFINIR");
			alert.setHeaderText("Informa��o para o Usu�rio");
			alert.setContentText("Falha na altera��o");
			alert.showAndWait();
			e.printStackTrace();
		}finally {
			txtPassword.clear();
		}
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
