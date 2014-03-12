package br.com.aid.core.daos;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.models.AbstracModel;

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
		this.em.remove(obj);
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
