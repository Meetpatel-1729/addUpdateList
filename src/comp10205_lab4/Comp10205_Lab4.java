/**
 * COMP10205 - Lab#4 Starting Code
 *
 * Question 1 - Do you notice any significant performance difference between the SortedLinkedList<T>
 * and the ArrayList<T> classes in terms of adding items? Answer: It takes
 * almost twice amount of time to add elements in sorted order in Array list
 * compare to the Linked list. Which means Linked list is faster.
 *
 * Question 2 - Do you notice any significant performance difference between the
 * classes in terms of removing items? Answer: It takes more time to remove
 * elements from the Linked list compare to the Array List.
 *
 * Question 3 - When would you choose to use a LinkedList over an ArrayList
 * based on the results in this lab? Answer: When there is a need to add/remove
 * any element on any location Linked list is more suitable compare to Array
 * list.
 *
 */
package comp10205_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Meet Patel
 */
public class Comp10205_Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        final int NUMBER_OF_NAMES = 18756; // Number of name sin the file

        final String filename = "resources/bnames.txt"; // Stores the file path

        final String[] names = new String[NUMBER_OF_NAMES]; // Stores each name in the array

        // May be useful for selecting random words to remove
        Random random = new Random(); // Generates random number

        // Read in all of the names 
        try {
            Scanner fin = new Scanner(new File(filename)); // Scanner object

            for (int i = 0; i < NUMBER_OF_NAMES; i++) {
                names[i] = fin.next(); //Stores each name in the array
            }
            fin.close(); // Close the file

        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage()); // Prints the error mesage when file not found
            System.exit(-1);
        }

        // Use the system to build the linked List
        // 1. Create the linkedList and add all items in Array
        System.out.println("Linked List (String) : ");
        SortedLinkedList<String> linkedList_String = new SortedLinkedList<>(); // Linked list type string 
//
        long start = System.nanoTime(); // Start time
        for (int i = 0; i < NUMBER_OF_NAMES; i++) {
            linkedList_String.add(names[i]); // Adds the names in the Linked list
        }

        long total = (System.nanoTime() - start); // Execution time
        System.out.printf("\tThe time required to add %d string elements to a Linked List = %d us\n", NUMBER_OF_NAMES, total / 1000);
        System.out.println("\t" + linkedList_String.size()); // Size of the linked list
        System.out.println("\t" + linkedList_String); // Prints the linked list
        System.out.println("\n");

        // 2. Remove half the items and time the code.
        start = System.nanoTime(); // Start time
        for (int i = 0; i < NUMBER_OF_NAMES / 2; i++) {
            linkedList_String.remove(names[i]); // Removes half elements from the linked list
        }

        System.out.printf("\tThe time required to remove %d string elements from a Linked List = %d us\n", NUMBER_OF_NAMES / 2, (System.nanoTime() - start) / 1000);
        System.out.println("\t" + linkedList_String.size()); // Size of the linked list
        System.out.println("\t" + linkedList_String); // prints the linked list
        System.out.println("\n");

        // 3. Create a SortedLinkedList of another data type and demonstrate 
        System.out.println("Linked List (Integer) : ");
        SortedLinkedList<Integer> linkedList_Integer = new SortedLinkedList<>(); // Linked list type Integer

        start = System.nanoTime(); // Start time
        for (int i = 0; i < NUMBER_OF_NAMES; i++) {
            linkedList_Integer.add(random.nextInt()); // Adds the random integers in the liniked list
        }
        System.out.printf("\tThe time required to add %d integer elements to a Linked List = %d us\n", NUMBER_OF_NAMES, (System.nanoTime() - start) / 1000);
        System.out.println("\t" + linkedList_Integer.size()); // Linked list size
        System.out.println("\t" + linkedList_Integer); // Prints the linked list
        System.out.println("\n");

        // 4. Build a standard ArrayList of String - Remember to sort list after each element is added
        //    Time this code.
        //    Use this timing data to compare add against SortedLinkedList in discussion
        //    Remove the half the elements and time again.  
        //    Use this timing data to compare remove against SortedLinkedList in discussion
        System.out.println("Array List (String) : ");
        ArrayList<String> arrayList_String = new ArrayList<>(); // Arraylist of type string

        start = System.nanoTime(); // Start time
        for (int i = 0; i < NUMBER_OF_NAMES; i++) {
            arrayList_String.add(names[i]); // Adds the element in the arraylist
            Collections.sort(arrayList_String, (s1, s2) -> s1.compareTo(s2)); // Sort the element in the array list
        }
        long total2 = (System.nanoTime() - start); // Execution time
        System.out.printf("\tThe time required to add %d elements to an ArrayList = %d us\n", NUMBER_OF_NAMES, total2 / 1000);
        System.out.println("\t" + arrayList_String.size()); // Array list size
        System.out.println("\t" + arrayList_String); // Prints the array list
        System.out.println("\n");

        start = System.nanoTime(); // Start time
        for (int i = 0; i < NUMBER_OF_NAMES / 2; i++) {
            arrayList_String.remove(names[i]); // Remove the half elements from the list
        }

        System.out.printf("\tThe time required to remove %d string elements from an Array List = %d us\n", NUMBER_OF_NAMES / 2, (System.nanoTime() - start) / 1000);
        System.out.println("\t" + arrayList_String.size()); // Size of the Array list
        System.out.println("\t" + arrayList_String); // Prints the Array list
    }
}
