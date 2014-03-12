package br.com.aid.core.business;

import java.util.List;

import javax.inject.Inject;

import br.com.aid.core.interfaces.business.LocalEstadoBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalEstadoDao;
import br.com.aid.core.models.Estado;

public class EstadoBusiness extends AbstracBusiness<Estado> implements
		LocalEstadoBusiness {

	private static final long serialVersionUID = -1923076670293097264L;

	@Inject
	private LocalEstadoDao dao;

	public EstadoBusiness() {
		super();
	}

	@Override
	protected Dao<Estado> getDao() {
		return this.dao;
	}

	@Override
	public List<Estado> listar() {
		return this.dao.listar();
	}	

}
