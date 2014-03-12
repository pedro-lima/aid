package br.com.aid.core.business;

import java.util.List;

import javax.inject.Inject;

import br.com.aid.core.annotations.Business;
import br.com.aid.core.enumerations.Ordenacao;
import br.com.aid.core.interfaces.business.LocalBeneficiadoBusiness;
import br.com.aid.core.interfaces.dao.Dao;
import br.com.aid.core.interfaces.dao.LocalBeneficiadoDao;
import br.com.aid.core.interfaces.search.LazyBeneficiadoSearchBusiness;
import br.com.aid.core.models.Beneficiado;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;
import br.com.aid.core.tos.BeneficiadoTO;

@Business
public class BeneficiadoBusiness extends AbstracBusiness<Beneficiado> implements
		LocalBeneficiadoBusiness, LazyBeneficiadoSearchBusiness {

	private static final long serialVersionUID = -6855915019804261955L;

	@Inject
	private LocalBeneficiadoDao dao;

	public BeneficiadoBusiness() {
		super();
	}

	@Override
	protected Dao<Beneficiado> getDao() {
		return this.dao;
	}

	@Override
	public List<BeneficiadoTO> pesquisar(String nome, String rua,
			String numero, String bairro, String cep, Cidade cidade,
			Estado estado, Ordenacao ordenacao, String campoOrdenacao,
			int first, int maxResults) {
		return this.dao.pesquisar(nome, rua, numero, bairro, cep, cidade,
				estado, ordenacao, campoOrdenacao, first, maxResults);
	}

	@Override
	public long total(String nome, String rua, String numero, String bairro,
			String cep, Cidade cidade, Estado estado) {
		return this.dao.total(nome, rua, numero, bairro, cep, cidade, estado);
	}

}
