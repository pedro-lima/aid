package br.com.aid.admin.converters;

import java.text.ParseException;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.swing.text.MaskFormatter;

@FacesConverter("TelefoneConverter")
public class TelefoneConverter implements Converter {

	public TelefoneConverter() {
		super();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return value.replace("(", "").replace(")", "").replace("-", "")
				.replace("_", "").replace(" ", "").trim();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String telefone = ((String) value).trim();
		if (component instanceof HtmlOutputText) {
			try {
				MaskFormatter mask = new MaskFormatter("(##) ####-####");
				mask.setValueContainsLiteralCharacters(false);
				return mask.valueToString(telefone);
			} catch (ParseException e) {
				throw new ConverterException(e);
			}
		} else {
			return telefone;
		}

	}

}
