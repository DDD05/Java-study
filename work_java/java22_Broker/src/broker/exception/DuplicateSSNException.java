package broker.exception;

public class DuplicateSSNException extends Exception {
	public DuplicateSSNException() {
		super("This is DuplicateSSNException...");
	}
	public DuplicateSSNException(String message) {
		super(message);
	}
}
