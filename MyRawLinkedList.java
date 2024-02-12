/*
 * I attest that the code in this file is entirely my own except for the starter
 * code provided with the assignment and the following exceptions:
 * <Enter all external resources and collaborations here. Note external code may
 * reduce your score but appropriate citation is required to avoid academic
 * integrity violations. Please see the Course Syllabus as well as the
 * university code of academic integrity:
 *  https://catalog.upenn.edu/pennbook/code-of-academic-integrity/ >
 * Signed,
 * Author: Carol Zhu
 * Penn email: zhu24y@seas.upenn.edu>
 * Date: 2024-02-04
 */

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.PriorityQueue;
import java.util.Collections;


public class MyRawLinkedList {
    private static final long serialVersionUID = 1561306366555780559L;

    static class Node {
        private static final long serialVersionUID = -3505677833599614054L;
        String value;
        Node next = null;

        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(String value) {
            this(value, null);
        }
    }

    /* This is intentionally left private so that you can't erroneously try to
     * instantiate a `new MyRawLinkedList()`
     */
    private MyRawLinkedList() {}

    /*
     * These methods included as examples for how to use Node as a linked list.
     */
    public static String listToString(Node head) {
        String ret = "";
        while (head != null) {
            ret += "\"" + head.value + (head.next == null ? "\" " : "\", ");
            head = head.next;
        }
        return "[ " + ret + "]";
    }

    public static void print(Node head) {
        System.out.println(listToString(head));
    }

    /*
     * Do not call this method in your code; it is not efficient. It is just for our
     * test cases.
     */
    public static String get(Node head, int index) {
        if (index < 0 || index >= size(head)) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    /* Do not call this method in your code. It is just for the test cases. */
    public static boolean contains(Node head, String value) {
        Node current = head;
        while (current != null) {
            if (current.value == value || current.value != null && current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /* Do not call this method in your code. It is just for the test cases. */
    public static int size(Node head) {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public static void main(String[] args) {
        Node list1 = new Node("One", new Node("Two", new Node("Three", null)));
        print(list1);

        Node args_as_list = null;
        for (int i = args.length - 1; i >= 0; i--)
            args_as_list = new Node(args[i], args_as_list);

        print(args_as_list);

        Node list2 = null;
        list2 = new Node("a", list2);
        list2 = new Node("b", list2);
        list2 = new Node("c", list2);
        print(list2);
    }

    /*
     * Implement the methods below. Please do not change their signatures!
     */

    public static Node reverse(Node head) {
    Node prev = null;
    Node current = head;
    Node next = null;
    while (current != null) {
        next = current.next; // 
        current.next = prev; // Reverse 
        prev = current; // Move pointers one position ahead
        current = next;
    }
    return prev; 
}

    public static Node removeMaximumValues(Node head, int N) {
    if (head == null || N <= 0) return head;

    // Identify N maximum values
    TreeSet<String> allValues = new TreeSet<>();
    Node current = head;
    while (current != null) {
        allValues.add(current.value);
        current = current.next;
    }

    // Early exit if removing all or more unique values than exist
    if (allValues.size() <= N) return null;

    // Find the N maximum values
    while (allValues.size() > N) {
        allValues.pollFirst(); // Remove the smallest values until only N largest remain
    }

    // Remove nodes containing N maximum values
    Node dummy = new Node("", null); // Dummy head to simplify edge cases
    dummy.next = head;
    current = dummy;
    while (current.next != null) {
        if (allValues.contains(current.next.value)) {
            current.next = current.next.next; // Remove node
        } else {
            current = current.next;
        }
    }

    return dummy.next;
}

public static boolean containsSubsequence(Node head, Node sub) {
    if (sub == null) return true; // An empty subsequence is always a subsequence.
    if (head == null) return false; // A non-empty subsequence cannot be a subsequence of an empty list.

    Node currentHead = head, currentSub = sub;
    
    while (currentHead != null) {
        Node tempHead = currentHead;
        currentSub = sub; // Reset subsequence pointer for every new starting point in the main list.
        
        while (tempHead != null && currentSub != null && tempHead.value.equals(currentSub.value)) {
            tempHead = tempHead.next;
            currentSub = currentSub.next;
        }
        
        if (currentSub == null) {
            // If we've reached the end of the subsequence, it means the entire subsequence was found in the main list.
            return true;
        }
        
        // Move to the next node in the main list and try again.
        currentHead = currentHead.next;
    }
    
    return false; // The subsequence was not found in the main list.
}


}
