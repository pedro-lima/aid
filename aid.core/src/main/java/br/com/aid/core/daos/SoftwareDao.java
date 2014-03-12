package br.com.aid.core.daos;

import java.util.List;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.enumerations.Ordenacao;
import br.com.aid.core.enumerations.TipoSoftware;
import br.com.aid.core.interfaces.dao.LocalSoftwareDao;
import br.com.aid.core.models.QHomologacao;
import br.com.aid.core.models.QSoftware;
import br.com.aid.core.models.Software;
import br.com.aid.core.tos.SoftwareTO;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.ConstructorExpression;

@Dao
public class SoftwareDao extends AbstractDao<Software> implements
		LocalSoftwareDao {

	private static final long serialVersionUID = -7436228260865006233L;

	public SoftwareDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	protected Class getClazz() {
		return Software.class;
	}

	public List<SoftwareTO> pesquisar(String marca, String modelo,
			String observacao, TipoSoftware tipo, Ordenacao ordenacao,
			String campoOrdenacao, int first, int maxResults) {

		JPAQuery query = new JPAQuery(this.getEm());

		QSoftware soft = QSoftware.software;
		QHomologacao hom = QHomologacao.homologacao;

		query = query.from(soft).leftJoin(soft.homologacoes, hom);

		query = this.filtrarPesquisa(marca, modelo, observacao, tipo, query, soft);

		query = query.groupBy(soft.marca, soft.modelo,
				soft.observacao, soft.tipo);
		
		query = this.ordenarPesquisa(ordenacao, campoOrdenacao, query, soft);

		List<SoftwareTO> lista = query
				.offset(first)
				.limit(maxResults)
				.list(ConstructorExpression.create(SoftwareTO.class, soft,
						hom.count()));

		return lista;
	}

	public long total(String marca, String modelo, String observacao,
			TipoSoftware tipo) {
		
		JPAQuery query = new JPAQuery(this.getEm());
		
		QSoftware soft = QSoftware.software;
		
		query = query.from(soft);
		query = filtrarPesquisa(marca, modelo, observacao, tipo, query, soft);
		
		return query.count();
		
	}

	private JPAQuery filtrarPesquisa(String marca, String modelo,
			String observacao, TipoSoftware tipo, JPAQuery query, QSoftware soft) {
		
		if (marca != null && !marca.trim().isEmpty()) {
			query = query.where(soft.marca.like("%" + marca + "%"));
		}

		if (modelo != null && !modelo.trim().isEmpty()) {
			query = query.where(soft.modelo.like("%" + modelo + "%"));
		}

		if (observacao != null && !observacao.trim().isEmpty()) {
			query = query.where(soft.observacao.like("%" + observacao + "%"));
		}

		if (tipo != null) {
			query = query.where(soft.tipo.eq(tipo));
		}
		
		return query;
	}

	private JPAQuery ordenarPesquisa(Ordenacao ordenacao,
			String campoOrdenacao, JPAQuery query, QSoftware soft) {

		if (campoOrdenacao != null && !campoOrdenacao.trim().isEmpty()) {
			switch (campoOrdenacao) {
			case "marca":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? soft.modelo
								.asc() : soft.modelo.desc());
			case "modelo":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? soft.marca
								.asc() : soft.marca.desc());
			case "tipo":
				return query
						.orderBy((ordenacao.equals(Ordenacao.ASC)) ? soft.tipo
								.asc() : soft.tipo.desc());
			default:
				return query;
			}
		} else {
			return query;
		}
	}

}
