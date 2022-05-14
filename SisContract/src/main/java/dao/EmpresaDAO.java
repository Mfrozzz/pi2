package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.DocumentException;

import model.Empresa;

public interface EmpresaDAO {

	public void insereEmpresa(Empresa empresa) throws SQLException;

	public void atualizaEmpresaLogin(String empresa,String txtfield) throws SQLException;
	
	public void atualizaEmpresaSenha(String empresa,String txtfield) throws SQLException;
	
	public void atualizaEmpresaCargos(String empresa,String txtfield) throws SQLException;

	public void removeEmpresa(Empresa empresa) throws SQLException,IOException;

	public int buscaPorCodigoEmpresa(String nomeEmpresa) throws SQLException;

	public void listaTodosEmpresa() throws SQLException, FileNotFoundException, DocumentException;
	
	public String Loginexecute(String login, String senha) throws SQLException;
	
	public int buscaPorCodigoEmpresa2(String loginEmpresa) throws SQLException;
}
