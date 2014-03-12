package br.com.aid.admin.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.aid.core.interfaces.business.LocalEstadoBusiness;
import br.com.aid.core.models.Estado;

@FacesConverter("EstadoConverter")
public class EstadoConverter implements Converter {

	@Inject
	private LocalEstadoBusiness business;

	@Inject
	private transient Logger log;

	public EstadoConverter() {
		super();
	}

	public LocalEstadoBusiness getBusiness() {
		return business;
	}

	public void setBusiness(LocalEstadoBusiness business) {
		this.business = business;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.trim().isEmpty()) {
			try {
				Long id = Long.parseLong(value);
				return this.business.buscar(id);
			} catch (NumberFormatException ex) {
				return null;
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				FacesMessage msg = new FacesMessage(
						"Ocorreu um erro ao converter o estado.", null);
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ConverterException(msg);
			}
		} else {
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null) {
			return null;
		} else {
			return ((Estado) (value)).getId().toString();
		}

	}

}
