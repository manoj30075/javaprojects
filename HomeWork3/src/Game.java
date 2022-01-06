/**
 * Game.java
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

public class Game {
    /**
     * main function
     * @param args args has the files name player finding strings
     */
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.setPlayerFileName(args[3]);
        player2.setPlayerFileName(args[1]);
        player1.setPlayerGuessWord(args[2]);
        player2.setPlayerGuessWord(args[0]);

        String[] splitStringOne = player1.getPlayerGuessWord().split("(?!^)");
        String[] splitStringTwo = player1.getPlayerGuessWord().split("(?!^)");
        String[] emptyStringOne = new String[splitStringOne.length];
        String[] emptyStringTwo = new String[splitStringTwo.length];
        int charsFoundOne = player1.getWordsGuessed();
        int charsFoundTwo = player2.getWordsGuessed();

        while (true) {
            player1.getPicture().printEnterLetterString("First your turn", emptyStringOne);
            String player1Input = player1.getPicture().userEnteredString();
            String printString1 = "";
            if (player1.getPlayerGuessWord().contains(player1Input)) {
                int placeToFillOne =
                        player1.getPicture().pushFoundCharToArray(splitStringOne,
                                emptyStringOne,
                                player1Input
                        );
                if (placeToFillOne<emptyStringOne.length) {
                    charsFoundOne++;
                    emptyStringOne[placeToFillOne] = player1Input;
                    player1.getPicture().printEnterLetterString("Your guess was correct: ", emptyStringOne);
                    System.out.println();
                    player1.getPicture().printLogo(player1.getPlayerFileName(), charsFoundOne, emptyStringOne.length);
                }

                for (String i: emptyStringOne) {
                    printString1 += i;
                }

                if (player1.getPlayerGuessWord().equals(printString1)) {
                    System.out.println("Player 1 won");
                    break;
                }
            }

            player2.getPicture().printEnterLetterString("Second your turn", emptyStringTwo);

            String player2Input = player2.getPicture().userEnteredString();
            String printString2 = "";
            if (player2.getPlayerGuessWord().contains(player2Input)) {
                int placeToFillTwo =
                        player2.getPicture().pushFoundCharToArray(
                                splitStringTwo,
                                emptyStringTwo,
                                player2Input
                        );
                if (placeToFillTwo<emptyStringTwo.length) {
                    charsFoundTwo++;
                    emptyStringTwo[placeToFillTwo] = player2Input;
                    player2.getPicture().printEnterLetterString("Your guess was correct: ", emptyStringTwo);
                    System.out.println();
                    player2.getPicture().printLogo(player2.getPlayerFileName(), charsFoundTwo, emptyStringTwo.length);
                }

                for (String i: emptyStringTwo) {
                    printString2 += i;
                }

                if (player2.getPlayerGuessWord().equals(printString2)) {
                    System.out.println("Player 2 won");
                    break;
                }
            }
        }
    }
}