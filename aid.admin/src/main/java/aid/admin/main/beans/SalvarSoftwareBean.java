package aid.admin.main.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
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
public class SalvarSoftwareBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private LocalSoftwareBusiness business;
	@Inject
	private Message mensagem;
	@Inject
	private Instance<Software> softwareInject;
	private Software software;
	@Inject
	private HttpSession session;
	public static final String sessionKey = "editar_software";

	public SalvarSoftwareBean() {
		super();
	}

	@PostConstruct
	public void init() {
		Software soft = (Software) this.session.getAttribute(sessionKey);
		if (soft == null) {
			this.newSoftware();
		} else {
			this.software = soft;
		}
	}

	private void newSoftware() {
		this.software = this.softwareInject.get();
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

	public Message getMensagem() {
		return mensagem;
	}

	public void setMensagem(Message mensagem) {
		this.mensagem = mensagem;
	}

	public Instance<Software> getSoftwareInject() {
		return softwareInject;
	}

	public void setSoftwareInject(Instance<Software> softwareInject) {
		this.softwareInject = softwareInject;
	}

	public void cadastrar() {
		try {
			this.business.salvar(software);
			mensagem.mensagemInfo("Sucesso", "Software cadastrado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao cadastrar o software.");
		}
	}

	public void editar() {
		try {
			this.business.atualizar(software);
			mensagem.mensagemInfo("Sucesso", "Software atualizado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao atualizar o software.");
		}
	}

	public void salvar() {
		if (this.software.getId() == null) {
			this.cadastrar();
		} else {
			this.editar();			
		}		
		this.limpar();
	}
	
	public void limpar() {
		this.session.removeAttribute(sessionKey);
		this.newSoftware();
	}

	public TipoSoftware[] getTipoSoftwares() {
		return TipoSoftware.values();
	}
}
