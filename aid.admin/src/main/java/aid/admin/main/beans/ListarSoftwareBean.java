package aid.admin.main.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import aid.core.main.enumerations.TipoSoftware;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.LocalSoftwareBusiness;
import aid.core.main.interfaces.Message;
import aid.core.main.models.Software;

@Named
@RequestScoped
public class ListarSoftwareBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private LocalSoftwareBusiness business;
	@Inject
	private Message mensagem;
	@Inject
	private HttpSession session;	
	private List<Software> softwareCollection;
	@Inject
	private Software software;

	@PostConstruct
	public void init() {	
		this.buscar();
	}

	public LocalSoftwareBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LocalSoftwareBusiness business) {
		this.business = business;
	}

	public Message getMensagem() {
		return mensagem;
	}

	public void setMensagem(Message mensagem) {
		this.mensagem = mensagem;
	}

	public List<Software> getSoftwareCollection() {
		return softwareCollection;
	}

	public void setSoftwareCollection(List<Software> softwareCollection) {
		this.softwareCollection = softwareCollection;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public void detalheSoftware(Software software) {
		this.software = software;
	}
	
	public void buscar() {
		this.softwareCollection = this.business.listar();
	}

	public void remover(Software software) {
		try {			
			this.business.remover(software);
			this.softwareCollection.remove(software);
			mensagem.mensagemInfo("Sucesso", "Software removido com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao remover o software.");
		}
	}

	public String editarSoftware(Software software) {
		this.session.setAttribute(SalvarSoftwareBean.sessionKey, software);
		return "cadastrar_software";
	}

	public TipoSoftware[] getTipoSoftwares() {
		return TipoSoftware.values();
	}
}
