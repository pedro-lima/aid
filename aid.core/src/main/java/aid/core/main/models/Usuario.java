package aid.core.main.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	@OneToOne(mappedBy = "usuario")
	private PessoaFisica pessoa;
	private boolean ativo;

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, PessoaFisica pessoa) {
		super();
		this.login = login;
		this.senha = senha;
		this.pessoa = pessoa;
		this.ativo = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PessoaFisica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
