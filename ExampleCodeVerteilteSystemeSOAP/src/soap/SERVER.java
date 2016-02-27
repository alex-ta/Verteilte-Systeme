package soap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.ws.Endpoint;

public class SERVER {

	public static void main(String[] args){
		
		Endpoint e = Endpoint.publish("http://localhost:8080/soap", new SOAPService());
		JOptionPane.showMessageDialog(null,"Server Beenden");
		e.stop();
		// wsimport -d PATH\src -keep -p soap.wsdl http://localhost:8080/soap?wsdl
	}
	
}
