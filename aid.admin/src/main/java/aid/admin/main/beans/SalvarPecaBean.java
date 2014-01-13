package aid.admin.main.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import aid.core.main.enumerations.TipoPeca;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.LocalPecaBusiness;
import aid.core.main.interfaces.Message;
import aid.core.main.models.Peca;

@Named
@RequestScoped
public class SalvarPecaBean implements Serializable {
	private static final long serialVersionUID = -98848243482016236L;
	@Inject
	private LocalPecaBusiness business;
	@Inject
	private Message mensagem;
	@Inject
	private Instance<Peca> pecaInject;
	private Peca peca;
	@Inject
	private HttpSession session;
	public static final String sessionKey = "editar_peca";

	public SalvarPecaBean() {
		super();
	}

	@PostConstruct
	public void init() {
		Peca pen = (Peca) this.session.getAttribute(sessionKey);
		if (pen == null) {
			this.criarNovaPeca();
		} else {
			this.peca = pen;
		}
	}

	public LocalPecaBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LocalPecaBusiness business) {
		this.business = business;
	}

	public Message getMensagem() {
		return mensagem;
	}

	public void setMensagem(Message mensagem) {
		this.mensagem = mensagem;
	}

	public Instance<Peca> getPecaInject() {
		return pecaInject;
	}

	public void setPecaInject(Instance<Peca> pecaInject) {
		this.pecaInject = pecaInject;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public static String getSessionkey() {
		return sessionKey;
	}

	public void cadastrar() {
		try {
			this.business.salvar(peca);
			mensagem.mensagemInfo("Sucesso",
					"Peca cadastrada com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao cadastrar a peca.");
		}
	}

	public void editar() {
		try {
			this.business.atualizar(peca);
			mensagem.mensagemInfo("Sucesso",
					"Peca atualizada com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao atualizar a peca.");
		}
	}

	public void salvar() {
		if (this.peca.getId() == null) {
			this.cadastrar();
		} else {
			this.editar();
		}
		this.limpar();
	}

	public void limpar() {
		this.session.removeAttribute(sessionKey);
		this.criarNovaPeca();
	}

	private void criarNovaPeca() {
		this.peca = this.pecaInject.get();
	}

	public TipoPeca[] getTipoPecas() {
		return TipoPeca.values();
	}
}
