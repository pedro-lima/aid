package aid.core.main.models;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//O Beneficiado pode ser uma pessoa ou uma entidade
@Entity
@NamedQueries({
		@NamedQuery(name = "beneficiado.listAll", query = "SELECT o FROM Beneficiado o"),
		@NamedQuery(name = "beneficiado.delete", query = "DELETE FROM Beneficiado o WHERE o.id LIKE :id"),
		@NamedQuery(name = "beneficiado.count", query = "SELECT COUNT(o) FROM Beneficiado o") })
public class Beneficiado implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Embedded
	private Contato contato = new Contato();
	@Embedded
	private Endereco endereco = new Endereco();	

	public Beneficiado() {
		super();
	}

	public Beneficiado(Long id, String nome, Contato contato,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	

}
