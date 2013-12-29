package aid.core.main.messages;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import aid.core.main.interfaces.Message;

public class AddFacesMessage implements Message {
	private static final long serialVersionUID = -3630271582798358952L;
	@Inject
	private FacesContext context;

	public void mensagemAlert(String titulo, String mensagem) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				titulo, mensagem));
	}

	public void mensagemInfo(String titulo, String mensagem) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				titulo, mensagem));
	}

	public void mensagemErro(String titulo, String mensagem) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				titulo, mensagem));
	}

	public void mensagemFatal(String titulo, String mensagem) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
				titulo, mensagem));
	}

}
