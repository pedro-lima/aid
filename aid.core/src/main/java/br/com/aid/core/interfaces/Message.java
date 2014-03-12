package br.com.aid.core.interfaces;

import java.io.Serializable;

public interface Message extends Serializable {

	public void addAlert(String mensagem);

	public void addAlert(String mensagem, String detalhe);

	public void addInfo(String mensagem);

	public void addInfo(String mensagem, String detalhe);

	public void addError(String mensagem);

	public void addError(String mensagem, String detalhe);

	public void addFatal(String mensagem);

	public void addFatal(String mensagem, String detalhe);
}
