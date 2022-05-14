package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {
	
	private IntegerProperty userid = new SimpleIntegerProperty();
	private StringProperty login = new SimpleStringProperty();
	private StringProperty senha = new SimpleStringProperty();
	private StringProperty areaAtu = new SimpleStringProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty endereco = new SimpleStringProperty();
	private StringProperty escolaridade = new SimpleStringProperty();
	private StringProperty xp = new SimpleStringProperty();
	private StringProperty especializacoes = new SimpleStringProperty();
	private StringProperty status = new SimpleStringProperty();
	
	/**
	 * Getter, setter e Construtor UserId
	 * @return userid
	 */
	public int getUserId() {
		return userid.get();
	}
	public void setUserid(int userid) {
		this.userid.set(userid);
	}
	public IntegerProperty useridProperty() {
		return userid;
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
	 * Getter, setter e Construtor AreaAtuacao
	 * @return areaAtu
	 */
	public String getareaAtu() {
		return areaAtu.get();
	}
	public void setareaAtu(String areaAtu) {
		this.areaAtu.set(areaAtu);
	}
	public StringProperty areaAtuProperty() {
		return areaAtu;
	}
	
	/**
	 * Getter, setter e Construtor nome
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
	 * Getter, Setter e construtor cpf
	 * @return cpf
	 */
	public String getCpf() {
		return cpf.get();
	}
	public void setCpf(String cpf) {
		this.cpf.set(cpf);
	}
	public StringProperty cpfProperty() {
		return cpf;
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
	 * Getter, Setter e construtor especializacoes
	 * @return especializacoes
	 */
	public String getEspecializacoes() {
		return especializacoes.get();
	}
	public void setEspecializacoes(String especializacoes) {
		this.especializacoes.set(especializacoes);
	}
	public StringProperty especializacoesProperty() {
		return especializacoes;
	}
	/**
	 * Getter, setter e construtor escolaridade
	 * @return escolaridade
	 */
	public String getEscolaridade() {
		return escolaridade.get();
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade.set(escolaridade);
	}
	public StringProperty escolaridadeProperty() {
		return escolaridade;
	}
	
	/**
	 * Getter, setter e construtor experiencia
	 * @return xp
	 */
	public String getXp() {
		return xp.get();
	}
	public void setXp(String xp) {
		this.xp.set(xp);
	}
	public StringProperty XpProperty() {
		return xp;
	}
	
	/**
	 * Getter, setter e construtor status
	 * @return status
	 */
	public String getStatus() {
		return status.get();
	}
	public void setStatus(String status) {
		this.status.set(status);
	}
	public StringProperty statusProperty() {
		return status;
	}
	
	public void clear() {
		setNome(null);
		setLogin(null);
		setareaAtu(null);
		setendereco(null);
		setCpf(null);
		setXp(null);
		setStatus(null);
		setEspecializacoes(null);
		setEscolaridade(null);
	}

}
