package aid.admin.main.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.LocalPecaBusiness;
import aid.core.main.interfaces.Message;
import aid.core.main.models.Peca;

@Named
@RequestScoped
public class ListarPecaBean implements Serializable {
	private static final long serialVersionUID = -5107152467615735045L;
	@Inject
	private LocalPecaBusiness business;
	@Inject
	private Message mensagem;
	@Inject
	private HttpSession session;
	private List<Peca> pecaCollection;
	@Inject
	private Peca peca;
	
	public ListarPecaBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.buscar();
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

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public List<Peca> getPecaCollection() {
		return pecaCollection;
	}

	public void setPecaCollection(List<Peca> pecaCollection) {
		this.pecaCollection = pecaCollection;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	

	public void detalhePeca(Peca peca) {
		this.peca = peca;
	}

	public void buscar() {
		this.pecaCollection = this.business.listar();
	}

	public void remover(Peca peca) {
		try {
			this.business.remover(peca);
			this.pecaCollection.remove(peca);
			mensagem.mensagemInfo("Sucesso",
					"Aluno removido com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao remover o aluno.");
		}
	}

	public String editarAluno(Peca peca) {
		this.session.setAttribute(SalvarPecaBean.sessionKey, peca);
		return "cadastrar_peca";
	}
}
