package br.com.aid.admin.datamodels;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.aid.core.enumerations.Ordenacao;

public abstract class AbstractLazyDataModel<T> extends LazyDataModel<T> {

	private static final long serialVersionUID = 3021290378988302080L;

	private transient LoadParans loadParans;

	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {

		Ordenacao order = (sortOrder.equals(SortOrder.ASCENDING)) ? Ordenacao.ASC : Ordenacao.DESC;

		this.loadParans = new LoadParans(first, pageSize, sortField, order,
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
		private Ordenacao sortOrder;
		private Map<String, String> filters;

		public LoadParans(int first, int pageSize, String sortField,
				Ordenacao sortOrder, Map<String, String> filters) {
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

		public Ordenacao getSortOrder() {
			return sortOrder;
		}

		public void setSortOrder(Ordenacao sortOrder) {
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
