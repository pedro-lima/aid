package br.com.aid.core.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class Contato implements Serializable {

	private static final long serialVersionUID = 8644148442579490163L;

	@NotBlank(message = "O telefone de contato deve ser informado.")	
	@Column(nullable = false)
	private String telefone;

	@Email(message = "Informe um e-mail v\u00E1lido.")
	@Size(min = 5, max = 50, message = "O e-mail de contato deve conter entre {min} e {max} caracteres.")
	@Column(length = 50, nullable = false)
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
