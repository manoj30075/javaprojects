/**
 * NearlyPerfectNumber.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program produces nearly perfect numbers between 2 and 1000
 * Here we are not considering 2 as a nearly perfect number
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */

public class NearlyPerfectNumber {
    /**
     * The main program.
     *
     * @param    args    command line arguments (ignored)
     */
    public static void main(String[] args) {
        int[] nearlyPerfectNumbers = getNearlyPerfectNumbers();
        System.out.print("The Nearly perfect numbers are ");

        for (int nearlyPerfectNumber : nearlyPerfectNumbers) {
            if (nearlyPerfectNumber != 0) {
                // prints each nearly perfect number
                System.out.print(nearlyPerfectNumber + "  ");
            }
        }
    }

    /**
     * Given an integer, determine if it is prime number or not
     *
     * @param    number    integer which has to be determined if it
     *                     is prime or not prime
     * @return   boolean   returns boolean, if prime return true else
     *                     returns false
     */
    public static boolean isPrime(int number) {
        for (int index = 2; index < number; index++) {
            if (number % index == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns all the nearly perfect numbers between 2 and 1000
     *
     * @return  int[]   returns all the nearly perfect integers between
     *                  2 and 1000 in an array
     */

    public static int[] getNearlyPerfectNumbers() {
        int[] nearlyPerfects = new int[30];
        int arrIndex = 0;
        for (int index = 2; index <= 1000; index++) {
            int sum = 0;
            for (int number = 2; number < index; number++) {
                if (isPrime(number)) {
                    sum += number;

                    if (sum == index) {
                        nearlyPerfects[arrIndex] = index;
                        arrIndex++;
                        break;
                    } else if (sum > index) {
                        break;
                    }
                }
            }
        }
        return nearlyPerfects;
    }
}
