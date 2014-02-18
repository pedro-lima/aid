package aid.admin.main.datamodels;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import aid.admin.main.interfaces.LazySoftwareCollection;
import aid.core.main.enumerations.Ordenacao;
import aid.core.main.enumerations.TipoSoftware;
import aid.core.main.interfaces.search.LazySoftwareSearchBusiness;
import aid.core.main.tos.SoftwareTO;

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

		Ordenacao order = (this.getLoadParans().getSortOrder()
				.equals(SortOrder.ASCENDING)) ? Ordenacao.ASC : Ordenacao.DESC;

		List<SoftwareTO> lista = this.business.pesquisar(this.getMarca(), this
				.getModelo(), this.getObservacao(), this.getTipo(), order, this
				.getLoadParans().getSortField(), this.getLoadParans()
				.getFirst(), this.getLoadParans().getPageSize());

		System.out.println(order);
		System.out.println(this.getLoadParans().getSortField());

		Long total = this.business.total(this.getMarca(), this.getModelo(),
				this.getObservacao(), this.getTipo());

		this.total = total.intValue();

		return lista;
	}

}
