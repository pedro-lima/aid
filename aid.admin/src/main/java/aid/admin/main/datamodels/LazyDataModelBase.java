package aid.admin.main.datamodels;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import aid.core.main.interfaces.Business;

public class LazyDataModelBase<T> extends LazyDataModel<T> {
	private static final long serialVersionUID = 756619247333463075L;
	@Inject
	private Business<T> business;
	@Inject
	private Logger log;		
	
	public LazyDataModelBase() {
		super();		
	}

	public Business<T> getBusiness() {
		return business;
	}

	public void setBusiness(Business<T> business) {
		this.business = business;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
		
//		List<Software> list = facade.load(first, pageSize, sortField, sortOrder,
//				filters);
//
//		log.log(Level.INFO, "list.size():"+ String.valueOf(list.size()));
//
//		if (list == null) {
//			setRowCount(0);
//			// throw new RuntimeException("Problem.");
//		} else {
//			setRowCount(facade.count());
//		}
//		
		
		// I am using the following line for debugging:
		// throw new RuntimeException(list.toString());
		return null;
	}	

}
