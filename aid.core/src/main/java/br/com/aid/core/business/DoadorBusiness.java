package br.com.aid.core.business;

import java.util.List;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.enumerations.Ordenacao;
import br.com.aid.core.interfaces.business.LocalDoadorBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalDoadorDao;
import br.com.aid.core.interfaces.search.LazyDoadorSearchBusiness;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Doador;
import br.com.aid.core.models.Estado;
import br.com.aid.core.tos.DoadorTO;

@Business
public class DoadorBusiness extends AbstracBusiness<Doador> implements
		LocalDoadorBusiness, LazyDoadorSearchBusiness {

	private static final long serialVersionUID = 8885532470965861258L;

	@Inject
	private LocalDoadorDao dao;

	public DoadorBusiness() {
		super();
	}

	@Override
	protected Dao<Doador> getDao() {
		return this.dao;
	}

	@Override
	public List<DoadorTO> pesquisar(String nome, String email, Cidade cidade,
			Estado estado, Ordenacao ordenacao, String campoOrdenacao,
			int first, int maxResults) {
		return this.dao.pesquisar(nome, email, cidade, estado, ordenacao,
				campoOrdenacao, first, maxResults);
	}

	@Override
	public long total(String nome, String email, Cidade cidade, Estado estado) {
		return this.dao.total(nome, email, cidade, estado);
	}

}
