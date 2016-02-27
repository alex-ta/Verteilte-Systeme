import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CLIENT {

	public static void main(String[] args) throws Exception{
		Registry r = LocateRegistry.getRegistry("localhost", 123);
		RMIInterface rmi = (RMIInterface) r.lookup("RMIX");
		System.out.println(rmi.callFunction());
		
	}
	
}
