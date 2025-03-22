package org.ubdev;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    /**
     * {1} client acknowledge
     * {}
     */
    @JmsListener(destination = "target", containerFactory = "myFactory")
    public void readMessage(Message message) throws JMSException {
        message.acknowledge(); // {1}
        System.out.println(message);
        // {2}
    }
}
