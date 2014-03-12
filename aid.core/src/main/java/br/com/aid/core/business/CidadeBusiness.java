package br.com.aid.core.business;

import java.util.List;

import javax.inject.Inject;

import br.com.aid.core.interfaces.business.LocalCidadeBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalCidadeDao;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;

public class CidadeBusiness extends AbstracBusiness<Cidade> implements
		LocalCidadeBusiness {

	private static final long serialVersionUID = 4141858138300952165L;

	@Inject
	private LocalCidadeDao dao;

	public CidadeBusiness() {
		super();
	}

	@Override
	protected Dao<Cidade> getDao() {
		return this.dao;
	}

	@Override
	public List<Cidade> listar(Estado estado) {
		return this.dao.listar(estado);
	}

}
