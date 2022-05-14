package dao;

import java.sql.SQLException;
import model.Empresa;
import model.Usuario;

public interface ContratacaoDAO {
	/**
	 * @param Usuario user
	 * @param Empresa emp
	 * @throws SQLException
	 * Realiza a solicitação de contratação
	 * */
	public void insereContrato(Usuario user, Empresa emp) throws SQLException;

}
