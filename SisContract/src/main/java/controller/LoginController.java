package controller;

import java.sql.SQLException;
import com.jfoenix.controls.JFXButton;
import application.MainSisContract;
import dao.EmpresaDBDAO;
import dao.UsuarioDBDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoginController {
	
    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private JFXButton btnLogin;
    
    @FXML
    private JFXButton btnEmpresaLogin;

    @FXML
    private JFXButton btnCadastro;

    @FXML
    private JFXButton btnOff;
    
    private UsuarioDBDAO userdao;
    private EmpresaDBDAO empresadao;
    private String findlogin;
    private BufferedWriter writer;
    /**
     * @param ActionEvent event
     * muda para a tela de cadastro
     * */
    @FXML
    void btnCadastroOnAction(ActionEvent event) {
    	MainSisContract.ChangeScreen("Cadastro");
    }
    /**
     * @param ActionEvent event
     * @throws IOException
     * realiza o login
     * */
    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException{
    	//procurar em dao o login e senha correspondente

    	userdao = new UsuarioDBDAO();
    	String login = txtLogin.getText();
    	String senha = txtPassword.getText();
    	
    	try {
			String sucess = userdao.Loginexecute(login, senha);
			if(sucess =="Back") {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("LOGIN");
				alert.setHeaderText("Falha de Login");
				alert.setContentText("Login e|ou senha incorreto(s)");
				alert.showAndWait();
				MainSisContract.ChangeScreen(sucess);
	    		txtLogin.clear();
	    		txtPassword.clear();
			}
			if(sucess =="User") {
				findlogin = txtLogin.getText();
				if(!getLoginName().equals(findlogin)) {
					writer = new BufferedWriter(new FileWriter("Login.txt", true));
					writer.write(findlogin);//escrita
					writer.newLine();
					writer.close();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("LOGIN");
					alert.setHeaderText("Verificação de Login");
					alert.setContentText("O programa irá fechar.\nAbra-o novamente e insira seu Login e senha");
					alert.showAndWait();
					Platform.exit();
				}else {
					MainSisContract.ChangeScreen(sucess);
					txtLogin.clear();
					txtPassword.clear();
				}
			}
			
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("LOGIN");
			alert.setHeaderText("Falha de Login");
			alert.setContentText("exception"+e);
			alert.showAndWait();
		}
    }
    /**
     * @param ActionEvent event
     * muda para a tela de usuário offline
     * */
	@FXML
    void btnOffOnAction(ActionEvent event) {
    	MainSisContract.ChangeScreen("Off");
		txtLogin.clear();
		txtPassword.clear();
    }
    /**
     * @param ActionEvent event
     * @throws IOException
     * realiza o login
     * */
    @FXML
    void btnEmpresaLoginOnAction(ActionEvent event) throws IOException {
    	empresadao = new EmpresaDBDAO();
    	String login = txtLogin.getText();
    	String senha = txtPassword.getText();
    	
    	try {
			String sucess = empresadao.Loginexecute(login, senha);
			if(sucess =="Back") {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("LOGIN");
				alert.setHeaderText("Falha de Login");
				alert.setContentText("Login e|ou senha incorreto(s)");
				alert.showAndWait();
				MainSisContract.ChangeScreen(sucess);
	    		txtLogin.clear();
	    		txtPassword.clear();
			}
			if(sucess =="Empresa") {
				
				findlogin = txtLogin.getText();
				if(!getLoginName().equals(findlogin)) {
					writer = new BufferedWriter(new FileWriter("Login.txt", true));
					writer.write(findlogin);//escrita
					writer.newLine();
					writer.close();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("LOGIN");
					alert.setHeaderText("Verificação de Login");
					alert.setContentText("O programa irá fechar.\nAbra-o novamente e insira seu Login e senha");
					alert.showAndWait();
					Platform.exit();
				}else {
					MainSisContract.ChangeScreen(sucess);
					txtLogin.clear();
					txtPassword.clear();
				}
			}
			
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("LOGIN");
			alert.setHeaderText("Falha de Login");
			alert.setContentText("exception"+e);
			alert.showAndWait();
		}
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
