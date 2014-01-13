package aid.core.main.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import aid.core.main.interfaces.Docente;

@Entity
public class Professor extends PessoaAcademica implements Docente {
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "profesor")
	private List<Doacao> doacoes = new ArrayList<Doacao>();
	
	public Professor() {
		super();
	}
	
	public Professor(String matricula, Usuario usuario,
			PessoaFisica pessoaFisica) {
		super(matricula, usuario, pessoaFisica);
	}

	public List<Doacao> getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(List<Doacao> doacoes) {
		this.doacoes = doacoes;
	}	
	
}
