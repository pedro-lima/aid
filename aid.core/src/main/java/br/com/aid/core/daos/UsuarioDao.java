package br.com.aid.core.daos;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalUsuarioDao;
import br.com.aid.core.models.Usuario;

@Dao
public class UsuarioDao extends AbstractDao<Usuario> implements LocalUsuarioDao {

	private static final long serialVersionUID = 852200074839869867L;

	public UsuarioDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Usuario.class;
	}

}
