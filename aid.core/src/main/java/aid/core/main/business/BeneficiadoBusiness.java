package aid.core.main.business;

import java.util.List;

import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.models.Beneficiado;

public class BeneficiadoBusiness implements Business<Beneficiado> {
	private static final long serialVersionUID = -6855915019804261955L;

	public void salvar(Beneficiado obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void remover(Beneficiado obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void atualizar(Beneficiado obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public List<Beneficiado> listar() {
		throw new UnsupportedOperationException();
	}

	public Beneficiado buscar(Long id) {
		throw new UnsupportedOperationException();
	}

}
