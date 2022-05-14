package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Empresa;
import model.Usuario;

public class ContratacaoDBDAO implements ContratacaoDAO{

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
	 * @param Usuario user
	 * @param Empresa emp
	 * @throws SQLException
	 * Realiza a solicitação de contratação
	 * */
	@Override
	public void insereContrato(Usuario user, Empresa emp) throws SQLException {
		open();
		sql = "INSERT INTO contratacao (userid,empresaid) VALUES (?,?);";
		statement = connection.prepareStatement(sql);
		statement.setInt(1,user.getUserId());
		statement.setInt(2,emp.getempresaId());
		statement.executeUpdate();
		
		close();
		
	}

}
