package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 
 * @author Marcos Vinicius Schimaichel Boava, Felipe Rangel Michalszeszen
 *
 */

public class MainSisContract extends Application{
	
	private static Stage stage;
	private static Scene loginScene;
	private static Scene cadastroScene;
	private static Scene offScene;
	private static Scene userscene;
	private static Scene empresaScene;
	private static Scene InfoOffScene;
	private static Scene InfoUserScene;
	private static Scene configUserScene;
	private static Scene configEmpScene;
	private static Scene modeloUserScene;
	private static Scene modeloOffScene;
	private static Scene novoUserScene;
	private static Scene empCurriculoScene;
	
	/**
	 * @param primarystage
	 * Start inicializa o metodo e a GUI
	 * @throws IOException
	 */
	@Override
	public void start(Stage primarystage) throws IOException {
		stage=primarystage;
		
		AnchorPane loginpane = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		loginScene= new Scene(loginpane);
		
		AnchorPane cadastropane = FXMLLoader.load(getClass().getResource("/view/Cadastro.fxml"));
		cadastroScene= new Scene(cadastropane);
		
		AnchorPane offpane = FXMLLoader.load(getClass().getResource("/view/Offline.fxml"));
		offScene= new Scene(offpane);
		
		AnchorPane userpane = FXMLLoader.load(getClass().getResource("/view/Usuario.fxml"));
		userscene= new Scene(userpane);
		
		AnchorPane empresaPane = FXMLLoader.load(getClass().getResource("/view/Empresa.fxml"));
		empresaScene= new Scene(empresaPane);
		
		AnchorPane infoOffPane = FXMLLoader.load(getClass().getResource("/view/InfoOff.fxml"));
		InfoOffScene = new Scene(infoOffPane);
		
		AnchorPane infoUserPane = FXMLLoader.load(getClass().getResource("/view/InfoUser.fxml"));
		InfoUserScene = new Scene(infoUserPane);
		
		AnchorPane configUserPane = FXMLLoader.load(getClass().getResource("/view/ConfigUser.fxml"));
		configUserScene = new Scene(configUserPane);
		
		AnchorPane configEmpPane = FXMLLoader.load(getClass().getResource("/view/ConfigEmpresa.fxml"));
		configEmpScene = new Scene(configEmpPane);
		
		AnchorPane modeloUserPane = FXMLLoader.load(getClass().getResource("/view/ModeloUser.fxml"));
		modeloUserScene= new Scene(modeloUserPane);
		
		AnchorPane modeloOffPane = FXMLLoader.load(getClass().getResource("/view/ModeloOff.fxml"));
		modeloOffScene= new Scene(modeloOffPane);
		
		AnchorPane novoUserPane = FXMLLoader.load(getClass().getResource("/view/NovoUser.fxml"));
		novoUserScene = new Scene(novoUserPane);
		
		AnchorPane empCurriculoPane = FXMLLoader.load(getClass().getResource("/view/EmpresaCurriculos.fxml"));
		empCurriculoScene = new Scene(empCurriculoPane);
		
		primarystage.setTitle("SisContract");
		primarystage.getIcons().add(new Image("/logomenor.png"));
		
		primarystage.setScene(loginScene);
		primarystage.show();		
	}
		public static void main(String[] args) {
			launch(args);
	}
		/**
		 * public static que é chamado sempre que está para ocorrer a mudança de uma cena para outra
		 * @param source
		 */
	public static void ChangeScreen(String source) {
		switch(source) {
		case "Cadastro":
			stage.setScene(cadastroScene);
			break;
		case "Off":
			stage.setScene(offScene);
			break;
		case "Back":
			stage.setScene(loginScene);
			break;
		case "User":
			stage.setScene(userscene);
			break;
		case "Empresa":
			stage.setScene(empresaScene);
			break;
		case "InfoOff":
			stage.setScene(InfoOffScene);
			break;
		case "InfoUser":
			stage.setScene(InfoUserScene);
			break;
		case "ConfigUser":
			stage.setScene(configUserScene);
			break;
		case "ConfigEmp":
			stage.setScene(configEmpScene);
			break;
		case "ModeloUser":
			stage.setScene(modeloUserScene);
			break;
		case "ModeloOff":
			stage.setScene(modeloOffScene);
			break;
		case "NewUser":
			stage.setScene(novoUserScene);
			break;
		case "NewOff":
			stage.setScene(InfoOffScene);
			break;
		case "EmpCur":
			stage.setScene(empCurriculoScene);
			break;
		}
	}
}