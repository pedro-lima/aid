package aid.core.main.interfaces;

import java.io.Serializable;

public interface Message extends Serializable {
	public void addAlert(String titulo, String mensagem);

	public void addInfo(String titulo, String mensagem);

	public void addError(String titulo, String mensagem);

	public void addFatal(String titulo, String mensagem);
}
