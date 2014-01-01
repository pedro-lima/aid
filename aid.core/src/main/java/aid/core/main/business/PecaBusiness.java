package aid.core.main.business;

import java.util.List;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.models.Peca;

public class PecaBusiness implements Business<Peca> {
	private static final long serialVersionUID = 8998525998074164237L;

	public void salvar(Peca obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void remover(Peca obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void atualizar(Peca obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public List<Peca> listar() {
		throw new UnsupportedOperationException();
	}

	public Peca buscar(Long id) {
		throw new UnsupportedOperationException();
	}

}
