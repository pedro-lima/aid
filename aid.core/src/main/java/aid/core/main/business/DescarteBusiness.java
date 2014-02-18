package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalDescarteBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalDescarteDao;
import aid.core.main.models.Descarte;

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
