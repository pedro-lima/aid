package aid.core.main.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import aid.core.main.enumerations.Curso;
import aid.core.main.interfaces.Discente;

@Entity
public class Aluno extends AbstracModel implements Discente {
	
	private static final long serialVersionUID = -1785316450090950089L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String matricula;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario = new Usuario();
	
	@OneToOne(cascade = CascadeType.ALL)
	private PessoaFisica pessoaFisica = new PessoaFisica();
	
	@Enumerated(EnumType.STRING)
	private Curso curso = Curso.CC;
	
	private int periodo;
	
	@OneToMany(mappedBy = "aluno")
	private List<Montagem> montagens;
	
	@OneToMany(mappedBy = "aluno")
	private List<Homologacao> homologacoes;
	
	@OneToMany(mappedBy = "aluno")
	private List<Descarte> descartes;
	
	@OneToMany(mappedBy = "aluno")
	private List<Ponto> pontos;

	public Aluno() {
		super();
	}

	public Aluno(String matricula, Usuario usuario, PessoaFisica pessoaFisica,
			Curso curso, int periodo) {
		super();
		this.matricula = matricula;
		this.usuario = usuario;
		this.pessoaFisica = pessoaFisica;
		this.curso = curso;
		this.periodo = periodo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public List<Montagem> getMontagens() {
		return montagens;
	}

	public void setMontagens(List<Montagem> montagens) {
		this.montagens = montagens;
	}

	public List<Homologacao> getHomologacoes() {
		return homologacoes;
	}

	public void setHomologacoes(List<Homologacao> homologacoes) {
		this.homologacoes = homologacoes;
	}

	public List<Descarte> getDescartes() {
		return descartes;
	}

	public void setDescartes(List<Descarte> descartes) {
		this.descartes = descartes;
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

}
