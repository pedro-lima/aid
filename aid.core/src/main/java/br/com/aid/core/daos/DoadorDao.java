package br.com.aid.core.daos;

import java.util.List;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.enumerations.Ordenacao;
import br.com.aid.core.interfaces.dao.LocalDoadorDao;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Doador;
import br.com.aid.core.models.Estado;
import br.com.aid.core.models.QCidade;
import br.com.aid.core.models.QDoador;
import br.com.aid.core.models.QEndereco;
import br.com.aid.core.models.QEstado;
import br.com.aid.core.models.QPeca;
import br.com.aid.core.tos.DoadorTO;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.ConstructorExpression;

@Dao
public class DoadorDao extends AbstractDao<Doador> implements LocalDoadorDao {

	private static final long serialVersionUID = -1363082169283277564L;

	public DoadorDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Doador.class;
	}

	@Override
	public List<DoadorTO> pesquisar(String nome, String email, Cidade cidade,
			Estado estado, Ordenacao ordenacao, String campoOrdenacao,
			int first, int maxResults) {

		JPAQuery query = new JPAQuery(this.getEm());

		QDoador doa = QDoador.doador;
		QEndereco end = QEndereco.endereco;
		QCidade cid = QCidade.cidade;
		QEstado est = QEstado.estado;
		QPeca pec = QPeca.peca;

		query = query.from(doa).leftJoin(doa.pecas, pec);

		query = query.innerJoin(doa.endereco, end);

		query = query.innerJoin(end.cidade, cid);

		query = query.innerJoin(cid.estado, est);

		query = this.filtrarPesquisa(nome, email, cidade, estado, query, doa,
				end, cid, est);

		query = query.groupBy(doa.nome, doa.contato.email, end.rua, end.bairro,
				cid, est);

		query = this.ordenarPesquisa(ordenacao, campoOrdenacao, query, doa,
				cid, est);

		List<DoadorTO> lista = query
				.offset(first)
				.limit(maxResults)
				.list(ConstructorExpression.create(DoadorTO.class, doa,
						pec.count()));

		return lista;

	}

	@Override
	public long total(String nome, String email, Cidade cidade, Estado estado) {

		JPAQuery query = new JPAQuery(this.getEm());

		QDoador doa = QDoador.doador;
		QEndereco end = QEndereco.endereco;
		QCidade cid = QCidade.cidade;
		QEstado est = QEstado.estado;

		query = query.from(doa);

		query = query.innerJoin(doa.endereco, end);

		query = query.innerJoin(end.cidade, cid);

		query = query.innerJoin(cid.estado, est);

		query = this.filtrarPesquisa(nome, email, cidade, estado, query, doa,
				end, cid, est);

		return query.count();
	}

	private JPAQuery ordenarPesquisa(Ordenacao ordenacao,
			String campoOrdenacao, JPAQuery query, QDoador doa, QCidade cid,
			QEstado est) {

		if (campoOrdenacao != null && !campoOrdenacao.trim().isEmpty()) {
			switch (campoOrdenacao) {
			case "nome":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? doa.nome
								.asc() : doa.nome.desc());
			case "telefone":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? doa.contato.telefone
								.asc() : doa.contato.telefone.desc());
			case "email":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? doa.contato.email
								.asc() : doa.contato.email.desc());

			case "cidade":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? cid.nome
								.asc() : cid.nome.desc());

			case "estado":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? est.nome
								.asc() : est.nome.desc());
			default:
				return query;
			}
		} else {
			return query;
		}

	}

	private JPAQuery filtrarPesquisa(String nome, String email, Cidade cidade,
			Estado estado, JPAQuery query, QDoador doa, QEndereco end,
			QCidade cid, QEstado est) {

		if (nome != null && !nome.trim().isEmpty()) {
			query = query.where(doa.nome.like("%" + nome + "%"));
		}

		if (email != null && !email.trim().isEmpty()) {
			query = query.where(doa.contato.email.like("%" + email + "%"));
		}

		if (cidade != null) {
			query = query.where(cid.eq(cidade));
		}

		if (estado != null) {
			query = query.where(est.eq(estado));
		}

		return query;
	}

}
