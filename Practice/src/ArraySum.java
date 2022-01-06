import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ArraySum extends Remote {
    int sum(int[] a) throws RemoteException;
}
