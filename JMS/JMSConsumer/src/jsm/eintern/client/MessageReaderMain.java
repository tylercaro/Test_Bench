package jsm.eintern.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageReaderMain {
	public final static String WEBLOGIC_URL = "t3://localhost:7001";
	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	public final static String JMS_FACTORY = "jms/QCF";
	public final static String QUEUE = "jms/QueueBC";
	

	public static void main(String[] args) throws Exception{
		InitialContext ic = MessageReader.getInitialContext(JNDI_FACTORY, WEBLOGIC_URL);
		
		MessageReader mr = new MessageReader();
		mr.init(ic, JMS_FACTORY, QUEUE);
		
		//pause to allow the JMS server time to call onMessage()
		synchronized (mr) {
			try{
				System.out.println("pause for onMessage to be called ...");
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			
		}
		
		mr.close();
		System.out.println("connection closed");
		
	}

}
