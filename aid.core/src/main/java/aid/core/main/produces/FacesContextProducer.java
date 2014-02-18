package aid.core.main.produces;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProducer implements Serializable {

	private static final long serialVersionUID = 7271779760458513462L;

	@Produces
	@RequestScoped
	private FacesContext createFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}
