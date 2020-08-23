package utilities;

import com.google.common.annotations.VisibleForTesting;
import exceptions.IllegalInstantiationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This is a utility class, which provides some methods to handle several properties.
 */
public class PropertiesUtil {

    @VisibleForTesting
    protected PropertiesUtil() throws IllegalInstantiationException {
        throw new IllegalInstantiationException("unauthorized instantiation called");
    }

    public static void loadProperties(Properties properties, String fileName) throws IOException {
        FileInputStream stream = new FileInputStream(fileName);
        properties.load(stream);
        stream.close();
    }

}
