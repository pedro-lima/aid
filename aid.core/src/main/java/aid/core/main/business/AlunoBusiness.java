package aid.core.main.business;

import java.util.List;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.models.Aluno;

public class AlunoBusiness implements Business<Aluno> {
	private static final long serialVersionUID = 6889283625039167997L;

	public void salvar(Aluno obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void remover(Aluno obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void atualizar(Aluno obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public List<Aluno> listar() {
		throw new UnsupportedOperationException();
	}

	public Aluno buscar(Long id) {
		throw new UnsupportedOperationException();
	}

}
