package aid.admin.main.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.LocalAlunoBusiness;
import aid.core.main.interfaces.Message;
import aid.core.main.models.Aluno;

@Named
@RequestScoped
public class ListarAlunoBean implements Serializable {
	private static final long serialVersionUID = -8173649202087482263L;
	@Inject
	private LocalAlunoBusiness business;
	@Inject
	private Message mensagem;
	@Inject
	private HttpSession session;
	private List<Aluno> alunoCollection;
	@Inject
	private Aluno aluno;

	public ListarAlunoBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.buscar();
	}

	public LocalAlunoBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LocalAlunoBusiness business) {
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

	public List<Aluno> getAlunoCollection() {
		return alunoCollection;
	}

	public void setAlunoCollection(List<Aluno> alunoCollection) {
		this.alunoCollection = alunoCollection;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void detalheAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void buscar() {
		this.alunoCollection = this.business.listar();
	}

	public void remover(Aluno aluno) {
		try {
			this.business.remover(aluno);
			this.alunoCollection.remove(aluno);
			mensagem.mensagemInfo("Sucesso",
					"Aluno removido com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao remover o aluno.");
		}
	}

	public String editarAluno(Aluno aluno) {
		this.session.setAttribute(SalvarAlunoBean.sessionKey, aluno);
		return "cadastrar_aluno";
	}

}
