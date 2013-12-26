package aid.core.main.persistences;

import javax.persistence.Query;
import aid.core.main.interfaces.LocalSoftwareDao;
import aid.core.main.models.Software;

public class SoftwareDao extends AbstractDao<Software> implements
		LocalSoftwareDao {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	protected Class getClazz() {
		return Software.class;
	}
	
	public int countHomologacoes(Long id) {
		Query q = this.getEm().createNamedQuery("software.count.homologacoes");
		q.setParameter("id", id);
		return (Integer) q.getSingleResult();
	}

}
