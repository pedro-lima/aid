package br.com.aid.core.daos;

import java.util.List;

import br.com.aid.core.annotations.Dao;
import br.com.aid.core.interfaces.dao.LocalEstadoDao;
import br.com.aid.core.models.Estado;
import br.com.aid.core.models.QEstado;

import com.mysema.query.jpa.impl.JPAQuery;

@Dao
public class EstadoDao extends AbstractDao<Estado> implements LocalEstadoDao {
	
	private static final long serialVersionUID = -6874543554662770727L;

	public EstadoDao() {
		super();
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getClazz() {
		return Estado.class;
	}

	@Override
	public List<Estado> listar() {
		
		JPAQuery query = new JPAQuery(this.getEm());
		
		QEstado est = QEstado.estado;		
		
		return query.from(est).list(est);
	}

}
