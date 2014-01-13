package aid.admin.main.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.LocalBeneficiadoBusiness;
import aid.core.main.interfaces.Message;
import aid.core.main.models.Beneficiado;

@Named
@RequestScoped
public class ListarBeneficiadoBean implements Serializable {
	private static final long serialVersionUID = 5548728852857964099L;
	@Inject
	private LocalBeneficiadoBusiness business;
	@Inject
	private Message mensagem;
	@Inject
	private HttpSession session;
	private List<Beneficiado> beneficiadoCollection;
	@Inject
	private Beneficiado beneficiado;

	public ListarBeneficiadoBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.buscar();
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

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public List<Beneficiado> getBeneficiadoCollection() {
		return beneficiadoCollection;
	}

	public void setBeneficiadoCollection(List<Beneficiado> beneficiadoCollection) {
		this.beneficiadoCollection = beneficiadoCollection;
	}

	public Beneficiado getBeneficiado() {
		return beneficiado;
	}

	public void setBeneficiado(Beneficiado beneficiado) {
		this.beneficiado = beneficiado;
	}

	public void detalheBeneficiado(Beneficiado beneficiado) {
		this.beneficiado = beneficiado;
	}

	public void buscar() {
		this.beneficiadoCollection = this.business.listar();
	}

	public void remover(Beneficiado beneficiado) {
		try {
			this.business.remover(beneficiado);
			this.beneficiadoCollection.remove(beneficiado);
			mensagem.mensagemInfo("Sucesso", "Beneficiado removido com sucesso.");
		} catch (CRUDException e) {
			mensagem.mensagemErro("Erro", "Erro ao remover o beneficiado.");
		}
	}

	public String editarBeneficiado(Beneficiado beneficiado) {
		this.session.setAttribute(SalvarBeneficiadoBean.sessionKey, beneficiado);
		return "cadastrar_beneficiado";
	}	

}
