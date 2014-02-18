package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalBeneficiadoBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalBeneficiadoDao;
import aid.core.main.models.Beneficiado;

@Business
public class BeneficiadoBusiness extends AbstracBusiness<Beneficiado> implements
		LocalBeneficiadoBusiness {
	private static final long serialVersionUID = -6855915019804261955L;
	@Inject
	private LocalBeneficiadoDao dao;

	public BeneficiadoBusiness() {
		super();
	}

	@Override
	protected Dao<Beneficiado> getDao() {
		return this.dao;
	}

}
