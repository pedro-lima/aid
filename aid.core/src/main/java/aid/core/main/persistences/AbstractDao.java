package aid.core.main.persistences;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import aid.core.main.annotations.Transaction;
import aid.core.main.interfaces.Dao;

public abstract class AbstractDao<T> implements Serializable, Dao<T> {
	private static final long serialVersionUID = 2689951424152897002L;
	@Inject
	private EntityManager em;

	public EntityManager getEm() {
		return this.em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transaction
	public void salvar(T obj) {
		this.em.persist(obj);
	}

	@Transaction
	public void remover(T obj) {
		this.em.remove(obj);
	}

	@Transaction
	public void atualizar(T obj) {
		this.em.merge(obj);
	}

	@SuppressWarnings("unchecked")
	public T buscar(Long id) {
		return (T) this.em.find(getClazz(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> listar() {
		CriteriaQuery<T> query = this.em.getCriteriaBuilder().createQuery(
				this.getClazz());
		query.from(this.getClazz());
		return this.em.createQuery(query).getResultList();
	}	

	@SuppressWarnings("unchecked")
	public T buscar(String query) {
		return (T) this.em.createNamedQuery(query).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(String query) {
		return this.em.createNamedQuery(query).getResultList();
	}
	
	@SuppressWarnings("rawtypes")
	protected abstract Class getClazz();

}
