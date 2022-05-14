package dao;
/**
 * Interface IConst responsável pelas strings de conexão com o banco de dados
 * */
public interface IConst {
	public static final String stringDeConexao = "jdbc:postgresql://localhost:5432/DB_SisContract";
	public static final String usuario = "postgres";
	public static final String senha = "postgres";
}
