package br.com.aid.core.produces;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import br.com.aid.core.annotations.ConfigProperty;

public class ConfigPropertyProducer {
	
	private final String PROPERTY_MISSING = "No property file found for: '{0}'";

	@Produces
	@ConfigProperty
	public Properties createConfiguration(InjectionPoint ip)
			throws IllegalStateException {

		ConfigProperty param = ip.getAnnotated().getAnnotation(
				ConfigProperty.class);

		if (param.file() == null || param.file().trim().isEmpty()) {
			throw new IllegalStateException(MessageFormat.format(
					PROPERTY_MISSING, new Object[] { param.file() }));
		}

		try {

			Properties prop = new Properties();
			
			InputStream input = ConfigProperty.class.getClassLoader()
					.getResourceAsStream(param.file());

			if (input == null) {
				if (param.required()) {
					throw new IllegalStateException(MessageFormat.format(
							PROPERTY_MISSING, new Object[] { param.file() }));
				}
			}

			prop.load(input);

			return prop;

		} catch (IOException e) {
			throw new IllegalStateException(MessageFormat.format(
					PROPERTY_MISSING, new Object[] { param.file() }));
		}
	}
}
