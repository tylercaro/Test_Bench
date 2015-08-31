package jsm.eintern.client;

import java.util.Hashtable;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageReader {
	private QueueConnectionFactory qconfactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private QueueReceiver qreciever;
	private Queue queue;

	public void init(Context ctx, String jmsFactory, String queueName) throws NamingException, JMSException {
		// Lookup JMS Factory with the JNDI name.
		qconfactory = (QueueConnectionFactory) ctx.lookup(jmsFactory);

		// Create a connection object.
		qcon = qconfactory.createQueueConnection();

		// Create a session object. Boolean is the transaction ON/OFF switch.
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

		// Create a queue object
		queue = (Queue) ctx.lookup(queueName);

		// Create a receiver object
		qreciever = qsession.createReceiver(queue);

		// Create a new JMS Listener instance
		JMSListener jmsListener = new JMSListener();

		//Create a JMS receiver object
		qreciever.setMessageListener(jmsListener);
		
		//Start the connection or IT WONT WORK
		qcon.start();
	}
		
		public void close() throws JMSException{
			qreciever.close();
			qsession.close();
			qcon.close();
		}
		
		public static InitialContext getInitialContext(String jndiFactory, String weblogicURL) throws NamingException{
			Hashtable<String, String> env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
			env.put(Context.PROVIDER_URL, weblogicURL);
			return new InitialContext(env);
		}
	
}
