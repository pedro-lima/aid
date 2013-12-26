package aid.core.main.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Peca implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	private String marca;
	private String capacidade;
	private String observcao;
	private String qrCode;
	@ManyToOne
	private Doador doador;
	@ManyToOne
	private Montagem montagem;
	@OneToOne
	private Descarte descarte;

	public Peca() {
		super();
	}

	public Peca(Date data, String marca, String capacidade, String observcao,
			String qrCode, Doador doador) {
		super();
		this.data = data;
		this.marca = marca;
		this.capacidade = capacidade;
		this.observcao = observcao;
		this.qrCode = qrCode;
		this.doador = doador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getObservcao() {
		return observcao;
	}

	public void setObservcao(String observcao) {
		this.observcao = observcao;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public Montagem getMontagem() {
		return montagem;
	}

	public void setMontagem(Montagem montagem) {
		this.montagem = montagem;
	}

	public Descarte getDescarte() {
		return descarte;
	}

	public void setDescarte(Descarte descarte) {
		this.descarte = descarte;
	}

}
