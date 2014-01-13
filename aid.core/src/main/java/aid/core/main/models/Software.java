package aid.core.main.models;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import aid.core.main.enumerations.TipoSoftware;

@Entity
@NamedQueries({

		@NamedQuery(name = "software.listAll.new", query = "SELECT NEW aid.core.main.models.Software(s.id, s.marca, s.modelo, s.observacao, s.tipo, COUNT(h.id)) "
				+ "FROM Software s LEFT JOIN s.homologacoes h "
				+ "GROUP BY s.id, s.marca, s.modelo, s.observacao, s.tipo"),
		@NamedQuery(name = "software.delete", query = "DELETE FROM Software o WHERE o.id LIKE :id"),
		@NamedQuery(name = "software.count", query = "SELECT COUNT(o) FROM Software o") })
public class Software implements Serializable {
	private static final long serialVersionUID = 1L;
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
	@NotNull
	@Column(nullable = false)
	private TipoSoftware tipo = TipoSoftware.AntiVirus;
	@ManyToMany
	private List<Homologacao> homologacoes = new ArrayList<Homologacao>();
	@Transient
	private Long totalHomologacoes;

	public Software() {
		super();
	}

	public Software(Long id, String marca, String modelo, String observacao,
			TipoSoftware tipo, Long totalHomologacoes) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.observacao = observacao;
		this.tipo = tipo;
		this.totalHomologacoes = totalHomologacoes;
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

	public Long getTotalHomologacoes() {
		return totalHomologacoes;
	}

	public void setTotalHomologacoes(Long totalHomologacoes) {
		this.totalHomologacoes = totalHomologacoes;
	}

	public boolean semHomologacoes() {
		return this.totalHomologacoes.intValue() == 0;
	}

	@Override
	public String toString() {
		return "Software [id=" + id + ", marca=" + marca + ", modelo=" + modelo
				+ ", observacao=" + observacao + ", tipo=" + tipo
				+ ", totalHomologacoes=" + totalHomologacoes + "]";
	}

}
