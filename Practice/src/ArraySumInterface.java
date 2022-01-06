import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ArraySumInterface extends Remote{
	public int addNumbers(int[] arr) throws RemoteException;
}
