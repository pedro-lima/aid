package aid.core.main.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import aid.core.main.enumerations.Curso;
import aid.core.main.interfaces.Discente;

@Entity
public class Aluno extends PessoaAcademica implements Discente {
	private static final long serialVersionUID = 1L;
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
		super(matricula, usuario, pessoaFisica);
		this.curso = curso;
		this.periodo = periodo;
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
