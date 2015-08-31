package jms.eintern.client;

import java.util.Hashtable;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageSender {
	private QueueConnectionFactory qconfactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private Queue queue;
	private TextMessage msg;
	private QueueSender qsender;
	
	public void init(Context ctx, String jmsFactory, String queueName ) throws NamingException, JMSException {
		
		//Lookup JMS Factory with the JNDI name.
		qconfactory =(QueueConnectionFactory) ctx.lookup(jmsFactory);
		
		//Create a connection object.
		qcon = qconfactory.createQueueConnection();
		
		//Create a session object. Boolean is the transaction ON/OFF switch.
		qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//Create a queue object
		queue = (Queue) ctx.lookup(queueName);
		
		//Create a sender object
		qsender= qsession.createSender(queue);
		
		//Create the message object
		msg = qsession.createTextMessage();
		
		//Start the connection or IT WON'T WORK
		qcon.start();
	}
	
	public void send (String message) throws JMSException{
		msg.setText(message);
		qsender.send(msg);
	}
	
	public void close() throws JMSException{
		qsender.close();
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
