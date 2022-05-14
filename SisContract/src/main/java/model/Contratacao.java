package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Contratacao {

	private IntegerProperty empresaid = new SimpleIntegerProperty();
	private IntegerProperty userid = new SimpleIntegerProperty();
	
	/**
	 * Getter, setter e Construtor empresaId
	 * @return userid
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
	
	
}
