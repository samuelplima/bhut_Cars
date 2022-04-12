package br.com.bhut.cars.rabbit;

import br.com.bhut.cars.dto.LogsDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class QueueSender implements Serializable {

    private RabbitTemplate rabbitTemplate;
    private Queue queue;

    @Autowired
    public QueueSender(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void send(LogsDTO logsDTO) {
        rabbitTemplate.convertAndSend(this.queue.getName(), logsDTO.toString().getBytes());
    }
}
