package exceptions;

import abstracts.AbstractPlainJava;
import org.junit.Test;

/**
 * JUnit test for {@link IncompatibleClassException}.
 */
public class IncompatibleClassExceptionTest extends AbstractPlainJava {

    private static final String TEST_MESSAGE = "TEST_MESSAGE";

    @Test
    public void getWithMessage() {
        try {
            throw new IncompatibleClassException(TEST_MESSAGE);
        } catch (IncompatibleClassException ex) {
            assertEquals("expected message not received", TEST_MESSAGE, ex.getMessage());
        }
    }

    @Test
    public void getWithoutMessage() {
        try {
            throw new IncompatibleClassException();
        } catch (IncompatibleClassException ex) {
            assertNull(ex.getMessage());
        }
    }

}