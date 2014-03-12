package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalDescarteBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalDescarteDao;
import br.com.aid.core.models.Descarte;

@Business
public class DescarteBusiness extends AbstracBusiness<Descarte> implements
		LocalDescarteBusiness {

	private static final long serialVersionUID = -2880484862545761496L;

	@Inject
	private LocalDescarteDao dao;

	public DescarteBusiness() {
		super();
	}

	@Override
	protected Dao<Descarte> getDao() {
		return this.dao;
	}

}
