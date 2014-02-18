package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalAdministradorBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalAdministradorDao;
import aid.core.main.models.Administrador;

@Business
public class AdministradorBusiness extends AbstracBusiness<Administrador>
		implements LocalAdministradorBusiness {
	private static final long serialVersionUID = -6046015758550676516L;
	@Inject
	private LocalAdministradorDao dao;

	public AdministradorBusiness() {
		super();
	}

	@Override
	protected Dao<Administrador> getDao() {	
		return this.dao;
	}

}
