package aid.core.main.produces;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.apache.log4j.Logger;
public class ProdutorLogger {
	
	@SuppressWarnings("rawtypes")
	@Produces
	public Logger createLogger(InjectionPoint ip){
		Class classe  = ip.getMember().getDeclaringClass();
		return Logger.getLogger(classe.getName());
	}

}
