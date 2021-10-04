package exceptions;

/**
 * Is thrown when a selected function is <b>NOT yet</b> implemented.
 */
public class FunctionNotImplementedException extends RuntimeException {

    /**
     * Constructs a {@code FunctionNotImplementedException} with no detail message.
     */
    public FunctionNotImplementedException() {
    }

    /**
     * Constructs a {@code FunctionNotImplementedException} with a specific
     * detail message.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public FunctionNotImplementedException(String message) {
        super(message);
    }

}
