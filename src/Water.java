/**
 * Water.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program find out if you can completely fill the empty bucket using
 * all the water of some buckets using the maximum and minimum number of buckets
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */

import java.util.Arrays;

public class Water {
    /**
     * The main program.
     *
     * @param    args    args are considered here as a way to indicate user wants
     *                   maximum number of buckets combination to fill the empty
     *                   buckets
     */
    public static void main(String[] args) {
        int[] buckets = {1,1,2,4,5};
        int[] bucketsToFill = {1,2,3,4,5,6,7,8,9};
        int[][] combinations = new int[3000][10];
        int[] index = new int[1];
        boolean areArgumentsAvailable = args.length > 0;

        // function call to modify combinations array with bucket combinations
        recursiveFunction(buckets, combinations, index);

        System.out.print("Available full bucket volumes: ");

        for (int j : buckets) {
            System.out.print(j + " ");
        }

        System.out.println();

        // prints possible combinations of buckets for fill empty bucket
        printBuckets(areArgumentsAvailable, bucketsToFill, combinations);
    }

    /**
     * This functions prints the possible buckets list to fill empty buckets
     *
     * @param areArgumentsAvailable this variable is used check if arguments
     *                              are present
     * @param bucketsToFill buckets list that's needs to be filled
     * @param combinations combinations that are possible with available
     *                     buckets
     */
    public static void printBuckets(
            boolean areArgumentsAvailable,
            int[] bucketsToFill,
            int[][] combinations
    ) {
        if (areArgumentsAvailable) {
            for (int bucket : bucketsToFill) {
                int[] maxBuckets = maxBuckets(combinations, bucket);
                System.out.println(
                        "For " + bucket + "l:" + "   "
                                + Arrays.toString(maxBuckets)
                );
            }

        } else {
            for (int bucket : bucketsToFill) {
                int[] minBuckets = minBuckets(combinations, bucket);
                System.out.println(
                        "For " + bucket + "l:" + "   "
                                + Arrays.toString(minBuckets)
                );
            }
        }
    }

    /**
     *  Title: program to remove an element
     *         from a specific index from an array
     *  Author: Geeks for Geeks
     *  Availability:
     *  https://www.geeksforgeeks.org/
     *  remove-an-element-at-specific-index-from-an-array-in-java/
     *
     *
     * @param arr the array that needs to be modified using index
     * @param index the index of the element that should be removed
     *              in arr
     * @return      array which is modified array using index
     */

    public static int[] removeTheElement(int[] arr,
                                         int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    /**
     * program to return factorial of an integer
     *
     * @param number integer to find factorial
     * @return       factorial of an integer
     */

    public static int factorial(int number) {
        if (number == 1) {
            return 1;
        }
        return number * factorial(number -  1);
    }

    /**
     * program to push the combinations of present buckets
     *
     * @param buckets buckets that used to find combinations
     * @param combinations all the possible bucket combinations
     *                     of buckets are stored here
     * @param index index array which stored the index of the combination
     *              array where the combination bucket needs to be pushed
     */

    public static void recursiveFunction(int[] buckets, int[][] combinations, int[] index) {
        combinations[index[0]] = buckets;
        if (buckets.length != 1) {
            for (int i = 0; i < (factorial(buckets.length)/factorial(buckets.length - 1)); i++) {
                    index[0] = index[0] + 1;
                    recursiveFunction(removeTheElement(buckets, i), combinations, index);
            }
        }
    }

    /**
     * program to print maximum bucket combinations
     * @param combinations array which has all the possible buckets
     *                     combinations
     * @param bucketToFill empty buckets which are to be filled
     * @return             maximum bucket combination
     */
    public static int[] maxBuckets(int[][] combinations, int bucketToFill) {
        int[] tempArray = new int[10];
        int bucketMax = 0;

        for (int i = 0; i < combinations.length; i++) {
            int sum = 0;
            for (int j = 0; j < combinations[i].length; j++) {
                sum += combinations[i][j];
            }

            if (sum == bucketToFill && combinations[i].length > bucketMax) {
                tempArray = combinations[i];
                bucketMax = combinations[i].length;
            }
        }

        return tempArray;
    }

    /**
     * program to print maximum bucket combinations
     * @param combinations array which has all the possible buckets
     *                     combinations
     * @param bucketToFill empty buckets which are to be filled
     * @return             minimum bucket combination
     */
    public static int[] minBuckets(int[][] combinations, int bucketToFill) {
        int[] tempArray = new int[10];
        int bucketMin = 100;

        for (int i = 0; i < combinations.length; i++) {
            int sum = 0;
            for (int j = 0; j < combinations[i].length; j++) {
                sum += combinations[i][j];
            }

            if (sum == bucketToFill && combinations[i].length < bucketMin) {
                tempArray = combinations[i];
                bucketMin = combinations[i].length;
            }
        }

        return tempArray;
    }
}
