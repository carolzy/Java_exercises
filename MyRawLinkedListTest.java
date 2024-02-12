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

class MyRawLinkedListTest {

   @Test
void testRawContainsSubsequence() {
    MyRawLinkedList.Node list = new MyRawLinkedList.Node("1", new MyRawLinkedList.Node("2", new MyRawLinkedList.Node("3", null)));
    MyRawLinkedList.Node subList1 = new MyRawLinkedList.Node("1", new MyRawLinkedList.Node("2", null));
    MyRawLinkedList.Node subList2 = new MyRawLinkedList.Node("2", new MyRawLinkedList.Node("3", null));
    MyRawLinkedList.Node subList3 = new MyRawLinkedList.Node("1", null);
    MyRawLinkedList.Node nonSubList = new MyRawLinkedList.Node("3", new MyRawLinkedList.Node("1", null));

    assertTrue(MyRawLinkedList.containsSubsequence(list, subList1));
    assertTrue(MyRawLinkedList.containsSubsequence(list, subList2));
    assertTrue(MyRawLinkedList.containsSubsequence(list, subList3));
    assertFalse(MyRawLinkedList.containsSubsequence(list, nonSubList)); // This should correctly reflect the intended logic.
}


   @Test
void testRawRemoveMaximumValues() {
    // Setup: Assuming a correct setup and implementation
    MyRawLinkedList.Node list = new MyRawLinkedList.Node("3", new MyRawLinkedList.Node("1", new MyRawLinkedList.Node("4", new MyRawLinkedList.Node("5", new MyRawLinkedList.Node("2", null)))));
    
    // Action: Remove two maximum values
    list = MyRawLinkedList.removeMaximumValues(list, 2); // This needs to be correctly implemented

    // Assertions: Verify the removal
    assertTrue(MyRawLinkedList.contains(list, "1"));
    assertTrue(MyRawLinkedList.contains(list, "2"));
    assertTrue(MyRawLinkedList.contains(list, "3"));
    assertFalse(MyRawLinkedList.contains(list, "4")); // Should have been removed
    assertFalse(MyRawLinkedList.contains(list, "5")); // Should have been removed
    assertEquals(3, MyRawLinkedList.size(list));
}

    @Test
    void testRawReverse() {
        MyRawLinkedList.Node list = new MyRawLinkedList.Node("1", new MyRawLinkedList.Node("2", new MyRawLinkedList.Node("3", new MyRawLinkedList.Node("4", new MyRawLinkedList.Node("5", null)))));
        MyRawLinkedList.Node reversedList = MyRawLinkedList.reverse(list);

        assertEquals("5", MyRawLinkedList.get(reversedList, 0));
        assertEquals("4", MyRawLinkedList.get(reversedList, 1));
        assertEquals("3", MyRawLinkedList.get(reversedList, 2));
        assertEquals("2", MyRawLinkedList.get(reversedList, 3));
        assertEquals("1", MyRawLinkedList.get(reversedList, 4));

        // Reversing the list again should return it to the original order
        MyRawLinkedList.Node originalOrderList = MyRawLinkedList.reverse(reversedList);
        assertEquals("1", MyRawLinkedList.get(originalOrderList, 0));
        assertEquals("2", MyRawLinkedList.get(originalOrderList, 1));
        assertEquals("3", MyRawLinkedList.get(originalOrderList, 2));
        assertEquals("4", MyRawLinkedList.get(originalOrderList, 3));
        assertEquals("5", MyRawLinkedList.get(originalOrderList, 4));
    }
}
