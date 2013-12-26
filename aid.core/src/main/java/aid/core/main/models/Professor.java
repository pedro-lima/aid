package aid.core.main.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Professor extends PessoaFisica {
	private static final long serialVersionUID = 1L;
	private String matricula;
	private Usuario usuario;
	@OneToMany(mappedBy = "professor")
	private List<Turma> turmas = new ArrayList<Turma>();
	@OneToMany(mappedBy = "profesor")
	private List<Doacao> doacoes = new ArrayList<Doacao>();

	public Professor() {
		super();
	}

	public Professor(String matricula, Usuario usuario) {
		super();
		this.matricula = matricula;
		this.usuario = usuario;
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

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Doacao> getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(List<Doacao> doacoes) {
		this.doacoes = doacoes;
	}

}
