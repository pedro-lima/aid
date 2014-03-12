package br.com.aid.admin.datamodels;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import br.com.aid.admin.interfaces.LazySoftwareCollection;
import br.com.aid.core.enumerations.TipoSoftware;
import br.com.aid.core.interfaces.search.LazySoftwareSearchBusiness;
import br.com.aid.core.tos.SoftwareTO;

@Alternative
public class SoftwareTOLazyDataModel extends AbstractLazyDataModel<SoftwareTO>
		implements LazySoftwareCollection {

	private static final long serialVersionUID = -7523447216149926607L;

	private int total;

	private String marca;

	private String modelo;

	private String observacao;

	private TipoSoftware tipo;

	@Inject
	private LazySoftwareSearchBusiness business;

	public SoftwareTOLazyDataModel() {
		super();
		this.setParametrosPesquisa(null, null, null, null);
	}

	public int getTotal() {
		return total;
	}

	public LazySoftwareSearchBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LazySoftwareSearchBusiness business) {
		this.business = business;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoSoftware getTipo() {
		return tipo;
	}

	public void setTipo(TipoSoftware tipo) {
		this.tipo = tipo;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public void setParametrosPesquisa(String marca, String modelo,
			String observacao, TipoSoftware tipo) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setObservacao(observacao);
		this.setTipo(tipo);
	}

	@Override
	public List<SoftwareTO> pesquisar() {

		List<SoftwareTO> lista = this.business.pesquisar(this.getMarca(), this
				.getModelo(), this.getObservacao(), this.getTipo(), this
				.getLoadParans().getSortOrder(), this.getLoadParans()
				.getSortField(), this.getLoadParans().getFirst(), this
				.getLoadParans().getPageSize());

		Long total = this.business.total(this.getMarca(), this.getModelo(),
				this.getObservacao(), this.getTipo());

		this.total = total.intValue();

		return lista;
	}

}
