package aid.core.main.business;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalPontoBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalPontoDao;
import aid.core.main.models.Ponto;

@Business
public class PontoBusiness extends AbstracBusiness<Ponto> implements
		LocalPontoBusiness {
	private static final long serialVersionUID = -9212487499197679348L;
	private LocalPontoDao dao;

	@Override
	protected Dao<Ponto> getDao() {
		return this.dao;
	}

}
