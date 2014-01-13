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
import aid.core.main.interfaces.LocalBeneficiadoBusiness;
import aid.core.main.interfaces.Message;
import aid.core.main.models.Beneficiado;

@Named
@RequestScoped
public class SalvarBeneficiadoBean implements Serializable {
	private static final long serialVersionUID = -1833808686296179033L;
	@Inject
	private LocalBeneficiadoBusiness business;
	@Inject
	private Message mensagem;
	@Inject
	private Instance<Beneficiado> beneficiadoInject;
	private Beneficiado beneficiado;
	@Inject
	private HttpSession session;
	public static final String sessionKey = "editar_beneficiado";

	public SalvarBeneficiadoBean() {
		super();
	}

	@PostConstruct
	public void init() {
		Beneficiado ben = (Beneficiado) this.session.getAttribute(sessionKey);
		if (ben == null) {
			this.criarNovoBeneficiado();
		} else {
			this.beneficiado = ben;
		}
	}

	public LocalBeneficiadoBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LocalBeneficiadoBusiness business) {
		this.business = business;
	}

	public Message getMensagem() {
		return mensagem;
	}

	public void setMensagem(Message mensagem) {
		this.mensagem = mensagem;
	}

	public Instance<Beneficiado> getBeneficiadoInject() {
		return beneficiadoInject;
	}

	public void setBeneficiadoInject(Instance<Beneficiado> beneficiadoInject) {
		this.beneficiadoInject = beneficiadoInject;
	}

	public Beneficiado getBeneficiado() {
		return beneficiado;
	}

	public void setBeneficiado(Beneficiado beneficiado) {
		this.beneficiado = beneficiado;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	public void cadastrar() {
		try {
			this.business.salvar(beneficiado);
			mensagem.mensagemInfo("Sucesso", "Beneficiado cadastrado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao cadastrar o beneficiado.");
		}
	}

	public void editar() {
		try {
			this.business.atualizar(beneficiado);
			mensagem.mensagemInfo("Sucesso", "Beneficiado atualizado com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao atualizar o beneficiado.");
		}
	}

	public void salvar() {
		if (this.beneficiado.getId() == null) {
			this.cadastrar();
		} else {
			this.editar();			
		}		
		this.limpar();
	}
	
	public void limpar() {
		this.session.removeAttribute(sessionKey);
		this.criarNovoBeneficiado();
	}
	
	private void criarNovoBeneficiado() {
		this.beneficiado = this.beneficiadoInject.get();
	}
	
	public Estado[] getEstados() {
		return Estado.values();
	}

}
