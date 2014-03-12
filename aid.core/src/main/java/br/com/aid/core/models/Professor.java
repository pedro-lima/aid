package br.com.aid.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.aid.core.interfaces.Docente;

@Entity
public class Professor extends AbstracModel implements Docente {
	
	private static final long serialVersionUID = -1599952249373072036L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String matricula;
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario = new Usuario();
	
	@OneToOne(cascade = CascadeType.ALL)
	private PessoaFisica pessoaFisica = new PessoaFisica();
	
	@OneToMany(mappedBy = "profesor")
	private List<Doacao> doacoes = new ArrayList<Doacao>();

	public Professor() {
		super();
	}

	public Professor(String matricula, Usuario usuario,
			PessoaFisica pessoaFisica) {
		super();
		this.matricula = matricula;
		this.usuario = usuario;
		this.pessoaFisica = pessoaFisica;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Doacao> getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(List<Doacao> doacoes) {
		this.doacoes = doacoes;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}	
	
}
