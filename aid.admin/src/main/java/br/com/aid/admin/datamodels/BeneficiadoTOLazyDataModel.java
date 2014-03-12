package br.com.aid.admin.datamodels;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.com.aid.admin.interfaces.LazyBeneficiadoCollection;
import br.com.aid.core.interfaces.search.LazyBeneficiadoSearchBusiness;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;
import br.com.aid.core.tos.BeneficiadoTO;

@Alternative
public class BeneficiadoTOLazyDataModel extends
		AbstractLazyDataModel<BeneficiadoTO> implements
		LazyBeneficiadoCollection {

	private static final long serialVersionUID = -7555252762634516128L;

	private int total;

	private String nome;

	private String rua;

	private String numero;

	private String bairro;

	private String cep;

	private Cidade cidade;

	private Estado estado;

	@Inject
	private LazyBeneficiadoSearchBusiness business;

	public BeneficiadoTOLazyDataModel() {
		super();
		this.setParametrosPesquisa(null, null, null, null, null, null, null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LazyBeneficiadoSearchBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LazyBeneficiadoSearchBusiness business) {
		this.business = business;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public int getTotal() {
		return this.total;
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

	@Override
	public void setParametrosPesquisa(String nome, String rua, String numero,
			String bairro, String cep, Cidade cidade, Estado estado) {
		this.setNome(nome);
		this.setRua(rua);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCep(cep);
		this.setCidade(cidade);
		this.setEstado(estado);
	}

	@Override
	public List<BeneficiadoTO> pesquisar() {
		List<BeneficiadoTO> lista = this.business.pesquisar(this.getNome(),
				this.getRua(), this.getNumero(), this.getBairro(), this
						.getCep(), this.getCidade(), this.getEstado(), this
						.getLoadParans().getSortOrder(), this.getLoadParans()
						.getSortField(), this.getLoadParans().getFirst(), this
						.getLoadParans().getPageSize());

		Long total = this.business.total(this.getNome(), this.getRua(),
				this.getNumero(), this.getBairro(), this.getCep(),
				this.getCidade(), this.getEstado());

		this.total = total.intValue();

		return lista;
	}

}
