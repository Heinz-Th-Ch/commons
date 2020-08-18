package exceptions;

/**
 * Is thrown when a utility or special object class is constructed.
 */
public class IllegalInstantiationException extends RuntimeException {

    /**
     * Constructs a {@code IllegalInstantiationException} with no detail message.
     */
    public IllegalInstantiationException() {
    }

    /**
     * Constructs a {@code IllegalInstantiationException} with a specified
     * detail message.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public IllegalInstantiationException(String message) {
        super(message);
    }

}
