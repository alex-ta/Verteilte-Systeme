package jms;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;


public class Observer {
	public static void main(String[] args) {
		Properties props = null;
		Context context = null;
		ConnectionFactory factory = null;
		Connection connection = null;
		String factoryName = "ConnectionFactory";
		String destName = "queue1";
		Destination dest = null;
		Session session = null;
		MessageProducer sender = null;
		String text = "Message 123";
		props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
		"org.exolab.jms.jndi.InitialContextFactory");
		props.put(Context.PROVIDER_URL,
		"tcp://localhost:3035/");
		try {
			context = new InitialContext(props);
			factory = (ConnectionFactory) context.lookup(factoryName);
			dest = (Destination) context.lookup(destName);
			connection = factory.createConnection();
			session = connection.createSession(
			false, Session.AUTO_ACKNOWLEDGE);
			sender = session.createProducer(dest);
			connection.start();
			TextMessage message = session.createTextMessage();
			message.setText(text);
			sender.send(message);
			System.out.println("Sent: " + message.getText());
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}