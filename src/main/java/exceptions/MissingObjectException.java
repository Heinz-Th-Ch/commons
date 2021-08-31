package exceptions;

/**
 * Is thrown when a check of an expected {@link Object} fails.
 */
public class MissingObjectException extends RuntimeException {

    /**
     * Constructs a {@code MissingObjectException} with no detail message.
     */
    public MissingObjectException() {
    }

    /**
     * Constructs a {@code MissingObjectException} with a specified
     * detail message.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MissingObjectException(String message) {
        super(message);
    }
}
