package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalPontoBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalPontoDao;
import br.com.aid.core.models.Ponto;

@Business
public class PontoBusiness extends AbstracBusiness<Ponto> implements
		LocalPontoBusiness {
	
	private static final long serialVersionUID = -9212487499197679348L;
	
	@Inject
	private LocalPontoDao dao;

	public PontoBusiness() {
		super();
	}

	@Override
	protected Dao<Ponto> getDao() {
		return this.dao;
	}

}
