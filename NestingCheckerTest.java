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
import org.junit.jupiter.api.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;


class NestingCheckerTest {

    @Test
    void testValidNesting() {
        Queue<Nestable> elements = new LinkedList<>(Arrays.asList(/* Populate with mock Nestable instances representing a valid sequence */));
        NestingReport report = NestingChecker.checkNesting(elements);
        assertEquals(NestingReport.Status.VALID, report.getStatus());
        assertTrue(report.getStackState().isEmpty());
    }

    @Test
    void testNullInput() {
        Queue<Nestable> elements = null;
        NestingReport report = NestingChecker.checkNesting(elements);
        assertEquals(NestingReport.Status.NULL_INPUT, report.getStatus());
    }

    @Test
    void testNullItemInQueue() {
        Queue<Nestable> elements = new LinkedList<>(Arrays.asList(/* Valid elements before null, possibly valid elements after */));
        NestingReport report = NestingChecker.checkNesting(elements);
        assertEquals(NestingReport.Status.NULL_ITEM, report.getStatus());
    }

    @Test
    void testInvalidClose() {
        Queue<Nestable> elements = new LinkedList<>(Arrays.asList(/* Mock Nestable instances leading to an invalid close */));
        NestingReport report = NestingChecker.checkNesting(elements);
        assertEquals(NestingReport.Status.INVALID_CLOSE, report.getStatus());
    }

    @Test
    void testNotTerminatedNesting() {
        Queue<Nestable> elements = new LinkedList<>(Arrays.asList(/* Mock Nestable instances with unclosed markers */));
        NestingReport report = NestingChecker.checkNesting(elements);
        assertEquals(NestingReport.Status.NOT_TERMINATED, report.getStatus());
    }
}
