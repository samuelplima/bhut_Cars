package br.com.bhut.cars.controller;

import br.com.bhut.cars.client.ClientWebhookPost;
import br.com.bhut.cars.rabbit.QueueConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Transactional
@RestController
@RequestMapping("/api")
public class WebHookController {

    private QueueConsumer queueConsumer;
    private ClientWebhookPost clientWebhookPost;


    @Autowired
    public WebHookController(QueueConsumer queueConsumer, ClientWebhookPost clientWebhookPost) {
        this.queueConsumer = queueConsumer;
        this.clientWebhookPost = clientWebhookPost;
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> webHook(){
        String requestBody = null;
        if(queueConsumer.getMyString() != null) {
            requestBody = queueConsumer.getMyString();
            clientWebhookPost.PostWebHook(requestBody);
            return new ResponseEntity<>(requestBody, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(requestBody, HttpStatus.NOT_FOUND);
        }
    }

}
