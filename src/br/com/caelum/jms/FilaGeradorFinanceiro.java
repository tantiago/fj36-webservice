package br.com.caelum.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig= {
		@ActivationConfigProperty(propertyName = "destinationLookup",
			propertyValue = "jms/FILA.GERADOR"),
		@ActivationConfigProperty(propertyName = "destinationType",
			propertyValue = "javax.jms.Topic")
})
public class FilaGeradorFinanceiro implements MessageListener{

	public void onMessage(Message msg) {
		try {
			TextMessage message = (TextMessage) msg;
			System.out.printf("Gerando notas para %s\n", message.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
