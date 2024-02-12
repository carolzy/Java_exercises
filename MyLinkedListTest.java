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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {
    private MyLinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new MyLinkedList();
        linkedList.addFirst("1");
        linkedList.addLast("2");
        linkedList.addLast("3");
        linkedList.addLast("4");
        linkedList.addLast("5");
    }

    @Test
    void testContains() {
        assertTrue(linkedList.contains("3"));
        assertFalse(linkedList.contains("6"));
    }

    @Test
    void testReverse() {
        linkedList.reverse();
        assertEquals("5", linkedList.get(0));
        assertEquals("4", linkedList.get(1));
        assertEquals("3", linkedList.get(2));
        assertEquals("2", linkedList.get(3));
        assertEquals("1", linkedList.get(4));

        linkedList.reverse(); // Reverse back to original
        assertEquals("1", linkedList.get(0));
        assertEquals("2", linkedList.get(1));
        assertEquals("3", linkedList.get(2));
        assertEquals("4", linkedList.get(3));
        assertEquals("5", linkedList.get(4));
    }



@Test
void testRemoveMaximumValues() {
    // Setup the list with a known series of values
    MyLinkedList list = new MyLinkedList();
    list.addLast("1");
    list.addLast("3");
    list.addLast("5");
    list.addLast("4");
    list.addLast("2");

    // Remove the two maximum values ("5" and "4")
    list.removeMaximumValues(2);

    // Verify the list now contains the remaining values
    assertTrue(list.contains("1"));
    assertTrue(list.contains("2"));
    assertTrue(list.contains("3"));
    assertFalse(list.contains("4")); // Should be removed
    assertFalse(list.contains("5")); // Should be removed
    assertEquals(3, list.size); // Size should be reduced to 3
}


void testContainsSubsequence() {
    // Main list setup
    MyLinkedList mainList = new MyLinkedList();
    mainList.addLast("1");
    mainList.addLast("2");
    mainList.addLast("3");
    mainList.addLast("4");
    mainList.addLast("5");

    // Subsequence list setup
    MyLinkedList subList = new MyLinkedList();
    subList.addLast("2");
    subList.addLast("3");
    subList.addLast("4");

    // Test for a valid subsequence
    assertTrue(mainList.containsSubsequence(subList));

    // Test for a non-existent subsequence
    MyLinkedList nonSubList = new MyLinkedList();
    nonSubList.addLast("3");
    nonSubList.addLast("2"); // Incorrect order
    assertFalse(mainList.containsSubsequence(nonSubList));

    // Test with an empty subsequence (should always return true)
    MyLinkedList emptyList = new MyLinkedList();
    assertTrue(mainList.containsSubsequence(emptyList));
}

}