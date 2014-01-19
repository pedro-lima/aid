package aid.core.main.business;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import aid.core.main.annotations.Transaction;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.interfaces.Dao;

public abstract class AbstracBusiness<T> implements Business<T> {
	private static final long serialVersionUID = 6492441215689865039L;
	@Inject
	private Dao<T> dao;

	public AbstracBusiness() {
		super();
	}

	public Dao<T> getDao() {
		return dao;
	}

	public void setDao(Dao<T> dao) {
		this.dao = dao;
	}

	@Transaction
	public void salvar(T obj) throws CRUDException {
		this.dao.salvar(obj);
	}

	@Transaction
	public void remover(T obj) throws CRUDException {
		this.dao.remover(this.dao.buscar(getObjectKey(obj)));
	}

	@Transaction
	public void atualizar(T obj) throws CRUDException {
		this.dao.atualizar(obj);
	}

	public T buscar(Long id) {
		try {
			return this.dao.buscar(id);
		} catch (NoResultException ex) {
			return null;
		}
	}

	public abstract Long getObjectKey(T object);

}
