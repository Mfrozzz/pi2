package dao;
/**
 * Interface IConst respons�vel pelas strings de conex�o com o banco de dados
 * */
public interface IConst {
	public static final String stringDeConexao = "jdbc:postgresql://localhost:5432/DB_SisContract";
	public static final String usuario = "postgres";
	public static final String senha = "postgres";
}
