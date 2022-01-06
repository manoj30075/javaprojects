import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ArraySumImp extends UnicastRemoteObject implements ArraySum {

    private static final long serialVersionUID = 1L;
    public ArraySumImp() throws RemoteException {
    }
    public int sum(int[] a) throws RemoteException {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
