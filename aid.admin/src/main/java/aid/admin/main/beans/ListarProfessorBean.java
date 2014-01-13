package aid.admin.main.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.LocalProfessorBusiness;
import aid.core.main.interfaces.Message;
import aid.core.main.models.Professor;

@Named
@RequestScoped
public class ListarProfessorBean implements Serializable {
	private static final long serialVersionUID = -7388716918777236125L;
	@Inject
	private LocalProfessorBusiness business;
	@Inject
	private Message mensagem;
	@Inject
	private HttpSession session;
	private List<Professor> professorCollection;
	@Inject
	private Professor professor;

	public ListarProfessorBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.buscar();
	}

	public LocalProfessorBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LocalProfessorBusiness business) {
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

	public List<Professor> getProfessorCollection() {
		return professorCollection;
	}

	public void setProfessorCollection(List<Professor> professorCollection) {
		this.professorCollection = professorCollection;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void detalheProfessor(Professor professor) {
		this.professor = professor;
	}

	public void buscar() {
		this.professorCollection = this.business.listar();
	}

	public void remover(Professor professor) {
		try {
			this.business.remover(professor);
			this.professorCollection.remove(professor);
			mensagem.mensagemInfo("Sucesso", "Professor removido com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao remover o professor.");
		}
	}

	public String editarProfessor(Professor professor) {
		this.session.setAttribute(SalvarProfessorBean.sessionKey, professor);
		return "cadastrar_professor";
	}
}
