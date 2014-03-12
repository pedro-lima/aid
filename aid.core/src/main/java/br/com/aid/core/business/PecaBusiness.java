package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalPecaBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalPecaDao;
import br.com.aid.core.models.Peca;

@Business
public class PecaBusiness extends AbstracBusiness<Peca> implements
		LocalPecaBusiness {
	
	private static final long serialVersionUID = 8998525998074164237L;
	
	@Inject
	private LocalPecaDao dao;

	public PecaBusiness() {
		super();
	}

	@Override
	protected Dao<Peca> getDao() {
		return this.dao;
	}

}
