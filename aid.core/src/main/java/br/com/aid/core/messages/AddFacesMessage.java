package br.com.aid.core.messages;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.aid.core.interfaces.Message;

@RequestScoped
@Alternative
public class AddFacesMessage implements Message {
	
	private static final long serialVersionUID = -3630271582798358952L;
	
	@Inject
	private FacesContext context;

	public void addAlert(String mensagem) {
		this.addAlert(mensagem, null);
	}

	public void addAlert(String mensagem, String detalhe) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				mensagem, detalhe));
	}

	public void addInfo(String mensagem) {
		this.addInfo(mensagem, null);
	}

	public void addInfo(String mensagem, String detalhe) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				mensagem, detalhe));
	}

	public void addError(String mensagem) {
		this.addError(mensagem, null);
	}

	public void addError(String mensagem, String detalhe) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				mensagem, detalhe));
	}

	public void addFatal(String mensagem) {
		this.addFatal(mensagem, null);
	}

	public void addFatal(String mensagem, String detalhe) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
				mensagem, detalhe));
	}

}
