package aid.admin.main.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
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

	public SalvarSoftwareBean() {
		super();
	}	
	
	@PostConstruct
	public void init() {
		this.newSoftware();
	}
	
	private void newSoftware(){
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

	public void salvar() {
		try {
			this.business.salvar(software);
			this.newSoftware();
			mensagem.mensagemInfo("Sucesso", "Software cadastrado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao cadastrar o software.");
		}
	}
	
	public TipoSoftware[] getTipoSoftwares() {
        return TipoSoftware.values();
    }
}
