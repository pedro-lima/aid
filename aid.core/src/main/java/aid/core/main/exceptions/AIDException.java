package aid.core.main.exceptions;

public class AIDException extends RuntimeException {

	private static final long serialVersionUID = 5522042263245805864L;

	public AIDException() {
		super();
	}

	public AIDException(String message, Throwable cause) {
		super(message, cause);
	}

	public AIDException(String message) {
		super(message);
	}

	public AIDException(Throwable cause) {
		super(cause);
	}

//	@Override
//	public String toString() {
//		return "AIDException [getMessage()=" + getMessage() + ", getCause()="
//				+ getCause() + ", getStackTrace()="
//				+ Arrays.toString(getStackTrace()) + ", getClass()="
//				+ getClass() + ", hashCode()=" + hashCode() + "]";
//	}

}
