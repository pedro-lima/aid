package br.com.aid.core.business;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.interfaces.business.LocalMontagemBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalMontagemDao;
import br.com.aid.core.models.Montagem;

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
