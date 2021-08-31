package exceptions;

import abstracts.AbstractPlainJava;
import org.junit.Test;

/**
 * JUnit test for {@link NegativeNumberException}.
 */
public class NegativeNumberExceptionTest extends AbstractPlainJava {

    private static final String TEST_MESSAGE = "TEST_MESSAGE";

    @Test
    public void getWithMessage() {
        try {
            throw new NegativeNumberException(TEST_MESSAGE);
        } catch (NegativeNumberException ex) {
            assertEquals("expected message not received",TEST_MESSAGE,ex.getMessage());
        }
    }

    @Test
    public void getWithoutMessage() {
        try {
            throw new NegativeNumberException();
        } catch (NegativeNumberException ex) {
            assertNull(ex.getMessage());
        }
    }

}