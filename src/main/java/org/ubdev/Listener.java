package org.ubdev;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    /**
     * {1} Manual acknowledge
     * {2} Listener container will ack message for second time after invocation
     */
    @JmsListener(destination = "target", containerFactory = "myFactory")
    public void readMessage(Message message) throws JMSException {
        message.acknowledge(); // {1}
        System.out.println(message);
        // {2}
    }
}
