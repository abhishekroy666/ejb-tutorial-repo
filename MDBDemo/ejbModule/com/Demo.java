package com;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: Demo
 *
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"
		) }, 
		mappedName = "MY_Q")
public class Demo implements MessageListener {

    /**
     * Default constructor. 
     */
    public Demo() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	TextMessage msg =  (TextMessage)message;
    	try {
			System.out.println("The message from queue"+msg.getText());
		} catch (Exception e) {
			// TODO: handle exception
		}
        
    }

}
