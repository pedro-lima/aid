package br.com.aid.core.models;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Endereco extends AbstracModel implements Serializable {

	private static final long serialVersionUID = -6000791855593624715L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, max = 200, message = "A rua deve conter entre {min} e {max} caracteres.")
	@Column(length = 200, nullable = false)
	private String rua;

	@Size(min = 1, max = 10, message = "O numero deve conter entre {min} e {max} caracteres.")
	@Column(length = 10, nullable = false)
	private String numero;

	@Size(min = 3, max = 200, message = "O bairro deve conter entre {min} e {max} caracteres.")
	@Column(length = 200, nullable = false)
	private String bairro;

	@NotBlank(message = "O CEP deve ser informado")
	@Column(length = 10, nullable = false)
	private String cep;

	@Nonnull
	@ManyToOne
	private Cidade cidade;

	public Endereco() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero
				+ ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
				+ "]";
	}

}
