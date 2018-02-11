package exception;

public class UnsupportedCommandException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String ERROR_BASE = "Invalid command: ";
	
	public UnsupportedCommandException(String command) {
		super(ERROR_BASE + command);
	}

}
