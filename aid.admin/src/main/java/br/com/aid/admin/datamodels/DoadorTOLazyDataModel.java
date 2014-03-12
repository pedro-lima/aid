package br.com.aid.admin.datamodels;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.com.aid.admin.interfaces.LazyDoadorCollection;
import br.com.aid.core.interfaces.search.LazyDoadorSearchBusiness;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;
import br.com.aid.core.tos.DoadorTO;

@Alternative
public class DoadorTOLazyDataModel extends AbstractLazyDataModel<DoadorTO>
		implements LazyDoadorCollection {

	private static final long serialVersionUID = 4271246044787273346L;

	private int total;

	private String nome;

	private String email;

	private Cidade cidade;

	private Estado estado;

	@Inject
	private LazyDoadorSearchBusiness business;

	public DoadorTOLazyDataModel() {
		super();
		this.setParametrosPesquisa(null, null, null, null);
	}

	@Override
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	public LazyDoadorSearchBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LazyDoadorSearchBusiness business) {
		this.business = business;
	}

	@Override
	public void setParametrosPesquisa(String nome, String email, Cidade cidade,
			Estado estado) {
		this.setNome(nome);
		this.setEmail(email);
		this.setCidade(cidade);
		this.setEstado(estado);
	}

	@Override
	public List<DoadorTO> pesquisar() {

		List<DoadorTO> lista = this.business.pesquisar(this.getNome(), this
				.getEmail(), this.getCidade(), this.getEstado(), this
				.getLoadParans().getSortOrder(), this.getLoadParans()
				.getSortField(), this.getLoadParans().getFirst(), this
				.getLoadParans().getPageSize());

		Long total = this.business.total(this.getNome(), this.getEmail(),
				this.getCidade(), this.getEstado());

		this.total = total.intValue();

		return lista;
	}

}
