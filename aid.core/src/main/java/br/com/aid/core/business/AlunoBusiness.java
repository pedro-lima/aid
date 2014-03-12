package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalAlunoBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalAlunoDao;
import br.com.aid.core.models.Aluno;

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
