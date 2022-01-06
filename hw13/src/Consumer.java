/*
 * Program Consumer
 *
 * @author      Manoj kumar reddy Palasamudram(mp6112)
 * @author      Ashwath Halemane(ah7387)
 */

class Consumer extends Thread {
	String name;
	Storage storage;

	Consumer(String name, Storage storage)	{
		this.name = name;
		this.storage = storage;
	}

	/**
	 * Consume the item from the storage
	 */
	public void run() {
		while (storage.getcLimit() > 0) {
			try {
				this.storage.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}