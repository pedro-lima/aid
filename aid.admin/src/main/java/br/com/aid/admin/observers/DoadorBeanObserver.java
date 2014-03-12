package br.com.aid.admin.observers;

import java.io.Serializable;

import javax.enterprise.event.Observes;

import br.com.aid.admin.annotations.LazyDataObserve;
import br.com.aid.admin.beans.DoadorBean;
import br.com.aid.admin.interfaces.LazyDoadorCollection;

public class DoadorBeanObserver implements Serializable {

	private static final long serialVersionUID = 1309109266346672912L;

	public DoadorBeanObserver() {
		super();
	}

	public void updateLazyDataModel(@Observes @LazyDataObserve DoadorBean bean) {
		LazyDoadorCollection datamodel = bean.getLista();
		datamodel.setParametrosPesquisa(bean.getDoadorPesquisa().getNome(),
				bean.getDoadorPesquisa().getEmail(), bean.getDoadorPesquisa()
						.getCidade(), bean.getDoadorPesquisa().getEstado());
	}

}
