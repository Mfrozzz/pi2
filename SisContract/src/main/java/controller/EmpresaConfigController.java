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
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EmpresaConfigController {

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
    private JFXButton btnAttSenha;

    @FXML
    private JFXButton btnCargosAtt;
    
    @FXML
    private JFXButton btnLoginAtt;

    @FXML
    private TextField txtLogin;
    
    @FXML
    private TextField txtCargos;

    @FXML
    private PasswordField txtPassword;
    
    private EmpresaDBDAO empdao;

    /**
     * @param MouseEvent event
     * muda para a tela de configurações
     * */
    @FXML
    void btnConfigOnAction(MouseEvent event) {
       	System.out.println("Config");
    	txtLogin.clear();
    	txtPassword.clear();
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
    	txtLogin.clear();
    	txtPassword.clear();
    	txtCargos.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de currículos
     * */
    @FXML
    void btnCurriculosOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("EmpCur");
    	txtLogin.clear();
    	txtPassword.clear();
    	txtCargos.clear();
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
    	txtCargos.clear();
    }
    /**
     * @param ActionEvent event
     * Realiza a alteração da senha da empresa
     * */
    @FXML
    void btnAttSenhaOnAction(ActionEvent event) {
    	empdao = new EmpresaDBDAO();
    	String rSenha = txtPassword.getText();
    	String usaLogin = lblEmpresaNome.getText();
		try {
			empdao.atualizaEmpresaSenha(usaLogin,rSenha);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("REDEFINIR");
			alert.setHeaderText("Informação para a Empresa");
			alert.setContentText("Senha redefinida");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("REDEFINIR");
			alert.setHeaderText("Informação para a Empresa");
			alert.setContentText("Falha na alteração");
			alert.showAndWait();
			e.printStackTrace();
		}finally {
			txtCargos.clear();
		}
    }
    /**
     * @param ActionEvent event
     * Realiza a alteração dos cargos ofertados pela empresa
     * */
    @FXML
    void btnCargosAttOnAction(ActionEvent event) {
    	empdao = new EmpresaDBDAO();
    	String rCargos = txtCargos.getText();
    	String usaLogin = lblEmpresaNome.getText();
		try {
			empdao.atualizaEmpresaCargos(usaLogin,rCargos);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("REDEFINIR");
			alert.setHeaderText("Informação para a Empresa");
			alert.setContentText("Cargos Ofertados Redefinidos redefinida");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("REDEFINIR");
			alert.setHeaderText("Informação para a Empresa");
			alert.setContentText("Falha na alteração");
			alert.showAndWait();
			e.printStackTrace();
		}finally {
			txtCargos.clear();
		}
    }
    /**
     * @param ActionEvent event
     * Realiza a alteração do login da empresa
     * */
    @FXML
    void btnLoginAttOnAction(ActionEvent event) {
    	
    	String rlogin = txtLogin.getText();
    	String usaLogin = lblEmpresaNome.getText();
		try {
			empdao.atualizaEmpresaLogin(usaLogin,rlogin);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("REDEFINIR");
				alert.setHeaderText("Informação para a Empresa");
				alert.setContentText("Login redefinido");
				alert.showAndWait();
			} catch (SQLException e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("REDEFINIR");
				alert.setHeaderText("Informação para a Empresa");
				alert.setContentText("Falha na alteração");
				alert.showAndWait();
				e.printStackTrace();
			}finally {
				txtLogin.clear();
			}
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
}