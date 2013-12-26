package aid.core.main.exceptions;

public class CRUDException extends Exception {
	private static final long serialVersionUID = 1L;

	public CRUDException() {
		super();
	}

	public CRUDException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CRUDException(String message, Throwable cause) {
		super(message, cause);
	}

	public CRUDException(String message) {
		super(message);
	}

	public CRUDException(Throwable cause) {
		super(cause);
	}
	
}
