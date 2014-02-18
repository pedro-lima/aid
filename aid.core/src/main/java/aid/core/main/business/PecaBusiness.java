package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalPecaBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalPecaDao;
import aid.core.main.models.Peca;

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
