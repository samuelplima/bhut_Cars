package br.com.bhut.cars.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "https://bin.webhookrelay.com/v1/webhooks/b91107ff-9580-4eee-a188-856afbe9128e", name = "forwarding-config-qqUJNK")
public interface ClientWebhookPost {

    @PostMapping
    String PostWebHook(String message);

}
