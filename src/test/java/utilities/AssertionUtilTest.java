package utilities;

import abstracts.AbstractPlainJava;
import exceptions.NegativeNumberException;
import org.junit.Test;

/**
 * JUnit test for{@link AssertionUtil}.
 */
public class AssertionUtilTest extends AbstractPlainJava {

    @Test(expected = NegativeNumberException.class)
    public void negativeCheckForThrowable() {
        Integer value = -1;
        AssertionUtil.notNegative("text", value);
    }

    @Test
    public void notNegativeForDouble() {
        String text = "Error ob object found";
        Double value = -0.01;
        try{
            AssertionUtil.notNegative(text,value);
        } catch (NegativeNumberException ex) {
            assertEquals("unexpected error text received",
                    text,
                    ex.getMessage());
        }
    }

    @Test
    public void notNegativeForFloat() {
        String text = "Error ob object found";
        Float value = (float) -1;
        try{
            AssertionUtil.notNegative(text,value);
        } catch (NegativeNumberException ex) {
            assertEquals("unexpected error text received",
                    text,
                    ex.getMessage());
        }
    }

    @Test
    public void notNegativeForInteger() {
        String text = "Error ob object found";
        Integer value = -1;
        try{
            AssertionUtil.notNegative(text,value);
        } catch (NegativeNumberException ex) {
            assertEquals("unexpected error text received",
                    text,
                    ex.getMessage());
        }
    }

    @Test
    public void notNegativeForLong() {
        String text = "Error ob object found";
        Long value = (long) -1;
        try{
            AssertionUtil.notNegative(text,value);
        } catch (NegativeNumberException ex) {
            assertEquals("unexpected error text received",
                    text,
                    ex.getMessage());
        }
    }

    @Test
    public void notNegativeForShort() {
        String text = "Error ob object found";
        Short value = (short) 1;
        try{
            AssertionUtil.notNegative(text,value);
        } catch (NegativeNumberException ex) {
            assertEquals("unexpected error text received",
                    text,
                    ex.getMessage());
        }
    }

    @Test
    public void notNullCheckForCorrectText() {
        String text = "Error ob object found";
        Integer value = null;
        try {
            AssertionUtil.notNull(text, value);
        } catch (NullPointerException ex) {
            assertEquals("unexpected error text received",
                    text,
                    ex.getMessage());
        }
    }

    @Test(expected = NullPointerException.class)
    public void notNullCheckForThrowable() {
        Integer value = null;
        AssertionUtil.notNull("text", value);
    }

}