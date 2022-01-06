/*
 * Program Storage
 *
 * @author      Manoj kumar reddy Palasamudram(mp6112)
 * @author      Ashwath Halemane(ah7387)
 */

class Storage {
	private int cLimit = 10;
	private int matchesCount = 0;
	private int matchBoxCount = 0;

	synchronized void produce(String type) throws InterruptedException {
		if(type.equals("matches")) {
			if(matchesCount < 90) {
			matchesCount++;
			System.out.println("Producing matches "+getCounts());
			} else {
				wait();
			}
		}
		if(type.equals("matchbox")) {
			if(matchBoxCount < 9) {
				matchBoxCount++;
				System.out.println("Producing matchbox "+getCounts());
			} else {
				wait();
			}
		}
		notify();
	}

	public synchronized void consume() throws InterruptedException {
		if(matchesCount >= 50 && matchBoxCount >= 1) {
			this.matchesCount -= 50;
			this.matchBoxCount -= 1;
			this.cLimit--;
			System.out.println("Consuming match and matchbox "+getCounts());
			notify();
		} else {
			wait();
		}
	}
	
	public int getcLimit() {
		return this.cLimit;
	}
	
	private String getCounts() {
		return "Matches Count: "+this.matchesCount +" MatchBox Count: "+this.matchBoxCount;
	}
}
