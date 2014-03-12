package br.com.aid.admin.observers;

import java.io.Serializable;

import javax.enterprise.event.Observes;

import br.com.aid.admin.annotations.LazyDataObserve;
import br.com.aid.admin.beans.BeneficiadoBean;
import br.com.aid.admin.interfaces.LazyBeneficiadoCollection;

public class BeneficiadoBeanObserver implements Serializable {

	private static final long serialVersionUID = -4054376359361794485L;

	public BeneficiadoBeanObserver() {
		super();
	}

	public void updateLazyDataModel(
			@Observes @LazyDataObserve BeneficiadoBean bean) {
		LazyBeneficiadoCollection datamodel = bean.getLista();
		datamodel.setParametrosPesquisa(bean.getNome(), bean.getRua(),
				bean.getNumero(), bean.getBairro(), bean.getCep(),
				bean.getCidade(), bean.getEstado());
	}

}
