package aid.core.main.daos;

import aid.core.main.annotations.Dao;
import aid.core.main.interfaces.dao.LocalUsuarioDao;
import aid.core.main.models.Usuario;

@Dao
public class UsuarioDao extends AbstractDao<Usuario> implements LocalUsuarioDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Usuario.class;
	}

}
