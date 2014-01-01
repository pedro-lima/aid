package aid.core.main.business;

import java.util.List;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.models.Doacao;

public class DoacaoBusiness implements Business<Doacao> {
	private static final long serialVersionUID = 807834398370705713L;

	public void salvar(Doacao obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void remover(Doacao obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void atualizar(Doacao obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public List<Doacao> listar() {
		throw new UnsupportedOperationException();
	}

	public Doacao buscar(Long id) {
		throw new UnsupportedOperationException();
	}

}
