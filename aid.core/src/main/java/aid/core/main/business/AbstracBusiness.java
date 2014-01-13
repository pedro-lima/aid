package aid.core.main.business;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.interfaces.Dao;

public abstract class AbstracBusiness<T> implements Business<T> {
	private static final long serialVersionUID = 6492441215689865039L;
	@Inject
	private Dao<T> dao;
	@Inject
	private Logger log;

	public AbstracBusiness() {
		super();
	}

	public Dao<T> getDao() {
		return dao;
	}

	public void setDao(Dao<T> dao) {
		this.dao = dao;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public void salvar(T obj) throws CRUDException {
		try {
			this.dao.salvar(obj);
		} catch (Exception ex) {
			System.out.println(ex);
			log.error(ex);
			throw new CRUDException(ex);
		}
	}

	public void remover(T obj) throws CRUDException {
		try {
			this.dao.remover(this.dao.buscar(getObjectKey(obj)));
		} catch (Exception ex) {
			log.error(ex);
			throw new CRUDException(ex);
		}
	}

	public void atualizar(T obj) throws CRUDException {
		try {
			this.dao.atualizar(obj);
		} catch (Exception ex) {
			log.error(ex);
			throw new CRUDException(ex);
		}
	}

	public T buscar(Long id) {
		try {
			return this.dao.buscar(id);
		} catch (NoResultException ex) {
			this.getLog().error(ex);
			return null;
		}
	}

	public abstract Long getObjectKey(T object);

}
