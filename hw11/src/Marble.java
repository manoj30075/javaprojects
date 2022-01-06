/**
 * Marble game.
 *
 * @author Manoj kumar reddy Palasamudram mp6112
 * @author Ashwath Sreedhar Halemane ah7387
 */
public class Marble extends Thread {
    private static int[] marbles;
    private static int maxMarbles = 100;
    private static String key = "marble";

    @Override
    public void run() {
        while (maxMarbles > 0) {
            synchronized (key) {
                Thread playerThread = Thread.currentThread();
                String threadName = playerThread.getName();
                int playerNumber = Integer.parseInt(threadName.substring(threadName.indexOf(" ") + 1));
                marbles[playerNumber]++;
                maxMarbles--;
            }

            try {
                Thread.sleep((int)(10*Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int noOfPlayers = 10;
        if (args.length > 0) {
            noOfPlayers = Integer.parseInt(args[0]);
        }
        Marble[] playerThreads = new Marble[noOfPlayers];
        marbles = new int[noOfPlayers];


        /*
         * Creating the threads.
         */
        for (int playerIndex=0; playerIndex < noOfPlayers; playerIndex++) {
            Marble player = new Marble();
            player.setName("Player " + playerIndex);
            playerThreads[playerIndex] = player;
        }

        /*
         * Starting the threads.
         */
        for (int marbleIndex=0; marbleIndex < noOfPlayers; marbleIndex++) {
            playerThreads[marbleIndex].start();
        }

        /*
         * Waiting for the threads to finish.
         */
        for (int marbleIndex=0; marbleIndex < noOfPlayers; marbleIndex++) {
            try {
                playerThreads[marbleIndex].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*
         * Printing the results.
         */
        for (int i=0; i< noOfPlayers; i++) {
            System.out.println("Player " + i + "  grabbed so many:  " + marbles[i] + " marbles");
        }
    }
}