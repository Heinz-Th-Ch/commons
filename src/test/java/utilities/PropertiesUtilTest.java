package utilities;

import abstracts.AbstractPlainJava;
import exceptions.IllegalInstantiationException;
import org.junit.BeforeClass;
import org.junit.Test;

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

    private static final Properties originalProperties = new Properties();

    @BeforeClass
    public static void beforeClass() throws IOException {
        originalProperties.setProperty(PROP1, VALUE1);
        originalProperties.setProperty(PROP2, VALUE2);
        originalProperties.setProperty(PROP3, VALUE3);
        originalProperties.store(new FileOutputStream(FILE_PATH + FILE_NAME), null);
    }

    /**
     * This method is used from test environment clean up functions.
     *
     * @return the file name with path
     */
    public static String getFileName(){
        return FILE_PATH + FILE_NAME;
    }

    private static void assertProperties(Properties checkProperties) {
        assertEquals("size of properties not equal",
                originalProperties.size(),
                checkProperties.size());
        checkProperties.forEach((k, v)
                -> assertEquals("expected value not found", originalProperties.get(k), v));
    }

    @Test
    public void propertiesUtilConstruction() {
        assertThrows("illegal instantiation executed",
                IllegalInstantiationException.class,
                PropertiesUtil::new);
    }

    @Test
    public void loadProperties() {
        System.out.println(this.getClass().getClassLoader().getResource("."));
        Properties checkProperties = new Properties();
        try {
            PropertiesUtil.loadProperties(checkProperties, FILE_NAME);
            assertProperties(checkProperties);
        } catch (IOException e) {
            fail("unexpected exception received");
        }
    }

    @Test
    public void loadPropertiesFileNotFound() {
        System.out.println(this.getClass().getClassLoader().getResource("."));
        Properties checkProperties = new Properties();
        assertThrows("unexpected exception received",
                NullPointerException.class,
                () -> PropertiesUtil.loadProperties(checkProperties, "notFound.properties"));
    }

}