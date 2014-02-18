package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalMontagemBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalMontagemDao;
import aid.core.main.models.Montagem;

@Business
public class MontagemBusiness extends AbstracBusiness<Montagem> implements
		LocalMontagemBusiness {
	private static final long serialVersionUID = -7155454345123708665L;
	@Inject
	private LocalMontagemDao dao;

	public MontagemBusiness() {
		super();
	}

	@Override
	protected Dao<Montagem> getDao() {
		return this.dao;
	}

}
