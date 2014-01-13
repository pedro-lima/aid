package aid.core.main.persistences;

import aid.core.main.interfaces.Dao;
import aid.core.main.models.Software;

public class SoftwareDao extends AbstractDao<Software> implements Dao<Software> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	protected Class getClazz() {
		return Software.class;
	}

}
