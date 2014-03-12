package br.com.aid.core.tos;

import br.com.aid.core.models.Doador;

import com.mysema.query.annotations.QueryProjection;

public class DoadorTO {
	
	private Doador doador;
	
	private Long totalDoacoes;

	@QueryProjection
	public DoadorTO(Doador doador, Long totalDoacoes) {
		super();
		this.doador = doador;
		this.totalDoacoes = totalDoacoes;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public Long getTotalDoacoes() {
		return totalDoacoes;
	}

	public void setTotalDoacoes(Long totalDoacoes) {
		this.totalDoacoes = totalDoacoes;
	}	

}
