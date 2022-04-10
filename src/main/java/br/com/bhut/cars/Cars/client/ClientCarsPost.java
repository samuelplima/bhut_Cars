package br.com.bhut.cars.Cars.client;

import br.com.bhut.cars.Cars.dto.CreateCarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://api-test.bhut.com.br:3000", name = "api")
public interface ClientCarsPost {

    @PostMapping("/api/cars")
    CreateCarDTO createCar(CreateCarDTO createCarDTO);
}


