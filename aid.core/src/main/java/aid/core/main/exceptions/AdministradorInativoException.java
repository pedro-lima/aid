package aid.core.main.exceptions;

public class AdministradorInativoException extends Exception {
	private static final long serialVersionUID = 1L;

	public AdministradorInativoException() {
		super();
	}

	public AdministradorInativoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AdministradorInativoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdministradorInativoException(String message) {
		super(message);
	}

	public AdministradorInativoException(Throwable cause) {
		super(cause);
	}

}
