package br.com.aid.core.daos;

import java.util.List;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.enumerations.Ordenacao;
import br.com.aid.core.interfaces.dao.LocalBeneficiadoDao;
import br.com.aid.core.models.Beneficiado;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;
import br.com.aid.core.models.QBeneficiado;
import br.com.aid.core.models.QDoacao;
import br.com.aid.core.tos.BeneficiadoTO;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.ConstructorExpression;

@Dao
public class BeneficiadoDao extends AbstractDao<Beneficiado> implements
		LocalBeneficiadoDao {
	
	private static final long serialVersionUID = 3799933776668849721L;

	public BeneficiadoDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Beneficiado.class;
	}

	@Override
	public List<BeneficiadoTO> pesquisar(String nome, String rua,
			String numero, String bairro, String cep, Cidade cidade,
			Estado estado, Ordenacao ordenacao, String campoOrdenacao,
			int first, int maxResults) {

		JPAQuery query = new JPAQuery(this.getEm());

		QBeneficiado ben = QBeneficiado.beneficiado;
		QDoacao doa = QDoacao.doacao;

		query = query.from(ben).leftJoin(ben.doacao, doa);

		query = this.filtrarPesquisa(nome, rua, numero, bairro, cep, cidade,
				estado, query, ben);

		query = this.ordenarPesquisa(ordenacao, campoOrdenacao, query, ben);

		List<BeneficiadoTO> lista = query
				.offset(first)
				.limit(maxResults)
				.list(ConstructorExpression.create(BeneficiadoTO.class, ben,
						doa.isNull()));

		return lista;
	}

	@Override
	public long total(String nome, String rua, String numero, String bairro,
			String cep, Cidade cidade, Estado estado) {

		JPAQuery query = new JPAQuery(this.getEm());

		QBeneficiado ben = QBeneficiado.beneficiado;
		
		query = query.from(ben);
		
		query = this.filtrarPesquisa(nome, rua, numero, bairro, cep, cidade,
				estado, query, ben);
		
		return query.count();
	}

	private JPAQuery ordenarPesquisa(Ordenacao ordenacao,
			String campoOrdenacao, JPAQuery query, QBeneficiado ben) {

		if (campoOrdenacao != null && !campoOrdenacao.trim().isEmpty()) {
			switch (campoOrdenacao) {
			case "nome":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? ben.nome
								.asc() : ben.nome.desc());
			case "rua":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? ben.endereco.rua
								.asc() : ben.endereco.rua.desc());
			case "numero":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? ben.endereco.numero
								.asc() : ben.endereco.numero.desc());

			case "bairro":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? ben.endereco.bairro
								.asc() : ben.endereco.bairro.desc());

			case "cidade":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? ben.endereco.cidade.nome
								.asc() : ben.endereco.cidade.nome.desc());

			case "estado":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? ben.endereco.cidade.estado.nome
								.asc() : ben.endereco.cidade.estado.nome.desc());

			default:
				return query;
			}
		} else {
			return query;
		}

	}

	private JPAQuery filtrarPesquisa(String nome, String rua, String numero,
			String bairro, String cep, Cidade cidade, Estado estado,
			JPAQuery query, QBeneficiado ben) {

		if (nome != null && !nome.trim().isEmpty()) {
			query = query.where(ben.nome.like("%" + nome + "%"));
		}

		if (rua != null && !rua.trim().isEmpty()) {
			query = query.where(ben.endereco.rua.like("%" + rua + "%"));
		}

		if (numero != null && !numero.trim().isEmpty()) {
			query = query.where(ben.endereco.numero.like("%" + numero + "%"));
		}

		if (bairro != null && !bairro.trim().isEmpty()) {
			query = query.where(ben.endereco.bairro.like("%" + bairro + "%"));
		}

		if (cep != null && !cep.trim().isEmpty()) {
			query = query.where(ben.endereco.cep.like("%" + cep + "%"));
		}

		if (cidade != null) {
			query = query.where(ben.endereco.cidade.eq(cidade));
		}

		if (estado != null) {
			query = query.where(ben.endereco.cidade.estado.eq(estado));
		}

		return query;
	}

}
