package aid.core.main.business;

import java.util.List;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.models.Descarte;

public class DescarteBusiness implements Business<Descarte> {
	private static final long serialVersionUID = -2880484862545761496L;

	public void salvar(Descarte obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void remover(Descarte obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void atualizar(Descarte obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public List<Descarte> listar() {
		throw new UnsupportedOperationException();
	}

	public Descarte buscar(Long id) {
		throw new UnsupportedOperationException();
	}

}
