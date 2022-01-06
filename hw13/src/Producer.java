/*
 * Program Producer
 *
 * @author      Manoj kumar reddy Palasamudram(mp6112)
 * @author      Ashwath Halemane(ah7387)
 */

class Producer extends Thread {
	String name;
	Storage storage;
	String type;

	Producer(String name, String type, Storage storage) {
		this.name = name;
		this.storage = storage;
		this.type = type;
	}

	public void run() {
		while (storage.getcLimit() > 0) {
			try {
				storage.produce(type);
			} catch (InterruptedException e) {
				System.out.println("Error occured while producing");
			}
		}
	}
}
