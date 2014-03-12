package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalProfessorBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalProfessorDao;
import br.com.aid.core.models.Professor;

@Business
public class ProfessorBusiness extends AbstracBusiness<Professor> implements
		LocalProfessorBusiness {
	
	private static final long serialVersionUID = 2999076029877744444L;
	
	@Inject
	private LocalProfessorDao dao;

	public ProfessorBusiness() {
		super();
	}

	@Override
	protected Dao<Professor> getDao() {
		return this.dao;
	}

}
