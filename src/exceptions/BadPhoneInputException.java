package exceptions;

public class BadPhoneInputException extends Exception {

	private static final long serialVersionUID = -909023879741517664L;

	public BadPhoneInputException(String s) {
		super(s);
	}
}
