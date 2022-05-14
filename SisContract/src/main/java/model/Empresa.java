package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Empresa {
	
	private IntegerProperty empresaid = new SimpleIntegerProperty();
	private StringProperty login = new SimpleStringProperty();
	private StringProperty senha = new SimpleStringProperty();
	private StringProperty cargosOf = new SimpleStringProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty cnpj = new SimpleStringProperty();
	private StringProperty endereco = new SimpleStringProperty();
	
	/**
	 * Getter, setter e Construtor empresaId
	 * @return empresaid
	 */
	public int getempresaId() {
		return empresaid.get();
	}
	public void setempresaid(int empresaid) {
		this.empresaid.set(empresaid);
	}
	public IntegerProperty empresaidProperty() {
		return empresaid;
	}
	
	/**
	 * Getter, setter e Construtor login
	 * @return login
	 */
	public String getLogin() {
		return login.get();
	}
	public void setLogin(String login) {
		this.login.set(login);
	}
	public StringProperty loginProperty() {
		return login;
	}
	
	/**
	 * Getter, setter e Construtor senha
	 * @return senha
	 */
	public String getsenha() {
		return senha.get();
	}
	public void setsenha(String senha) {
		this.senha.set(senha);
	}
	public StringProperty senhaProperty() {
		return senha;
	}
	
	/**
	 * Getter, Setter e construtor cpf
	 * @return cpf
	 */
	public String getCnpj() {
		return cnpj.get();
	}
	public void setCnpj(String cnpj) {
		this.cnpj.set(cnpj);
	}
	public StringProperty cnpjProperty() {
		return cnpj;
	}
	
	/**
	 * Getter, setter e Construtor nomefantasia
	 * @return nome
	 */
	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	public StringProperty nomeProperty() {
		return nome;
	}
	
	/**
	 * Getter, Setter e construtor endereço
	 * @return endereco
	 */
	public String getendereco() {
		return endereco.get();
	}
	public void setendereco(String endereco) {
		this.endereco.set(endereco);
	}
	public StringProperty enderecoProperty() {
		return endereco;
	}
	
	/**
	 * Getter, setter e Construtor cargosOfertados
	 * @return senha
	 */
	public String getcargosof() {
		return cargosOf.get();
	}
	public void setcargosOfe(String cargosOfe) {
		this.cargosOf.set(cargosOfe);
	}
	public StringProperty cargosOfeProperty() {
		return cargosOf;
	}

}
