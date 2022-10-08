package mm.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import mm.config.JmsConfig;
import mm.model.HelloWorldMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;

/**
 * Created by jt on 2019-07-17.
 */
@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

//    @Scheduled(fixedRate = 200)
//    public void sendMessage(){
//        System.out.println("\nSTART sendMessage\n");
//        HelloWorldMessage message = HelloWorldMessage
//                .builder()
//                .id(UUID.randomUUID())
//                .message("Hello World! from sendMessage()")
//                .build();
//
//        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
//        System.out.println("\nEND sendMessage\n");
//    }

    @Scheduled(fixedRate = 200)
    public void sendAndReceiveMessage() throws JMSException {

        System.out.println("\nSTART sendAndReceiveMessage\n");
        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World!! from sendAndReceiveMessage()")
                .build();

        Message receviedMsg = jmsTemplate.sendAndReceive(JmsConfig.MY_SEND_RCV_QUEUE, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                System.out.println("\nSTART createMessage\n");
                Message helloMessage = null;

                try {
                    helloMessage = session.createTextMessage(objectMapper.writeValueAsString(message));
                    helloMessage.setStringProperty("_type", "mm.model.HelloWorldMessage");

//                    System.out.println("Sending Hello");

                    System.out.println("\nEND createMessage\n");
                    return helloMessage;

                } catch (JsonProcessingException e) {
                   throw new JMSException("boom");
                }
            }
        });

        System.out.println(receviedMsg.getBody(String.class));
        System.out.println("\nEND sendAndReceiveMessage\n");
    }

}
