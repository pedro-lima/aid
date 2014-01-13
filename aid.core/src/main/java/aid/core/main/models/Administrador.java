package aid.core.main.models;

import javax.persistence.Entity;

import aid.core.main.interfaces.Gerenciador;

@Entity
public class Administrador extends PessoaAcademica implements Gerenciador{
	private static final long serialVersionUID = 1L;
	
	public Administrador() {
		super();
	}

	public Administrador(String matricula, Usuario usuario,
			PessoaFisica pessoaFisica) {
		super(matricula, usuario, pessoaFisica);
	}	

}
