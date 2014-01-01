package aid.core.main.business;

import java.util.List;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.models.Administrador;

public class AdministradorBusiness implements Business<Administrador> {
	private static final long serialVersionUID = -6046015758550676516L;

	public void salvar(Administrador obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void remover(Administrador obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void atualizar(Administrador obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public List<Administrador> listar() {
		throw new UnsupportedOperationException();
	}

	public Administrador buscar(Long id) {
		throw new UnsupportedOperationException();
	}

}
