package br.com.aid.core.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import br.com.aid.core.enumerations.TipoSoftware;

@Entity
public class Software extends AbstracModel implements Serializable {

	private static final long serialVersionUID = 2972798962488059673L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, max = 150, message = "A marca do software deve conter entre {min} e {max} caracteres.")
	@Column(length = 150, nullable = false)
	private String marca;

	@Size(min = 2, max = 150, message = "A modelo do software deve conter entre {min} e {max} caracteres.")
	@Column(length = 150, nullable = false)
	private String modelo;

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String observacao;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "O tipo do software deve ser informado.")
	@Column(nullable = false)
	private TipoSoftware tipo;

	@ManyToMany
	private List<Homologacao> homologacoes = new ArrayList<Homologacao>();

	public Software() {
		super();
	}

	public Software(String marca, String modelo, String observacao,
			TipoSoftware tipo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.observacao = observacao;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoSoftware getTipo() {
		return tipo;
	}

	public void setTipo(TipoSoftware tipo) {
		this.tipo = tipo;
	}

	public List<Homologacao> getHomologacoes() {
		return homologacoes;
	}

	public void setHomologacoes(List<Homologacao> homologacoes) {
		this.homologacoes = homologacoes;
	}

	@Override
	public String toString() {
		return "Software [id=" + id + ", marca=" + marca + ", modelo=" + modelo
				+ ", observacao=" + observacao + ", tipo=" + tipo + "]";
	}	

}
