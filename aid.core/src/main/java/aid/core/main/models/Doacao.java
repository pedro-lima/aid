package aid.core.main.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Doacao extends AbstracModel implements Serializable {
	
	private static final long serialVersionUID = -6156144552506810611L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@OneToOne(mappedBy = "doacao")
	private Homologacao homologacao;
	
	@ManyToOne
	private Professor profesor;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Beneficiado beneficiado;

	public Doacao() {
		super();
	}

	public Doacao(Date data, Homologacao homologacao, Professor profesor,
			Beneficiado beneficiado) {
		super();
		this.data = data;
		this.homologacao = homologacao;
		this.profesor = profesor;
		this.beneficiado = beneficiado;
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

	public Homologacao getHomologacao() {
		return homologacao;
	}

	public void setHomologacao(Homologacao homologacao) {
		this.homologacao = homologacao;
	}

	public Professor getProfesor() {
		return profesor;
	}

	public void setProfesor(Professor profesor) {
		this.profesor = profesor;
	}

	public Beneficiado getBeneficiado() {
		return beneficiado;
	}

	public void setBeneficiado(Beneficiado beneficiado) {
		this.beneficiado = beneficiado;
	}

}
