package exceptions;

import abstracts.AbstractPlainJava;
import org.junit.Test;

/**
 * JUnit test for {@link IllegalInstantiationException}.
 */
public class IllegalInstantiationExceptionTest extends AbstractPlainJava {

    private static final String TEST_MESSAGE = "TEST_MESSAGE";

    @Test
    public void getWithMessage() {
        try {
            throw new IllegalInstantiationException(TEST_MESSAGE);
        } catch (IllegalInstantiationException ex) {
            assertEquals("expected message not received",TEST_MESSAGE,ex.getMessage());
        }
    }

    @Test
    public void getWithoutMessage() {
        try {
            throw new IllegalInstantiationException();
        } catch (IllegalInstantiationException ex) {
            assertNull(ex.getMessage());
        }
    }

}