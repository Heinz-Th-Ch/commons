package enumerations;

/**
 * This enum is used to present several global values for all applications properties.
 */
public enum PropertyKeys {

    PROPERTY_CSV_BALL_CHARACTERISTICS_FILE_NAME("csvfile.ballcharacteristics.filename"),
    PROPERTY_CSV_CRAZY_GOLF_SITE_CHARACTERISTICS_FILE_NAME("csvfile.crazygolfsitecharacteristics.filename"),
    PROPERTY_CSV_FILE_ENLARGEMENT_PATH("csvfile.enlargement.path"),
    PROPERTY_CSV_FILE_PATH("csvfile.path"),
    PROPERTY_CSV_SUITCASE_CHARACTERISTICS_FILE_NAME("csvfile.suitcasecharacteristics.filename"),

    PROPERTY_DATA_BALL_CHARACTERISTICS_FILE_NAME("datafile.ballcharacteristics.filename"),
    PROPERTY_DATA_CRAZY_GOLF_SITE_CHARACTERISTICS_FILE_NAME("datafile.crazygolfsitecharacteristics.filename"),
    PROPERTY_DATA_FILE_PATH("datafile.path"),
    PROPERTY_DATA_SUITCASE_CHARACTERISTICS_FILE_NAME("datafile.suitcasecharacteristics.filename"),

    PROPERTY_INTERNAL_SERVER_ACCEPTED_HOSTS("internal.server.accepted.hosts"),
    PROPERTY_INTERNAL_SERVER_NUMBER_OF_PARALLEL_CONNECTS("internal.server.number.of.parallel.connects"),
    PROPERTY_INTERNAL_SERVER_PORT("internal.server.port"),

    PROPERTY_LOG_FILE_NAME("logfile.filename"),
    PROPERTY_LOG_FILE_PATH("logfile.path"),

    PROPERTY_PDF_CRAZY_GOLF_ADMIN_SUMMARY_FILE_NAME("pdffile.crazyGolfAdminSummary.filename"),
    PROPERTY_PDF_FILE_ENLARGEMENT_PATH("pdffile.enlargement.path"),

    PROPERTY_REMOTEAPPLICATION_INTERNAL_SERVER_HOSTNAME("remoteapplication.internal.server.hostname"),
    PROPERTY_REMOTEAPPLICATION_INTERNAL_SERVER_PORT("remoteapplication.internal.server.port"),

    PROPERTY_WEBAPPLICATION_INTERNAL_SERVER_HOSTNAME("webapplication.internal.server.hostname"),
    PROPERTY_WEBAPPLICATION_INTERNAL_SERVER_PORT("webapplication.internal.server.port"),

    PROPERTY_WEB_SERVER_ACCEPTED_HOSTS("web.server.accepted.hosts"),
    PROPERTY_WEB_SERVER_NUMBER_OF_PARALLEL_CONNECTS("web.server.number.of.parallel.connects"),
    PROPERTY_WEB_SERVER_PORT("web.server.port"),
    ;

    final String propertyKey;

    PropertyKeys(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

}
