package aid.core.main.persistences;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import aid.core.main.annotations.Transaction;
import aid.core.main.interfaces.Dao;
import aid.core.main.pojos.QueryParam;

public abstract class AbstractDao<T> implements Dao<T> {
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
	public T atualizar(T obj) {
		return (T) this.em.merge(obj);
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
	public T buscar(String query, QueryParam... params) {
		return (T) this.addQueryParans(this.em.createNamedQuery(query))
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")	
	public List<T> listar(String query, QueryParam... params) {
		return this.addQueryParans(this.em.createNamedQuery(query))
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(String query, int offset, int max,
			QueryParam... params) {
		return this.addQueryParans(this.em.createNamedQuery(query))
				.setFirstResult(offset).setMaxResults(max).getResultList();
	}
	
	public int executar(String query, QueryParam... params) {
		return this.addQueryParans(this.em.createNamedQuery(query))
				.executeUpdate();
	}

	public Long count(String query, QueryParam... params) {
		return (Long) this.addQueryParans(this.em.createNamedQuery(query))
				.getSingleResult();
	}

	private Query addQueryParans(Query query, QueryParam... parans) {
		for (QueryParam param : parans) {
			query.setParameter(param.getNome(), param.getValor());
		}
		return query;
	}

	@SuppressWarnings("rawtypes")
	protected abstract Class getClazz();

}
