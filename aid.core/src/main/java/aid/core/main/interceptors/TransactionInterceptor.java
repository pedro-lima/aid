package aid.core.main.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import aid.core.main.annotations.Transaction;

@Interceptor
@Transaction
public class TransactionInterceptor {
	@Inject
	private EntityManager manager;
	@Inject
	private Logger log;

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
			log.error(e);
			if (tx != null)
				tx.rollback();
			return e;
		}

	}
}
