package aid.admin.main.observers;

import java.io.Serializable;

import javax.enterprise.event.Observes;

import aid.admin.main.annotations.LazyDataObserve;
import aid.admin.main.beans.SoftwareBean;
import aid.admin.main.interfaces.LazySoftwareCollection;

public class SoftwareBeanObserver implements Serializable {

	private static final long serialVersionUID = -7820302406838235036L;

	public SoftwareBeanObserver() {
		super();
	}

	public void updateLazyDataModel(@Observes @LazyDataObserve SoftwareBean bean) {
		LazySoftwareCollection datamodel = bean.getLista();
		datamodel.setParametrosPesquisa(bean.getMarca(), bean.getModelo(),
				bean.getObservacao(), bean.getTipo());
	}

}
