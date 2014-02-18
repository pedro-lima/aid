package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalDoadorBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalDoadorDao;
import aid.core.main.models.Doador;

@Business
public class DoadorBusiness extends AbstracBusiness<Doador> implements
		LocalDoadorBusiness {
	private static final long serialVersionUID = 8885532470965861258L;
	@Inject
	private LocalDoadorDao dao;

	@Override
	protected Dao<Doador> getDao() {
		return this.dao;
	}

}
