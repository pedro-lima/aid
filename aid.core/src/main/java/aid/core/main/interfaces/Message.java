package aid.core.main.interfaces;

public interface Message {
	public void mensagemAlert(String titulo, String mensagem);

	public void mensagemInfo(String titulo, String mensagem);

	public void mensagemErro(String titulo, String mensagem);

	public void mensagemFatal(String titulo, String mensagem);
}
