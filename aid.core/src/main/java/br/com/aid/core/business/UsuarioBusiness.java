package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalUsuarioBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalUsuarioDao;
import br.com.aid.core.models.Usuario;

@Business
public class UsuarioBusiness extends AbstracBusiness<Usuario> implements
		LocalUsuarioBusiness {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LocalUsuarioDao dao;

	public UsuarioBusiness() {
		super();
	}

	@Override
	protected Dao<Usuario> getDao() {
		return this.dao;
	}

}
