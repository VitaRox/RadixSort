import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vita.Wiebe@seattlecolleges.edu
 * Assignment 5: RadixSort;
 * Our objective is to implement the Radix Sort sorting algorithm using queues as the
 * "buckets".
 */
public class RadixSort<i> {

    // Fields:
    private static int maxSize = 0;
    
    /*
    Make an array of Queues;
    These queues will constitute our "buckets" 0-9;
     */
    private static Queue<Integer>[] buckets = new Queue[10];
    
    /**
     * Initialize all the queues in the array, buckets, to be LinkedList-based;
     */
    private static void initBuckets() {
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /**
     * Get the maximum length, in digits, of the input array of ints;
     * Pre: 'input' must contain ints;
     * Post: we know what the highest number of digits in 'input' is;
     * @param input, an array of ints;
     */
    public static int getMax(int[] input) {
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            // Create temp variable to store Stringified version of current element in 'input';
            String temp = Integer.toString(input[i]);
            // If exceeds the current 'max length', update this maximum value;
            if (temp.length() > max) {
                max = temp.length();
            }
        }
        // Set our field maxSize to the value of 'max';
        maxSize = max;
        // Return 'maxSize' so that method doubles as a getter;
        return maxSize;
    }
    
    /**
     * Implement the radixSort specialized sorting algorithm;
     * Pre: 'input' is an unsorted array;
     * Post: 'input' is a numerically-sorted array, in ascending order;
     * @param input, an array of ints to be sorted in ascending order;
     */
    public static void radixSort(int[] input) {
        // For the number of digits in the longest number in 'input';
        for (int i = getMax(input); i >= 0; i--) {
            // For each number in the list we are sorting;
            for (int elem : input) {
                // Create temp variable that is current element cast to String type;
                String temp = Integer.toString(elem);
                // Declare/initialize variable representing the char version of current digit to be examined;
                int exam = 0;
                // If equal to maxSize:
                if (temp.length() == maxSize) {
                    // Get current digit as a char of String 'temp', then convert back to int;
                    exam = Character.getNumericValue(temp.charAt(i));
                    // Else: the number has fewer digits than the biggest number in the sort list,
                    // treat it as a zero;
                    // For each bucket;
                    for (int idx = 0; idx < 10; idx++) {
                        // If the digit being examined currently corresponds to the index of the bucket, add it;
                        if (exam == idx) {
                            buckets[idx].add(elem);
                        }
                    }
                }
            }
            /*
             Put the items from the buckets back into the array in the order they
             are come across;
             For the number of elements in our input array, 'input'..
            */
            for (int j = 0; j < input.length; j++) {
                // For each of the 10 buckets;
                for (int k = 0; k < 10; k++) {
                    // Dump this bucket's contents, in order, back into next element of 'input';
                    while (!buckets[j].isEmpty()) {
                        input[j] = buckets[k].remove();
                    }
                }
            }
        }
    }
    
    /**
     * Pretty-print a given array;
     * Use to demonstrate pre- and post-sorted input array, 'input';
     * Pre: a non-empty array, 'input';
     * Post: 'input' is printed with curly braces and comma delineation to the console;
     * @param input, the array to be printed
     */
    public static void printArray(int[] input) {
        System.out.println("{ ");
        for (int i = 0; i < input.length - 1; i++) {
            System.out.println(input[i] + ", ");
        }
        System.out.println(input[input.length - 1] + " }");
    }
    
    /**
     * Our application method;
     * Should demonstrate properly implemented radix sort;
     * @param args the command-line arguments;
     */
    public static void main(String[] args) {
        int[] list =  {7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241,6589, 6622, 1211};
        
    }




}
