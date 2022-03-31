package comp10205_lab4;

/**
 * Generic Linked List class that always keeps the elements in order
 *
 * @author mark.yendt
 * @modified by Meet Patel
 * @param <T>
 */
public class SortedLinkedList<T extends Comparable> {

    /**
     * The Node class stores a list element and a reference to the next node.
     */
    private final class Node<T extends Comparable> {

        T value;
        Node next;

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         * @param n The reference to the successor node.
         */
        Node(T val, Node n) {
            value = val;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         */
        Node(T val) {
            // Call the other (sister) constructor.
            this(val, null);
        }
    }
    private Node first;  // list head

    /**
     * Constructor.
     */
    public SortedLinkedList() {
        first = null;
    }

    /**
     * The isEmpty method checks to see if the list is empty.
     *
     * @return true if list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * The size method returns the length of the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        int count = 0;
        Node p = first;
        while (p != null) {
            // There is an element at p
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * The add method adds an element at a position.
     *
     * @param element The element to add to the list in sorted order.
     */
    public void add(T element) {

        Node temp = first; // Stores first element in the temp

        Node e = new Node(element); // Stores new variable 

        Node a; // Temporary variable

        int position; // stores difference between two strings 

        int position2; // stores difference between two strings 

        // When the linked list is empty
        if (isEmpty()) {
            first = e;
        } // When entered element is the smallest it assign the first to the new word and link rest of the words afterwards
        else if (e.value.compareTo(temp.value) < 0) {
            a = temp;
            first = e;
            e.next = a;
        } // When entered word is in middle or last position of the linked list
        else {
            // Loop through until it reaches the end of the linked list
            while (temp != null) {
                position = e.value.compareTo(temp.value); // Compare the word with the new word

                // When entered word is alphabetically bigger then the word and it's next element is not null
                if (position > 0 && temp.next != null) {
                    position2 = e.value.compareTo(temp.next.value); // // Compare the next word with the new word

                    // entered word is alphabetically equal or greater then the current word but smaller then the next word
                    // It breaks the link between those two words and add new word between them
                    if (position >= 0 && position2 < 0) {
                        a = temp.next;
                        temp.next = e;
                        e.next = a;
                        break;
                    }
                } // When the entered word is the largest
                else if (position >= 0 && temp.next == null) {
                    temp.next = e; // It asigns the element to the last position
                    break;
                }
                temp = temp.next; // Increment the loop
            }
        }
    }

    /**
     * The toString method computes the string representation of the list.
     *
     * @return The string form of the list.
     */
    @Override
    public String toString() {
        String listOfItems = "["; // String element to store the items in the linked list

        // TODO: Iterate through the list and append items to end of listOfItems
        Node temp = first; // Assign first to the temp element
        
        // Loop through the end of the linked list
        while (temp != null) {
            listOfItems += temp.value + ", "; // Add each element in the string variable
            temp = temp.next; // Increment the pointer
        }
        listOfItems += "]"; // End of the Linked list

        return listOfItems; // Return all the elements
    }

    /**
     * The remove method removes an element.
     *
     * @param element The element to remove.
     * @return true if the remove succeeded, false otherwise.
     */
    public boolean remove(T element) {
        // Gives an error when the list is empty
        if (isEmpty()) {
            System.out.println("There are no elements in the Linked List");
            return false;
        } 
        
        // Remove the first element if the element is at the first position
        else if (first.value.equals(element)) {
            first = first.next;
            return true;
        } 
        
        // If the element is elsewhere
        else {
            Node temp = first; // Assign the first to the temp variable
            
            // Loop through until the next element is not null
            while (temp.next != null) {
                // Remove the element from the list and return true
                if (temp.next.value.equals(element)) {
                    temp.next = temp.next.next;
                    return true;
                }
                temp = temp.next; // Increment the loop
            }
        }
        return false; // Return false
    }
}
