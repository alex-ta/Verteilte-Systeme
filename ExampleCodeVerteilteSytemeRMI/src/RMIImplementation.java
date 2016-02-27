import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIImplementation extends UnicastRemoteObject implements RMIInterface{
	protected RMIImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String callFunction() throws RemoteException {
		System.out.println("Server call");
		return "You called the Function";
	}

	
}
