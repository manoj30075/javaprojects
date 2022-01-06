import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ArraySumImplementation extends UnicastRemoteObject implements ArraySumInterface{
	public int a = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4572863375818206875L;

	protected ArraySumImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized int addNumbers(int[] arr) throws RemoteException {
		System.out.println("executing here "+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a = arr[0];
		int sum = 0;
		for(int i=0;i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(a);
		return sum;
	}

}
