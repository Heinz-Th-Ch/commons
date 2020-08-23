package utilities;

import abstracts.AbstractPlainJava;
import dataStructures.CommonValues;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.lf5.LogLevel;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApplicationLoggerUtilTest extends AbstractPlainJava {

    private final static String PROPERTY_FILE_NAME = "log4j.properties";
    private final static String LOG_FILE_NAME_1 = "ApplicationLoggerUtilTest-" + CommonValues.TIME_STAMP_PLACE_HOLDER + "-1.log";
    private final static String LOG_FILE_NAME_2 = "ApplicationLoggerUtilTest-2.log";
    private final static String LOG_FILE_NAME_FILTER = "ApplicationLoggerUtilTest*.log";

    private final static String ROOT_CATEGORY = "log4j.rootCategory=INFO, stdout\n";
    private final static String APPENDER = "log4j.appender.stdout=org.apache.log4j.ConsoleAppender\n";
    private final static String LAYOUT = "log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\n";
    private final static String LAYOUT_PATTERN = "log4j.appender.stdout.layout.ConversionPattern=%d{yy-MM-dd HH:mm:ss:SSS} %5p %t %c{2}:%L - %m%n\n";

    private ApplicationLoggerUtil loggerUtil;

    @Before
    public void setUp() throws Exception {
        FileOutputStream stream = new FileOutputStream(getTestDataPath() + PROPERTY_FILE_NAME);
        stream.write(ROOT_CATEGORY.getBytes());
        stream.write(APPENDER.getBytes());
        stream.write(LAYOUT.getBytes());
        stream.write(LAYOUT_PATTERN.getBytes());
        stream.close();
        ApplicationLoggerUtil.logOutputStream = null;
        ApplicationLoggerUtil.logRecords.clear();
        loggerUtil = new ApplicationLoggerUtil(this.getClass());
    }

    @Test
    public void debug() throws IOException {
        loggerUtil.debug("text for formatting a value: {}, {}",
                "debug()",
                Long.valueOf("47"));
        assertTrue("wrong size of list",
                ApplicationLoggerUtil.logRecords.isEmpty());
    }

    @Test
    public void error() throws IOException {
        loggerUtil.error("text for formatting a value: {}, {}",
                "error()",
                Long.valueOf("147"));
        assertEquals("wrong size of list",
                1,
                ApplicationLoggerUtil.logRecords.size());
    }

    @Test
    public void info() throws IOException {
        loggerUtil.setLogOutputStream(getTestDataPath(), LOG_FILE_NAME_1);
        loggerUtil.info("text for formatting a value: {}, {}",
                "info()",
                Long.valueOf("247"));
        assertTrue("wrong size of list",
                ApplicationLoggerUtil.logRecords.isEmpty());
    }

    @Test
    public void warn() throws IOException {
        loggerUtil.warn("text for formatting a value: {}, {}",
                "warn()",
                Long.valueOf("347"));
        assertEquals("wrong size of list",
                1,
                ApplicationLoggerUtil.logRecords.size());
    }

    /**
     * This test is constructed via a helper method {@link ApplicationLoggerUtil#testGetCallingStatement()} to
     * guarantee the correct stack trace information.
     */
    @Test
    public void getCallingStatement() {
        Pair<Pair<String, Integer>, String> result = loggerUtil.testGetCallingStatement();
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        StackTraceElement element = stElements[1];
        assertEquals("invalid calling statement part 1",
                element.getClassName(),
                result.getLeft().getLeft());
        assertEquals("invalid calling statement part 2",
                (element.getLineNumber() - 1),
                result.getLeft().getRight().intValue());
        assertEquals("invalid classLoaderName",
                element.getClassLoaderName(),
                result.getRight());
    }

    @Test
    public void writeRecordToFileButWrittenToList() throws IOException {
        loggerUtil.writeRecordToFile(LogLevel.DEBUG,
                null,
                null,
                "app",
                "text for formatting a value: {}, {}",
                "writeRecordToFile()",
                Long.valueOf("47"));
        assertEquals("wrong size of list",
                1,
                ApplicationLoggerUtil.logRecords.size());
    }

    @Test
    public void writeRecordToFileRealWrittenToFile() throws IOException {
        loggerUtil.setLogOutputStream(getTestDataPath(), LOG_FILE_NAME_1);
        loggerUtil.writeRecordToFile(LogLevel.DEBUG,
                null,
                null,
                "app",
                "text for formatting a value: {}, {}",
                "writeRecordToFile()",
                Long.valueOf("47"));
        assertTrue("wrong size of list",
                ApplicationLoggerUtil.logRecords.isEmpty());
    }

    @Test
    public void writeRecordToFileFirstWrittenToListThenWrittenToFile() throws IOException {
        loggerUtil.writeRecordToFile(LogLevel.DEBUG,
                null,
                null,
                "app",
                "text for formatting a value: {}, {}",
                "writeRecordToFile()",
                Long.valueOf("47"));
        assertEquals("wrong size of list",
                1,
                ApplicationLoggerUtil.logRecords.size());
        loggerUtil.setLogOutputStream(getTestDataPath(), LOG_FILE_NAME_1);
        loggerUtil.writeRecordToFile(LogLevel.DEBUG,
                null,
                null,
                "app",
                "text for formatting a value: {}, {}",
                "writeRecordToFile()",
                Long.valueOf("147"));
        assertTrue("wrong size of list",
                ApplicationLoggerUtil.logRecords.isEmpty());
    }

    @Test
    public void setLogOutputStream() throws IOException {
        loggerUtil.setLogOutputStream(getTestDataPath(), LOG_FILE_NAME_1);
        assertNotNull("file output stream not set", ApplicationLoggerUtil.logOutputStream);
        FileOutputStream oldStream = ApplicationLoggerUtil.logOutputStream;
        loggerUtil.setLogOutputStream(getTestDataPath(), LOG_FILE_NAME_2);
        assertEquals("file output stream changed", oldStream, ApplicationLoggerUtil.logOutputStream);
    }

}