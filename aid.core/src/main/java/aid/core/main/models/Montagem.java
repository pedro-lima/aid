package aid.core.main.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Montagem implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;
	private boolean finalizado = false;
	@ManyToOne
	private Aluno aluno;
	@OneToOne
	private Homologacao homologacao;
	@OneToMany(mappedBy = "montagem")
	private List<Peca> pecas = new ArrayList<Peca>();

	public Montagem() {
		super();
	}

	public Montagem(Date dataInicio, Aluno aluno) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = null;
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public Homologacao getHomologacao() {
		return homologacao;
	}

	public void setHomologacao(Homologacao homologacao) {
		this.homologacao = homologacao;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public void finalizarMontagem() {
		this.finalizado = true;
		this.dataFim = new Date();
	}

	public void iniciarMontagem() {
		this.finalizado = false;
		this.dataFim = null;
	}

}
