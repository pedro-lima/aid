package aid.core.main.business;

import java.util.List;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.Business;
import aid.core.main.models.Professor;

public class ProfessorBusiness implements Business<Professor> {
	private static final long serialVersionUID = 2999076029877744444L;

	public void salvar(Professor obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void remover(Professor obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public void atualizar(Professor obj) throws CRUDException {
		throw new UnsupportedOperationException();
	}

	public List<Professor> listar() {
		throw new UnsupportedOperationException();
	}

	public Professor buscar(Long id) {
		throw new UnsupportedOperationException();
	}

}
