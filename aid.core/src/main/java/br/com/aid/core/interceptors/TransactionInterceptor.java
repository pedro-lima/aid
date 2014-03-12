package br.com.aid.core.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.aid.core.annotations.Transaction;

@Interceptor
@Transaction
public class TransactionInterceptor {
	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object gerenciaTransacao(InvocationContext context) {
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			Object retorno = context.proceed();
			tx.commit();
			return retorno;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			return e;
		}

	}
}
