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
 * Penn email: <zhu24y@seas.upenn.edu>
 * Date: 2024-02-04
 */

public class MyLinkedList {

    private static final long serialVersionUID = 1663679278942178557L;
    static class Node {
        private static final long serialVersionUID = -539394075146871892L;
        String value;
        Node next;

        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        Node(String value) {
            this(value, null);
        }
    }

    protected Node head = null;
    protected Node tail = null;
    protected int size = 0;

    public void addFirst(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(String value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void add(int index, String value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            if (current.next == null) {
                tail = newNode;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
    }

    public boolean contains(String value) {
        Node current = head;
        while (current != null) {
            if (current.value == value || current.value != null && current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        } else {
            return;
        }
        if (head == null) {
            tail = null;
        }
        if (size > 0)
            size--;
    }

    public void removeLast() {
        if (head == null) { // empty list
            return;
        } else if (head == tail) {
            // single element list
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            current.next = null;
        }
        size--;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        else if (index == 0)
            removeFirst();
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
            size--;
        }
    }

    /*
     * Implement the methods below. Please do not change their signatures!
     */

    public void reverse() {
    Node prev = null;
    Node current = head;
    Node next = null;
    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    tail = head;
    head = prev;
}
    public void removeMaximumValues(int N) {
    while (N > 0 && head != null) {
        // Find the maximum value in the list.
        Node current = head;
        String maxValue = current.value;
        while (current != null) {
            if (current.value.compareTo(maxValue) > 0) {
                maxValue = current.value;
            }
            current = current.next;
        }

        // Remove all nodes with the maximum value.
        while (contains(maxValue)) { // contains() checks if the list contains a value
            remove(maxValue); // remove() removes the first occurrence of a value
        }

        N--;
    }
}

// Utility method to remove a node with a specific value.
private void remove(String value) {
    if (head == null) return;
    if (head.value.equals(value)) {
        head = head.next;
        if (head == null) tail = null;
        size--;
        return;
    }
    Node current = head;
    while (current.next != null) {
        if (current.next.value.equals(value)) {
            current.next = current.next.next;
            if (current.next == null) tail = current;
            size--;
            return;
        }
        current = current.next;
    }
}

   public Boolean containsSubsequence(MyLinkedList other) {
    // An empty list is a subsequence of any list, including an empty list
    if (other.head == null) return true;

    Node thisCurrent = this.head;

    // If 'this' list is empty, it cannot contain a non-empty subsequence
    if (thisCurrent == null) return false;

    while (thisCurrent != null) {
        Node otherCurrent = other.head;
        Node startThis = thisCurrent;

        // Use a flag to track matching process
        boolean isMatching = true;

        while (startThis != null && otherCurrent != null) {
            // Check for null to avoid NullPointerException
            if (startThis.value == null && otherCurrent.value == null) {
                startThis = startThis.next;
                otherCurrent = otherCurrent.next;
            } else if (startThis.value != null && startThis.value.equals(otherCurrent.value)) {
                startThis = startThis.next;
                otherCurrent = otherCurrent.next;
            } else {
                isMatching = false;
                break;
            }
        }

        // If otherCurrent is null, a full match was found
        if (isMatching && otherCurrent == null) return true;

        thisCurrent = thisCurrent.next;
    }

    return false; // No matching subsequence found
}


}
