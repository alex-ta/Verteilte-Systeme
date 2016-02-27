package soap;
import soap.wsdl.*;

public class CLIENT {
	public static void main(String[] args){
		
		SOAPSERVICE s = new SOAPServiceService().getSOAPSERVICEPort();
		
		System.out.println(s.banner() + " HASHCODE= "+ s.crypt("HASHCODE"));
		
		
	}

}
