import java.util.*;

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

class NumberThreads extends Thread {
    private int start;
    private int end;
    static int[] result;
    public String key = "key";
    static List<String> list = new ArrayList<>();

    public NumberThreads(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        synchronized (key) {
            for (int i = start; i < end; i++) {
                int sum = i;
                int index = 0;
                result = new int[1000];
                result[index] = sum;
                index++;
                do {
                    sum = getSquaredSum(sum);
                    if (!inArray(result, sum)) {
                        result[index] = sum;
                    } else {
                        break;
                    }
                    index++;
                } while (sum != 1);
                if (sum == 1) {
                    list.add( i+ ": " + printResultFormat(result, index));
                }
            }
        }

    }
    /**
     * The main program.
     *
     * @param    args    command line arguments (ignored)
     */
    public static void main(String[] args) {
        int threadsCount = 10;
        int count = 1000;

        if (args.length > 0) {
            threadsCount = Integer.parseInt(args[0]);
            count = Integer.parseInt(args[1]);
        }

        NumberThreads[] threads = new NumberThreads[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new NumberThreads(i * count / threadsCount, (i + 1) * count / threadsCount);
        }

        for (int i = 0; i < threadsCount; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                Integer index1 = Integer.parseInt(o1.substring(0, o1.indexOf(":")));
//                Integer index2 = Integer.parseInt(o2.substring(0, o2.indexOf(":")));
//                return index1.compareTo(index2);
//            }
//        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
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

    public static String printEachNumber(int numberToPrint) {
        String res = "";
        if (numberToPrint < 10) {
            res += numberToPrint + "^2 = " + getSquaredSum(numberToPrint);
        } else {
            String str = String.valueOf(numberToPrint);
            // Regex taken from
            // https://stackoverflow.com/questions/5235401/split-string-into-array-of-character-strings
            String[] arrStr = str.split("(?!^)");

            for (int j = 0; j < arrStr.length; j++) {
                if (j != arrStr.length - 1) {
                    res += arrStr[j] + "^2 + ";
                } else {
                    res += arrStr[j] + "^2 = " + getSquaredSum(numberToPrint);
                }
            }
        }

        return res;
    }

    /**
     * Program to print the calculated
     * @param calculatedNumberArray Array which has the calculated squared numbers of an integer
     * @param calculatedNumber Number to which the squared number is calculated
     */
    public static String printResultFormat(int[] calculatedNumberArray, int calculatedNumber) {
        String res = "";

        for (int eachNumber: calculatedNumberArray) {
            if (eachNumber != 0) {
                res += printEachNumber(eachNumber);
                if (eachNumber != 1) {
                    res += " | ";
                }
            }
        }
        return res;
    }
}
