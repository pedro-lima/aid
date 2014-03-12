package br.com.aid.core.daos;

import java.util.List;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalCidadeDao;
import br.com.aid.core.models.Cidade;
import br.com.aid.core.models.Estado;
import br.com.aid.core.models.QCidade;

import com.mysema.query.jpa.impl.JPAQuery;

@Dao
public class CidadeDao extends AbstractDao<Cidade> implements LocalCidadeDao {

	private static final long serialVersionUID = -1801068106663806929L;

	public CidadeDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class getClazz() {
		return Cidade.class;
	}

	@Override
	public List<Cidade> listar(Estado estado) {

		JPAQuery query = new JPAQuery(this.getEm());
		QCidade cid = QCidade.cidade;

		return query.from(cid).where(cid.estado.eq(estado)).list(cid);
	}

}
