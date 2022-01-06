/*
 * Program Test
 *
 * @author      Manoj kumar reddy Palasamudram(mp6112)
 * @author      Ashwath Halemane(ah7387)
 */

public class Test {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Storage storage = new Storage();
		Producer producerMatches = new Producer("Match Producer", "matches", storage);
		Producer producerMatchBox = new Producer("Match Box Producer", "matchbox", storage);
		Consumer consumer = new Consumer("Consumer", storage);
		producerMatches.start();
		producerMatchBox.start();
		consumer.start();
	}
}
