package br.com.aid.core.business;

import br.com.aid.core.annotations.Transaction;
import br.com.aid.core.interfaces.business.Business;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.models.AbstracModel;

public abstract class AbstracBusiness<T extends AbstracModel> implements
		Business<T> {
	private static final long serialVersionUID = 6492441215689865039L;

	public AbstracBusiness() {
		super();
	}

	@Transaction
	public void salvar(T obj) {
		if (obj.getId() == null) {
			this.getDao().salvar(obj);
		} else {
			this.getDao().atualizar(obj);
		}
	}

	@Transaction
	public void remover(T obj) {
		this.getDao().remover(this.getDao().atualizar(obj));
	}

	public T buscar(Long id) {
		return this.getDao().buscar(id);
	}

	protected abstract Dao<T> getDao();

}
