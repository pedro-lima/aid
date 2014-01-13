package aid.core.main.interfaces;

import java.util.List;

import aid.core.main.models.Software;

public interface LocalSoftwareBusiness extends Business<Software> {

	public List<Software> listar(int first, int maxResults);
	
	public Long count();
	
}
