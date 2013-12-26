package aid.core.main.models;

import javax.persistence.Entity;

@Entity
public class Administrador extends PessoaFisica {
	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
	}

	public Administrador(String nome, String cpf, String rg, Contato contato,
			Endereco endereco) {
		super(nome, cpf, rg, contato, endereco);
	}

}
