package jsm.eintern.client;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JMSListener implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		try{
			String msgText;
			
			//Make sure the message is a text type
			if(msg instanceof TextMessage){
				msgText=((TextMessage)msg).getText();
			}else{
				msgText=msg.toString();
			}
			//Print message.
			System.out.println("Message Received: " + msgText);
			
		}catch(JMSException jmse){
			jmse.getMessage();
		}
	}

}
