package aid.admin.main.datamodels;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import aid.core.main.interfaces.Dao;

public abstract class AbstractLazyDataModel<T> extends LazyDataModel<T> {
	private static final long serialVersionUID = 756619247333463075L;
	@Inject
	private Dao<T> dao;
	private List<T> collection;

	public AbstractLazyDataModel() {
		super();
	}

	public Dao<T> getDao() {
		return dao;
	}

	public void setDao(Dao<T> dao) {
		this.dao = dao;
	}	

	@Override
	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {

		this.collection = dao.list(first, pageSize);
		this.setRowCount(this.dao.count().intValue());

		return this.collection;
	}
}
