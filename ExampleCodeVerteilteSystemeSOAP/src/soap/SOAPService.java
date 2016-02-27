package soap;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "SOAPSERVICE" )
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SOAPService {

	@WebMethod
	public String banner (){
		return "Hey from your Soap Service";
	}
	
	@WebMethod(operationName = "crypt")
	@WebResult(name="crypted")
	public int hash(@WebParam(name = "msg") String msg){
		return msg.hashCode();
	}
	
}
