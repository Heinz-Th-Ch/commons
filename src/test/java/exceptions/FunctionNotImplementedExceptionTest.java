package exceptions;

import abstracts.AbstractPlainJava;
import org.junit.Test;

/**
 * JUnit test for {@link FunctionNotImplementedException}.
 */
public class FunctionNotImplementedExceptionTest extends AbstractPlainJava {

    private static final String TEST_MESSAGE = "TEST_MESSAGE";

    @Test
    public void getWithMessage() {
        try {
            throw new FunctionNotImplementedException(TEST_MESSAGE);
        } catch (FunctionNotImplementedException ex) {
            assertEquals("expected message not received", TEST_MESSAGE, ex.getMessage());
        }
    }

    @Test
    public void getWithoutMessage() {
        try {
            throw new FunctionNotImplementedException();
        } catch (FunctionNotImplementedException ex) {
            assertNull(ex.getMessage());
        }
    }

}