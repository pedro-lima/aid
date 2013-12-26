package aid.core.main.interfaces;

import aid.core.main.models.Software;

public interface LocalSoftwareDao extends Dao<Software> {
	public int countHomologacoes(Long id);

}
