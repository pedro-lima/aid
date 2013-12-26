package aid.core.main.models;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import aid.core.main.enumerations.Estado;

@Embeddable
public class Endereco {		
	private String rua;
	private int numero;
	private String bairro;
	private String cep;
	private String cidade;
	@Enumerated(EnumType.STRING)
	private Estado estado;

	public Endereco() {
		super();
	}

	public Endereco(String rua, int numero, String bairro, String cep,
			String cidade, Estado estado) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
