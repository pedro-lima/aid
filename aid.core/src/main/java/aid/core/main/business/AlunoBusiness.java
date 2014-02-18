package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalAlunoBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalAlunoDao;
import aid.core.main.models.Aluno;

@Business
public class AlunoBusiness extends AbstracBusiness<Aluno> implements
		LocalAlunoBusiness {
	private static final long serialVersionUID = 6889283625039167997L;
	@Inject
	private LocalAlunoDao dao;

	public AlunoBusiness() {
		super();
	}

	@Override
	protected Dao<Aluno> getDao() {
		return this.dao;
	}

}
