package br.com.aid.core.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

//O Beneficiado pode ser uma pessoa ou uma entidade
@Entity
public class Beneficiado extends AbstracModel implements Serializable {

	private static final long serialVersionUID = 1019031481225412533L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 10, max = 200, message = "O nome do beneficiado deve conter entre {min} e {max} caracteres.")
	@Column(length = 200, nullable = false)
	private String nome;

	@Embedded
	private Contato contato;

	@OneToOne
	private Endereco endereco;

	@OneToOne
	private Doacao doacao;	

	public Beneficiado() {
		super();
	}

	public Beneficiado(String nome, Contato contato, Endereco endereco) {
		super();
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
