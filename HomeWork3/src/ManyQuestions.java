import java.util.Random;

public class ManyQuestions {

    public static String sumUpFromLowerToLarger(int a, int b)	{
        String rValue = "";
        if ( a < b )	{
            for (int index = a; index < b; index ++ )
                rValue += a + ": " + index + " ";
        } else {
            for (int index = b; index < a; index ++ )
                rValue += b + ": " + index + " ";
        }
        return rValue;

    }

    /**
     * This function takes a and b and adds to final variable rValue to print sumFromLowerToLarger
     * @param a a is the beginning range from which loop starts
     * @param b b is the endpoint till which loop ends
     * @return returns string with final rValue which is the sum from lower to higher
     */
    //loop generalized to print lower to upper function
    public static String forLoop(int a, int b){
        String rValue = "";

        for(int index = a; index <b; index++){
            rValue += a + ": " + index + " ";
        }

        return rValue;
    }

    /**
     * This is the refined sumUpFromLowerToLargerBetter using ternary operator
     * @param a range of the sum, might be greater than b or lesser than b
     * @param b range of the sum, might be greater than a or lesser than a
     * @return returns rValue which is the from lower to higher
     */
    public static String sumUpFromLowerToLargerBetter(int a, int b)	{
        return a<b ? forLoop(a,b) : forLoop(b,a);
    }

    public static String printBitRepresentation(int a)	{
        String rValue = "";
        for ( int index = 31; index >= 0; index -- )	{
            if ( (  ( a )  & ( 1 << index ) ) == ( 1 << index ) )
                rValue += "1";
            else
                rValue += "0";
        }
        return rValue;
    }

    /**
     * Helper function to add value to resultant
     * @param s to string where 1 or 0 is added
     * @return returns the string modified with 0 or 1
     */
    public static String add(String s){
        String rValue = "";
        if(s=="1"){
            return rValue+'1';
        }else {
            return rValue + '0';
        }
    }

    public static String printBitRepresentationBetter(int aInt)	{

        String rValue ="";

        for ( int index = 31; index >= 0; index -- ){
            rValue += (( aInt ) & ( 1 << index ) ) == ( 1 << index ) ? add("1") : add("0");
        }
        return rValue;
    }

    public static int findMaximumBetter(int a, int b, int c, int d)	{
        int aresb = (a>b)? a:b; //"you can create a more elegant solution";
        int cresb = (c>b)? c:d;
        return aresb > cresb ? aresb : cresb;
    }

    public static int findMaximum(int a, int b, int c, int d)	{
        int rValue;
        int maxAndB = 0;
        int maxCndD = 0;
        if ( a > b )
            maxAndB = a;
        else
            maxAndB = b;
        if ( c > d )
            maxCndD = c;
        else
            maxCndD = d;
        if ( maxAndB > maxCndD )
            rValue = maxAndB;
        else
            rValue = maxCndD;
        return rValue;
    }

    public static String reverseString(String original) {
        String rValue = "";
        for ( int index = original.length(); index > 0; index -- )
            rValue += original.substring(index -1, index);
        return rValue;
    }

    public static String reverseStringBetter(String original) {
        String rValue = "";
        for ( int index = original.length() - 1; index >= 0; index -- )
            rValue += original.charAt(index);         //abcd
        return rValue;
    }

    public static String reverseStringR(String original) {
        if ( original.length() == 1 ) {
            return original;
        }
        return reverseStringR(original.substring(1)) + original.substring(0, 1);
    }

    public static void main( String[] args ) {
        int a = 3;
        int b = 1;
        int c = 2;
        int d = 1;
        String aString = "abcde";
        long foundThisOneMissing;
        int soManyBits = 31;
        boolean useConstantAlgorithm = false;

        if ( args.length > 0 )
            soManyBits = Integer.parseInt(args[0]);
        useConstantAlgorithm = ( args.length > 1 );
        useConstantAlgorithm = true;

        long thisNumberIsMissing = (long)new Random().nextInt((int)Math.pow(2, soManyBits));
        thisNumberIsMissing += ( thisNumberIsMissing == 0 ) ? 1 : 0;

        System.out.println("printFromLowerToLarger(" + a + "," + b + ") = " + sumUpFromLowerToLarger(a, b ) );
        System.out.println("sumUpFromLowerToLargerBetter(" + a + "," + b + ") = " + sumUpFromLowerToLargerBetter(a, b ) );
        System.out.println("printBitRepresentation(" + a + "):		" + printBitRepresentation(a));
        System.out.println("printBitRepresentationBetter(" + a + "):	" + printBitRepresentationBetter(a));
        System.out.println("findMaximum(" + a + ", " + b + ", " + c + ", " + d + " ) = " + findMaximum(a, b, c, d ) );
        System.out.println("findMaximumBetter(" + a + ", " + b + ", " + c + ", " + d + " ) = " + findMaximumBetter(a, b, c, d ) );
        System.out.println("reverseString(" + aString + ") =	" + reverseString(aString) );
        System.out.println("reverseStringR(" + aString + ") =	" + reverseStringR(aString) );
        System.out.println("reverseStringBetter(" + aString + ") =	" + reverseStringBetter(aString) );
    }
}