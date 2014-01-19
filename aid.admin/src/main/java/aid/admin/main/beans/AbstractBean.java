package aid.admin.main.beans;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.interfaces.Message;

public abstract class AbstractBean<T> implements Serializable {
	private static final long serialVersionUID = 3382514612742350150L;
	@Inject
	private Conversation conversation;
	@Inject
	private Instance<Message> message;
	@Inject
	private Instance<Logger> log;

	public AbstractBean() {
		super();
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public void remover(T object) {
		try {
			this.getBusiness().remover(object);
			message.get().mensagemInfo("Sucesso",
					"Operação realizada com sucesso.");
		} catch (CRUDException e) {
			log.get().error(e);
			message.get().mensagemErro("Erro",
					"Não foi possivel completar a operação solicitada.");
		}
	}

	public String editar(T object) {
		if (conversation.isTransient()) {
			conversation.begin();
		}
		this.selecionar(object);
		return this.getUrl();
	}

	public void salvar() {
		try {
			if (this.getObjectId() == null) {
				this.getBusiness().salvar(getObject());
			} else {
				this.getBusiness().atualizar(getObject());
			}
			if (!conversation.isTransient()) {
				conversation.end();
			}
			message.get().mensagemInfo("Sucesso",
					"Operação realizada com sucesso.");
			this.limpar();
		} catch (Exception e) {
			log.get().error(e);
			message.get().mensagemErro("Erro",
					"Não foi possivel completar a operação solicitada.");
		}
	}

	protected abstract Business<T> getBusiness();

	protected abstract Long getObjectId();

	protected abstract T getObject();

	protected abstract String getUrl();

	public abstract void selecionar(T object);

	public abstract void limpar();

}
