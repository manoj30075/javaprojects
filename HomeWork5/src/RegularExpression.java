/**
 * RegularExpression.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program to match regular expression
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class RegularExpression {
    static String[] allPatternsToTest = {
            "^..$", ".{2,}", "^[^aeiou]*a[^aeiou]*e[^aeiou]*i[^aeiou]*o[^aeiou]*u[^aeiou]*$",
            "(ac/AC|dc/DC)", "^[a-z&&[^hpb]]*$", "^\\((one|uno|eins)\\)$", "^[mM]oma", "^\\[([a-m]|[O-Z])\\]",
            "^a[1-3]{2}$", "^a[\\d]+", "^\\w{2}[\\d]{3}$"

    };

    static String[] allPatternsToWords = {
            "a word which is two characters long",
            "a word which is two or more characters long",
            "a word with the vowels ’aeiou’ in order and each vowel can appear only once ",
            "includes ac/dc or AC/DC - (ac/AC|dc/DC)",
            "includes only lower case characters, but not the character ’h’, ’p’, and ’b’",
            "starts with ’(’, followed by ’one’ or ’uno’, or ’eins’, followed by ’)’",
            " starts with ’M’ or ’m’ followed ’oma’",
            "starts with ’[’, followed by ’a-m’ or ’O-Z’, followed by ’]’",
            "starts with ’a’ followed by 2 digits in the range between 1 to 3 only",
            "starts with ’a’ followed by one digit or more digits",
            "starts with 2 lower case characters’ followed by 3 digits"
    };

    public static void processStatic(String stringToMatch)	{
        int index = 0;
        String toMatchString = stringToMatch.substring(1, stringToMatch.length() - 1);
        System.out.println("Word to test: -" + toMatchString + "=");
        while ( index < allPatternsToTest.length )	{
            if  ( Pattern.matches(allPatternsToTest[index], toMatchString ) )	{
                System.out.println("This regular expression " + allPatternsToTest[index]
                        + " matches the following input: -" + toMatchString);
                System.out.println(" 	verbal explanation: " + allPatternsToWords[index]);
            }
            index++;
        }
    }

    public static void main(String[] args) {
        if (args.length > 1 && args[1] == "input") {
            Scanner sc = null;
            try {
                sc = new Scanner(new File("words.txt"));
            } catch (FileNotFoundException e) {}
            while (sc.hasNext()) {
                processStatic(sc.next());
            }
        } else {
            processStatic(args[0]);
        }

    }
}