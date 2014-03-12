package br.com.aid.core.produces;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.aid.core.annotations.ConfigResourceBundle;

public class ResourceBundleProducer {

	private final String PROPERTY_MISSING = "No resource bundle file found for: '{0}'";

	@Inject
	private FacesContext context;

	@Produces
	@ConfigResourceBundle
	public ResourceBundle createResourceBundle(InjectionPoint ip)
			throws IllegalStateException {

		ConfigResourceBundle param = ip.getAnnotated().getAnnotation(
				ConfigResourceBundle.class);

		try {
			ResourceBundle resource = ResourceBundle.getBundle(param.file(),
					context.getViewRoot().getLocale());
			return resource;
		} catch (NullPointerException | MissingResourceException e) {
			throw new IllegalStateException(MessageFormat.format(
					PROPERTY_MISSING, new Object[] { param.file() }));
		}

	}
}
