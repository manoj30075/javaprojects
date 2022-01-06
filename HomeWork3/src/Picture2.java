import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Picture2 {
    /**
     * This function prints the user provided input with concatenating
     * the emptyStringArray
     * @param inputString string the user provides
     * @param emptyString array of stings where user found correctly
     */
    public void printEnterLetterString(String inputString,
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
    public String userEnteredString() {
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
    public int pushFoundCharToArray(String[] userInput,
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
    public void printLogo(String fileName,
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
}
