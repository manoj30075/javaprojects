import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

class Worker extends Thread {
	ArraySumInterface obj;

	public Worker(ArraySumInterface obj) {
		this.obj = obj;
	}

	public void run() {
		try {
			System.out.println(obj.addNumbers(new int[] { 1, 2, 3, 4 }));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class Client {
	public static void main(String[] args) {
		try {
			ArraySumInterface obj = (ArraySumInterface) Naming.lookup("//localhost:1888/sum");
			for (int i = 0; i < 5; i++) {
				Worker worker = new Worker(obj);
				worker.start();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
