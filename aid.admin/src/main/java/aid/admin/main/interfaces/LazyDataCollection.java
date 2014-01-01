package aid.admin.main.interfaces;

import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;

public interface LazyDataCollection<T> {
	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters);
	
	public Object getRowKey(T model);
	
	public String getEntrada();
	
	public void setEntrada(String texto);
}
