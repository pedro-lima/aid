package aid.core.main.business;

import aid.core.main.annotations.Transaction;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.business.Business;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.models.AbstracModel;

public abstract class AbstracBusiness<T extends AbstracModel> implements
		Business<T> {
	private static final long serialVersionUID = 6492441215689865039L;

	public AbstracBusiness() {
		super();
	}

	@Transaction
	public void salvar(T obj) throws CRUDException {
		try {
			if (obj.getId() == null) {
				this.getDao().salvar(obj);
			} else {
				this.getDao().atualizar(obj);
			}
		} catch (Exception ex) {
			throw new CRUDException(ex);
		}
	}

	@Transaction
	public void remover(T obj) throws CRUDException {
		try {			
			this.getDao().remover(this.getDao().atualizar(obj));
		} catch (Exception ex) {
			throw new CRUDException(ex);
		}
	}

	public T buscar(Long id) throws CRUDException {
		try {
			return this.getDao().buscar(id);
		} catch (Exception ex) {
			throw new CRUDException(ex);
		}
	}

	protected abstract Dao<T> getDao();

}
