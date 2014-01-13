package aid.core.main.business;

import java.util.List;
import aid.core.main.interfaces.LocalSoftwareBusiness;
import aid.core.main.models.Software;

public class SoftwareBusiness extends AbstracBusiness<Software> implements
		LocalSoftwareBusiness {
	private static final long serialVersionUID = 1674493130437643508L;

	public List<Software> listar() {
		return this.getDao().listar("software.listAll.new");
	}

	public List<Software> listar(int first, int maxResults) {
		return this.getDao().listar("software.listAll.new", first, maxResults);
	}

	public Long count() {
		return this.getDao().count("software.count");
	}

	@Override
	public Long getObjectKey(Software object) {
		return object.getId();
	}

}
