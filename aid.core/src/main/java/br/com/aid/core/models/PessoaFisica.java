package br.com.aid.core.models;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PessoaFisica extends AbstracModel implements Serializable {
	
	private static final long serialVersionUID = 1806080436517838868L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	@Embedded
	private Contato contato;
	
	@OneToOne
	private Endereco endereco;

	public PessoaFisica() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PessoaFisica(String nome, String cpf, String rg, Contato contato,
			Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.contato = contato;
		this.endereco = endereco;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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
