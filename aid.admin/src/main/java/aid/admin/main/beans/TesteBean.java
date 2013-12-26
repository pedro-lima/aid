package aid.admin.main.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import aid.core.main.interfaces.LocalSoftwareDao;

@Named
@RequestScoped
public class TesteBean implements Serializable {
	private static final long serialVersionUID = 6345034659912374776L;
	@Inject
	private LocalSoftwareDao dao;
	@Inject
	private FacesContext context;
	
	@PostConstruct
	public void init() {
		System.out.println(dao);
		System.out.println(context);
	}

	public String getTexto() {
		return "Tesde de bean.";
	}

	public LocalSoftwareDao getDao() {
		return dao;
	}

	public void setDao(LocalSoftwareDao dao) {
		this.dao = dao;
	}	
	
}
