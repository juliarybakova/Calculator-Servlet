package com.Homework;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;*/


import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;
import java.util.Arrays;
import java.util.Collection;




@Rule
public TestRule rr = new RepeatRule();
//@RepeatedTest(10)



@RunWith(Parameterized.class)
public class CalcTest {

    private  final Calc Add = new Calc();

    @Parameterized.Parameter(0)
    public String initialExpression;
    @Parameterized.Parameter(1)
    public int expected;
    @Parameterized.Parameter(2)
    public int expectedNegative;
    @Parameterized.Parameter(3)
    public String wrongInitialExpression;


    @Test
    public void passedTest() {

        int actual = Add.evaluate(initialExpression);

        Assert.assertEquals(actual, expected, String.format("Test failed. Expected %d, but found %d%n", expected, actual));
        if (actual == expected) {
            System.out.printf("Passed with expected %d and initial Expression %s%n", expected, initialExpression);
        }


    }

    @Test(expected = CalcException.class)
    public void negativeTest() throws CalcException {
        int actual = Add.evaluate(initialExpression);
        CalcExceptionForNegative exc = new CalcExceptionForNegative();
        exc.throwException(actual, expectedNegative);

    }

    @Test(expected = RuntimeException.class)
    public void failedTest() throws RuntimeException {
        int actual;
        try {Add.evaluate(wrongInitialExpression);}
        catch (RuntimeException e) {System.out.println("Wrong input string"); throw e;}

    }


    @Parameterized.Parameters(name = "initialExpression = {0}; expected = {1}")
    public static  Collection<Object[]> inputs() {
        return Arrays.asList(new Object[][]{
                {"27+3", 30, 25, "27++3"},
                {"27-3", 24, 23, ""},
                {"27/3", 9, 24, "27$10"},
                {"27*3", 81, 30, "+27-27"}
        });
    }
}





