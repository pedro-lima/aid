package br.com.aid.core.business;

import java.util.List;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.enumerations.Ordenacao;
import br.com.aid.core.enumerations.TipoSoftware;
import br.com.aid.core.interfaces.business.LocalSoftwareBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalSoftwareDao;
import br.com.aid.core.interfaces.search.LazySoftwareSearchBusiness;
import br.com.aid.core.models.Software;
import br.com.aid.core.tos.SoftwareTO;

@Business
public class SoftwareBusiness extends AbstracBusiness<Software> implements
		LocalSoftwareBusiness, LazySoftwareSearchBusiness {
	
	private static final long serialVersionUID = 1674493130437643508L;
	
	@Inject
	private LocalSoftwareDao dao;

	public SoftwareBusiness() {
		super();
	}

	@Override
	protected Dao<Software> getDao() {
		return this.dao;
	}

	public List<SoftwareTO> pesquisar(String marca, String modelo,
			String observacao, TipoSoftware tipo, Ordenacao ordenacao,
			String campoOrdenacao, int first, int maxResults) {
		return this.dao.pesquisar(marca, modelo, observacao, tipo, ordenacao,
				campoOrdenacao, first, maxResults);
	}

	public long total(String marca, String modelo, String observacao,
			TipoSoftware tipo) {
		return this.dao.total(marca, modelo, observacao, tipo);
	}

}
