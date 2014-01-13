package aid.core.main.models;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;
	private String telefone;	
	private String email;
	
	public Contato() {
		super();
	}

	public Contato(String telefone, String email) {
		super();
		this.telefone = telefone;
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
