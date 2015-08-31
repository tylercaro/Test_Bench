package jms.eintern.client;

import javax.naming.InitialContext;

public class MessageSenderMain {
	public final static String WEBLOGIC_URL = "t3://localhost:7001";
	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	public final static String JMS_FACTORY = "jms/QCF";
	public final static String QUEUE = "jms/QueueBC";
	
 	public static void main(String[] args) throws Exception{
 		InitialContext ic = MessageSender.getInitialContext(JNDI_FACTORY, WEBLOGIC_URL);
		
		MessageSender ms = new MessageSender();
		ms.init(ic, JMS_FACTORY,QUEUE);
		ms.send("I'm sorry Dave, I'm afraid I can't do that.");
		ms.close();
	}

}
