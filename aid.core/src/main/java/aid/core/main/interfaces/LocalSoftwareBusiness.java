package aid.core.main.interfaces;

import aid.core.main.models.Software;

public interface LocalSoftwareBusiness extends Business<Software> {

	public boolean isDelete(Long id);	
	
}
