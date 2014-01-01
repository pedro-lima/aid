package aid.core.main.business;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;
import aid.core.main.exceptions.CRUDException;
import aid.core.main.interfaces.LocalSoftwareBusiness;
import aid.core.main.interfaces.LocalSoftwareDao;
import aid.core.main.models.Software;

public class SoftwareBusiness implements LocalSoftwareBusiness {
	private static final long serialVersionUID = 1674493130437643508L;
	@Inject
	private LocalSoftwareDao dao;
	@Inject
	private Logger log;

	public void salvar(Software obj) throws CRUDException {
		try {
			this.dao.salvar(obj);
		} catch (Exception ex) {
			log.error(ex);
			throw new CRUDException(ex);
		}
	}

	public void remover(Software obj) throws CRUDException {
		try {			
			this.dao.remover(this.dao.buscar(obj.getId()));			
		} catch (Exception ex) {
			log.error(ex);
			throw new CRUDException(ex);
		}
	}

	public void atualizar(Software obj) throws CRUDException {
		try {
			this.dao.atualizar(obj);
		} catch (Exception ex) {
			log.error(ex);
			throw new CRUDException(ex);
		}
	}

	public List<Software> listar() {
		return dao.listar("software.listAll.new");
	}

	public Software buscar(Long id) {
		try {
			return this.dao.buscar(id);
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	public boolean isDelete(Long id) {
		return this.dao.countHomologacoes(id) == 0;
	}	

}
