package net.dericbourg.util.option;

/**
 * Exception thrown when {@link Option}.getValueOrThrowException is called but
 * specified exception could not be thrown.
 * 
 * @author adericbourg
 * 
 */
public class UnableToThrowSpecifiedExceptionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new UnableToThrowSpecifiedExceptionException exception with
	 * cause exception.
	 * 
	 * @param e Cause.
	 */
	public UnableToThrowSpecifiedExceptionException(Throwable e) {
		super(e);
	}

	/**
	 * Constructs a new UnableToThrowSpecifiedExceptionException with a cause
	 * exception and a detail message.
	 * 
	 * @param message Detail message.
	 * @param e Cause.
	 */
	public UnableToThrowSpecifiedExceptionException(String message, Throwable e) {
		super(message, e);
	}
}
