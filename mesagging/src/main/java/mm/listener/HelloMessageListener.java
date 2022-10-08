package mm.listener;

import lombok.RequiredArgsConstructor;
import mm.config.JmsConfig;
import mm.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

/**
 * Created by jt on 2019-07-17.
 */
@RequiredArgsConstructor
@Component
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message){

        System.out.println("\nSTART listen --> MY_QUEUE\n");
        System.out.println("\nEND listen --> MY_QUEUE\n");
//
//        System.out.println(helloWorldMessage);


        // uncomment and view to see retry count in debugger
       // throw new RuntimeException("foo");

    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) throws JMSException {

        System.out.println("\nSTART listenForHello --> MY_SEND_RCV_QUEUE\n");
        HelloWorldMessage payloadMsg = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World!!! from listenForHello()")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);
        System.out.println("\nEND listenForHello --> MY_SEND_RCV_QUEUE\n");
    }
}
