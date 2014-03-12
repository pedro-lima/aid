package br.com.aid.admin.beans;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.omnifaces.cdi.ViewScoped;

import br.com.aid.admin.annotations.LazyDataObserve;
import br.com.aid.admin.interfaces.LazySoftwareCollection;
import br.com.aid.core.annotations.ConfigResourceBundle;
import br.com.aid.core.enumerations.TipoSoftware;
import br.com.aid.core.interfaces.Message;
import br.com.aid.core.interfaces.business.LocalSoftwareBusiness;
import br.com.aid.core.models.Software;

@Named
@ViewScoped
public class SoftwareBean implements Serializable {

	private static final long serialVersionUID = -699178981378670265L;

	@Inject
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

	@Inject
	@ConfigResourceBundle(file = "messages")
	private transient ResourceBundle resource;

	public SoftwareBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	// ====================================GET/SET====================================

	public LocalSoftwareBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LocalSoftwareBusiness business) {
		this.business = business;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public LazySoftwareCollection getLista() {
		return lista;
	}

	public void setLista(LazySoftwareCollection lista) {
		this.lista = lista;
	}

	public Event<SoftwareBean> getEvent() {
		return event;
	}

	public void setEvent(Event<SoftwareBean> event) {
		this.event = event;
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

	public ResourceBundle getResource() {
		return resource;
	}

	public void setResource(ResourceBundle resource) {
		this.resource = resource;
	}

	// ====================================METODOS====================================

	public void remover() {
		try {
			this.business.remover(software);
			message.addInfo(this.resource.getString("comum_sucesso"));
			this.software = new Software();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			message.addError(this.resource.getString("comum_erro"));
		}
	}

	public void salvar() {
		try {
			this.business.salvar(software);
			message.addInfo(this.resource.getString("comum_sucesso"));
			this.software = new Software();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			message.addError(this.resource.getString("comum_erro"));
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
		return this.novoSoftware ? this.resource
				.getString("software_cadastrar") : this.resource
				.getString("software_editar");
	}

}
