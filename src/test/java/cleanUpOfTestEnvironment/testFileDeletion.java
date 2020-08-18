/**
 * This package is only a service package to support the clean up of several tests in this project.
 */
package cleanUpOfTestEnvironment;

import org.apache.commons.lang3.tuple.Pair;
import utilities.ApplicationLoggerUtilTest;
import utilities.PropertiesUtilTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * This class is used to delete several files which are created during tests in this project.
 */
public class testFileDeletion {

    private final static String propertiesUtilTestFile = PropertiesUtilTest.getFileName();
    private final static Pair<String, String> applicationLoggerUtilTestFile = ApplicationLoggerUtilTest.getFileNameFilter();

    public static void main(String... ars) throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader.getResource("."));
        cleanUpPropertiesUtilTest();
        cleanUpApplicationLoggerUtilTest();
    }

    private static void cleanUpApplicationLoggerUtilTest() throws IOException {
        String[] fileSplitter = applicationLoggerUtilTestFile.getRight().split(Pattern.quote("*"));
        for (File entry : new File(applicationLoggerUtilTestFile.getLeft()).listFiles()) {
            if (entry.getName().startsWith(fileSplitter[0]) && entry.getName().endsWith(fileSplitter[1])) {
                Files.deleteIfExists(Paths.get(applicationLoggerUtilTestFile.getLeft() + entry.getName()));
            }
        }
    }

    private static void cleanUpPropertiesUtilTest() throws IOException {
        Files.deleteIfExists(Paths.get(propertiesUtilTestFile));
    }

}
