package aid.core.main.persistences;

import aid.core.main.models.Usuario;

public class UsuarioDao extends AbstractDao<Usuario> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Usuario.class;
	}

}
