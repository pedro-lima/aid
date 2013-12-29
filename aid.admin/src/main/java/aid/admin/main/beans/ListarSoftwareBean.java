package aid.admin.main.beans;

import java.io.Serializable;
import java.util.ArrayList;
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
	private Software software;

	@PostConstruct
	public void init() {
		try {
			this.softwareCollection = business.listar();
		} catch (CRUDException e) {
			this.softwareCollection = new ArrayList<>();
		} finally {
			this.software = new Software();
		}
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

	public boolean isDelete(Software software) {
		return this.business.isDelete(software.getId());
	}

	public void detalheSoftware(Software software) {
		this.software = software;
	}

	public void remover(Software software) {
		try {
			this.business.remover(software);
			this.softwareCollection = business.listar();
			mensagem.mensagemInfo("Sucesso", "Software removido com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao remover o software.");
		}
	}

	public String editarSoftware(Software software) {
		this.session.setAttribute(SalvarSoftwareBean.sessionKey,software);
		return "cadastrar_software";
	}

	public TipoSoftware[] getTipoSoftwares() {
		return TipoSoftware.values();
	}
}
