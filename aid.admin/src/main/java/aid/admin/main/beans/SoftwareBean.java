package aid.admin.main.beans;

import java.util.List;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import aid.core.main.enumerations.TipoSoftware;
import aid.core.main.interfaces.LocalSoftwareBusiness;
import aid.core.main.models.Software;

@Named
@ConversationScoped
public class SoftwareBean extends AbstractBean<Software> {
	private static final long serialVersionUID = -699178981378670265L;
	@Inject
	private LocalSoftwareBusiness business;
	private Software software;

	public SoftwareBean() {
		super();
		this.limpar();
	}

	public LocalSoftwareBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LocalSoftwareBusiness business) {
		this.business = business;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	@Override
	protected Long getObjectId() {
		return this.software.getId();
	}

	@Override
	protected String getUrl() {
		return "cadastrar_software";
	}

	@Override
	public void selecionar(Software object) {
		this.software = object;
	}

	@Override
	public void limpar() {
		this.software = new Software();
	}

	public TipoSoftware[] getTipoSoftwares() {
		return TipoSoftware.values();
	}

	@Override
	protected Software getObject() {
		return this.software;
	}
	
	public List<Software> getListagem() {
		return this.business.listar();
	}
	
	
}
