package utilities;

import exceptions.NegativeNumberException;

/**
 * This is a utility class for several assertions. Each method throws accurately one exception if needed.
 */
public class AssertionUtil {

    /**
     * Checks, if an object is not null.
     *
     * @param errorText text to set inside the exception
     * @param checkableObject any implementation of {@link Object} to check
     * @throws NullPointerException if the object is null
     */
    public static void notNull(String errorText, Object checkableObject) throws NullPointerException {
        if (checkableObject == null) {
            throw new NullPointerException(errorText);
        }
    }

    /**
     * Checks, if a Number has a negative value.
     *
     * @param errorText text to set inside the exception
     * @param checkableNumber any implementation of {@link Number} to check
     * @throws NegativeNumberException if the number is negative
     */
    public static void notNegative(String errorText, Number checkableNumber) throws NegativeNumberException {
        if (checkableNumber.longValue() < 0) {
            throw new NegativeNumberException(errorText);
        }
    }

}
