package exceptions;

/**
 * Is thrown when a check of two objects gives a difference.
 */
public class IncompatibleClassException extends RuntimeException {
    /**
     * Constructs a {@code IncompatibleClassException} with no detail message.
     */
    public IncompatibleClassException() {
    }

    /**
     * Constructs a {@code IncompatibleClassException} with a specified
     * detail message.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public IncompatibleClassException(String message) {
        super(message);
    }
}
