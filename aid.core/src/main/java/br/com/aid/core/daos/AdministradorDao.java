package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalAdministradorDao;
import br.com.aid.core.models.Administrador;

@Dao
public class AdministradorDao extends AbstractDao<Administrador> implements
		LocalAdministradorDao {

	private static final long serialVersionUID = 300669647664256027L;

	public AdministradorDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Administrador.class;
	}

}
