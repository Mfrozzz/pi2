package dao;

import java.sql.SQLException;
import model.Empresa;
import model.Usuario;

public interface ContratacaoDAO {
	/**
	 * @param Usuario user
	 * @param Empresa emp
	 * @throws SQLException
	 * Realiza a solicita��o de contrata��o
	 * */
	public void insereContrato(Usuario user, Empresa emp) throws SQLException;

}
