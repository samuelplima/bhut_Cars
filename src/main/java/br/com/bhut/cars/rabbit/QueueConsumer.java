package br.com.bhut.cars.rabbit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Component
public class QueueConsumer implements Serializable {

    private String myString;

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload Message message) {
        byte[] byteArray = (byte[]) message.getPayload();
        myString = ("New car created: " + new String(byteArray));
    }

}
