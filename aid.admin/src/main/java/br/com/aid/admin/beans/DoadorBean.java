package br.com.aid.admin.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.aid.admin.interfaces.LazyDoadorCollection;
import br.com.aid.core.interfaces.business.Business;
import br.com.aid.core.interfaces.business.LocalCidadeBusiness;
import br.com.aid.core.interfaces.business.LocalDoadorBusiness;
import br.com.aid.core.interfaces.business.LocalEstadoBusiness;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Contato;
import br.com.aid.core.models.Doador;
import br.com.aid.core.models.Endereco;
import br.com.aid.core.models.Estado;

@Named
@ViewScoped
public class DoadorBean extends AbstractBean<Doador, DoadorBean> implements
		Serializable {

	private static final long serialVersionUID = 490967361912890650L;

	@Inject
	private LocalDoadorBusiness doadorBusiness;

	@Inject
	private LocalEstadoBusiness estadoBusiness;

	@Inject
	private LocalCidadeBusiness cidadeBusiness;

	@Inject
	private LazyDoadorCollection lista;

	private Doador doador;

	private DoadorPesquisa doadorPesquisa;

	private transient List<Estado> estados;

	private transient List<Cidade> cidadesPesquisa;

	private transient List<Cidade> cidadesCadastro;

	public DoadorBean() {
		super();
	}

	@PostConstruct
	public void init() {
		this.estados = this.listarEstados();
		this.limparPesquisa();
	}

	// ====================================GET/SET====================================

	public LocalDoadorBusiness getDoadorBusiness() {
		return doadorBusiness;
	}

	public void setDoadorBusiness(LocalDoadorBusiness doadorBusiness) {
		this.doadorBusiness = doadorBusiness;
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

	public LazyDoadorCollection getLista() {
		return lista;
	}

	public void setLista(LazyDoadorCollection lista) {
		this.lista = lista;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public DoadorPesquisa getDoadorPesquisa() {
		return doadorPesquisa;
	}

	public void setDoadorPesquisa(DoadorPesquisa doadorPesquisa) {
		this.doadorPesquisa = doadorPesquisa;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidadesPesquisa() {
		return cidadesPesquisa;
	}

	public void setCidadesPesquisa(List<Cidade> cidadesPesquisa) {
		this.cidadesPesquisa = cidadesPesquisa;
	}

	public List<Cidade> getCidadesCadastro() {
		return cidadesCadastro;
	}

	public void setCidadesCadastro(List<Cidade> cidadesCadastro) {
		this.cidadesCadastro = cidadesCadastro;
	}

	// ====================================METODOS====================================

	public void limparPesquisa() {
		this.cidadesPesquisa = null;
		this.doadorPesquisa = new DoadorPesquisa();
		this.pesquisar();
	}

	public String getNomePanel() {
		return this.getOperacao().equals(ControllerOperacao.Editar) ? this
				.getResource().getString("doador_editar") : this.getResource()
				.getString("doador_cadastrar");
	}

	public List<Estado> listarEstados() {
		return this.estadoBusiness.listar();
	}

	public void listarCidadesCadastro() {
		if (this.doador != null && this.doador.getEndereco() != null
				&& this.doador.getEndereco().getCidade() != null
				&& this.doador.getEndereco().getCidade().getEstado() != null) {
			this.cidadesCadastro = this.cidadeBusiness.listar(this.doador
					.getEndereco().getCidade().getEstado());
		} else {
			this.cidadesCadastro = null;
		}
	}

	public void listarCidadesPesquisa() {
		if (this.doadorPesquisa.getEstado() != null) {
			this.cidadesPesquisa = this.cidadeBusiness
					.listar(this.doadorPesquisa.getEstado());
		} else {
			this.cidadesPesquisa = null;
		}
		this.doadorPesquisa.setCidade(null);
	}

	public void prepararCadastro() {
		this.doador = construirObjeto();
	}

	public Doador construirObjeto() {
		Doador doador = new Doador();
		doador.setContato(new Contato());
		Endereco endereco = new Endereco();
		this.cidadesCadastro = this.cidadeBusiness.listar(estados.get(0));
		endereco.setCidade(this.cidadesCadastro.get(0));
		doador.setEndereco(endereco);
		return doador;
	}

	public void prepararEdicaoDoador() {		
		this.cidadesCadastro = this.cidadeBusiness.listar(this.doador
				.getEndereco().getCidade().getEstado());
	}

	public void limpar() {
		this.doador = null;
	}

	// ====================================CLASSES====================================

	public class DoadorPesquisa implements Serializable {

		private static final long serialVersionUID = -8962622952329612718L;

		private String nome;

		private String email;

		private Cidade cidade;

		private Estado estado;

		public DoadorPesquisa() {
			super();
		}

		public DoadorPesquisa(String nome, String email, Cidade cidade,
				Estado estado) {
			super();
			this.nome = nome;
			this.email = email;
			this.cidade = cidade;
			this.estado = estado;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
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

	}

	// ===============================METODOS_ABSTRATOS=================================

	@Override
	public Doador getModel() {
		return this.doador;
	}

	@Override
	public Business<Doador> getBusiness() {
		return this.doadorBusiness;
	}

	@Override
	public void limparModel() {
		this.prepararCadastro();
	}

}
