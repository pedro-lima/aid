package br.com.aid.admin.converters;

import java.text.ParseException;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.swing.text.MaskFormatter;

@FacesConverter("CepConverter")
public class CepConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return value.replace("-", "").replace("_", "").replace(".", "")
				.replace(" ", "").trim();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String cep = ((String) value).trim();
		if (component instanceof HtmlOutputText) {
			try {

				MaskFormatter mask = new MaskFormatter("##.###-###");
				mask.setValueContainsLiteralCharacters(false);
				return mask.valueToString(cep);
			} catch (ParseException e) {
				throw new ConverterException(e);
			}
		} else {
			return cep;
		}

	}

}
