package aid.admin.main.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.omnifaces.cdi.ViewScoped;

import aid.admin.main.annotations.LazyDataObserve;
import aid.admin.main.interfaces.LazySoftwareCollection;
import aid.core.main.enumerations.TipoSoftware;
import aid.core.main.exceptions.AIDException;
import aid.core.main.interfaces.Message;
import aid.core.main.interfaces.business.LocalSoftwareBusiness;
import aid.core.main.models.Software;

@Named
@ViewScoped
public class SoftwareBean implements Serializable {

	private static final long serialVersionUID = -699178981378670265L;

	@Inject
	@RequestScoped
	private LocalSoftwareBusiness business;

	@Inject
	private transient Logger log;

	@Inject
	private transient Message message;

	@Inject
	private LazySoftwareCollection lista;

	@Inject
	private Event<SoftwareBean> event;

	private Software software;

	private String marca;

	private String modelo;

	private String observacao;

	private TipoSoftware tipo;
	
	private boolean novoSoftware;

	public SoftwareBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.limpar();		
	}

	// ====================================GET/SET====================================

	public LazySoftwareCollection getLista() {
		return lista;
	}

	public void setLista(LazySoftwareCollection lista) {
		this.lista = lista;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoSoftware getTipo() {
		return tipo;
	}

	public void setTipo(TipoSoftware tipo) {
		this.tipo = tipo;
	}	
	
	public boolean isNovoSoftware() {
		return novoSoftware;
	}

	public void setNovoSoftware(boolean novoSoftware) {
		this.novoSoftware = novoSoftware;
	}
	

	// ====================================METODOS====================================

	public void remover() {
		try {			
			this.business.remover(software);
			message.addInfo("Operação realizada com sucesso.", null);
			this.software = new Software();
		} catch (AIDException e) {
			log.error(e);
			message.addError(
					"Não foi possivel completar a operação solicitada.", null);
		}
	}

	public void salvar() {
		try {
			this.business.salvar(software);
			message.addInfo("Operação realizada com sucesso.", null);
			this.software = new Software();
		} catch (AIDException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			message.addError(
					"Não foi possivel completar a operação solicitada.", null);
		}
	}

	public void limpar() {
		this.software = new Software();
		this.marca = null;
		this.modelo = null;
		this.observacao = null;
		this.tipo = null;
	}

	public TipoSoftware[] getTipoSoftwares() {
		return TipoSoftware.values();
	}

	public void pesquisar() {
		event.select(new AnnotationLiteral<LazyDataObserve>() {
			private static final long serialVersionUID = 4271664556438849268L;
		}).fire(this);
	}

	public void limparPesquisa() {
		this.limpar();
		this.pesquisar();
	}	
	
	public String getNomePanel() {
		return this.novoSoftware? "Cadastrar Software" : "Editar Software";
	}
	// ====================================================================
}
