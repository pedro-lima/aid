package br.com.aid.core.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Homologacao extends AbstracModel implements Serializable {

	private static final long serialVersionUID = -7217852355207159756L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;

	private String observacao;

	private boolean finalizado = false;

	@ManyToOne
	private Aluno aluno;

	@OneToOne(mappedBy = "homologacao")
	private Montagem montagem;

	@ManyToMany(mappedBy = "homologacoes")
	private List<Software> softwares = new ArrayList<Software>();

	@OneToMany(mappedBy = "homologacao")
	private List<ItemHomologacao> itens = new ArrayList<ItemHomologacao>();

	@OneToOne
	private Doacao doacao;

	public Homologacao() {
		super();
	}

	public Homologacao(Date dataInicio, Date dataFim, String observacao,
			Aluno aluno, Montagem montagem) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.observacao = observacao;
		this.aluno = aluno;
		this.montagem = montagem;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Montagem getMontagem() {
		return montagem;
	}

	public void setMontagem(Montagem montagem) {
		this.montagem = montagem;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public List<Software> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(List<Software> softwares) {
		this.softwares = softwares;
	}

	public List<ItemHomologacao> getItens() {
		return itens;
	}

	public void setItens(List<ItemHomologacao> itens) {
		this.itens = itens;
	}

	public Doacao getDoacao() {
		return doacao;
	}

	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}

}
