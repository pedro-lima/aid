package br.com.aid.core.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.aid.core.enumerations.FaseHomologacao;

@Entity
public class ItemHomologacao extends AbstracModel implements Serializable {

	private static final long serialVersionUID = 2056950008150070697L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private FaseHomologacao tipo;

	private String observacao;

	@ManyToOne
	private Homologacao homologacao;

	public ItemHomologacao() {
		super();
	}

	public ItemHomologacao(FaseHomologacao tipo, String observacao,
			Homologacao homologacao) {
		super();
		this.tipo = tipo;
		this.observacao = observacao;
		this.homologacao = homologacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FaseHomologacao getTipo() {
		return tipo;
	}

	public void setTipo(FaseHomologacao tipo) {
		this.tipo = tipo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Homologacao getHomologacao() {
		return homologacao;
	}

	public void setHomologacao(Homologacao homologacao) {
		this.homologacao = homologacao;
	}

}
