package aid.core.main.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Beneficiado extends PessoaFisica {
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Doacao doacao;

	public Beneficiado() {
		super();
	}

	public Beneficiado(String nome, String cpf, String rg, Contato contato,
			Endereco endereco, Doacao doacao) {
		super(nome, cpf, rg, contato, endereco);
		this.doacao = doacao;
	}

	public Doacao getDoacao() {
		return doacao;
	}

	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}

}
