import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SERVER {
	
	// RMIObject needs UnicastRemoteObject to run as server
	
	public static void main(String[] args) throws Exception{
		RMIImplementation rmi = new RMIImplementation();
		Registry r = LocateRegistry.createRegistry(123);
		r.bind("RMIX", rmi);
		System.out.println("Server up");
	}
	

}
