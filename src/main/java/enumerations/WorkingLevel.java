package enumerations;

/**
 * This enumeration ist used to define the working level of a starting application.
 * The start of an application is used with a correct {@link #workingMode} in the arg list of the main method.
 */
public enum WorkingLevel {

    DEV("local", "development/"),

    INT("int", "integration/"),

    PROD("prod", "production/"),

    TEST("test", "test/");

    private final String workingMode;
    private final String directoryName;

    WorkingLevel(String workingMode, String directoryName) {
        this.workingMode = workingMode;
        this.directoryName = directoryName;
    }

    /**
     * Returns the control value, which normally is used at the start of an application.
     *
     * @return the actual defined working mode
     */
    public String getWorkingMode() {
        return workingMode;
    }

    /**
     * Returns the name of the directory, which is normally used to expand the resource path for normal file handling.
     *
     * @return the corresponding directory name
     */
    public String getDirectoryName() {
        return directoryName;
    }

}
