package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import com.itextpdf.text.DocumentException;
import model.Usuario;

public interface UsuarioDAO {

	public void insereUser(Usuario usuario) throws SQLException;

	public void atualizaUserArea(String usuario,String txtfield) throws SQLException;
	
	public void atualizaUserCpf(String usuario,String txtfield) throws SQLException;
	
	public void atualizaUserEndereco(String usuario,String txtfield) throws SQLException;
	
	public void atualizaUserEscolaridade(String usuario,String txtfield) throws SQLException;
	
	public void atualizaUserEspecializacao(String usuario,String txtfield) throws SQLException;
	
	public void atualizaUserNome(String usuario,String txtfield) throws SQLException;
	
	public void atualizaUserXP(String usuario,String txtfield) throws SQLException;
	
	public void atualizaConfigLogin(String usuario, String txtfield) throws SQLException;
	
	public void atualizaConfigSenha(String usuario, String txtfield) throws SQLException;
	
	public void atualizaStatus(Usuario user) throws SQLException;

	public void removeUser(Usuario usuario) throws SQLException,IOException;
	
	public String Loginexecute(String login,String senha) throws SQLException;
	
	public String buscaNaEmpresa(String usuario) throws SQLException;

	public String buscaPorLoginUser(String usuario) throws SQLException;

	public String buscaPorNomeUser(String usuario) throws SQLException;

	public String buscaPorCPFUser(String usuario) throws SQLException;

	public String buscaPorAreaAtuUser(String usuario) throws SQLException;

	public String buscaPorEnderecoUser(String usuario) throws SQLException;

	public String buscaPorEspecUser(String usuario) throws SQLException;

	public String buscaPorEscolaridadeUser(String usuario) throws SQLException;

	public String buscaPorXPUser(String usuario) throws SQLException;
	
	public int buscaPorID(String usuario) throws SQLException;
	
	public void listaUsers() throws SQLException, FileNotFoundException, DocumentException;
	
	public String viewContractName(String user)throws SQLException;
	
	public String viewContractEspec(String user)throws SQLException;
	
	public String viewContractXP(String user)throws SQLException;
	
	public String viewContractEscola(String user) throws SQLException;
	
	public String statusUser(String user) throws SQLException;
	
}
