package aid.core.main.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Doador implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@Embedded
	private Contato contato = new Contato();
	@Embedded
	private Endereco endereco = new Endereco();
	@OneToMany(mappedBy = "doador")
	private List<Peca> pecas = new ArrayList<Peca>();

	public Doador() {
		super();
	}

	public Doador(Long id, String nome, Contato contato, Endereco endereco) {
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

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

}
