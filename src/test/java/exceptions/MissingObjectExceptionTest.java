package exceptions;

import abstracts.AbstractPlainJava;
import org.junit.Test;

/**
 * JUnit test for {@link MissingObjectException}.
 */
public class MissingObjectExceptionTest extends AbstractPlainJava {

    private static final String TEST_MESSAGE = "TEST_MESSAGE";

    @Test
    public void getWithMessage() {
        try {
            throw new MissingObjectException(TEST_MESSAGE);
        } catch (MissingObjectException ex) {
            assertEquals("expected message not received", TEST_MESSAGE, ex.getMessage());
        }
    }

    @Test
    public void getWithoutMessage() {
        try {
            throw new MissingObjectException();
        } catch (MissingObjectException ex) {
            assertNull(ex.getMessage());
        }
    }

}