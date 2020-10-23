package enumerations;

import abstracts.AbstractPlainJava;
import org.junit.Test;

/**
 * JUnit test for {@link WorkingLevel}.
 */
public class WorkingLevelTest extends AbstractPlainJava {

    private final int NUMBER_OF_ENTRIES = 4;

    public static final String DEVELOPMENT = "development";
    public static final String INT = "int";
    public static final String INTEGRATION = "integration";
    public static final String LOCAL = "local";
    public static final String PROD = "prod";
    public static final String PRODUCTION = "production";
    public static final String TEST = "test";



    @Test
    public void testNumberOfValues() {
        assertEquals("invalid number of values",
                NUMBER_OF_ENTRIES,
                WorkingLevel.values().length);
    }

    @Test
    public void getWorkingMode() {
        assertEquals("invalid control value for enum DEV", LOCAL, WorkingLevel.valueOf("DEV").getWorkingMode());
        assertEquals("invalid control value for enum INT", INT, WorkingLevel.valueOf("INT").getWorkingMode());
        assertEquals("invalid control value for enum PROD", PROD, WorkingLevel.valueOf("PROD").getWorkingMode());
        assertEquals("invalid control value for enum TEST", TEST, WorkingLevel.valueOf("TEST").getWorkingMode());
    }

    @Test
    public void getDirectoryName() {
        assertEquals("invalid directory name for enum DEV", DEVELOPMENT, WorkingLevel.valueOf("DEV").getDirectoryName());
        assertEquals("invalid directory name for enum INT", INTEGRATION, WorkingLevel.valueOf("INT").getDirectoryName());
        assertEquals("invalid directory name for enum PROD", PRODUCTION, WorkingLevel.valueOf("PROD").getDirectoryName());
        assertEquals("invalid directory name for enum TEST", TEST, WorkingLevel.valueOf("TEST").getDirectoryName());
    }

}