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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class InfoUserController {

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
    private JFXButton btnAlert;

    @FXML
    private JFXButton btnAlert1;
    
    @FXML
    private JFXButton btnAreaAtt;

    @FXML
    private JFXButton btnCPFatt;
    
    @FXML
    private JFXButton btnEnderecoAtt;

    @FXML
    private JFXButton btnEscolaridadeAtt;

    @FXML
    private JFXButton btnEspecAtt;

    @FXML
    private JFXButton btnNomeAtt;

    @FXML
    private JFXButton btnXpAtt;
    
    @FXML
    private JFXButton btnAlert2;

    @FXML
    private Label lblUserName;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtEspec;

    @FXML
    private TextField txtCPF;
    
    @FXML
    private TextField txtXP;

    @FXML
    private TextField txtAreaAtu;
    
    @FXML
    private TextField txtEscolaridade;
    
    private UsuarioDBDAO userdao;

    /**
     * @param MouseEvent event
     * muda para a tela de configurações e limpa os campos de informações
     * */
    @FXML
    void btnConfigOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ConfigUser");
    	txtCidade.clear();
    	txtNome.clear();
    	txtCPF.clear();
    	txtAreaAtu.clear();
    	txtEscolaridade.clear();
    	txtEspec.clear();
    	txtXP.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de informações de usuário e limpa os campos de informações
     * */
    @FXML
    void btnInfoOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("InfoUser");
    	txtCidade.clear();
    	txtNome.clear();
    	txtCPF.clear();
    	txtAreaAtu.clear();
    	txtEscolaridade.clear();
    	txtEspec.clear();
    	txtXP.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de login e limpa os campos de informações
     * */
    @FXML
    void btnLogoutOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("Back");
    	txtCidade.clear();
    	txtNome.clear();
    	txtCPF.clear();
    	txtAreaAtu.clear();
    	txtEscolaridade.clear();
    	txtEspec.clear();
    	txtXP.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de modelos e limpa os campos de informações
     * */
    @FXML
    void btnModeloOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ModeloUser");
    	txtCidade.clear();
    	txtNome.clear();
    	txtCPF.clear();
    	txtAreaAtu.clear();
    	txtEscolaridade.clear();
    	txtEspec.clear();
    	txtXP.clear();
    }
    /**
     * @param ActionEvent event
     * cria um alert com informações para inserir os campos corretamente no banco de dados
     * visando um currículo melhor criado
     * */
    @FXML
    void btnAlertOnAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informações Especificações");
		alert.setHeaderText("ATENÇÃO!");
		alert.setContentText("Adicione suas especificações com campos separados por ,");
		alert.showAndWait();
    }
    /**
     * @param ActionEvent event
     * cria um alert com informações para inserir os campos corretamente no banco de dados
     * visando um currículo melhor criado
     * */
    @FXML
    void btnAlert1OnAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informações Experiência");
		alert.setHeaderText("ATENÇÃO!");
		alert.setContentText("Campos Separados por , \nAnos de experiência dentro de ()");
		alert.showAndWait();
    }
    /**
     * @param ActionEvent event
     * cria um alert com informações para inserir os campos corretamente no banco de dados
     * visando um currículo melhor criado
     * */
    @FXML
    void btnAlert2OnAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informações Endereço");
		alert.setHeaderText("ATENÇÃO!");
		alert.setContentText("Endereço,numero,cep,cidade/estado.\nCampos Separados por , ");
		alert.showAndWait();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de criação de currículos e limpa os campos de informações
     * */
    @FXML
    void btnNewOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("NewUser");
    	txtCidade.clear();
    	txtNome.clear();
    	txtCPF.clear();
    	txtAreaAtu.clear();
    	txtEscolaridade.clear();
    	txtEspec.clear();
    	txtXP.clear();
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
     * @param ActionEvent event
     * atualiza o campo area de atuação
     * */
    @FXML
    void btnAreaAttOnAction(ActionEvent event) {
    	String texto = txtAreaAtu.getText();
    	String usuario = lblUserName.getText();
    	userdao=new UsuarioDBDAO();
    	try {
			userdao.atualizaUserArea(usuario, texto);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização realizada");
			alert.setContentText("Area de Atuação alterada com sucesso");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização falhou");
			alert.setContentText("Falha na atualização de Area de Atuação "+e);
			alert.showAndWait();
		}finally {
			txtAreaAtu.clear();
		}
    }
    /**
     * @param ActionEvent event
     * atualiza o campo cpf
     * */
    @FXML
    void btnCPFattOnAction(ActionEvent event) {
    	String texto = txtCPF.getText();
    	String usuario = lblUserName.getText();
    	userdao=new UsuarioDBDAO();
    	try {
			userdao.atualizaUserCpf(usuario, texto);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização realizada");
			alert.setContentText("CPF alterado com sucesso");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização falhou");
			alert.setContentText("Falha na atualização de CPF "+e);
			alert.showAndWait();
		}finally {
			txtCPF.clear();
		}
    }
    /**
     * @param ActionEvent event
     * atualiza o campo endereço
     * */
    @FXML
    void btnEnderecoAttOnAction(ActionEvent event) {
    	String texto = txtCidade.getText();
    	String usuario = lblUserName.getText();
    	userdao=new UsuarioDBDAO();
    	try {
			userdao.atualizaUserEndereco(usuario, texto);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização realizada");
			alert.setContentText("Endereço alterado com sucesso");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização falhou");
			alert.setContentText("Falha na atualização de Endereço "+e);
			alert.showAndWait();
		}finally {
			txtCidade.clear();
		}
    }
    /**
     * @param ActionEvent event
     * atualiza o campo escolaridade
     * */
    @FXML
    void btnEscolaridadeAttOnAction(ActionEvent event) {
    	String texto = txtEscolaridade.getText();
    	String usuario = lblUserName.getText();
    	userdao=new UsuarioDBDAO();
    	try {
			userdao.atualizaUserEscolaridade(usuario, texto);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização realizada");
			alert.setContentText("Escolaridade alterada com sucesso");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização falhou");
			alert.setContentText("Falha na atualização de Escolaridade "+e);
			alert.showAndWait();
		}finally {
			txtEscolaridade.clear();
		}
    }
    /**
     * @param ActionEvent event
     * atualiza o campo especializações
     * */
    @FXML
    void btnEspecAttOnAction(ActionEvent event) {
    	String texto = txtEspec.getText();
    	String usuario = lblUserName.getText();
    	userdao=new UsuarioDBDAO();
    	try {
			userdao.atualizaUserEspecializacao(usuario, texto);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização realizada");
			alert.setContentText("Especializações alteradas com sucesso");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização falhou");
			alert.setContentText("Falha na atualização de Especializações "+e);
			alert.showAndWait();
		}finally {
			txtEspec.clear();
		}
    }
    /**
     * @param ActionEvent event
     * atualiza o campo nome
     * */
    @FXML
    void btnNomeAttOnAction(ActionEvent event) {
    	String texto = txtNome.getText();
    	String usuario = lblUserName.getText();
    	userdao=new UsuarioDBDAO();
    	try {
			userdao.atualizaUserNome(usuario, texto);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização realizada");
			alert.setContentText("Nome alterado com sucesso");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização falhou");
			alert.setContentText("Falha na atualização de Nome "+e);
			alert.showAndWait();
		}finally {
			txtNome.clear();
		}
    }
    /**
     * @param ActionEvent event
     * atualiza o campo experiência
     * */
    @FXML
    void btnXpAttOnAction(ActionEvent event) {
    	String texto = txtXP.getText();
    	String usuario = lblUserName.getText();
    	userdao=new UsuarioDBDAO();
    	try {
			userdao.atualizaUserXP(usuario, texto);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização realizada");
			alert.setContentText("Experiência alterada com sucesso");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atualização");
			alert.setHeaderText("Atualização falhou");
			alert.setContentText("Falha na atualização de Experiência "+e);
			alert.showAndWait();
		}finally {
			txtXP.clear();
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