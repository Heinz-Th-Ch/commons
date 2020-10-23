package dataStructures;

import abstracts.AbstractPlainJava;
import org.junit.Test;

/**
 * JUnit test for {@link CommonValues}.
 */
public class CommonValuesTest extends AbstractPlainJava {

    private final int NUMBER_OF_FIELDS = 2;

    @Test
    public void testNumberOfValues() {
        assertEquals("invalid number of fields",
                NUMBER_OF_FIELDS,
                CommonValues.class.getDeclaredFields().length);
    }

}