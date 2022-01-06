
/*
 * Program RelayRace on n no.of runners for k no.of laps.
 *
 * @author      Manoj kumar reddy Palasamudram(mp6112)
 * @author      Ashwath Halemane(ah7387)
 */

public class Relay extends Thread {
    static int relayLaps = 4;
    static int lap = 1;
    static final String key = "Relay";
    static int noOfLaps = 5;
    int player;

    public Relay(int player) {
        this.player = player;
    }

    @Override
    //Method to run the thread
    public void run() {
        if (lap <= noOfLaps) {
            try {
                synchronized (key) {
                    if (player == relayLaps) {
                        System.out.println("Baton given to " + player);
                        if (lap < noOfLaps) {
                            new Relay(1).start();
                        }
                        Thread.sleep(1000);
                        if (lap <= noOfLaps)
                            System.out.println("Race number " + lap);
                        lap += 1;
                        key.notifyAll();
                    } else {
                        System.out.println("Baton given to " + player);
                        Thread.sleep(1000);
                        if (player < relayLaps) {
                            new Relay(player + 1).start();
                        }
                        key.wait();
                    }
                }
            }
            catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

    //Main method
    public static void main(String[] args) {
        if (args.length == 2) {
            relayLaps = Integer.parseInt(args[0]);
            noOfLaps = Integer.parseInt(args[1]);
        }

        System.out.println("Relay race starting");
        new Relay(1).start();
    }
}
