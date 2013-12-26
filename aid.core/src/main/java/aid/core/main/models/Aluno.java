package aid.core.main.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import aid.core.main.enumerations.Curso;

@Entity
public class Aluno extends PessoaFisica {
	private static final long serialVersionUID = 1L;
	private String matricula;
	@Enumerated(EnumType.STRING)
	private Curso curso;
	@Min(value=1,message="O valor não pode ser menor que 8.")
	@Max(value=8,message="O valor não pode ser menor que 1.")
	private int periodo;
	@ManyToOne
	private Turma turma;
	@OneToMany(mappedBy = "aluno")
	private List<Montagem> montagens = new ArrayList<Montagem>();
	@OneToMany(mappedBy = "aluno")
	private List<Homologacao> homologacoes = new ArrayList<Homologacao>();
	@OneToMany(mappedBy = "aluno")
	private List<Descarte> descartes = new ArrayList<Descarte>();
	@OneToMany(mappedBy = "aluno")
	private List<Ponto> pontos = new ArrayList<Ponto>();

	public Aluno() {
		super();
	}

	public Aluno(String nome, String cpf, String rg, Contato contato,
			Endereco endereco, String matricula, Curso curso, int periodo,
			Turma turma) {
		super(nome, cpf, rg, contato, endereco);
		this.matricula = matricula;
		this.curso = curso;
		this.periodo = periodo;
		this.turma = turma;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
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
