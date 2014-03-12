package br.com.aid.core.models;

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
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Descarte extends AbstracModel implements Serializable {

	private static final long serialVersionUID = -4072714103101874964L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@NotBlank
	private String justificativa;
	
	@OneToOne(mappedBy = "descarte")
	private Peca peca;
	
	@ManyToOne
	private Aluno aluno;

	public Descarte() {
		super();
	}

	public Descarte(Date data, Peca peca, String justificativa, Aluno aluno) {
		super();
		this.data = data;
		this.peca = peca;
		this.justificativa = justificativa;
		this.aluno = aluno;
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

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
