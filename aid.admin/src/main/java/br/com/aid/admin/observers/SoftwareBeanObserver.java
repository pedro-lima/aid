package br.com.aid.admin.observers;

import java.io.Serializable;

import javax.enterprise.event.Observes;

import br.com.aid.admin.annotations.LazyDataObserve;
import br.com.aid.admin.beans.SoftwareBean;
import br.com.aid.admin.interfaces.LazySoftwareCollection;

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
