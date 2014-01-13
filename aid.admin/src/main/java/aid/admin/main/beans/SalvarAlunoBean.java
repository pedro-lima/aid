package aid.admin.main.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import aid.core.main.enumerations.Curso;
import aid.core.main.enumerations.Estado;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.LocalAlunoBusiness;
import aid.core.main.interfaces.Message;
import aid.core.main.models.Aluno;

@Named
@RequestScoped
public class SalvarAlunoBean implements Serializable {
	private static final long serialVersionUID = -4008948547660605384L;
	@Inject
	private LocalAlunoBusiness business;
	@Inject
	private Message mensagem;
	@Inject		
	private Instance<Aluno> alunoInject;	
	private Aluno aluno;
	@Inject
	private HttpSession session;
	public static final String sessionKey = "editar_aluno";

	public SalvarAlunoBean() {
		super();
	}

	@PostConstruct
	public void init() {
		Aluno al = (Aluno) this.session.getAttribute(sessionKey);
		if (al == null) {
			this.criarNovoAluno();
		} else {
			this.aluno = al;
		}
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

	public Instance<Aluno> getAlunoInject() {
		return alunoInject;
	}

	public void setAlunoInject(Instance<Aluno> alunoInject) {
		this.alunoInject = alunoInject;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
			this.business.salvar(aluno);
			mensagem.mensagemInfo("Sucesso", "Aluno cadastrado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao cadastrar o aluno.");
		}
	}

	public void editar() {
		try {
			this.business.atualizar(aluno);
			mensagem.mensagemInfo("Sucesso", "Aluno atualizado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao atualizar o aluno.");
		}
	}

	public void salvar() {
		if (this.aluno.getId() == null) {
			this.cadastrar();
		} else {
			this.editar();
		}
		this.limpar();
	}

	public void limpar() {
		this.session.removeAttribute(sessionKey);
		this.criarNovoAluno();
	}

	private void criarNovoAluno() {
		this.aluno = this.alunoInject.get();
	}

	public Estado[] getEstados() {
		return Estado.values();
	}

	public Curso[] getCursos() {
		return Curso.values();
	}
}
