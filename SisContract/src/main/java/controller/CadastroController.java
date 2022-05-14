package controller;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import application.MainSisContract;
import dao.EmpresaDBDAO;
import dao.UsuarioDBDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Empresa;
import model.Usuario;

public class CadastroController {

    @FXML
    private TextField txtcadLogin;

    @FXML
    private TextField txtDoc;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtAtuacao;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private JFXRadioButton rbtnCPF;

    @FXML
    private JFXRadioButton rbtnCnpj;

    @FXML
    private JFXButton btnCadastro;

    @FXML
    private Button btnVoltar;
    
    private Usuario user;
    private Empresa empresa;
    private UsuarioDBDAO userdao;
    private EmpresaDBDAO empresadao;
    /**
     * @param ActionEvent event
     * @throws IOException, SQLException
     * realiza o cadastro com as informações dos textfields
     * */
    @FXML
    void btnCadastroOnAction(ActionEvent event) throws IOException, SQLException {
    	if(rbtnCPF.isSelected()==true) {
    		
    	user = new Usuario();
    	userdao = new UsuarioDBDAO();
    	user.setUserid(userdao.generateId());
    	user.setLogin(txtcadLogin.getText());
    	user.setsenha(txtSenha.getText());
    	user.setCpf(txtDoc.getText());
    	user.setNome(txtNome.getText());
    	user.setareaAtu(txtAtuacao.getText());
    	user.setendereco(txtCidade.getText());
    	try {
			userdao.insereUser(user);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CADASTRO");
			alert.setHeaderText("Informação para o Usuário");
			alert.setContentText("Usuário Cadastrado com Sucesso");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CADASTRO");
			alert.setHeaderText("Informação para o Usuário");
			alert.setContentText("FALHA NO CADASTRO");
			alert.showAndWait();
			e.printStackTrace();
		}
    	}
    	if(rbtnCnpj.isSelected()==true) {
    		empresa = new Empresa();
    		empresadao = new EmpresaDBDAO();
    		
    		empresa.setempresaid(empresadao.generateId());
    		empresa.setLogin(txtcadLogin.getText());
    		empresa.setsenha(txtSenha.getText());
    		empresa.setNome(txtNome.getText());
    		empresa.setCnpj(txtDoc.getText());
    		empresa.setendereco(txtCidade.getText());
    		try {
				empresadao.insereEmpresa(empresa);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("CADASTRO");
				alert.setHeaderText("Informação para o Usuário");
				alert.setContentText("Empresa Cadastrada com Sucesso");
				alert.showAndWait();
			} catch (SQLException e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("CADASTRO");
				alert.setHeaderText("Informação para o Usuário");
				alert.setContentText("FALHA NO CADASTRO");
				alert.showAndWait();
				e.printStackTrace();
			}
    	}
    	txtSenha.clear();
    	txtNome.clear();
    	txtAtuacao.clear();
    	txtCidade.clear();
    	txtDoc.clear();
    	txtcadLogin.clear();
    	rbtnCPF.setSelected(false);
    	rbtnCnpj.setSelected(false);
    }
    /**
     * @param ActionEvent event
     * muda para a tela de login
     * */
    @FXML
    void btnVoltarOnAction(ActionEvent event) {
    	MainSisContract.ChangeScreen("Back");
    	txtSenha.clear();
    	txtNome.clear();
    	txtAtuacao.clear();
    	txtCidade.clear();
    	txtDoc.clear();
    	txtcadLogin.clear();
    	rbtnCPF.setSelected(false);
    	rbtnCnpj.setSelected(false);
    }
    /**
     * @param ActionEvent event
     * ao selecionado deixa o outro radio button desmarcado
     * */
    @FXML
    void rbtnCNPJOnAction(ActionEvent event) {
    	if(rbtnCnpj.isSelected()==true) {
    		rbtnCPF.setSelected(false);
    	}
    }
    /**
     * @param ActionEvent event
     * ao selecionado deixa o outro radio button desmarcado
     * */
    @FXML
    void rbtnCPFOnAction(ActionEvent event) {
    	if(rbtnCPF.isSelected()==true) {
    		rbtnCnpj.setSelected(false);
    	}
    }
}