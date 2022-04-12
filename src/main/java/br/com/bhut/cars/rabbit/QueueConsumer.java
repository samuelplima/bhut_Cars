package br.com.bhut.cars.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class QueueConsumer implements Serializable {

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload Message message) {
        byte[] byteArray = (byte[]) message.getPayload();
        String myString = new String(byteArray);
        System.out.println(myString);
    }

}
