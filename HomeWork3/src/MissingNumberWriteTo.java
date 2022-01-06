/**
 * MissingNumberWriteTo.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program finds the missing number in n-bits digits
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MissingNumberWriteTo {
    static int soManyBits;
    static String fileName;

    static Scanner input;

    static int nextNumberFromTheStack = 0;

    public static void parseArgs(String[] args)	{
        for ( int index = 0; index < args.length; index += 2 )	{
            if ( args[index].equals("-n") )	{
                soManyBits = Integer.parseInt(args[index + 1 ] );
            } else {
                System.out.println("Unrecognized argument -"  + args[index] + "=" );
                System.exit(1);
            }
        }
    }
    public static void createNumbers()	{
        long maximumNumber = (long)Math.pow(2, soManyBits );
        long thisNumberIsMissing = (long)new Random().nextInt((int)Math.pow(2, soManyBits));
        thisNumberIsMissing = ( thisNumberIsMissing == 0 ) ? 1 : thisNumberIsMissing;

        for ( int index = 1; index < maximumNumber; index ++ )	{
            if ( index != thisNumberIsMissing )
                System.out.println(index);
        }
    }

    public static void main( String[] args ) {
        parseArgs(args);
        createNumbers();
    }
}