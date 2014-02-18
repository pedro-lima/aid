package aid.admin.main.datamodels;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public abstract class AbstractLazyDataModel<T> extends LazyDataModel<T> {

	private static final long serialVersionUID = 3021290378988302080L;

	private transient LoadParans loadParans;

	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {

		this.loadParans = new LoadParans(first, pageSize, sortField, sortOrder,
				filters);

		List<T> lista = this.pesquisar();

		this.setRowCount(this.getTotal());
		return lista;
	}
	
	public LoadParans getLoadParans() {
		return loadParans;
	}

	public abstract int getTotal();

	public abstract List<T> pesquisar();

	protected class LoadParans {
		private int first;
		private int pageSize;
		private String sortField;
		private SortOrder sortOrder;
		private Map<String, String> filters;

		public LoadParans(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, String> filters) {
			super();
			this.first = first;
			this.pageSize = pageSize;
			this.sortField = sortField;
			this.sortOrder = sortOrder;
			this.filters = filters;
		}

		public int getFirst() {
			return first;
		}

		public void setFirst(int first) {
			this.first = first;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public String getSortField() {
			return sortField;
		}

		public void setSortField(String sortField) {
			this.sortField = sortField;
		}

		public SortOrder getSortOrder() {
			return sortOrder;
		}

		public void setSortOrder(SortOrder sortOrder) {
			this.sortOrder = sortOrder;
		}

		public Map<String, String> getFilters() {
			return filters;
		}

		public void setFilters(Map<String, String> filters) {
			this.filters = filters;
		}

		@Override
		public String toString() {
			return "LoadParans [first=" + first + ", pageSize=" + pageSize
					+ ", sortField=" + sortField + ", sortOrder=" + sortOrder
					+ ", filters=" + filters + "]";
		}

	}

}
