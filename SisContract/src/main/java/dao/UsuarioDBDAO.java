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
import model.Usuario;

public class UsuarioDBDAO implements UsuarioDAO{
	
	private String sql;
	private Connection connection;
	private PreparedStatement statement;
	/**
	 * abre a conex�o com o banco de dados
	 * @throws SQLException
	 * */
	private void open() throws SQLException {
		connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
	}
	/**
	 * fecha a conex�o com o Banco de dados
	 * @throws SQLException
	 * */
	private void close() throws SQLException {
		connection.close();
	}
	/**
	 * @param Usuario usuario
	 * @throws SQLException
	 * cadastro do usu�rio no banco de dados do sistema
	 * */
	@Override
	public void insereUser(Usuario usuario) throws SQLException {
		open();
		sql = "INSERT INTO usuario (userid,login,senha,nome,area,endereco,cpf,status) VALUES (?,?,?,?,?,?,?,?);";
		statement = connection.prepareStatement(sql);
		statement.setInt(1,usuario.getUserId() );
		statement.setString(2,usuario.getLogin());
		statement.setString(3,usuario.getsenha());
		statement.setString(4,usuario.getNome());
		statement.setString(5,usuario.getareaAtu());
		statement.setString(6,usuario.getendereco());
		statement.setString(7,usuario.getCpf());
		statement.setString(8, "desempregado");
		statement.executeUpdate();
		close();
	}
	/**
	 * @param Usuario usuario
	 * @throws SQLException 
	 * @throws IOException
	 * removerusu�rio do banco de dados(implementado mas n�o utilizado)
	 * */
	@Override
	public void removeUser(Usuario usuario) throws SQLException, IOException {
		open();
		sql="Delete from Usuario where login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, usuario.getLogin());
		statement.executeUpdate();
		close();
	}
	/**
	 * @return resultado
	 * @param String usuario
	 * @throws SQLException
	 * busca o login de usu�rio usando o texto da label de nome
	 * */
	@Override
	public String buscaPorLoginUser(String usuario) throws SQLException {
		open();
		sql= "SELECT login FROM usuario WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1,usuario );
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "login" );
			close();
			return resultado;
		}
	}
	/**
	 * @return resultado
	 * @param String usuario
	 * @throws SQLException
	 * busca o nome de usu�rio usando o texto da label de nome
	 * */
	@Override
	public String buscaPorNomeUser(String usuario) throws SQLException {
		open();
		sql= "SELECT nome FROM usuario WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1,usuario);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "nome" );
			close();
			return resultado;
		}
	}
	/**
	 * @return resultado
	 * @param String usuario
	 * @throws SQLException
	 * busca o cpf de usu�rio usando o texto da label de nome
	 * */
	@Override
	public String buscaPorCPFUser(String usuario) throws SQLException {
		open();
		sql= "SELECT cpf FROM usuario WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1,usuario );
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "cpf" );
			close();
			return resultado;
		}
	}
	/**
	 * @return resultado
	 * @param String usuario
	 * @throws SQLException
	 * busca a area de atua��o do usu�rio usando o texto da label de nome
	 * */
	@Override
	public String buscaPorAreaAtuUser(String usuario) throws SQLException {
		open();
		sql= "SELECT area FROM usuario WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1,usuario);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "area" );
			close();
			return resultado;
		}
	}
	/**
	 * @return resultado
	 * @param String usuario
	 * @throws SQLException
	 * busca o endere�o do usu�rio usando o texto da label de nome
	 * */
	@Override
	public String buscaPorEnderecoUser(String usuario) throws SQLException {
		open();
		sql= "SELECT endereco FROM usuario WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1,usuario );
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "endereco" );
			close();
			return resultado;
		}
	}
	/**
	 * @return resultado
	 * @param String usuario
	 * @throws SQLException
	 * busca as especializa��es e habilidades do usu�rio usando o texto da label de nome
	 * */
	@Override
	public String buscaPorEspecUser(String usuario) throws SQLException {
		open();
		sql= "SELECT especializacoes FROM usuario WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1,usuario );
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "especializacoes" );
			close();
			return resultado;
		}
	}
	/**
	 * @return resultado
	 * @param String usuario
	 * @throws SQLException
	 * busca escolaridade de usu�rio usando o texto da label de nome
	 * */
	@Override
	public String buscaPorEscolaridadeUser(String usuario) throws SQLException {
		open();
		sql= "SELECT escolaridade FROM usuario WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1,usuario );
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "escolaridade" );
			close();
			return resultado;
		}
	}
	/**
	 * @return resultado
	 * @param String usuario
	 * @throws SQLException
	 * busca experi�ncia de usu�rio usando o texto da label de nome
	 * */
	@Override
	public String buscaPorXPUser(String usuario) throws SQLException {
		open();
		sql= "SELECT experiencia FROM usuario WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1,usuario);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "experiencia" );
			close();
			return resultado;
		}
	}
	/**
	 * @return o pr�ximo id para cadastrar o usuario
	 * @throws SQLException
	 * */
	public int generateId() throws SQLException {
		// Abre a conex�o
		open();
			String sql = "SELECT MAX(userid) AS Max_val FROM Usuario";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1)+1;
				}else 
				return 1;
	}
	/**
	 * @return String back ou user
	 * @param String login
	 * @param String senha
	 * @throws SQLException
	 * realiza o login do usu�rio
	 * */
	@Override
	public String Loginexecute(String login, String senha) throws SQLException {
		open();
		sql = "SELECT u.login,u.senha FROM usuario u WHERE u.login = ? and u.senha = ?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, login);
		statement.setString(2, senha);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return "Back";
		}else {
			close();
			return "User";
		}
	}
	/**
	 * @param String usuario
	 * @param String txtfield
	 * @throws SQLException
	 * atualiza a area de atua��o
	 * */
	@Override
	public void atualizaUserArea(String usuario,String txtfield) throws SQLException {
		open();
		sql="UPDATE usuario SET area=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,usuario);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String usuario
	 * @param String txtfield
	 * @throws SQLException
	 * atualiza o cpf
	 * */
	@Override
	public void atualizaUserCpf(String usuario,String txtfield) throws SQLException {
		open();
		sql="UPDATE usuario SET cpf=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,usuario);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String usuario
	 * @param String txtfield
	 * @throws SQLException
	 * atualiza o endere�o
	 * */
	@Override
	public void atualizaUserEndereco(String usuario,String txtfield) throws SQLException {
		open();
		sql="UPDATE usuario SET endereco=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,usuario);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String usuario
	 * @param String txtfield
	 * @throws SQLException
	 * atualiza a escolaridade
	 * */
	@Override
	public void atualizaUserEscolaridade(String usuario,String txtfield) throws SQLException {
		open();
		sql="UPDATE usuario SET escolaridade=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,usuario);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String usuario
	 * @param String txtfield
	 * @throws SQLException
	 * atualiza as especializa��es
	 * */
	@Override
	public void atualizaUserEspecializacao(String usuario,String txtfield) throws SQLException {
		open();
		sql="UPDATE usuario SET especializacoes=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,usuario);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String usuario
	 * @param String txtfield
	 * @throws SQLException
	 * atualiza o nome do usuario
	 * */
	@Override
	public void atualizaUserNome(String usuario,String txtfield) throws SQLException {
		open();
		sql="UPDATE usuario SET nome=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,usuario);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String usuario
	 * @param String txtfield
	 * @throws SQLException
	 * atualiza a experi�ncia
	 * */
	@Override
	public void atualizaUserXP(String usuario,String txtfield) throws SQLException {
		open();
		sql="UPDATE usuario SET experiencia=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,usuario);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String usuario
	 * @param String txtfield
	 * @throws SQLException
	 * atualiza o login nas configura��es
	 * */
	@Override
	public void atualizaConfigLogin(String usuario, String txtfield) throws SQLException {
		open();
		sql="UPDATE usuario SET login=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,usuario);
		statement.executeUpdate();
		close();
	}
	/**
	 * @param String usuario
	 * @param String txtfield
	 * @throws SQLException
	 * atualiza a senha nas configura��es
	 * */
	@Override
	public void atualizaConfigSenha(String usuario, String txtfield) throws SQLException {
		open();
		sql="UPDATE usuario SET senha=? WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, txtfield);
		statement.setString(2,usuario);
		statement.executeUpdate();
		close();
	}
	/**
	 * @return resultado
	 * @param String usuario
	 * @throws SQLException
	 * retorna o nome do usuario pela consulta no banco de dados
	 * */
	@Override
	public String buscaNaEmpresa(String usuario) throws SQLException {
		open();
		sql= "SELECT nome FROM usuario WHERE nome=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1,usuario);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "nome" );
			close();
			return resultado;
		}
	}
	/**
	 * @return id
	 * @param String usuario
	 * @throws SQLException
	 * retorna o id do usuario pela consulta no banco de dados
	 * */
	@Override
	public int buscaPorID(String usuario) throws SQLException {
		open();
		sql= "SELECT userid FROM usuario WHERE login=?;";
		statement = connection.prepareStatement(sql);
		statement.setString(1, usuario);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return -1;
		}else {
			int id = rs.getInt("userid");
			close();
			return id;
		}
	}
	/**
	 * @throws SQLException, FileNotFoundException, DocumentException
	 * cria lista de usu�rios com alguma rela��o com empresas
	 * */
	@Override
	public void listaUsers() throws SQLException, FileNotFoundException, DocumentException {
		open();
		sql="SELECT u.nome,u.escolaridade,u.experiencia,u.especializacoes, e.empresaid FROM usuario u Join Contratacao c On u.userid=c.userid JOIN empresa e ON e.empresaid=c.empresaid";
		statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		Font f= new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD,BaseColor.BLACK);
		Paragraph vazio = new Paragraph(" ");
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\marco\\OneDrive\\Imagens\\SisContractDocs\\listaUsuarios.pdf"));
		doc.open();
		doc.addTitle("Curriculos Enviados");
		doc.addAuthor("SisContract Corporation");
		doc.addLanguage("pt-br");
		while(rs.next()) {
			Paragraph p= new Paragraph(rs.getString("nome")+","+rs.getString("escolaridade")+","+rs.getString("experiencia")+","+rs.getString("especializacoes")+","+rs.getInt("empresaid"),f);
			doc.add(p);
			doc.add(vazio);
		}
		doc.close();
		close();
	}
	/**
	 * @param String User
	 * @throws SQLException
	 * @return resultado
	 * retorna o nome do usu�rio para a empresa visualizar melhor
	 * */
	@Override
	public String viewContractName(String user) throws SQLException {
		open();
		sql="SELECT nome FROM usuario WHERE nome=?;";
		statement =  connection.prepareStatement(sql);
		statement.setString(1, user);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "nome" );
			close();
			return resultado;
		}
	}
	/**
	 * @param String User
	 * @throws SQLException
	 * @return resultado
	 * retorna as especializa��es do usu�rio para a empresa visualizar melhor
	 * */
	@Override
	public String viewContractEspec(String user) throws SQLException {
		open();
		sql="SELECT especializacoes FROM usuario WHERE nome=?;";
		statement =  connection.prepareStatement(sql);
		statement.setString(1, user);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "especializacoes" );
			close();
			return resultado;
		}
	}
	/**
	 * @param String User
	 * @throws SQLException
	 * @return resultado
	 * retorna a experi�ncia do usu�rio para a empresa visualizar melhor
	 * */
	@Override
	public String viewContractXP(String user) throws SQLException {
		open();
		sql="SELECT experiencia FROM usuario WHERE nome=?;";
		statement =  connection.prepareStatement(sql);
		statement.setString(1, user);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "experiencia" );
			close();
			return resultado;
		}
	}
	/**
	 * @param String User
	 * @throws SQLException
	 * @return resultado
	 * retorna a escolaridade do usu�rio para a empresa visualizar melhor
	 * */
	@Override
	public String viewContractEscola(String user) throws SQLException {
		open();
		sql="SELECT escolaridade FROM usuario WHERE nome=?;";
		statement =  connection.prepareStatement(sql);
		statement.setString(1, user);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "escolaridade" );
			close();
			return resultado;
		}
	}
	/**
	 * @param Usuario user
	 * @throws SQLException
	 * contrata��o, realiza a troca do status de desempregado para empregado
	 * */
	@Override
	public void atualizaStatus(Usuario user) throws SQLException {
		open();
		sql="UPDATE usuario SET status=? WHERE nome=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, user.getStatus());
		statement.setString(2, user.getNome());
		statement.executeUpdate();
		close();
	}
	/**
	 * @return resultado
	 * @param String user
	 * @throws SQLException
	 * retorna o status do usu�rio
	 * */
	@Override
	public String statusUser(String user) throws SQLException {
		open();
		sql="SELECT status FROM usuario WHERE login=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, user);
		ResultSet rs = statement.executeQuery();
		if(!rs.next()) {
			close();
			return null;
		}else {
			String resultado = rs.getString( "status" );
			close();
			return resultado;			
		}
	}
}
