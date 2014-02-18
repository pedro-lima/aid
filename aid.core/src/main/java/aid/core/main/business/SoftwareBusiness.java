package aid.core.main.business;

import java.util.List;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.enumerations.Ordenacao;
import aid.core.main.enumerations.TipoSoftware;
import aid.core.main.interfaces.business.LocalSoftwareBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalSoftwareDao;
import aid.core.main.interfaces.search.LazySoftwareSearchBusiness;
import aid.core.main.models.Software;
import aid.core.main.tos.SoftwareTO;

@Business
public class SoftwareBusiness extends AbstracBusiness<Software> implements
		LocalSoftwareBusiness, LazySoftwareSearchBusiness {
	private static final long serialVersionUID = 1674493130437643508L;
	@Inject
	private LocalSoftwareDao dao;

	public SoftwareBusiness() {
		super();
	}

	@Override
	protected Dao<Software> getDao() {
		return this.dao;
	}

	public List<SoftwareTO> pesquisar(String marca, String modelo,
			String observacao, TipoSoftware tipo, Ordenacao ordenacao,
			String campoOrdenacao, int first, int maxResults) {
		return this.dao.pesquisar(marca, modelo, observacao, tipo, ordenacao,
				campoOrdenacao, first, maxResults);
	}

	public long total(String marca, String modelo, String observacao,
			TipoSoftware tipo) {
		return this.dao.total(marca, modelo, observacao, tipo);
	}

}
