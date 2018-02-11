package exception;

public class InvalidGroupException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String ERROR_BASE = "Invalid argument sequence: ";

	public InvalidGroupException(String[] parameters) {
		super(ERROR_BASE + String.join(",", parameters));
	}

}
