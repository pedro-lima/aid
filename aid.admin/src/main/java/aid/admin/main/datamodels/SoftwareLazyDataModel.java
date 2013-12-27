package aid.admin.main.datamodels;

import aid.core.main.models.Software;

public class SoftwareLazyDataModel extends  AbstractLazyDataModel<Software>{
	private static final long serialVersionUID = 7069298318691817625L;

	@Override
	public Object getRowKey(Software model) {
		return model.getId();
	}

}
