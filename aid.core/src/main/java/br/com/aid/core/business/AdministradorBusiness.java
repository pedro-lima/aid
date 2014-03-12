package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalAdministradorBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalAdministradorDao;
import br.com.aid.core.models.Administrador;

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
