package aid.admin.main.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
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
	private Software software;
	@Inject
	private LazyDataModel<Software> softwareCollection;

	@PostConstruct
	public void init() {
		/*try {
			this.softwareCollection = business.listar();
		} catch (CRUDException e) {
			this.softwareCollection = new ArrayList<>();
			e.printStackTrace();
		}*/
	}
	
	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public LazyDataModel<Software> getSoftwareCollection() {
		return softwareCollection;
	}

	public void setSoftwareCollection(LazyDataModel<Software> softwareCollection) {
		this.softwareCollection = softwareCollection;
	}

	public boolean isDelete(Software software) {
		return this.business.isDelete(software.getId());
	}

	public void delete(Software software) {
		try {
			this.business.remover(software);
			mensagem.mensagemInfo("Sucesso", "Software removido com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao remover o software.");
		}
	}

	public void detalhe(Software software) {
		this.software = software;
	}

	public TipoSoftware[] getTipoSoftwares() {
        return TipoSoftware.values();
    }
	
	public void editar(Software software) {
		try {
			this.business.atualizar(software);
			mensagem.mensagemInfo("Sucesso", "Software atualizado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao atualizar o software.");
		}
	}

}
