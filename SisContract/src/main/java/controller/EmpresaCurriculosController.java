package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import com.itextpdf.text.DocumentException;
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
import model.Usuario;

public class EmpresaCurriculosController {

    @FXML
    private ImageView btnCurriculos;

    @FXML
    private ImageView btnLogout;

    @FXML
    private ImageView btnContratar;
    
    @FXML
    private TextField txtProcurar;
    
    @FXML
    private JFXButton btnProcurar;
    
    @FXML
    private JFXButton btnAceitar;
    
    @FXML
    private JFXButton btnView;

    @FXML
    private ImageView btnConfig;

    @FXML
    private Label lblEmpresaNome;
    
    @FXML
    private Label lblEscolaridade;

    @FXML
    private Label lblEspec;

    @FXML
    private Label lblXP;

    @FXML
    private Label lblname;
    
    private UsuarioDBDAO userdao;
    private Usuario user;
    
    /**
     * @param MouseEvent event
     * muda para a tela de configura��es
     * */
    @FXML
    void btnConfigOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ConfigEmp");
    	txtProcurar.clear();
    }
    /**
     * @param MouseEvent event
     * abre um alert que informa
     * */
    @FXML
    void btnContratarOnAction(MouseEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("EM BREVE");
		alert.setHeaderText("Fun��o prevista para o PI-III");
		alert.showAndWait();
    	txtProcurar.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de curr�culos
     * */
    @FXML
    void btnCurriculosOnAction(MouseEvent event) {
    	txtProcurar.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de login
     * */
    @FXML
    void btnLogoutOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("Back");
    	txtProcurar.clear();
    }
    /**
     * @param ActionEvent event
     * @throws SQLException
     * realiza a busca mais espec�fica do usu�rio procurado
     * mostra os detalhes focados em um usu�rio
     * */
    @FXML
    void btnProcurarOnAction(ActionEvent event) throws SQLException {
    	userdao= new UsuarioDBDAO();
    	String procura = txtProcurar.getText();
    	String nome = userdao.viewContractName(procura);
    	String xp = userdao.viewContractXP(procura);
    	String espec = userdao.viewContractEspec(procura);
    	String escola = userdao.viewContractEscola(procura);
    	lblname.setText(nome);
    	lblXP.setText(xp);
    	lblEspec.setText(espec);
    	lblEscolaridade.setText(escola);
    	txtProcurar.clear();
    }
    /**
     * @param ActionEvent event
     * Realiza a contrata��o do usu�rio pela empresa
     * muda o status
     * */
    @FXML
    void btnAceitarOnAction(ActionEvent event) {
    	userdao = new UsuarioDBDAO();
    	user = new Usuario();
    	user.setStatus("empregado");
    	user.setNome(txtProcurar.getText());
    	try {
			userdao.atualizaStatus(user);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Usuario Contratado");
			alert.setHeaderText("Contrata��o realizada");
			alert.setContentText("O usu�rio ser� notificado");
			alert.showAndWait();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Usuario n�o Contratado");
			alert.setHeaderText("Contrata��o n�o realizada");
			alert.setContentText("Erro:"+e);
			alert.showAndWait();
		}
    }
    /**
     * @param ActionEvent event 
     * @throws SQLException
     * chama o m�todo listaUsers oqual cria um documento pdf com os usu�rios que possuem liga��o com alguma empresa
     *  na tabela contrata��o(solicita��o)
     * */
    @FXML
    void btnViewOnAction(ActionEvent event) throws SQLException {
    	userdao = new UsuarioDBDAO();
    	try {
			userdao.listaUsers();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Relat�rio criado");
			alert.setHeaderText("usuarios com o pedido enviado j� disponiveis");
			alert.setContentText("Relat�rio j� criado na pasta\nC:\\Users\\marco\\OneDrive\\Imagens\\SisContractDocs");
			alert.showAndWait();
		} catch (FileNotFoundException | SQLException | DocumentException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Relat�rio n�o criado");
			alert.setHeaderText("Erro na cria��o do relat�rio");
			alert.setContentText("erro:"+e);
			alert.showAndWait();
			e.printStackTrace();
		}
    }
    /**
     * @param MouseEvent event
     * muda o conte�do da label
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