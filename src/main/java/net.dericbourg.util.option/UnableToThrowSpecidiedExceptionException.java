package net.dericbourg.util.option;

public class UnableToThrowSpecidiedExceptionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnableToThrowSpecidiedExceptionException(Throwable e) {
        super(e);
    }

    public UnableToThrowSpecidiedExceptionException(String message, Throwable e) {
        super(message, e);
    }
}
