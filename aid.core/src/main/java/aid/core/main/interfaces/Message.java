package aid.core.main.interfaces;

import java.io.Serializable;

public interface Message extends Serializable {
	public void mensagemAlert(String titulo, String mensagem);

	public void mensagemInfo(String titulo, String mensagem);

	public void mensagemErro(String titulo, String mensagem);

	public void mensagemFatal(String titulo, String mensagem);
}
