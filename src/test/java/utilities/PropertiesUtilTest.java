package utilities;

import abstracts.AbstractPlainJava;
import exceptions.IllegalInstantiationException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * JUnit test for {@link PropertiesUtil}.
 */
public class PropertiesUtilTest extends AbstractPlainJava {

    private final static String FILE_NAME = "PropertiesUtilTest.properties";
    private final static String FILE_PATH = "target/test-classes/";

    private final static String PROP1 = "test.value1";
    private final static String PROP2 = "test.value2";
    private final static String PROP3 = "test.value3";
    private final static String VALUE1 = "value1";
    private final static String VALUE2 = "value2";
    private final static String VALUE3 = "value3";

    private final Properties originalProperties = new Properties();

    @Before
    public void setup() throws IOException {
        FileOutputStream stream = new FileOutputStream(getTestDataPath() + FILE_NAME);
        originalProperties.setProperty(PROP1, VALUE1);
        originalProperties.setProperty(PROP2, VALUE2);
        originalProperties.setProperty(PROP3, VALUE3);
        originalProperties.store(stream, null);
        stream.close();
    }

    @Test
    public void propertiesUtilConstruction() {
        assertThrows("illegal instantiation executed",
                IllegalInstantiationException.class,
                PropertiesUtil::new);
    }

    @Test
    public void loadProperties() {
        Properties checkProperties = new Properties();
        try {
            PropertiesUtil.loadProperties(checkProperties, getTestDataPath() + FILE_NAME);
            assertProperties(checkProperties);
        } catch (IOException e) {
            fail("unexpected exception received");
        }
    }

    @Test
    public void loadPropertiesFileNotFound() {
        Properties checkProperties = new Properties();
        assertThrows("unexpected exception received",
                FileNotFoundException.class,
                () -> PropertiesUtil.loadProperties(checkProperties, "notFound.properties"));
    }

    private void assertProperties(Properties checkProperties) {
        assertEquals("size of properties not equal",
                originalProperties.size(),
                checkProperties.size());
        checkProperties.forEach((k, v)
                -> assertEquals("expected value not found", originalProperties.get(k), v));
    }

}