package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalAdministradorDao;
import aid.core.main.models.Administrador;

@Dao
public class AdministradorDao extends AbstractDao<Administrador> implements
		LocalAdministradorDao {
	private static final long serialVersionUID = 1L;

	public AdministradorDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Administrador.class;
	}

}
