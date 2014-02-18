package aid.core.main.business;

import javax.inject.Inject;

import aid.core.main.annotations.Business;
import aid.core.main.interfaces.business.LocalHomologacaoBusiness;
import aid.core.main.interfaces.dao.Dao;
import aid.core.main.interfaces.dao.LocalHomologacaoDao;
import aid.core.main.models.Homologacao;

@Business
public class HomologacaoBusiness extends AbstracBusiness<Homologacao> implements
		LocalHomologacaoBusiness {
	private static final long serialVersionUID = -4406735515592464020L;
	@Inject
	private LocalHomologacaoDao dao;

	public HomologacaoBusiness() {
		super();
	}

	@Override
	protected Dao<Homologacao> getDao() {
		return this.dao;
	}

}
