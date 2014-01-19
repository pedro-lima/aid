package aid.core.main.produces;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.log4j.Logger;

public class LoggerProducer implements Serializable {
	private static final long serialVersionUID = -8798194733931035997L;

	@SuppressWarnings("rawtypes")
	@Produces
	public Logger createLogger(InjectionPoint ip) {
		Class classe = ip.getMember().getDeclaringClass();
		return Logger.getLogger(classe.getName());
	}

}
