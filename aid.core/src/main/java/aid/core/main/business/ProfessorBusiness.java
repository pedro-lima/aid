package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalProfessorBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalProfessorDao;
import aid.core.main.models.Professor;

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
