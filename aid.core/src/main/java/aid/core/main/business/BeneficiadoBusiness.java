package aid.core.main.business;

import java.util.List;
import aid.core.main.interfaces.LocalBeneficiadoBusiness;
import aid.core.main.models.Beneficiado;

public class BeneficiadoBusiness extends AbstracBusiness<Beneficiado> implements
		LocalBeneficiadoBusiness {
	private static final long serialVersionUID = -6855915019804261955L;

	public BeneficiadoBusiness() {
		super();
	}

	public List<Beneficiado> listar() {
		return this.getDao().listar("beneficiado.listAll");
	}

	@Override
	public Long getObjectKey(Beneficiado object) {
		return object.getId();
	}

}
