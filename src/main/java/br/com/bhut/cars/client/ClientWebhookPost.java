package br.com.bhut.cars.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "https://vsibuy2y128jbxidmooi7o.hooks.webhookrelay.com", name = "forwarding-config-oikc6C")
public interface ClientWebhookPost {

    @PostMapping
    String PostWebHook(String message);

}
