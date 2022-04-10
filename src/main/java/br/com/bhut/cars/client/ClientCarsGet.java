package br.com.bhut.cars.client;

import br.com.bhut.cars.dto.CarsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(url= "http://api-test.bhut.com.br:3000" , name = "api")
public interface ClientCarsGet {

    @GetMapping("api/cars")
    List<CarsDTO> getCars();

}
