package br.com.bhut.cars.rabbit;

import br.com.bhut.cars.client.ClientWebhookPost;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
public class QueueConsumer implements Serializable {

    private String myString;
    private ClientWebhookPost clientWebhookPost;

    @Autowired
    public QueueConsumer(ClientWebhookPost clientWebhookPost) {
        this.clientWebhookPost = clientWebhookPost;
    }

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload Message message) {
        byte[] byteArray = (byte[]) message.getPayload();
        myString = ("New car created: " + new String(byteArray));
        clientWebhookPost.PostWebHook(myString);
    }

}
