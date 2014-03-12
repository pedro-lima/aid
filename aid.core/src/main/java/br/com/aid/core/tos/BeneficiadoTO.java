package br.com.aid.core.tos;

import java.io.Serializable;

import br.com.aid.core.models.Beneficiado;

import com.mysema.query.annotations.QueryProjection;

public class BeneficiadoTO  implements Serializable {
	
	private static final long serialVersionUID = -8227966335369293836L;
	
	private Beneficiado beneficiado;
	
	private boolean contemplado;

	@QueryProjection
	public BeneficiadoTO(Beneficiado beneficiado, boolean contemplado) {
		super();
		this.beneficiado = beneficiado;
		this.contemplado = contemplado;
	}

	public Beneficiado getBeneficiado() {
		return beneficiado;
	}

	public void setBeneficiado(Beneficiado beneficiado) {
		this.beneficiado = beneficiado;
	}

	public boolean isContemplado() {
		return contemplado;
	}

	public void setContemplado(boolean contemplado) {
		this.contemplado = contemplado;
	}
	
}
