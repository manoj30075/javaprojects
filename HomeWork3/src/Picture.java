/**
 * Picture.java
 *
 * Version: 1
 * Revisions: 0
 *
 * This program is a logo reveal game where players are needed to guess the word
 *
 *
 * @author      Ashwath sreedhar halemane, ah7387
 * @author      Manoj kumar reddy Palasamudram, mp6112
 */

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Picture {
    /**
     * This function prints the user provided input with concatenating
     * the emptyStringArray
     * @param inputString string the user provides
     * @param emptyString array of stings where user found correctly
     */
    public static void printEnterLetterString(String inputString,
                                              String[] emptyString) {
        String concatenatedString = "";
        for (String i: emptyString) {
            if (i != null) {
                concatenatedString += i;
            } else
                concatenatedString += ".";
        }
        System.out.print(inputString + " (" + concatenatedString + "): ");
    }

    /**
     * Takes user input
     * @return returns the string user entered
     */
    public static String userEnteredString() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        return sc.next();
    }

    /**
     * This function gets the index of the char that users inputs
     * @param userInput user provided split string
     * @param emptyString split strings which user is finding
     * @param matchingInput input char user entered
     * @return matched input index in userInput
     */
    public static int pushFoundCharToArray(String[] userInput,
                                           String[] emptyString,
                                           String matchingInput) {
        int index = userInput.length + 1;
        for (int i = 0; i<userInput.length; i++) {
            if (emptyString[i] == null) {
                if (userInput[i].equals(matchingInput)) {
                    index = i;
                    break;
                }
            }

        }

        return index;
    }

    /**
     * This function prints the logo based on the user progress percentage
     * @param fileName name of the file
     * @param charsFound no of chars user found
     * @param emptyStringLength length of the string user has to find
     */
    public static void printLogo(String fileName,
                                 int charsFound,
                                 int emptyStringLength) {
        Scanner sc = null;
        Random rand = new Random();
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {}
        while (sc.hasNext()) {
            String scannedString = sc.next();
            String[] splitString = scannedString.split("(?!^)");
            for (int i = 0; i<splitString.length; i++) {
                int rand_int = rand.nextInt(1000);
                if (rand_int % (emptyStringLength + 1 - charsFound) == 0) {
                    System.out.print(splitString[i]);
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
    }

    /**
     * main function
     * @param args args has the files name player finding strings
     */
    public static void main(String[] args) {
        String fileOne = args[3];
        String fileTwo = args[1];
        String stringToFindFirstPlayer = args[2];
        String stringToFindSecondPlayer = args[0];

        String[] splitStringOne = stringToFindFirstPlayer.split("(?!^)");
        String[] splitStringTwo = stringToFindSecondPlayer.split("(?!^)");
        String[] emptyStringOne = new String[splitStringOne.length];
        String[] emptyStringTwo = new String[splitStringTwo.length];
        int charsFoundOne = 0;
        int charsFoundTwo = 0;

        while (true) {
            printEnterLetterString("First your turn", emptyStringOne);
            String player1Input = userEnteredString();
            String printString1 = "";
            if (stringToFindFirstPlayer.contains(player1Input)) {
                int placeToFillOne =
                        pushFoundCharToArray(splitStringOne,
                                emptyStringOne,
                                player1Input
                        );
                if (placeToFillOne<emptyStringOne.length) {
                    charsFoundOne++;
                    emptyStringOne[placeToFillOne] = player1Input;
                    printEnterLetterString("Your guess was correct: ", emptyStringOne);
                    System.out.println();
                    printLogo(fileOne, charsFoundOne, emptyStringOne.length);
                }

                for (String i: emptyStringOne) {
                    printString1 += i;
                }

                if (stringToFindFirstPlayer.equals(printString1)) {
                    System.out.println("Player 1 won");
                    break;
                }
            }

            printEnterLetterString("Second your turn", emptyStringTwo);

            String player2Input = userEnteredString();
            String printString2 = "";
            if (stringToFindSecondPlayer.contains(player2Input)) {
                int placeToFillTwo =
                        pushFoundCharToArray(
                                splitStringTwo,
                                emptyStringTwo,
                                player2Input
                        );
                if (placeToFillTwo<emptyStringTwo.length) {
                    charsFoundTwo++;
                    emptyStringTwo[placeToFillTwo] = player2Input;
                    printEnterLetterString("Your guess was correct: ", emptyStringTwo);
                    System.out.println();
                    printLogo(fileTwo, charsFoundTwo, emptyStringTwo.length);
                }

                for (String i: emptyStringTwo) {
                    printString2 += i;
                }

                if (stringToFindSecondPlayer.equals(printString2)) {
                    System.out.println("Player 2 won");
                    break;
                }
            }
        }
    }
}