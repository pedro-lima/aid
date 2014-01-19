package aid.core.main.produces;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer implements Serializable {	
	private static final long serialVersionUID = -2549640682431112006L;
	
	@Produces
	@ApplicationScoped
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("aid");
	
	@Produces
	@RequestScoped
	private EntityManager createEntityManager(){
		return factory.createEntityManager();
	}
	
	public void destroyEntityManager(@Disposes EntityManager manager) {
		manager.close();		
	}
	
}
