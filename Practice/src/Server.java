import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) {
		ArraySumInterface obj;
		try {
			obj = new ArraySumImplementation();
			//Naming.bind("rmi://localhost:1888/sum", obj);
			Registry rgsty = LocateRegistry.createRegistry(1888);
			rgsty.bind("sum", obj);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
