package exceptions;

/**
 * Is thrown when a check of a {@link Number} for negative value takes effect.
 */
public class NegativeNumberException extends RuntimeException {

    /**
     * Constructs a {@code NegativeNumberException} with no detail message.
     */
    public NegativeNumberException() {
    }

    /**
     * Constructs a {@code NegativeNumberException} with a specified
     * detail message.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NegativeNumberException(String message) {
        super(message);
    }

}
