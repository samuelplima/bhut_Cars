package br.com.bhut.cars.Cars.client;

import br.com.bhut.cars.Cars.dto.CarsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(url= "https://jsonplaceholder.typicode.com" , name = "todos")
public interface ClientCarsGet {

    @GetMapping("/todos")
    List<CarsDTO> getCars();

}
