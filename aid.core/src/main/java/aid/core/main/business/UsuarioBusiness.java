package aid.core.main.business;

import javax.inject.Inject;
import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalUsuarioBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalUsuarioDao;
import aid.core.main.models.Usuario;

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
