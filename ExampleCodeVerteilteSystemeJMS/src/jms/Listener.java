package jms;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Listener {
	
	public static void main(String[] args) {
		Properties props = null;
		Context context = null;
		ConnectionFactory factory = null;
		Connection connection = null;
		String factoryName = "ConnectionFactory";
		String destName = "queue1";
		Destination dest = null;
		Session session = null;
		MessageConsumer receiver = null;
		props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
		"org.exolab.jms.jndi.InitialContextFactory");
		props.put(Context.PROVIDER_URL,
		"tcp://localhost:3035/");
		try{
			context = new InitialContext(props);
			factory = (ConnectionFactory) context.lookup(factoryName);
			dest = (Destination) context.lookup(destName);
			connection = factory.createConnection();
			session = connection.createSession(
			false, Session.AUTO_ACKNOWLEDGE);
			receiver = session.createConsumer(dest);
			connection.start();
			System.out.println("Receiver started ...");
		
			Message message = receiver.receive();
			if (message instanceof TextMessage) {
			TextMessage text = (TextMessage) message;
			System.out.println("Received: " + text.getText());
			} else if (message != null) {
			System.out.println("Received non text message");
		}
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
