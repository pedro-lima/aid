package br.com.aid.core.exceptions;

public class MontarPecaDescartadaException extends AIDException {
	private static final long serialVersionUID = 1L;

	public MontarPecaDescartadaException() {
		super();
	}

	public MontarPecaDescartadaException(String message, Throwable cause) {
		super(message, cause);
	}

	public MontarPecaDescartadaException(String message) {
		super(message);
	}

	public MontarPecaDescartadaException(Throwable cause) {
		super(cause);
	}

}
