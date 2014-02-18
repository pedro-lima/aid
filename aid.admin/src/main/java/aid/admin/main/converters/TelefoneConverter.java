package aid.admin.main.converters;

import java.text.ParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.swing.text.MaskFormatter;

@FacesConverter("TelefoneConverter")
public class TelefoneConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		String telefone = value.replace("(", "").replace(")", "")
				.replace("-", "").replace("_", "").replace(" ", "").trim();
		return telefone;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		try {
			String telefone = (String) value;
			MaskFormatter mask = new MaskFormatter("(##)####-####");
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(telefone);
		} catch (ParseException e) {
			throw new ConverterException(e);
		}
	}

}
