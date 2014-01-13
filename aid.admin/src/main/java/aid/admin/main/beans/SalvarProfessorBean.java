package aid.admin.main.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import aid.core.main.enumerations.Estado;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.LocalProfessorBusiness;
import aid.core.main.interfaces.Message;
import aid.core.main.models.Professor;

@Named
@RequestScoped
public class SalvarProfessorBean implements Serializable {
	private static final long serialVersionUID = 4189232492840435209L;
	@Inject
	private LocalProfessorBusiness business;
	@Inject
	private Message mensagem;
	@Inject
	private Instance<Professor> professorInject;
	private Professor professor;
	@Inject
	private HttpSession session;
	public static final String sessionKey = "editar_professor";

	public SalvarProfessorBean() {
		super();
	}

	@PostConstruct
	public void init() {
		Professor pro = (Professor) this.session.getAttribute(sessionKey);
		if (pro == null) {
			this.criarNovoProfessor();
		} else {
			this.professor = pro;
		}
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

	public Instance<Professor> getProfessorInject() {
		return professorInject;
	}

	public void setProfessorInject(Instance<Professor> professorInject) {
		this.professorInject = professorInject;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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
			this.business.salvar(professor);
			mensagem.mensagemInfo("Sucesso",
					"Professor cadastrado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao cadastrar o professor.");
		}
	}

	public void editar() {
		try {
			this.business.atualizar(professor);
			mensagem.mensagemInfo("Sucesso",
					"Professor atualizado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao atualizar o professor.");
		}
	}

	public void salvar() {
		if (this.professor.getId() == null) {
			this.cadastrar();
		} else {
			this.editar();
		}
		this.limpar();
	}

	public void limpar() {
		this.session.removeAttribute(sessionKey);
		this.criarNovoProfessor();
	}

	private void criarNovoProfessor() {
		this.professor = this.professorInject.get();
	}

	public Estado[] getEstados() {
		return Estado.values();
	}
}
