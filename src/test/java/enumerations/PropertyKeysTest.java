package enumerations;

import abstracts.AbstractPlainJava;
import org.junit.Test;

/**
 * JUnit test for {@link PropertyKeys}.
 */
public class PropertyKeysTest extends AbstractPlainJava {

    private final static int NUMBER_OF_ENTRIES = 24;

    @Test
    public void testNumberOfValues() {
        assertEquals("invalid number of values",
                NUMBER_OF_ENTRIES,
                PropertyKeys.values().length);
    }

}