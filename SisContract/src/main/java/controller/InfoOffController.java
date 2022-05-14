package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import application.MainSisContract;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class InfoOffController {

    @FXML
    private ImageView logout;

    @FXML
    private ImageView btnNovo;

    @FXML
    private ImageView btnInfo;

    @FXML
    private ImageView btnModelo;

    @FXML
    private Label lblOff;

    @FXML
    private JFXButton btnSalvar;
    
    @FXML
    private JFXButton btnAlert;
    
    @FXML
    private JFXButton btnAlert1;
    
    @FXML
    private JFXButton btnAlert2;
    
    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtnome;
    
    @FXML
    private TextField txtEspec;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtAreaAtu;
    
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtEscolaridade;
    
    @FXML
    private TextField txtXP;
    
    @FXML
    private JFXRadioButton rbtnModelo1;

    @FXML
    private JFXRadioButton rbtnModelo2;

    @FXML
    private JFXRadioButton rbtnModelo3;
    /**
     * @param MouseEvent event
     * muda para a tela de informa��es/cria��o de curr�culos
     * */
    @FXML
    void btnInfoOnAction(MouseEvent event) {
    	System.out.println("Info");
    	txtCidade.clear();
    	txtnome.clear();
    	txtCPF.clear();
    	txtAreaAtu.clear();
    	txtEspec.clear();
    	txtEmail.clear();
    	txtEscolaridade.clear();
    	txtXP.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de modelos de curr�culo
     * */
    @FXML
    void btnModeloOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("ModeloOff");
    	txtCidade.clear();
    	txtnome.clear();
    	txtCPF.clear();
    	txtAreaAtu.clear();
    	txtEmail.clear();
    	txtEspec.clear();
    	txtEscolaridade.clear();
    	txtXP.clear();
    }
    /**
     * @param MouseEvent event
     * muda para a tela de informa��es/cria��o de curr�culos
     * */
    @FXML
    void btnNovoOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("NewOff");
    	txtCidade.clear();
    	txtnome.clear();
    	txtCPF.clear();
    	txtAreaAtu.clear();
    	txtEspec.clear();
    	txtEmail.clear();
    	txtEscolaridade.clear();
    	txtXP.clear();
    }
    /**
     * @param ActionEvent event
     * cria um alert com informa��es para a cria��o do curr�culo
     * */
    @FXML
    void btnAlertOnAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informa��es Especifica��es");
		alert.setHeaderText("ATEN��O!");
		alert.setContentText("Adicione suas especifica��es com campos separados por ,");
		alert.showAndWait();
    }
    /**
     * @param ActionEvent event
     * cria um alert com informa��es para a cria��o do curr�culo
     * */
    @FXML
    void btnAlert1OnAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informa��es Experi�ncia");
		alert.setHeaderText("ATEN��O!");
		alert.setContentText("Campos Separados por , \nAnos de experi�ncia dentro de ()");
		alert.showAndWait();
    }
    /**
     * @param ActionEvent event
     * cria um alert com informa��es para a cria��o do curr�culo
     * */
    @FXML
    void btnAlert2OnAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informa��es Endere�o");
		alert.setHeaderText("ATEN��O!");
		alert.setContentText("Endere�o,numero,cep,cidade/estado.\nCampos Separados por , ");
		alert.showAndWait();
    }
    /**
     * @param ActionEvent event
     * @throws DocumentException,MalformedURLException,IOException
     * cria o curr�culo
     * */
	@FXML
    void btnSalvarOnAction(ActionEvent event) throws DocumentException, MalformedURLException, IOException {
    	String nome = txtnome.getText();
    	String cpf= txtCPF.getText();
    	String areaAtu= txtAreaAtu.getText();
    	String cidade= txtCidade.getText();
    	String especializacao= txtEspec.getText();
    	String escolaridade= txtEscolaridade.getText();
    	String email=txtEmail.getText();
    	String xp =txtXP.getText();//adicionado caso novo bd
    	
    	if(rbtnModelo1.isSelected()==true) {//modelo1
    		String imgDelimit = "C:\\Users\\marco\\eclipse-workspace\\SisContract\\src\\main\\resources\\botoes\\delimitador.png";
    		String imgDelimit2 = "C:\\Users\\marco\\eclipse-workspace\\SisContract\\src\\main\\resources\\botoes\\delimitadormenor.png";
    		Font f1= new Font(Font.FontFamily.TIMES_ROMAN,24,Font.BOLD,BaseColor.BLACK);
    		Font f2= new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD,BaseColor.BLACK);
    		Font f3= new Font(Font.FontFamily.TIMES_ROMAN,16,Font.NORMAL,BaseColor.BLACK);
    		
    		Document doc1 = new Document();//cria doc
    		PdfWriter.getInstance(doc1, new FileOutputStream("C:\\Users\\marco\\OneDrive\\Imagens\\SisContractDocs\\curriculum1.pdf"));
    		doc1.open();//abre
    		doc1.addTitle("Curriculo-modelo1");
    		doc1.addAuthor("SisContract Corporation");
    		doc1.addLanguage("pt-br");
    		
    		doc1.add(Image.getInstance(String.format(imgDelimit)));
    		
    		Paragraph p1 =new Paragraph(nome,f1);
    		p1.setAlignment(Element.ALIGN_CENTER);
    		p1.setSpacingAfter(10);
    		doc1.add(p1);
    		doc1.add(Image.getInstance(String.format(imgDelimit2)));
    		Paragraph p7 = new Paragraph("OBJETIVO\nFazer Parte da Equipe,Crescimento Profissional,Crescimento da Empresa",f3);
    		p7.setAlignment(Element.ALIGN_CENTER);
    		doc1.add(p7);
    		doc1.add(Image.getInstance(String.format(imgDelimit2)));
    		Paragraph p2=new Paragraph("CPF:"+cpf,f2);
    		doc1.add(p2);
    		Paragraph p8 = new Paragraph("E-MAIL:"+email,f3);
    		doc1.add(p8);
    		Paragraph p5 = new Paragraph("ENDERE�O:"+cidade,f2);
    		doc1.add(p5);
    		doc1.add(Image.getInstance(String.format(imgDelimit2)));
    		Paragraph p3 = new Paragraph("AREA DE ATUA��O:"+areaAtu,f2);
    		doc1.add(p3);
    		Paragraph p4 = new Paragraph("ESCOLARIDADE:"+escolaridade,f2);
    		doc1.add(p4);
    		doc1.add(Image.getInstance(String.format(imgDelimit2)));
    		Paragraph p6 =new Paragraph("ESPECIALIZA��ES:"+especializacao,f2);
    		doc1.add(p6);
    		Paragraph p9 =  new Paragraph("EXPERI�NCIA:"+xp,f2);
    		doc1.add(p9);
    		doc1.add(Image.getInstance(String.format(imgDelimit2)));
		
    		doc1.close();//fecha
    	}
    	if(rbtnModelo2.isSelected()==true) {//modelo2
    		Document doc2 = new Document();
    		PdfWriter.getInstance(doc2, new FileOutputStream("C:\\Users\\marco\\OneDrive\\Imagens\\SisContractDocs\\curriculum2.pdf"));
    		
    		doc2.open();//abre
    		doc2.addTitle("Curriculo-modelo2");
    		doc2.addAuthor("SisContract Corporation");
    		doc2.addLanguage("pt-br");
    		
    		Font f1 = new Font(Font.FontFamily.HELVETICA,22,Font.BOLD,BaseColor.DARK_GRAY);//fontes
    		Font f2 = new Font(Font.FontFamily.HELVETICA,28,Font.BOLD,BaseColor.BLACK);
    		Font f3 = new Font(Font.FontFamily.HELVETICA,16,Font.NORMAL,BaseColor.CYAN);
    		Font f4 = new Font(Font.FontFamily.HELVETICA,16,Font.NORMAL,BaseColor.BLACK);
    		Font f5 = new Font(Font.FontFamily.HELVETICA,20,Font.NORMAL,BaseColor.BLACK);
    		
    		Paragraph p1 = new Paragraph(nome,f2);
    		p1.setAlignment(Element.ALIGN_JUSTIFIED);
    		doc2.add(p1);
    		Paragraph p2 = new Paragraph(cidade,f3);
    		doc2.add(p2);
    		Paragraph p3 = new Paragraph("------------------------------------------------------------------------------",f5);
    		doc2.add(p3);
    		Paragraph p4 = new Paragraph("OBJETIVO",f1);
    		doc2.add(p4);
    		Paragraph p5 = new Paragraph("Fazer Parte da Equipe,Crescimento Profissional,Crescimento da Empresa e Desempenhar um bom servi�o em meu devido cargo.",f4);
    		doc2.add(p5);
    		doc2.add(p3);
    		Paragraph p6 = new Paragraph("EDUCA��O",f1);
    		doc2.add(p6);
    		Paragraph p7 = new Paragraph(escolaridade,f4);
    		doc2.add(p7);
    		doc2.add(p3);
    		Paragraph p8 = new Paragraph("ESPECIALIZA��ES",f1);
    		doc2.add(p8);
    		Paragraph p9 = new Paragraph("Atuante na Area de "+areaAtu+"\nEspecializa��es em "+especializacao,f4);
    		doc2.add(p9);
    		doc2.add(p3);
    		Paragraph p10 = new Paragraph("INFORMA��ES",f1);
    		doc2.add(p10);
    		Paragraph p11 = new Paragraph("CPF:"+cpf+"\nE-Mail:"+email,f4);
    		doc2.add(p11);
    		Paragraph p12 = new Paragraph("EXPERI�NCIA",f1);
    		doc2.add(p12);
    		Paragraph p13= new Paragraph(xp,f4);
    		doc2.add(p13);
    		doc2.add(p3);
    		
    		doc2.close();//fecha
    	}
    	if(rbtnModelo3.isSelected()==true) {//modelo3
    		Document doc3 = new Document();//cria
    		PdfWriter.getInstance(doc3, new FileOutputStream("C:\\Users\\marco\\OneDrive\\Imagens\\SisContractDocs\\curriculum3.pdf"));
    		
    		doc3.open();//abre
    		doc3.addTitle("Curriculo-modelo3");
    		doc3.addAuthor("SisContract Corporation");
    		doc3.addLanguage("pt-br");
    		
    		Font f1 =new Font(Font.FontFamily.COURIER,22,Font.BOLD,BaseColor.CYAN);//fontes
    		Font f2 =new Font(Font.FontFamily.COURIER,24,Font.BOLD,BaseColor.DARK_GRAY);
    		Font f3 =new Font(Font.FontFamily.COURIER,16,Font.BOLD,BaseColor.GRAY);
    		Font f4 =new Font(Font.FontFamily.COURIER,14,Font.NORMAL,BaseColor.GRAY);
    		Font f5 =new Font(Font.FontFamily.COURIER,16,Font.BOLD,BaseColor.DARK_GRAY);
    		
    		Paragraph plinha = new Paragraph("_______________________________________",f1);
    		Paragraph p1 = new Paragraph(nome,f2);
    		p1.setAlignment(Element.ALIGN_CENTER);
    		doc3.add(p1);
    		Paragraph p2 = new Paragraph(areaAtu,f3);
    		p2.setAlignment(Element.ALIGN_CENTER);
    		doc3.add(p2);
    		doc3.add(plinha);
    		doc3.add(plinha);
    		Paragraph p3 = new Paragraph("OBJETIVO",f5);
    		doc3.add(p3);
    		Paragraph p4 = new Paragraph("         Fazer Parte da Equipe,Crescimento Profissional,Crescimento da Empresa e Desempenhar um bom servi�o em meu devido cargo.",f4);
    		doc3.add(p4);
    		doc3.add(plinha);
    		Paragraph p5 = new Paragraph("INFORMA��ES",f5);
    		doc3.add(p5);
    		Paragraph p6 = new Paragraph("           CPF:"+cpf+"\n           E-mail:"+email,f4);
    		doc3.add(p6);
    		Paragraph p7 = new Paragraph("           "+cidade,f4);
    		doc3.add(p7);
    		doc3.add(plinha);
    		Paragraph p8 = new Paragraph("EDUCA��O",f5);
    		doc3.add(p8);
    		Paragraph p9 = new Paragraph("         "+escolaridade,f4);
    		doc3.add(p9);
    		doc3.add(plinha);
    		Paragraph p10= new Paragraph("HABILIDADES",f5);
    		doc3.add(p10);
    		Paragraph p11= new Paragraph("           "+especializacao,f4);
    		doc3.add(p11);
    		doc3.add(plinha);
    		Paragraph p12=new Paragraph("EXPERI�NCIA",f5);
    		doc3.add(p12);
    		Paragraph p13 = new Paragraph("           "+xp,f4);
    		doc3.add(p13);
    		doc3.add(plinha);
    		doc3.add(plinha);
    		doc3.close();//fecha
    	}
    	if(rbtnModelo1.isSelected()==false&&rbtnModelo2.isSelected()==false&&rbtnModelo3.isSelected()==false) {//nenhjm modelo selecionado
        	Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Cria��o do PDF");
    		alert.setHeaderText("Curr�culo n�o criado criado");
    		alert.setContentText("Selecione um modelo para criar o curr�culo");
    		alert.showAndWait();
    	}else {
    		    Alert alert = new Alert(AlertType.INFORMATION);
    		    alert.setTitle("Cria��o do PDF");
    		    alert.setHeaderText("Curr�culo criado");
    		    alert.setContentText("Curr�culo foi criado e encontra-se na pasta\nC:\\Users\\marco\\OneDrive\\Imagens\\SisContractDocs");
    		    alert.showAndWait();
    	}
    }
    /**
     * @param ActionEvent event
     * ao selecionado deixa os outros radio buttons desmarcados
     * */
    @FXML
    void rbtnModelo1OnAction(ActionEvent event) {
    	if(rbtnModelo1.isSelected()==true) {
    		rbtnModelo2.setSelected(false);
    		rbtnModelo3.setSelected(false);
    	}
    }
    /**
     * @param ActionEvent event
     * ao selecionado deixa os outros radio buttons desmarcados
     * */
    @FXML
    void rbtnModelo2OnAction(ActionEvent event) {
       	if(rbtnModelo2.isSelected()==true) {
    		rbtnModelo1.setSelected(false);
    		rbtnModelo3.setSelected(false);
    	}
    }
    /**
     * @param ActionEvent event
     * ao selecionado deixa os outros radio buttons desmarcados
     * */
    @FXML
    void rbtnModelo3OnAction(ActionEvent event) {
       	if(rbtnModelo3.isSelected()==true) {
    		rbtnModelo2.setSelected(false);
    		rbtnModelo1.setSelected(false);
    	}
    }
    /**
     * @param MouseEvent event
     * muda para a tela de login
     * */
    @FXML
    void logoutOnAction(MouseEvent event) {
    	MainSisContract.ChangeScreen("Back");
    	txtCidade.clear();
    	txtnome.clear();
    	txtCPF.clear();
    	txtEspec.clear();
    	txtAreaAtu.clear();
    	txtEmail.clear();
    	txtEscolaridade.clear();
    	txtXP.clear();
		rbtnModelo1.setSelected(false);
		rbtnModelo2.setSelected(false);
		rbtnModelo3.setSelected(false);
    }
}
