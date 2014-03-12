package br.com.aid.core.tos;

import java.io.Serializable;

import br.com.aid.core.models.Software;

import com.mysema.query.annotations.QueryProjection;

public class SoftwareTO implements Serializable {

	private static final long serialVersionUID = 7629516384638355001L;

	private Software software;

	private Long totalHomologacoes;

	@QueryProjection
	public SoftwareTO(Software software, Long totalHomologacoes) {
		super();
		this.software = software;
		this.totalHomologacoes = totalHomologacoes;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public Long getTotalHomologacoes() {
		return totalHomologacoes;
	}

	public void setTotalHomologacoes(Long totalHomologacoes) {
		this.totalHomologacoes = totalHomologacoes;
	}

	public boolean isSemHologacoes() {
		int total = (totalHomologacoes == null) ? 0 : totalHomologacoes
				.intValue();
		return total == 0;
	}

}
