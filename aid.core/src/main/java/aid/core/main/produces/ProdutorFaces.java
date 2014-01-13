package aid.core.main.produces;

import java.io.Serializable;
import javax.enterprise.inject.Produces;
import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class ProdutorFaces implements Serializable {
	private static final long serialVersionUID = -7878030142026962451L;

	@Produces
	private FacesContext context = FacesContext.getCurrentInstance();

	@Produces
	private ExternalContext externalContext = FacesContext.getCurrentInstance()
			.getExternalContext();

	@Produces
	private Application application = FacesContext.getCurrentInstance()
			.getApplication();

	@Produces
	private HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();

	/*@Produces
	private HttpSession session = ((HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest())
			.getSession();*/

}
