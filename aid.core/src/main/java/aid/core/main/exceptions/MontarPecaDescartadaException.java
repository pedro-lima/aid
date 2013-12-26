package aid.core.main.exceptions;

public class MontarPecaDescartadaException extends Exception {
	private static final long serialVersionUID = 1L;

	public MontarPecaDescartadaException() {
		super();
	}

	public MontarPecaDescartadaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
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
