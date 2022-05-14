package dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.Empresa;

public class EmpresaDBDAO implements EmpresaDAO{
	
	private String sql;
	private Connection connection;
	private PreparedStatement statement;
	/**
	 * abre a conexão com o banco de dados
	 * @throws SQLException
	 * */
	private void open() throws SQLException {
		connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
	}
	/**
	 * fecha a conexão com o Banco de dados
	 * @throws SQLException
	 * */
	private void close() throws SQLException {
		connection.close();
	}
	/**
	 * @throws SQLException
	 * @param Empresa empresa
	 * Cadastra a empresa
	 * */
	@Override
	public void insereEmpresa(Empresa empresa) throws SQLException {
		open();
		sql = "INSERT INTO empresa (empresaid,login,senha,nome,cnpj,endereco) VALUES(?,?,?,?,?,?);";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, empresa.getempresaId());
		statement.setString(2,empresa.getLogin());
		statement.setString(3,empresa.getsenha());
		statement.setString(4,empresa.getNome());
		statement.setString(6,empresa.getendereco());
		statement.setString(5,empresa.getCnpj());
		statement.executeUpdate();
		close();
	}
	/**
	 * @throws SQLException
	 * @throws IOException
	 * @param Empresa empresa
	 * remoção de empresa do banco de dados(implementado porem não aplicado)
	 * */
	@Override
	public void removeEmpresa(Empresa empresa) throws SQLException, IOException {
		open();
		sql="Delete from empresa where login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, empresa.getLogin());
		statement.executeUpdate();
		close();
	}
	/**
	 * @return id
	 * @throws SQLException
	 * @param String nomeEmpresa
	 * busca o codigo da empresa utilizando o nome desta para a busca
	 * */
	@Override
	public int buscaPorCodigoEmpresa(String nomeEmpresa) throws SQLException {
		open();
		sql= "SELECT empresaid FROM empresa WHERE nome=?;";
		statement = connection.prepareStatement(sql);
		statement.setString(1, nomeEmpresa);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return -1;
		}else {
			int id = rs.getInt("empresaid");
			close();
			return id;
		}
	}
	/**
	 * @return id
	 * @throws SQLException
	 * @param String nomeEmpresa
	 * busca o codigo da empresa utilizando o login desta para a busca
	 * */
	@Override
	public int buscaPorCodigoEmpresa2(String loginEmpresa) throws SQLException {
		open();
		sql= "SELECT empresaid FROM empresa WHERE login=?;";
		statement = connection.prepareStatement(sql);
		statement.setString(1, loginEmpresa);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return -1;
		}else {
			int id = rs.getInt("empresaid");
			close();
			return id;
		}
	}
	/**
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * gera o arquivo pdf com todas as empresas
	 * */
	@Override
	public void listaTodosEmpresa() throws SQLException, FileNotFoundException, DocumentException {
		open();
		sql="SELECT nome,endereco,cargosof FROM empresa;";
		statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		Paragraph vazio = new Paragraph(" ");
		Document docEmpresas= new Document();
		Font f= new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD,BaseColor.BLACK);
		PdfWriter.getInstance(docEmpresas, new FileOutputStream("C:\\Users\\marco\\OneDrive\\Imagens\\SisContractDocs\\listaEmpresas.pdf"));
		docEmpresas.open();
		docEmpresas.addTitle("Empresas Cadastradas");
		docEmpresas.addAuthor("SisContract Corporation");
		docEmpresas.addLanguage("pt-br");
		while(rs.next()) {
			Paragraph p1 = new Paragraph(rs.getString("nome")+","+rs.getString("endereco")+","+rs.getString("cargosof"),f);
			docEmpresas.add(p1);
			docEmpresas.add(vazio);
		}
		docEmpresas.close();
		close();
	}
	
	/**
	 * @throws SQLException
	 * @return numero inteiro para a geração do cadastro de usuário com o próximo id disponivel
	 * */
	public int generateId() throws SQLException {
		// Abre a conexão
		open();
			String sql = "SELECT MAX(empresaid) AS Max_val FROM empresa";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1)+1;
				}
				return 1;
	}
	/**
	 * Execução do login pela empresa
	 * @param String login
	 * @param String senha
	 * @throws SQLException
	 * @return back ou empresa*/
	@Override
	public String Loginexecute(String login, String senha) throws SQLException {
		open();
		sql = "SELECT e.nome,e.senha FROM empresa e WHERE e.login = ? and e.senha = ?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, login);
		statement.setString(2, senha);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return "Back";
		}else {
			close();
			return "Empresa";
		}
	}
	/**
	 * @param String empresa
	 * @param String txtfield
	 * @throws SQLException
	 * Atualiza o login da empresa
	 * */
	@Override
	public void atualizaEmpresaLogin(String empresa, String txtfield) throws SQLException {
		open();
		sql="UPDATE empresa SET Login=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,empresa);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String empresa
	 * @param String txtfield
	 * @throws SQLException
	 * Atualiza a senha da empresa
	 * */
	@Override
	public void atualizaEmpresaSenha(String empresa, String txtfield) throws SQLException {
		open();
		sql="UPDATE empresa SET senha=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,empresa);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String empresa
	 * @param String txtfield
	 * @throws SQLException
	 * Atualiza os cargos ofertados pela empresa
	 * */
	@Override
	public void atualizaEmpresaCargos(String empresa, String txtfield) throws SQLException {
		open();
		sql="UPDATE empresa SET cargosof=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,empresa);
		statement.executeUpdate();
		close();
	}
}
