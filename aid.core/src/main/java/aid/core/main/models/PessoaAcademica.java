package aid.core.main.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public abstract class PessoaAcademica implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricula;	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario = new Usuario();
	@OneToOne(cascade = CascadeType.ALL)
	private PessoaFisica pessoaFisica = new PessoaFisica();

	public PessoaAcademica() {
		super();
	}

	public PessoaAcademica(String matricula, Usuario usuario,
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
