package br.com.bhut.cars.rabbit;

import br.com.bhut.cars.dto.CreateCarDTO;
import br.com.bhut.cars.dto.LogsDTO;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
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
