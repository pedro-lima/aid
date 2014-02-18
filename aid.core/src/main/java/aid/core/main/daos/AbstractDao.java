package aid.core.main.daos;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import aid.core.main.interfaces.dao.Dao;
import aid.core.main.models.AbstracModel;

public abstract class AbstractDao<T extends AbstracModel> implements Dao<T> {
	
	private static final long serialVersionUID = 2689951424152897002L;
	
	@Inject
	private EntityManager em;
	
	public AbstractDao() {
		super();
	}

	public EntityManager getEm() {
		return this.em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(T obj) {		
		this.em.persist(obj);
	}
		
	public void remover(T obj) {
		T t = this.em.merge(obj);
		this.em.remove(t);
	}

	public T atualizar(T obj) {
		return (T) this.em.merge(obj);
	}

	@SuppressWarnings("unchecked")
	public T buscar(Long id) {
		return (T) this.em.find(getClazz(), id);
	}	

	@SuppressWarnings("rawtypes")
	protected abstract Class getClazz();
}
