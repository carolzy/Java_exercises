/*
 ***** Important!  Please Read! *****
 *
 *  - Do NOT remove any of the existing import statements
 *  - Do NOT import additional junit packages 
 *  - You MAY add in other non-junit packages as needed
 * 
 *  - Do NOT remove any of the existing test methods or change their name
 *  - You MAY add additional test methods.  If you do, they should all pass
 * 
 *  - ALL of your assert test cases within each test method MUST pass, otherwise the 
 *        autograder will fail that test method
 *  - You MUST write the require number of assert test cases in each test method, 
 *        otherwise the autograder will fail that test method
 *  - You MAY write more than the required number of assert test cases as long as they all pass
 * 
 *  - All of your assert test cases within a method must be related to the method they are meant to test
 *  - All of your assert test cases within a method must be distinct and non-trivial
 *  - Your test cases should reflect the method requirements in the homework instruction specification
 * 
 *  - Your assert test cases will be reviewed by the course instructors and they may take off
 *        points if your assert test cases to do not meet the requirements
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

class RpnCalculatorTest {

    @Test
    void testSimpleExpression() {
        RpnCalculator calculator = new RpnCalculator();
        assertEquals(9, calculator.evaluateExpression(Arrays.asList("3", "6", "+")));
    }

    @Test
    void testComplexExpression() {
        RpnCalculator calculator = new RpnCalculator();
        assertEquals(14, calculator.evaluateExpression(Arrays.asList("5", "1", "2", "+", "4", "*", "+", "3", "-")));
    }

    @Test
    void testDivisionByZero() {
        RpnCalculator calculator = new RpnCalculator();
        assertNull(calculator.evaluateExpression(Arrays.asList("10", "0", "/")));
    }

    @Test
    void testNullInputList() {
        RpnCalculator calculator = new RpnCalculator();
        assertNull(calculator.evaluateExpression(null));
    }

    @Test
    void testNullElementInInputList() {
        RpnCalculator calculator = new RpnCalculator();
        assertNull(calculator.evaluateExpression(Arrays.asList("10", null, "+")));
    }

    @Test
    void testDivision() {
        RpnCalculator calculator = new RpnCalculator();
        assertEquals(2, calculator.evaluateExpression(Arrays.asList("5", "2", "/")));
    }
}
