/**
 * Number.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program produces all numbers between 1 and 1000 who have the following
 * property:
 *
 *      for n 1 to 1000
 *          do
 *               tmpN = sum of the squares of the digits of n.
 *               n = tmpN
 *          until  n == 1, or n has been seen before
 *
 *
 *          if ( n == 1 )
 *          n has the desired property
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */

class Number {
    /**
     * The main program.
     *
     * @param    args    command line arguments (ignored)
     */
    public static void main(String[] args) {
        int[] res;
        int index;

        for (int i = 1; i <= 1000; i++) {
            int sum = i;
            index = 0;
            res = new int[1000];
            res[index] = sum;
            index++;
            do {
                sum = getSquaredSum(sum);
                if (!inArray(res, sum)) {
                    res[index] = sum;
                } else {
                    break;
                }
                index++;
            } while (sum != 1);
            if (sum == 1) {
                printResultFormat(res, i);
            }

        }
    }

    /**
     * This program returns squared
     * @param number number to get squared sum
     * @return int returns the squared sum
     */
    public static int getSquaredSum(int number) {
        int sum = 0;

        do {
            sum += Math.pow((number % 10), 2);
            number = number / 10;
        } while (number != 0);

        return sum;
    }

    /**
     * Program to check if element in an integer array
     * @param array Array which has all the elements
     * @param numberToFind number to check if it is in the array
     * @return boolean returns if the number is present in the array
     */
    public static boolean inArray(int[] array, int numberToFind) {
        for (int arr: array) {
            if (arr == numberToFind) {
                return true;
            }
        }
        return false;
    }

    /**
     * This program prints the squared number calculated form
     * @param numberToPrint number which needs to be printed
     */

    public static void printEachNumber(int numberToPrint) {
        if (numberToPrint < 10) {
            System.out.print(numberToPrint + "^2 = " + getSquaredSum(numberToPrint));
        } else {
            String str = String.valueOf(numberToPrint);
            // Regex taken from
            // https://stackoverflow.com/questions/5235401/split-string-into-array-of-character-strings
            String[] arrStr = str.split("(?!^)");

            for (int j = 0; j < arrStr.length; j++) {
                if (j != arrStr.length - 1) {
                    System.out.print(arrStr[j] + "^2 + ");
                } else {
                    System.out.print(arrStr[j] + "^2 = " + getSquaredSum(numberToPrint));
                }
            }
        }
    }

    /**
     * Program to print the calculated
     * @param calculatedNumberArray Array which has the calculated squared numbers of an integer
     * @param calculatedNumber Number to which the squared number is calculated
     */
    public static void printResultFormat(int[] calculatedNumberArray, int calculatedNumber) {
        System.out.print(calculatedNumber + ":  ");

        for (int eachNumber: calculatedNumberArray) {
            if (eachNumber != 0) {
                printEachNumber(eachNumber);
                if (eachNumber != 1) {
                    System.out.print(" | ");
                }
            }
        }
        System.out.println();
    }
}