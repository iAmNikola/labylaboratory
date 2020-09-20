package exceptions;

public class BadInputException extends Exception{

	private static final long serialVersionUID = 3164085610475465560L;

	public BadInputException(String s) {
		super(s);
	}
}
