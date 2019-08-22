package broker.exception;

public class RecordNotFoundException extends Exception {

	public RecordNotFoundException() {
		super("This is RecordNotFoundException..");
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

}
