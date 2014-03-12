package br.com.aid.core.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Doador extends AbstracModel implements Serializable {

	private static final long serialVersionUID = -5538169288159219886L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome do doador deve ser informado.")
	private String nome;

	@Embedded
	private Contato contato;

	@OneToOne
	@Cascade(CascadeType.ALL)
	private Endereco endereco;

	@OneToMany(mappedBy = "doador")
	private List<Peca> pecas = new ArrayList<Peca>();

	public Doador() {
		super();
	}

	public Doador(String nome, Contato contato, Endereco endereco) {
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

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	@Override
	public String toString() {
		return "Doador [id=" + id + ", nome=" + nome + ", contato=" + contato
				+ ", endereco=" + endereco + "]";
	}

}
