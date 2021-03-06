package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @return DriverManager.getConnection
 * gera a conex?o
 * 
 * */
public class Conexao implements IConst{
	public static Connection getConexao(String stringDeConexao, String usuario, String senha) {
		try {
			return DriverManager.getConnection(stringDeConexao, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
