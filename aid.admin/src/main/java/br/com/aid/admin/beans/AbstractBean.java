package br.com.aid.admin.beans;

import java.util.ResourceBundle;

import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.aid.admin.annotations.LazyDataObserve;
import br.com.aid.core.annotations.ConfigResourceBundle;
import br.com.aid.core.interfaces.Message;
import br.com.aid.core.interfaces.business.Business;

public abstract class AbstractBean<Model, Bean> {

	@Inject
	private transient Logger log;

	@Inject
	private transient Message message;

	private ControllerOperacao operacao;

	@Inject
	private Event<Bean> event;

	@Inject
	@ConfigResourceBundle(file = "messages")
	private transient ResourceBundle resource;

	public AbstractBean() {
		super();
		this.operacao = ControllerOperacao.Listar;
	}

	// ====================================GET/SET====================================

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

	public ControllerOperacao getOperacao() {
		return operacao;
	}

	public void setOperacao(ControllerOperacao operacao) {
		this.operacao = operacao;
	}

	public ResourceBundle getResource() {
		return resource;
	}

	public void setResource(ResourceBundle resource) {
		this.resource = resource;
	}

	public Event<Bean> getEvent() {
		return event;
	}

	public void setEvent(Event<Bean> event) {
		this.event = event;
	}

	// ====================================METODOS====================================

	public void setCodigoOperacao(int codigo) {
		switch (codigo) {
		case 1:
			this.operacao = ControllerOperacao.Detalhar;
			break;
		case 2:
			this.operacao = ControllerOperacao.Editar;
			break;
		case 3:
			this.operacao = ControllerOperacao.Listar;
			break;
		case 4:
			this.operacao = ControllerOperacao.Remover;
			break;
		default:
			this.operacao = ControllerOperacao.Salvar;
			break;
		}
	}

	public void remover() {
		try {
			this.getBusiness().remover(getModel());
			message.addInfo(this.resource.getString("comum_sucesso"));
			this.limparModel();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			message.addError(this.resource.getString("comum_erro"));
		}
	}

	public void salvar() {
		try {
			this.getBusiness().salvar(getModel());
			message.addInfo(this.resource.getString("comum_sucesso"));
			this.limparModel();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			message.addError(this.resource.getString("comum_erro"));
		}
	}

	@SuppressWarnings("unchecked")
	public void pesquisar() {
		this.event.select(new AnnotationLiteral<LazyDataObserve>() {
			private static final long serialVersionUID = 4271664556438849268L;
		}).fire((Bean) this);
	}

	// ===============================METODOS_ABSTRATOS=================================

	public abstract Model getModel();

	public abstract Business<Model> getBusiness();

	public abstract void limparModel();

	// ==================================ENUNS==========================================

	public enum ControllerOperacao {
		Detalhar(1), Editar(2), Listar(3), Remover(4), Salvar(5);

		private int codigo;

		private ControllerOperacao(int codigo) {
			this.codigo = codigo;
		}

		public int getCodigo() {
			return codigo;
		}
	}

}
