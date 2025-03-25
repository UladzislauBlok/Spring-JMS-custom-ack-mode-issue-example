package org.ubdev;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class Application {

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setSessionTransacted(false);
        factory.setSessionAcknowledgeMode(ActiveMQJMSConstants.INDIVIDUAL_ACKNOWLEDGE); // or Tibco EXPLICIT_CLIENT_ACKNOWLEDGE(23)
        factory.setAcknowledgeAfterListener(false);
        return factory;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending an message.");
        jmsTemplate.convertAndSend("target", "Hello world!");
    }

}
