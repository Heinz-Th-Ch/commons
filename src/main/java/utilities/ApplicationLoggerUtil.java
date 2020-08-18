package utilities;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.lf5.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import static dataStructures.CommonValues.TIME_STAMP_PLACE_HOLDER;
import static org.apache.log4j.lf5.LogLevel.*;

/**
 * This is a utility class, which provides to log messages to stdout and at best to a defined file.
 */
public class ApplicationLoggerUtil {

    private static final SimpleDateFormat TIME_STAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss.SSS");
    @VisibleForTesting
    protected static List<String> logRecords = new ArrayList<>(List.of());
    @VisibleForTesting
    protected static FileOutputStream logOutputStream;

    private final Logger logger;

    public ApplicationLoggerUtil(Class<?> classOfCaller) {
        logger = LoggerFactory.getLogger(classOfCaller);
    }

    public void debug(String text, Object... objects) throws IOException {
        Pair<Pair<String, Integer>, String> caller = getCallingStatement();
        logger.debug(text, objects);
        if (logger.isDebugEnabled()) {
            writeRecordToFile(DEBUG,
                    caller.getLeft().getLeft(),
                    caller.getLeft().getRight(),
                    caller.getRight(),
                    text,
                    objects);
        }
    }

    public void error(String text, Object... objects) throws IOException {
        Pair<Pair<String, Integer>, String> caller = getCallingStatement();
        logger.error(text, objects);
        if (logger.isErrorEnabled()) {
            writeRecordToFile(ERROR,
                    caller.getLeft().getLeft(),
                    caller.getLeft().getRight(),
                    caller.getRight(),
                    text,
                    objects);
        }
    }

    public void info(String text, Object... objects) throws IOException {
        Pair<Pair<String, Integer>, String> caller = getCallingStatement();
        logger.info(text, objects);
        if (logger.isInfoEnabled()) {
            writeRecordToFile(INFO,
                    caller.getLeft().getLeft(),
                    caller.getLeft().getRight(),
                    caller.getRight(),
                    text,
                    objects);
        }
    }

    public void warn(String text, Object... objects) throws IOException {
        Pair<Pair<String, Integer>, String> caller = getCallingStatement();
        logger.warn(text, objects);
        if (logger.isWarnEnabled()) {
            writeRecordToFile(WARN,
                    caller.getLeft().getLeft(),
                    caller.getLeft().getRight(),
                    caller.getRight(),
                    text,
                    objects);
        }
    }

    public synchronized void setLogOutputStream(String pathName, String fileName) throws FileNotFoundException {
        if (logOutputStream != null) {
            return;
        }
        if (fileName.contains(TIME_STAMP_PLACE_HOLDER)) {
            Pair<String, String> splitter = Pair.of(fileName.substring(0, fileName.indexOf(TIME_STAMP_PLACE_HOLDER)),
                    fileName.substring(fileName.indexOf(TIME_STAMP_PLACE_HOLDER) + TIME_STAMP_PLACE_HOLDER.length()));
            String timeStamp = TIME_STAMP_FORMAT.format(new Date());
            fileName = pathName + splitter.getLeft() + timeStamp + splitter.getRight();
        }
        logOutputStream = new FileOutputStream(fileName);
    }

    @VisibleForTesting
    protected synchronized void writeRecordToFile(LogLevel level, String caller, Integer callerLine, String thread, String text, Object... objects) throws IOException {
        FormattingTuple tuple = MessageFormatter.arrayFormat(text, objects);
        String logRecord = new ApplicationLogRecordBuilder()
                .logLevel(level)
                .caller(caller)
                .callerLine(callerLine)
                .thread(thread)
                .message(tuple.getMessage())
                .build();
        if (logOutputStream != null) {
            for (String message : logRecords) {
                logOutputStream.write(message.getBytes());
            }
            logRecords.clear();
            logOutputStream.write(logRecord.getBytes());
        } else {
            logRecords.add(logRecord);
        }
    }

    /**
     * This method is only use for test the method {@link @getCallingStatement}.
     *
     * @return the result of the execution
     */
    @VisibleForTesting
    protected Pair<Pair<String, Integer>, String> testGetCallingStatement() {
        return this.getCallingStatement();
    }

    private Pair<Pair<String, Integer>, String> getCallingStatement() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        StackTraceElement element = stElements[3];
        return Pair.of(Pair.of(element.getClassName(), element.getLineNumber()),
                element.getClassLoaderName());
    }

    static class ApplicationLogRecordBuilder {
        private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        private final static String MESSAGE_FORMAT = "%s %5s %4s %s:%-4d - %s\n";
        private final static String CALLER_REPLACING_VALUE = "...";
        private final static int CALLER_LENGTH = 40;

        private String logLevel;
        private String caller;
        private Integer callerLine;
        private String thread;
        private String message;


        private ApplicationLogRecordBuilder logLevel(LogLevel level) {
            this.logLevel = level.getLabel();
            return this;
        }

        public ApplicationLogRecordBuilder caller(String caller) {
            this.caller = caller;
            return this;
        }

        public ApplicationLogRecordBuilder callerLine(Integer callerLine) {
            this.callerLine = callerLine;
            return this;
        }

        public ApplicationLogRecordBuilder thread(String thread) {
            this.thread = thread;
            return this;
        }

        private ApplicationLogRecordBuilder message(String message) {
            this.message = message;
            return this;
        }

        private String build() {
            return String.format(MESSAGE_FORMAT,
                    DATE_FORMAT.format(new Date()),
                    this.logLevel,
                    this.thread,
                    prepareCallerValue(this.caller),
                    this.callerLine,
                    this.message);
        }

        @VisibleForTesting
        protected String prepareCallerValue(String value) {
            if (value != null) {
                if (value.length() > CALLER_LENGTH) {
                    String[] splitter = value.split(Pattern.quote("."));
                    StringBuilder valueBuilder = new StringBuilder();
                    for (int i = 0; i < splitter.length; i++) {
                        if (i < (splitter.length) - 1) {
                            valueBuilder.append(splitter[i].charAt(0));
                            valueBuilder.append(".");
                        } else {
                            valueBuilder.append(splitter[i]);
                        }
                    }
                    value = valueBuilder.toString();
                    if (value.length() > CALLER_LENGTH) {
                        value = CALLER_REPLACING_VALUE + value.substring(value.length() - (CALLER_LENGTH - CALLER_REPLACING_VALUE.length()));
                    }
                }
                StringBuilder valueBuilder = new StringBuilder(value);
                while (valueBuilder.length() < CALLER_LENGTH) {
                    valueBuilder.insert(0, ' ');
                }
                value = valueBuilder.toString();
            }
            return value;
        }

    }

}
