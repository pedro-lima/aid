package aid.core.main.persistences;

import aid.core.main.models.Administrador;

public class AdministradorDao extends AbstractDao<Administrador> {
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
