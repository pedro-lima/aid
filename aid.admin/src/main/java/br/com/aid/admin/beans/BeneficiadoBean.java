package br.com.aid.admin.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.omnifaces.cdi.ViewScoped;

import br.com.aid.admin.annotations.LazyDataObserve;
import br.com.aid.admin.interfaces.LazyBeneficiadoCollection;
import br.com.aid.core.interfaces.Message;
import br.com.aid.core.interfaces.business.LocalBeneficiadoBusiness;
import br.com.aid.core.interfaces.business.LocalCidadeBusiness;
import br.com.aid.core.interfaces.business.LocalEstadoBusiness;
import br.com.aid.core.models.Beneficiado;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Contato;
import br.com.aid.core.models.Endereco;
import br.com.aid.core.models.Estado;

@Named
@ViewScoped
public class BeneficiadoBean implements Serializable {

	private static final long serialVersionUID = 490967361912890650L;

	@Inject
	private LocalBeneficiadoBusiness beneficiadoBusiness;

	@Inject
	private LocalEstadoBusiness estadoBusiness;

	@Inject
	private LocalCidadeBusiness cidadeBusiness;

	@Inject
	private transient Logger log;

	@Inject
	private transient Message message;

	@Inject
	private LazyBeneficiadoCollection lista;

	@Inject
	private Event<BeneficiadoBean> event;

	private Beneficiado beneficiado;

	private String nome;

	private String rua;

	private String numero;

	private String bairro;

	private String cep;

	private Cidade cidade;

	private Estado estado;

	private Estado estadoCadastro;

	private boolean novoBeneficiado;

	public BeneficiadoBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	// ====================================GET/SET====================================

	public LocalBeneficiadoBusiness getBeneficiadoBusiness() {
		return beneficiadoBusiness;
	}

	public void setBeneficiadoBusiness(
			LocalBeneficiadoBusiness beneficiadoBusiness) {
		this.beneficiadoBusiness = beneficiadoBusiness;
	}

	public LocalEstadoBusiness getEstadoBusiness() {
		return estadoBusiness;
	}

	public void setEstadoBusiness(LocalEstadoBusiness estadoBusiness) {
		this.estadoBusiness = estadoBusiness;
	}

	public LocalCidadeBusiness getCidadeBusiness() {
		return cidadeBusiness;
	}

	public void setCidadeBusiness(LocalCidadeBusiness cidadeBusiness) {
		this.cidadeBusiness = cidadeBusiness;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public LazyBeneficiadoCollection getLista() {
		return lista;
	}

	public void setLista(LazyBeneficiadoCollection lista) {
		this.lista = lista;
	}

	public Event<BeneficiadoBean> getEvent() {
		return event;
	}

	public void setEvent(Event<BeneficiadoBean> event) {
		this.event = event;
	}

	public Beneficiado getBeneficiado() {
		return beneficiado;
	}

	public void setBeneficiado(Beneficiado beneficiado) {
		this.beneficiado = beneficiado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstadoCadastro() {
		return estadoCadastro;
	}

	public void setEstadoCadastro(Estado estadoCadastro) {
		this.estadoCadastro = estadoCadastro;
	}

	public boolean isNovoBeneficiado() {
		return novoBeneficiado;
	}

	public void setNovoBeneficiado(boolean novoBeneficiado) {
		this.novoBeneficiado = novoBeneficiado;
	}

	// ====================================METODOS====================================

	public void remover() {
		try {
			this.beneficiadoBusiness.remover(beneficiado);
			message.addInfo("Opera��o realizada com sucesso.", null);
			this.beneficiado = this.construirObjeto();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			message.addError(
					"N�o foi possivel completar a opera��o solicitada.", null);
		}
	}

	public void salvar() {
		try {
			this.beneficiadoBusiness.salvar(beneficiado);
			message.addInfo("Opera��o realizada com sucesso.", null);
			this.beneficiado = this.construirObjeto();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			message.addError(
					"N�o foi possivel completar a opera��o solicitada.", null);
		}
	}

	public void limpar() {
		this.beneficiado = this.construirObjeto();
		this.nome = null;
		this.rua = null;
		this.numero = null;
		this.bairro = null;
		this.cep = null;
		this.cidade = null;
		this.estado = null;
	}

	public void pesquisar() {
		event.select(new AnnotationLiteral<LazyDataObserve>() {
			private static final long serialVersionUID = 4271664556438849268L;
		}).fire(this);
	}

	public void limparPesquisa() {
		this.limpar();
		this.pesquisar();
	}

	public String getNomePanel() {
		return this.novoBeneficiado ? "Cadastrar Beneficiado"
				: "Editar Beneficiado";
	}

	public List<Estado> getEstados() {
		return this.estadoBusiness.listar();
	}

	public List<Cidade> getCidades() {
		return this.cidadeBusiness.listar(this.estadoCadastro);
	}

	public Beneficiado construirObjeto() {
		Beneficiado beneficiado = new Beneficiado();
		beneficiado.setContato(new Contato());
		beneficiado.setEndereco(new Endereco());
		return beneficiado;
	}

}
