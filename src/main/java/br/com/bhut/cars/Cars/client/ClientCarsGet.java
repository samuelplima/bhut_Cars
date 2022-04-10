package br.com.bhut.cars.Cars.client;

import br.com.bhut.cars.Cars.dto.CarsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@FeignClient(url= "http://api-test.bhut.com.br:3000" , name = "api")
public interface ClientCarsGet {

    @GetMapping("api/cars")
    List<CarsDTO> getCars();

}
